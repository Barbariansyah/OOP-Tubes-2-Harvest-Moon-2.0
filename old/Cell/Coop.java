public class Coop extends Land implements Renderable{
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