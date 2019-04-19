public class Grassland extends Land{
    public Grassland(){
        grass = false;
        type = "Grassland";
    }

    public String Render(){
        if(isGrass()){
            return "#";
        }else{
            return "-";
        }
    }
}