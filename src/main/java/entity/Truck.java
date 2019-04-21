package entity;

public class Truck extends Facility{
    private static Truck truckInstance = null;
    private int awayCounter;

    private Truck(int _x, int _y){
        pos_x = _x;
        pos_y = _y;
        awayCounter = 0;
    }
    
    public static Truck getInstance() throws IllegalAccessException{
        if (truckInstance != null){
            return truckInstance;
        }
        else{
            throw new IllegalAccessException("Well not initialized");
        }
    }

    public static void initialize(int _x, int _y){ 
        if (truckInstance == null){
            truckInstance = new Truck(_x, _y);
        }
    }

    public String render(){
        return "T";
    }

    public void tickTruck(){
        if (awayCounter > 0){
            awayCounter--;
        }
    }

    public void setAwayCounter(int val){
        awayCounter = val;
    }

    public int getAwayCounter(){
        return awayCounter;
    }
}