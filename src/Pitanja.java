public class Pitanja {

    private int id;
    private String pitanja;

    public Pitanja(int id, String pitanja) {
        this.id = id;
        this.pitanja = pitanja;
    }

    public Pitanja() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPitanja() {
        return pitanja;
    }

    public void setPitanja(String pitanja) {
        this.pitanja = pitanja;
    }

    @Override
    public String toString() {
        return "Pitanja{" +
                "id=" + id +
                ", pitanja='" + pitanja + '\'' +
                '}';
    }
}
