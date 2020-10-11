package Entity;

public class Obec {
    private int kod;
    private String nazev;
    private ObceType obceType;
    public Obec(){
        this.obceType = ObceType.OBEC;
    }
    public Obec(int kod,String nazev){
    this.kod = kod;
    this.nazev = nazev;
    this.obceType = ObceType.OBEC;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }
    public String getTypeObce(){
        return obceType.name();
    }
}
