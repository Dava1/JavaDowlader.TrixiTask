package main;

import Entity.CastObce;
import Entity.Obec;
import Handlers.Downlader;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Downlader downlader = new Downlader();
        Set<Obec> obce = downlader.getObce();
        Set<CastObce> castObce = downlader.getCastObces();
        for (Obec e:
             obce) {
            System.out.println(e.getKod()+" "+e.getNazev()+" "+e.getTypeObce());
        }
        for (CastObce e:
             castObce) {
            System.out.println(e.getNazev()+" "+e.getKod()+" "+e.getTypeObce());
        }
    }
}
