package Entity;

import Enums.ObceType;

public abstract class AObce {
   private int kod;
   private String nazev;
   public AObce() {
   }

   AObce(int kod,String nazev){
      this.kod = kod;
      this.nazev = nazev;
   }
   public int getKod(){return kod;}
   public String getNazev(){return nazev;}
   public void setKod(int kod){
      this.kod= kod;
   };
   public void setNazev(String nazev) {
      this.nazev = nazev;
   }

   @Override
   public String toString(){
   return nazev
           +" ,"+kod;
   }
}
