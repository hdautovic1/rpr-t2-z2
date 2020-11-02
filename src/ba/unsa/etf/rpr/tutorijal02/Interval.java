package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
private double pocetna,krajnja;
private  boolean pocetnaPripada,krajnjaPripada;

    public Interval(double pocetna, double kraj, boolean pocetnaPripada, boolean krajnjaPripada) {
        this.pocetna=pocetna;
        this.krajnja=krajnja;
        this.pocetnaPripada=pocetnaPripada;
        this.krajnjaPripada=krajnjaPripada;
    }
    public Interval(){
        pocetnaPripada=false;
        krajnjaPripada=false;
        pocetna=0;
        krajnja=0;
    }
    public static Interval intersect(Interval i1, Interval i2) {
       double poc=0;
       double krj=0;
       boolean pocprip=false;
       boolean krjprip=false;
        if(i1.pocetna<i2.pocetna){
            poc=i2.pocetna;
            pocprip=i2.pocetnaPripada;

        }else
        {
            poc=i1.pocetna;
            pocprip=i1.pocetnaPripada;
        }
        if(i1.krajnja<i2.krajnja){
            poc=i1.krajnja;
            pocprip=i1.krajnjaPripada;

        }else
        {
            poc=i2.pocetna;
            pocprip=i2.krajnjaPripada;
        }
        Interval rjesenje =new Interval(poc,krj,pocprip,krjprip);
        return rjesenje;

    }


    public boolean isIn(double v) {
        if(pocetnaPripada==true&&krajnjaPripada==true){
            if(v>=pocetna&&v<=krajnja)return true;
            else return  false;
        }
        if(pocetnaPripada==true&&krajnjaPripada==false){
            if(v>=pocetna&&v<krajnja)return true;
            else return  false;
        }
        if(pocetnaPripada==false&&krajnjaPripada==true){
            if(v>pocetna&&v<=krajnja)return true;
            else return  false;
        }
        if(pocetnaPripada==false&&krajnjaPripada==false){
            if(v>pocetna&&v<krajnja)return true;
            else return  false;
        }
         return  false:
    }

    public boolean isNull() {
        if(pocetnaPripada==false && krajnjaPripada==false && pocetna==0 && krajnja==0 )return true;
        return false;
    }

    public Interval intersect(Interval interval) {
    }
}
