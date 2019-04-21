package engstarsfarm;

import viewcontroller.Game;
import model.LinkedList;
import entity.Player;

public class App{
    public static void main(String[] args){
        try{
            Game.initialize("map/map.dat");
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
