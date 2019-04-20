package engstarsfarm;

import viewcontroller.Game;
import model.LinkedList;
import entity.Player;
import product.CowMeat;
import product.ChickenEgg;

public class App{
    public static void main(String[] args){
        try{
            Game.initialize("map.dat");
            Game.drawScreen();
            while (true){
                Game.tick();
                Game.drawScreen();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
