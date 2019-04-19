public class Barn extends Land{
    public Barn(){
        grass = false;
        type = "Barn";
    }

    public String Render(){
        if(isGrass()){
            return "@";
        }else{
            return "X";
        }
    }
}