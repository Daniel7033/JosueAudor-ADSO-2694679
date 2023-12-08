package Entity;

public class Artista {

    private Integer idArtista;
    private String nombreArtista;
    
    public Artista(Integer idArtista, String nombrea){
        this.idArtista = idArtista;
        this.nombreArtista = nombrea;
    }
    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }
}
