package Entity;

import Enums.ObceType;

public class CastAObce extends AObce {
    private Obec patriKObcu;
    private ObceType obecType;

    public CastAObce(int kod, String nazev) {

        super(kod, nazev);
        this.obecType = ObceType.CAST_OBCE;
    }
    public void setObec(Obec obec){
        this.patriKObcu = obec;
    }
    public void setObecType(ObceType obecType){
        this.obecType = obecType;
    }
    public ObceType getObecType(){
        return this.obecType;
    }
    @Override
    public String toString(){
        return obecType+", "+super.toString();
    }
}
