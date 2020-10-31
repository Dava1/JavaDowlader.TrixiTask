package Entity;

import Enums.ObceType;

public class Obec extends AObce {

    private ObceType obceType;

    public Obec(){
    };
    public Obec(int kod,String nazev){
        super(kod,nazev);
        this.obceType = ObceType.OBEC;
    }

    public String getTypeObce(){
        return obceType.name();
    }
    @Override
    public String toString(){
        return obceType+", "+super.toString();
    }
}
