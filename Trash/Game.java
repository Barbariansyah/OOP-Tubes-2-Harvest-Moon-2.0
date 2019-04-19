import java.util.Scanner;
import java.io.File;

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
    public static void initialize(String filename){
        animals = new LinkedList<FarmAnimal>();
        
        BeefRolade.initRecipe();
        Pancake.initRecipe();
        GoatCheese.initRecipe();
        ChickenButterMilk.initRecipe();

        if (filename == "none"){
            //Default initializer
            nBaris = 5; 
            nKolom = 5;
    
            landmap = new Land[nBaris][nKolom];
            entitymap = new Entity[nBaris][nKolom];

            Player.initialize("Default", 5, 0, 0, 0);
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
        }else{
            loadGame(filename);
        }
    }
    /**
     * Method load game yang akan dipanggil oleh konstruktor.
     * Membaca kondisi permainan dan memuatnya dalam memori.
     * @param filename nama file eksternal untuk dibaca
     */
    public static void loadGame(String filename){
        Scanner scanner;
        File file = null;
        try{
            file = new File(filename);
            scanner = new Scanner(file);
        } catch (Exception e){
            scanner = new Scanner(System.in);
        }

        //Reading map size
        String cmd;
        int xsize = 0;
        int ysize = 0;
        while (scanner.hasNextLine()){
            xsize++;
            cmd = scanner.nextLine();
            if (ysize == 0){
                ysize = cmd.length();
            }
        }

        nBaris = xsize;
        nKolom = ysize;
        landmap = new Land[nBaris][nKolom];
        entitymap = new Entity[nBaris][nKolom];

        scanner.close();

        try{
            scanner = new Scanner(file);
        } catch (Exception e){
            scanner = new Scanner(System.in);
        }

        for (int i = 0; i < nBaris; i++) {
            cmd = scanner.nextLine();
            for (int j = 0; j < nKolom; j++) {
                char chr = cmd.charAt(j);
                if (chr == '-'){
                    landmap[i][j] = new Grassland();
                }
                else if (chr == 'O'){
                    landmap[i][j] = new Coop();
                }
                else if (chr == 'X'){
                    landmap[i][j] = new Barn();
                }
                else if (chr == '#'){
                    landmap[i][j] = new Grassland();
                    landmap[i][j].growGrass();
                }
                else if (chr == '*'){
                    landmap[i][j] = new Coop();
                    landmap[i][j].growGrass();
                }
                else if (chr == '@'){
                    landmap[i][j] = new Barn();
                    landmap[i][j].growGrass();
                }
                else if (chr == 'P'){
                    try {
                        Player.initialize("Default", 5, 0, i, j);
                        entitymap[i][j] = Player.getInstance();
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                }
                else if (chr == 'M'){
                    try {
                        Mixer.initialize(i,j);
                        entitymap[i][j] = Mixer.getInstance();
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                }
                else if (chr == 'W'){
                    try {
                        Well.initialize(0,2);
                        entitymap[i][j] = Well.getInstance();
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                }
                else if (chr == 'T'){
                    try {
                        Truck.initialize(i,j);
                        entitymap[i][j] = Truck.getInstance();
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                }
                else if (chr == 'C'){
                    animals.add(new Chicken(i,j));
                    landmap[i][j] = new Coop();
                    entitymap[i][j] = animals.get(animals.length()-1);
                }
                else if (chr == 'S'){
                    animals.add(new Cow(i,j));
                    landmap[i][j] = new Grassland();
                    entitymap[i][j] = animals.get(animals.length()-1);
                }
                else if (chr =='U'){
                    animals.add(new Dino(i,j));
                    landmap[i][j] = new Coop();
                    entitymap[i][j] = animals.get(animals.length()-1);
                }else if (chr == 'D'){
                    animals.add(new Duck(i,j));
                    landmap[i][j] = new Coop();
                    entitymap[i][j] = animals.get(animals.length()-1);
                }else if (chr == 'G'){
                    animals.add(new Goat(i,j));
                    landmap[i][j] = new Grassland();
                    entitymap[i][j] = animals.get(animals.length()-1);
                }else if (chr == 'R'){
                    animals.add(new Rabbit(i,j));
                    landmap[i][j] = new Barn();
                    entitymap[i][j] = animals.get(animals.length()-1);
                }
            }
        }

        scanner.close();
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