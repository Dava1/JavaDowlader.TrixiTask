package main;

import Entity.CastAObce;
import Entity.Obec;
import Handlers.Downlader;

import java.util.Set;

public class Main {
   static String url = "https://vdp.cuzk.cz/vymenny_format/soucasna/20200930_OB_573060_UZSZ.xml.zip";
    public static void main(String[] args) {
        Downlader downlader = new Downlader("Trixi.zip",url);
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
