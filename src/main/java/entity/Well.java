package entity;

public class Well extends Facility{
    private static Well wellInstance = null;

    private Well(int _x, int _y){
        pos_x = _x;
        pos_y = _y;
    }
    
    public static Well getInstance() throws IllegalAccessException{
        if (wellInstance != null){
            return wellInstance;
        }
        else{
            throw new IllegalAccessException("Well not initialized");
        }
    }

    public static void initialize(int _x, int _y){ 
        if (wellInstance == null){
            wellInstance = new Well(_x, _y);
        }
    }

    public String render(){
        return "W";
    }
}