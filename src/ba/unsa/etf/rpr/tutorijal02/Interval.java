package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
private double pocetna,krajnja;
private  boolean pocetnaPripada,krajnjaPripada;

    public Interval(double pocetna, double kraj, boolean pocetnaPripada, boolean krajnjaPripada) {
        if(pocetna>kraj) throw new IllegalArgumentException("Pogresan unos");
        this.pocetna=pocetna;
        this.krajnja=kraj;
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
        if(i1.pocetna<i2.pocetna && i1.krajnja<i2.krajnja && i2.pocetna<i1.krajnja){
        Interval rjesenje=new Interval(i2.pocetna,i1.krajnja,i2.pocetnaPripada,i1.krajnjaPripada);
        return rjesenje;
        }
        else if(i2.pocetna<i1.pocetna && i2.krajnja<i1.krajnja && i1.pocetna<i2.krajnja){
         Interval rjesenje=new Interval(i1.pocetna,i2.krajnja,i1.pocetnaPripada,i2.krajnjaPripada);
         return rjesenje;
        }
        else if(i2.pocetna<i1.pocetna && i1.krajnja<i2.krajnja && i1.pocetna<i1.krajnja){
         Interval rjesenje=new Interval(i1.pocetna,i1.krajnja,i1.pocetnaPripada,i1.krajnjaPripada);
         return rjesenje;
        }
        else if(i1.pocetna<i2.pocetna && i2.krajnja<i1.krajnja && i2.pocetna<i2.krajnja ){
            Interval rjesenje=new Interval(i2.pocetna,i2.krajnja,i2.pocetnaPripada,i2.krajnjaPripada);
            return rjesenje;
         }else if(i1.pocetna==i2.pocetna && i1.krajnja==i2.krajnja){
            boolean pocetnapr=true;
            boolean krajnjapr=true;
            if(i1.pocetnaPripada==false || i2.pocetnaPripada==false){
                pocetnapr=false;
            }
            if(i2.krajnjaPripada==false || i2.krajnjaPripada==false){
                krajnjapr=false;
            }
            Interval Rjesenje= new Interval(i1.pocetna, i1.krajnja,pocetnapr,krajnjapr);
            return Rjesenje;
        }else return null;
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
         return  false;
    }

    public boolean isNull() {
        if(pocetnaPripada==false && krajnjaPripada==false && pocetna==0 && krajnja==0 )return true;
        return false;
    }

    public Interval intersect(Interval i2) {
        double poc=0;
        double krj=0;
        boolean pocprip=false;
        boolean krjprip=false;
        if(this.pocetna<i2.pocetna){
            poc=i2.pocetna;
            pocprip=i2.pocetnaPripada;

        }else
        {
            poc=this.pocetna;
            pocprip=this.pocetnaPripada;
        }
        if(this.krajnja<i2.krajnja){
            poc=this.krajnja;
            pocprip=this.krajnjaPripada;

        }else
        {
            poc=i2.pocetna;
            pocprip=i2.krajnjaPripada;
        }
        Interval rjesenje =new Interval(poc,krj,pocprip,krjprip);
        return rjesenje;

    }

    @Override
    public String toString() {
        if(pocetna==0 && krajnja==0)return "()";
        if(pocetnaPripada==true &&krajnjaPripada==true)
        return "[" +pocetna+","+krajnja+"]";
        if(pocetnaPripada==false &&krajnjaPripada ==false)
            return "(" +pocetna+","+krajnja+")";
        if(pocetnaPripada==true &&krajnjaPripada ==false)
            return "[" +pocetna+","+krajnja+")";
        if(pocetnaPripada==false && krajnjaPripada==true)
            return "([)" +pocetna+","+krajnja+"]";
        return null;
    }
}
