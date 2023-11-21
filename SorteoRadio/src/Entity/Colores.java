package Entity;

public class Colores {
    private Integer idColor;
    String color;
    
    public Colores(Integer idrgb, String color){
        this.idColor = idrgb;
        this.color = color;
    }
    
    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
