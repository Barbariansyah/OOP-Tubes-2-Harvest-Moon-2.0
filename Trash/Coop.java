public class Coop extends Land{
    public Coop(){
        grass = false;
        type = "Coop";
    }

    public String render(){
        if(isGrass()){
            return "*";
        }else{
            return "O";
        }
    }
}