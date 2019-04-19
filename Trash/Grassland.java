public class Grassland extends Land{
    public Grassland(){
        grass = false;
        type = "Grassland";
    }

    public String render(){
        if(isGrass()){
            return "#";
        }else{
            return "-";
        }
    }
}