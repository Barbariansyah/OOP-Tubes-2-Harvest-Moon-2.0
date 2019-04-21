import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 * GameWindow
 */
public class GameWindow extends JFrame implements KeyListener{

    private static TileComponent[][] landmap;    
    private static int nBaris,nKolom;
    private static int x,y;

    public GameWindow(){  
        super("Game Window");      
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.validate();
        addKeyListener(this);   
    }

    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();

        //Hilangkan player
        BufferedImage img = landmap[x][y].getEntityImage();
        landmap[x][y].setEntityImage(null);

        if (keyCode == KeyEvent.VK_LEFT)
            x--;
        else if (keyCode == KeyEvent.VK_RIGHT)
            x++;
        else if (keyCode == KeyEvent.VK_UP)
            y--;
        else if (keyCode == KeyEvent.VK_DOWN)
            y++;
        //tick(keyCode);

        landmap[x][y].setEntityImage(img);
        repaint();
    }

    public void keyReleased(KeyEvent evt) {
    }

    public void keyTyped(KeyEvent evt) {
    } 

    public static void updateGameState(){
    }
    
    public static void main(String[] args) throws InterruptedException{
        nBaris = 5; 
        nKolom = 5;
        x = 0;
        y = 0;
        int tilesize = 100;

        GameWindow g = new GameWindow();
        g.setSize(tilesize*nBaris, tilesize*nKolom);

        //Land
        landmap = new TileComponent[nBaris][nKolom];
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                landmap[i][j] = new TileComponent();
                landmap[i][j].setBounds(i*tilesize, j*tilesize, tilesize, tilesize);
                try {
                    landmap[i][j].setLandImage(ImageIO.read(new File("barn.png")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                g.add(landmap[i][j]);
            }
        }
        //Masukkan player
        try {
            landmap[x][y].setEntityImage(ImageIO.read(new File("engi.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        g.pack();
        g.setResizable(false);
        updateGameState();
    }
}