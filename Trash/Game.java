import java.util.Scanner;

/**
 * Kelas Statik Game.
 * Sebuah kelas static yang menyimpan state dari game dan
 * method yang digunakan untuk interaksi antar objek pada Engi's Farm
 */
public class Game {
    private static Land[][] landmap;            
    private static Entity[][] entitymap;        
    private static LinkedList<FarmAnimal> animals; 
    private static int nBaris,nKolom;

    /**
     * Initialize Game.
     * Menerima nama file untuk kemudian dibaca dan dimuat dalam struktur data game.
     * @param filename nama file eksternal untuk dibaca
     */
    public static void initialize(String filename, int xsize, int ysize){
        nBaris = xsize;
        nKolom = ysize;

        landmap = new Land[nBaris][nKolom];
        entitymap = new Entity[nBaris][nKolom];
        animals = new LinkedList<FarmAnimal>();

        BeefRolade.initRecipe();
        Pancake.initRecipe();
        GoatCheese.initRecipe();
        ChickenButterMilk.initRecipe();

        //TODO : Implementasi di loadGame
        Player.initialize("Test", 5, 0, 0, 0);
        Truck.initialize(0,1);
        Well.initialize(0,2);
        Mixer.initialize(0,3);

        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                landmap[i][j] = new Grassland();
                entitymap[i][j] = null;
            }
        }

        try{
            entitymap[0][0] = Player.getInstance();
            entitymap[0][1] = Truck.getInstance();
            entitymap[0][2] = Well.getInstance();
            entitymap[0][3] = Mixer.getInstance();
        }catch (Exception e){

        }

        loadGame(filename);
    }
    /**
     * Method load game yang akan dipanggil oleh konstruktor.
     * Membaca kondisi permainan dan memuatnya dalam memori.
     * @param filename nama file eksternal untuk dibaca
     */
    public static void loadGame(String filename){
        // TODO
    }
    /**
     * Method save game untuk menyimpan kondisi permainan ke file eksternal.
     * @param filename nama file eksternal yang akan diisi kondisi permainan
     */
    public static void saveGame(String filename){
        //TODO
    }
    /**
     * Method tick untuk menggerakan tick permainan.
     * Method ini akan memanggil semua method pada elemen map maupun entities yang
     * berhubungan dengan game tick.
     */
    public static void tick() throws IllegalAccessException{
        //Menerima input command
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String cmd;
        if (scanner.hasNextLine()){
            cmd = scanner.nextLine();
        }else{
            cmd = "";
        }

        Player player;
        try{
            player = Player.getInstance();
        } catch (IllegalAccessException e) {
            // TODO
            throw new IllegalAccessException("Player belum diinisialisasi");
        }
        if (cmd.equals("MOVE")) {
            player.Move();
        }else if (cmd.equals("INTERACT")) {
            player.Interact();
        }else if (cmd.equals("GROW")) {
            player.Grow();
        }else if (cmd.equals("TALK")) {
            player.Talk();
        }else if (cmd.equals("STATUS")) {
            player.PrintStatus();
        }else if (cmd.equals("KILL")) {
            player.Kill();
        }else if (cmd.equals("MIX")) {
            player.Mix();
        }

        //Menggerakan semua animal dan mengupdate kondisinya
        for(FarmAnimal animal : animals){
            if (animal.GetHungerCountdown() <= -5){
                animals.remove(animal);
                setEntity(animal.GetX(),animal.GetY(),null);
            }else{
                animal.ReduceHungerCountdown();
                animal.Move();
                animal.Eat();
            }
        }

        //Mengubah away counter truck
        try{
            Truck.getInstance().tickTruck();
        } catch (IllegalAccessException e) {
            throw new IllegalAccessException("Truck belum diinisialisasi");
        }
    }
    /**
     * Method draw screen mencetak kondisi permainan.
     * Method ini memanfaatkan method virtual render dari kelas renderer yang
     * diturunkan pada semua kelas selain produk.
     */
    public static void drawScreen(){
        for(int i = 0; i < nBaris; i++){
            for(int j = 0; j < nKolom; j++){
                if (entitymap[i][j] != null){
                    System.out.print(entitymap[i][j].Render());
                }else{
                    System.out.print(landmap[i][j].Render());
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    /**
     * Method untuk mengakses land pada posisi x, y.
     * @param x posisi x land, dimulai dari 0, harus selalu valid
     * @param y posisi y land, dimulai dari 0, harus selalu valid
     * @return objek land pada posisi x, y
     */
    public static Land getLand(int x, int y){
        return landmap[x][y];
    }
    /**
     * Method untuk menentukan apakah posisi x, y ada dalam map.
     * @param x , dimulai dari 0
     * @param y , dimulai dari 0
     * @return apakah posisi x, y valid
     */
    public static boolean isValidPosition(int x, int y){
        return (x >= 0 && y >= 0 && x < nBaris && y < nKolom);
    }
    /**
     * Method untuk menentukan apakah ada entity di posisi x, y
     * @param x posisi x untuk ditentukan apakah terdapat entity, dimulai dari 0
     * @param y posisi y untuk ditentukan apakah terdapat entity, dimulai dari 0
     * @return apakah posisi x,y terdapat entity
     */
    public static boolean isValidEntity(int x, int y){
        return entitymap[x][y] != null;
    }
    /**
     * Method untuk mengakses entity pada posisi x, y.
     * @param x posisi x entity, dimulai dari 0, harus selalu dalam ukuran map
     * @param y posisi y entity, dimulai dari 0, harus selalu dalam ukuran map
     * @return objek entity pada posisi x, y. Null jika tidak ada
     */
    public static Entity getEntity(int x, int y){
        return entitymap[x][y];
    }
    /**
     * Method untuk mengubah entitymap pada posisi x,y menjadi pointer entity E.
     * @param x posisi x entity, dimulai dari 0, harus selalu dalam ukuran map
     * @param y posisi y entity, dimulai dari 0, harus selalu dalam ukuran map
     * @param E pointer entity, nullptr jika tidak ada
     * @return objek entity pada posisi x, y
     */
    public static void setEntity(int x, int y, Entity E){
        entitymap[x][y] = E;
    }

    public static boolean isAdjacent(int x1, int y1, int x2, int y2){
        return ((x2 == x1+1 || x2 == x1-1) && y2 == y1) || ((y2 == y1+1 || y2 == y1-1) && x2 == x1);
    }
    /**
     * Method untuk mengakses farmanimal yang memiliki posisi x,y.
     * @param x posisi x farmanimal, dimulai dari 0 
     * @param y posisi y farmanimal, dimulai dari 0
     * @return objek farmanimal pada posisi x, y. Null jika tidak ada
     */
    public static FarmAnimal getAnimal(int x, int y) throws IllegalAccessException{
        for(int i = 0; i < animals.length(); i++){
            if (animals.get(i).GetX() == x && animals.get(i).GetY() == y){
                return animals.get(i);
            }
        }
        throw new IllegalAccessException("No animal at the desired location");
    }
}