public class TacanOdgovor {

    private int id;
    private char tacanOdgovor;

    public TacanOdgovor(int id, char tacanOdgovor) {
        this.id = id;
        this.tacanOdgovor = tacanOdgovor;
    }

    public TacanOdgovor(char tacanOdgovor) {
        this.tacanOdgovor = tacanOdgovor;
    }

    public TacanOdgovor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getTacanOdgovor() {
        return tacanOdgovor;
    }

    public void setTacanOdgovor(char tacanOdgovor) {
        this.tacanOdgovor = tacanOdgovor;
    }

    @Override
    public String toString() {
        return "TacanOdgovor{" +
                "id=" + id +
                ", tacanOdgovor=" + tacanOdgovor +
                '}';
    }
}
