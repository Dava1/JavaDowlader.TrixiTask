package main;

import Entity.CastAObce;
import Entity.Obec;
import Handlers.Downlader;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Downlader downlader = new Downlader();
        Set<Obec> obce = downlader.getObce();
        Set<CastAObce> castObce = downlader.getCastObces();
        for (Obec e:
             obce) {
            System.out.println(e.toString());
        }
        for (CastAObce e:
             castObce) {
            System.out.println(e.toString());
        }
    }
}
