import javax.swing.*;
import java.awt.*;

public class TileComponent extends JComponent{
        private int drawColor,x,y;
        public TileComponent(int _drawColor, int _x, int _y){
            drawColor = _drawColor;
            x = 0;
            y = 0;
        }

        /**
         * @param drawColor the drawColor to set
         */
        public void setDrawColor(int drawColor) {
            this.drawColor = drawColor;
            this.repaint();
        }

        /**
         * @return the drawColor
         */
        public int getDrawColor() {
            return drawColor;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            switch (drawColor) {
                case 0:
                    g.setColor(Color.RED);
                    g.fillRect(x, y, 50, 50);
                    break;
                case 1:
                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, 50, 50);
                    break;
                case 2:
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, 50, 50);
                    break;
                case 3:
                    g.setColor(Color.PINK);
                    g.fillRect(x, y, 50, 50);
                    break;
                case 4:
                    g.setColor(Color.ORANGE);
                    g.fillRect(x, y, 50, 50);
                    break;
                case 5:
                    g.setColor(Color.CYAN);
                    g.fillRect(x, y, 50, 50);
                    break;
                default:
                    break;
            }
        }
    }