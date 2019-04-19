public class Mixer extends Facility implements Renderable{
    private static Mixer mixerInstance = null;

    private Mixer(int _x, int _y){
        pos_x = _x;
        pos_y = _y;
    }
    
    public static Mixer getInstance() throws IllegalAccessException{
        if (mixerInstance != null){
            return mixerInstance;
        }
        else{
            throw new IllegalAccessException("Mixer not initialized");
        }
    }

    public static void initialize(int _x, int _y){
        if (mixerInstance == null){
            mixerInstance = new Mixer(_x, _y);
            Game.setEntity(_x, _y, mixerInstance);
        }
    }

    public String Render(){
        return "M";
    }
}