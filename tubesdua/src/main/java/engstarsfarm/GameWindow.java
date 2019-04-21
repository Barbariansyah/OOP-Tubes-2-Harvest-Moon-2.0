package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import viewcontroller.Game;
import cell.Land;
import entity.Player;
import model.Product;
/**
 * GameWindow
 */
public class GameWindow extends JFrame implements KeyListener{

    private TileComponent[][] tiles;
    private JLabel waterlabel, moneylabel, inventorylabel, animalchat;

    private static HashMap<Character,BufferedImage> entitySprite;
    private static HashMap<Character,BufferedImage> landSprite;

    public GameWindow(){  
        super("Eng*s Farm");      
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        int nBaris = Game.getnBaris();
        int nKolom = Game.getnKolom();
        int tilesize = 50;

        //Inisialisasi panel game dan informasi
        Container container = this.getContentPane();
        JPanel jpleft = new JPanel();
        jpleft.setBackground(Color.RED);
        jpleft.setLayout(null);
        container.add(jpleft,BorderLayout.WEST);
        JPanel jpright = new JPanel();
        jpright.setBackground(Color.WHITE);
        jpright.setLayout(new BoxLayout(jpright, BoxLayout.Y_AXIS));
        container.add(jpright,BorderLayout.EAST);

        //Tambahkan jlabel untuk panel informasi
        JLabel infolabel = new JLabel("Player Info", SwingConstants.CENTER);
        jpright.add(infolabel);
        waterlabel = new JLabel("Water Container : 5", SwingConstants.CENTER);
        jpright.add(waterlabel);
        moneylabel = new JLabel("Money : 0", SwingConstants.CENTER);
        jpright.add(moneylabel);
        inventorylabel = new JLabel("Inventory : ", SwingConstants.CENTER);
        jpright.add(inventorylabel);

        //Tambahkan jlabel untuk pembicaraan dengan binatang
        animalchat = new JLabel("Farm Chat", SwingConstants.CENTER);
        container.add(animalchat,BorderLayout.SOUTH);

        //Inisialisasi tiles pada window
        tiles = new TileComponent[nBaris][nKolom];
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                tiles[i][j] = new TileComponent();
                tiles[i][j].setBounds(j*tilesize, i*tilesize, tilesize, tilesize);
                jpleft.add(tiles[i][j]);
            }
        }

        //Diperlukan untuk kalkulasi ukuran dan menggambar ke layar
        jpleft.setPreferredSize(new Dimension(tilesize*nKolom, tilesize*nBaris));
        this.pack();
        this.setResizable(false);
        this.updateView();
        this.setVisible(true);
        this.repaint();
        addKeyListener(this);
    }

    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();
        try {
            Game.tick(keyCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.updateView();
        this.repaint();
    }

    public void keyReleased(KeyEvent evt) {
    }

    public void keyTyped(KeyEvent evt) {
    } 

    public void updateView(){
        //Update tampilan farm
        int nBaris = Game.getnBaris();
        int nKolom = Game.getnKolom();
        for(int i = 0; i < nBaris; i++){
            for(int j = 0; j < nKolom; j++){
                tiles[i][j].setEntityImage(null);
                tiles[i][j].setLandImage(null);
                if (Game.isValidEntity(i,j)){
                    try {
                        tiles[i][j].setEntityImage(entitySprite.get(Game.getEntity(i, j).render().charAt(0)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    tiles[i][j].setLandImage(landSprite.get(Game.getLand(i, j).render().charAt(0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //Update player info
        try {
            waterlabel.setText("Water Container : "+String.valueOf(Player.getInstance().getWaterContainer()));
            moneylabel.setText("Money : "+String.valueOf(Player.getInstance().getMoney()));
            String inventory = "<html>Inventory : <br>";
            for (Product item : Player.getInstance().getInventory()){
                inventory += item.getName() + " " + item.getPrice() + "<br>";
            }
            inventory += "</html>";
            inventorylabel.setText(inventory);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Tes apakah game telah selesai
        if (Game.getAnimals().size() == 0){
            System.out.println("Game Over");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

    /**
     * @param animalchat the animalchat to set
     */
    public void setAnimalchat(String animalchat) {
        this.animalchat.setText(animalchat);
    }

    public static void initializeEntitySprite(){
        entitySprite = new HashMap<Character,BufferedImage>();
        try {
            entitySprite.put('P', ImageIO.read(new File("img/engi.png")));
            entitySprite.put('M', ImageIO.read(new File("img/mixer.png")));
            entitySprite.put('W', ImageIO.read(new File("img/well.png")));
            entitySprite.put('T', ImageIO.read(new File("img/truck.png")));
            entitySprite.put('C', ImageIO.read(new File("img/chicken.png")));
            entitySprite.put('S', ImageIO.read(new File("img/cow.png")));
            entitySprite.put('U', ImageIO.read(new File("img/dino.png")));
            entitySprite.put('D', ImageIO.read(new File("img/duck.png")));
            entitySprite.put('G', ImageIO.read(new File("img/goat.png")));
            entitySprite.put('R', ImageIO.read(new File("img/rabbit.png")));
            entitySprite.put('c', ImageIO.read(new File("img/chicken-hungry.png")));
            entitySprite.put('s', ImageIO.read(new File("img/cow-hungry.png")));
            entitySprite.put('u', ImageIO.read(new File("img/dino-hungry.png")));
            entitySprite.put('d', ImageIO.read(new File("img/duck-hungry.png")));
            entitySprite.put('g', ImageIO.read(new File("img/goat-hungry.png")));
            entitySprite.put('r', ImageIO.read(new File("img/rabbit-hungry.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initializeLandSprite(){
        landSprite = new HashMap<Character,BufferedImage>();
        try {
            landSprite.put('-', ImageIO.read(new File("img/grassland.png")));
            landSprite.put('O', ImageIO.read(new File("img/coop.png")));
            landSprite.put('X', ImageIO.read(new File("img/barn.png")));
            landSprite.put('#', ImageIO.read(new File("img/grassland-grass.png")));
            landSprite.put('*', ImageIO.read(new File("img/coop-grass.png")));
            landSprite.put('@', ImageIO.read(new File("img/barn-grass.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}