public class Grassland extends Land implements Renderable{
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