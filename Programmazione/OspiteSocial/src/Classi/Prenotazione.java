package Classi;

import java.sql.Date;
import java.util.List;

public class Prenotazione {
    private Utente utenteOspitante;
    private List<Utente> ospiti;
    private Date dataInizioSogg;
    private Date dataFineSogg;
    private String stato;
    private Alloggio alloggio;
    private List<PostoLetto> postiLetto;
    private String motivazione;

    public Prenotazione(Utente utenteOspitante, List<Utente> ospiti, Date dataInizioSogg, Date dataFineSogg, Alloggio alloggio, List<PostoLetto> postiLetto) {
        this.utenteOspitante = utenteOspitante;
        this.ospiti = ospiti;
        this.dataInizioSogg = dataInizioSogg;
        this.dataFineSogg = dataFineSogg;
        this.stato = "Da confermare";
        this.alloggio = alloggio;
        this.postiLetto = postiLetto;
        this.motivazione = "";
    }

    public Integer controlloPostiLetto(Integer posti,Date inizio,Date fine){
        Integer postoLetto=0;
        if( (inizio.after(dataInizioSogg) && inizio.before(dataFineSogg) || inizio.compareTo(dataInizioSogg)==0) || (fine.after(dataInizioSogg) && fine.before(dataFineSogg) || fine.compareTo(dataFineSogg)==0)){
                for(int i=0;i<postiLetto.size();i++)postoLetto+=alloggio.getNumeroTotalePostiLetto();
            return posti-postoLetto;
        }
        return posti;
    }
    
    public boolean controlloPeriodo(Date inizio,Date fine){
        if( (inizio.after(dataInizioSogg) && inizio.before(dataFineSogg) || inizio.compareTo(dataInizioSogg)==0) || (fine.after(dataInizioSogg) && fine.before(dataFineSogg) || fine.compareTo(dataFineSogg)==0)){
            return true;
        }
        return false;
    }
    
    public Utente getUtenteOspitante() {
        return utenteOspitante;
    }

    public List<Utente> getOspiti() {
        return ospiti;
    }

    public Date getDataInizioSogg() {
        return dataInizioSogg;
    }

    public Date getDataFine() {
        return dataFineSogg;
    }

    public String getStato() {
        return stato;
    }

    public Alloggio getAlloggio() {
        return alloggio;
    }

    public List<PostoLetto> getPostiLetto() {
        return postiLetto;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    @Override
    public String toString() {
        return "Prenotazione{" + "utenteOspitante=" + utenteOspitante + ", dataInizioSogg=" + dataInizioSogg + ", dataFineSogg=" + dataFineSogg + ", stato=" + stato + ", motivazione=" + motivazione + '}';
    }
    
}
