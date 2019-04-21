package engstarsfarm;

import viewcontroller.Game;
import model.LinkedList;
import entity.Player;
import product.*;

public class App{
    public static void main(String[] args){
        try{
            Game.initialize("map/map.dat");
            Player.getInstance().getInventory().add(new ChickenEgg());
            Player.getInstance().getInventory().add(new CowMeat());
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
