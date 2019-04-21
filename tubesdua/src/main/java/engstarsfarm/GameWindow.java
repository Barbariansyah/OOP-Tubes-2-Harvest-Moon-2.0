package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import viewcontroller.Game;
/**
 * GameWindow
 */
public class GameWindow extends JFrame implements KeyListener{

    private TileComponent[][] tiles;

    public GameWindow(){  
        super("Eng*s Farm");      
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.validate();
        addKeyListener(this);
        
        int nBaris = Game.getnBaris();
        int nKolom = Game.getnKolom();
        int tilesize = 50;

        this.setSize(tilesize*nKolom, tilesize*nBaris);

        //Inisialisasi tiles pada window
        tiles = new TileComponent[nBaris][nKolom];
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                tiles[i][j] = new TileComponent();
                tiles[i][j].setBounds(j*tilesize, i*tilesize, tilesize, tilesize);
                this.add(tiles[i][j]);
            }
        }

        this.pack();
        this.setResizable(false);
        this.updateView();
        this.repaint();
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
        int nBaris = Game.getnBaris();
        int nKolom = Game.getnKolom();
        for(int i = 0; i < nBaris; i++){
            for(int j = 0; j < nKolom; j++){
                tiles[i][j].setEntityImage(null);
                tiles[i][j].setLandImage(null);
                if (Game.isValidEntity(i,j)){
                    try {
                        tiles[i][j].setEntityImage(ImageIO.read(new File("engi.png")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    tiles[i][j].setLandImage(ImageIO.read(new File("barn.png")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}