import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
/**
 * GameWindow
 */
public class GameWindow extends JFrame implements KeyListener{

    private static TileComponent[][] landmap;    
    private static int nBaris,nKolom;

    public GameWindow(){  
        super("Game Window");       
        this.setSize(600, 600);       
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        //this.setContentPane(op);
        this.setVisible(true);
        this.validate();
        addKeyListener(this);   
    }

    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();

        // if (keyCode == KeyEvent.VK_LEFT)
        //     np.setBounds(posx-10,posy,50,50);
        // else if (keyCode == KeyEvent.VK_RIGHT)
        //     np.setBounds(posx+10,posy,50,50);
        // else if (keyCode == KeyEvent.VK_UP)
        //     np.setBounds(posx,posy-10,50,50);
        // else if (keyCode == KeyEvent.VK_DOWN)
        //     np.setBounds(posx,posy+10,50,50);
        System.out.println("masuk gan");
        updateGameState();
    }

    public void keyReleased(KeyEvent evt) {
    }

    public void keyTyped(KeyEvent evt) {
    } 

    public static void updateGameState(){
        Random rd = new Random();

        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                landmap[i][j].setDrawColor(rd.nextInt(6));
                System.out.print(landmap[i][j].getDrawColor());
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        nBaris = 5; 
        nKolom = 5;

        GameWindow g = new GameWindow();
        landmap = new TileComponent[nBaris][nKolom];
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                landmap[i][j] = new TileComponent(2, i*50, j*50);
                landmap[i][j].setBounds(i*50, j*50, 50, 50);
                g.add(landmap[i][j]);
            }
        }
        updateGameState();
    }
}