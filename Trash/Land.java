public abstract class Land implements Renderable{
    protected boolean grass;
    protected String type;

    public void growGrass(){
        grass = true;
    }

    public void removeGrass(){
        grass = false;
    }

    public boolean isGrass(){
        return grass;
    }

    public String getType(){
        return type;
    }

    public abstract String Render();
}