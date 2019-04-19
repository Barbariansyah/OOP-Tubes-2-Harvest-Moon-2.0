public class Coop extends Land{
    public Coop(){
        grass = false;
        type = "Coop";
    }

    public String Render(){
        if(isGrass()){
            return "*";
        }else{
            return "O";
        }
    }
}