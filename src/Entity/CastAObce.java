package Entity;

public class CastObce extends Obec {
    private ObceType obceType;

    public CastObce(int kod,String nazev) {
    super(kod,nazev);
    this.obceType = ObceType.CASTOBCE;
    }

    @Override
    public String getTypeObce() {
        return obceType.name();
    }
}
