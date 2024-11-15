
package desarrollo.tpentrega1.entidades;

public class Coordenada {
    private double lat;
    private double lng;

    public Coordenada() {
    }

    public Coordenada(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
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
