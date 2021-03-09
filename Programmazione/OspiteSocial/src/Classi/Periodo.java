package Classi;

import java.sql.Date;

public class Periodo {
    private Date dataInizio;
    private Date dataFine;

    public Periodo(Date dataInizio, Date dataFine) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }
    
    public boolean confrontaPeriodo(Date inizio,Date fine){
        if( (inizio.after(dataInizio) || inizio.toString().compareTo(dataInizio.toString())==0) && (fine.before(dataFine) || fine.toString().compareTo(dataFine.toString())==0)){
           return true;
        }else{
           return false;
        }
           
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "Periodo{" + "dataInizio=" + dataInizio + ", dataFine=" + dataFine + '}';
    }
    
}
