package harisgusinac.com.recipesolution.model;

public class Mesurment {
    private String id;
    private String mesurment;

    public Mesurment(String id, String mesurment) {
        this.id = id;
        this.mesurment = mesurment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMesurment() {
        return mesurment;
    }

    public void setMesurment(String mesurment) {
        this.mesurment = mesurment;
    }

}
