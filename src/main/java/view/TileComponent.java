package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TileComponent extends JComponent{
        private int x,y,size;
        private BufferedImage landImage, entityImage;

        public TileComponent(){
            x = 0;
            y = 0;
            landImage = null;
            entityImage = null;
        }

        /**
         * @param size the size to set
         */
        public void setSize(int size) {
            this.size = size;
        }

        /**
         * @param landImage the landImage to set
         */
        public void setLandImage(BufferedImage landImage) {
            this.landImage = landImage == null ? null : resize(landImage,this.getBounds().width,this.getBounds().height);
        }

        /**
         * @param entityImage the entityImage to set
         */
        public void setEntityImage(BufferedImage entityImage) {
            this.entityImage = entityImage == null ? null : resize(entityImage,this.getBounds().width,this.getBounds().height);
        }

        /**
         * @return the entityImage
         */
        public BufferedImage getEntityImage() {
            return entityImage;
        }

        public static BufferedImage resize(BufferedImage img, int newW, int newH) {  
            int w = img.getWidth();  
            int h = img.getHeight();  
            BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
            Graphics2D g = dimg.createGraphics();  
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
            g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
            g.dispose();  
            return dimg;  
        }  

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (landImage != null){
                g.drawImage(landImage, 0, 0, null);
            }
            if (entityImage != null){
                g.drawImage(entityImage, 0, 0, null);
            }
        }
    }