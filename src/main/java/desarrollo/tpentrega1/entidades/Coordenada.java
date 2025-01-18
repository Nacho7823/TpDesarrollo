
package desarrollo.tpentrega1.entidades;

public class Coordenada {
    private int id_coordenada;
    private double lat;
    private double lng;

    public Coordenada() {
    }

    public Coordenada(int id, double lat, double lng) {
        this.id_coordenada = id;
        this.lat = lat;
        this.lng = lng;
    }
    
    public Coordenada(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public int getId_coordenada() {
        return id_coordenada;
    }
    
    public void setId_coordenada(int id_coordenada) {
        this.id_coordenada = id_coordenada;
    }
    
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
    
    
    @Override
    public String toString() {
        return "Coordenada{" + "lat=" + lat + ", lng=" + lng + '}';
    }
}
