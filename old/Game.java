import java.util.Scanner;

/**
 * Kelas Statik Game.
 * Sebuah kelas static yang menyimpan state dari game dan
 * method yang digunakan untuk interaksi antar objek pada Engi's Farm
 */
public static class Game {
    private static Land[][] landmap;            
    private static Entity[][] entitymap;        
    private static LinkedList<FarmAnimal> animals; 
    private static int nBaris,nKolom;
    //TODO : Hapus setelah implementasi singleton
    private static Truck truck;
    private static Well well;
    private static Mixer mixer;
    private static Player player;

    /**
     * Initialize Game.
     * Menerima nama file untuk kemudian dibaca dan dimuat dalam struktur data game.
     * @param filename nama file eksternal untuk dibaca
     */
    public static void Initialize(string filename, int xsize, int ysize){
        nBaris = xsize;
        nKolom = ysize;

        landmap = new Land[nBaris][nKolom];
        entitymap = new Entity[nBaris][nKolom];

        BeefRolade.initRecipe();
        Pancake.initRecipe();
        GoatCheese.initRecipe();
        ChickenButterMilk.initRecipe();
        LoadGame(filename);
    }
    /**
     * Method load game yang akan dipanggil oleh konstruktor.
     * Membaca kondisi permainan dan memuatnya dalam memori.
     * @param filename nama file eksternal untuk dibaca
     */
    public static void LoadGame(string filename){
        // TODO
    }
    /**
     * Method save game untuk menyimpan kondisi permainan ke file eksternal.
     * @param filename nama file eksternal yang akan diisi kondisi permainan
     */
    public static void SaveGame(string filename){
        //TODO
    }
    /**
     * Method tick untuk menggerakan tick permainan.
     * Method ini akan memanggil semua method pada elemen map maupun entities yang
     * berhubungan dengan game tick.
     */
    public static void Tick(){
        //Menerima input command
        Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("> ");
        String cmd = scanner.nextLine();
        if (cmd.equals("MOVE")) {
            player.Move();
        }else if (cmd.equals("INTERACT")) {
            player.interact();
        }else if (cmd.equals("GROW")) {
            player.grow();
        }else if (cmd.equals("TALK")) {
            player.Talk();
        }else if (cmd.equals("STATUS")) {
            player.printStatus();
        }else if (cmd.equals("KILL")) {
            player.kill();
        }else if (cmd.equals("MIX")) {
            player.mix();
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
        truck.TickTruck();
    }
    /**
     * Method draw screen mencetak kondisi permainan.
     * Method ini memanfaatkan method virtual render dari kelas renderer yang
     * diturunkan pada semua kelas selain produk.
     */
    public static void DrawScreen(){
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
    public static FarmAnimal getAnimal(int x, int y){
        for(int i = 0; i < animals.length(); i++){
            if (animals.get(i).GetX() == x && animals.get(i).GetY() == y){
                return animals.get(i);
            }
        }
        throw Exception("No animal at the desired location");
    }

    //TODO : Hilangkan, dengan implementasi singleton maka tidak diperlukan lagi

    /**
     * Method untuk mengakses instans truck jika berada di dekat posisi x,y.
     * @param x posisi x akses, digunakan untuk menentukan apakah berada di dekat truck 
     * @param y posisi y akses, digunakan untuk menentukan apakah berada di dekat truck
     * @return objek truck pada jika berada di dekat x,y. throws exception jika tidak berada di dekat x,y
     */
    public static Truck getTruck(int x, int y){
        if (isAdjacent(x,y,truck.GetX(),truck.GetY()))
            return truck;
        else
            throw Exception("Truck is not nearby");
    }
    /**
     * Method untuk mengakses instans well jika berada di dekat posisi x,y.
     * @param x posisi x akses, digunakan untuk menentukan apakah berada di dekat well 
     * @param y posisi y akses, digunakan untuk menentukan apakah berada di dekat well
     * @return objek well pada jika berada di dekat x,y. throws exception jika tidak berada di dekat x,y
     */
    public static Well getWell(int x, int y){
        if (isAdjacent(x,y,well.GetX(),well.GetY()))
            return well;
        else
            throw Exception("Well is not nearby");
    }
    /**
     * Method untuk mengakses instans mixer jika berada di dekat posisi x,y.
     * @param x posisi x akses, digunakan untuk menentukan apakah berada di dekat mixer 
     * @param y posisi y akses, digunakan untuk menentukan apakah berada di dekat mixer
     * @return objek mixer pada jika berada di dekat x,y. throws exception jika tidak berada di dekat x,y
     */
    public static Mixer getMixer(int x, int y){
        if (isAdjacent(x,y,mixer.GetX(),mixer.GetY()))
            return mixer;
        else
            throw Exception("Mixer is not nearby");
    }
    /**
     * Method untuk mengakses instans player
     * @return objek player
     */
    public static Player getPlayer(){
        return player;
    }

}