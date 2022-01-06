public class Odgovor {

    private int pitanje_id;
    private String poljeA;
    private String poljeB;
    private String poljeC;
    private String poljeD;

    public Odgovor(String poljeA, String poljeB, String poljeC, String poljeD) {
        this.poljeA = poljeA;
        this.poljeB = poljeB;
        this.poljeC = poljeC;
        this.poljeD = poljeD;
    }

    public Odgovor(int pitanje_id, String poljeA, String poljeB, String poljeC, String poljeD) {
        this.pitanje_id = pitanje_id;
        this.poljeA = poljeA;
        this.poljeB = poljeB;
        this.poljeC = poljeC;
        this.poljeD = poljeD;
    }

    public Odgovor() {
    }

    public int getPitanje_id() {
        return pitanje_id;
    }

    public void setPitanje_id(int pitanje_id) {
        this.pitanje_id = pitanje_id;
    }

    public String getPoljeA() {
        return poljeA;
    }

    public void setPoljeA(String poljeA) {
        this.poljeA = poljeA;
    }

    public String getPoljeB() {
        return poljeB;
    }

    public void setPoljeB(String poljeB) {
        this.poljeB = poljeB;
    }

    public String getPoljeC() {
        return poljeC;
    }

    public void setPoljeC(String poljeC) {
        this.poljeC = poljeC;
    }

    public String getPoljeD() {
        return poljeD;
    }

    public void setPoljeD(String poljeD) {
        this.poljeD = poljeD;
    }

    @Override
    public String toString() {
        return "Odgovor{" +
                "pitanje_id=" + pitanje_id +
                ", poljeA='" + poljeA + '\'' +
                ", poljeB='" + poljeB + '\'' +
                ", poljeC='" + poljeC + '\'' +
                ", poljeD='" + poljeD + '\'' +
                '}';
    }
}
