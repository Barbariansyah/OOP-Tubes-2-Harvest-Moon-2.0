package cell;

public class Barn extends Land{
    public Barn(){
        grass = false;
        type = "Barn";
    }

    public String render(){
        if(isGrass()){
            return "@";
        }else{
            return "X";
        }
    }
}