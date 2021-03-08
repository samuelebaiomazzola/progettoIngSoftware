package Classi;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Alloggio {
    private String indirizzo;
    private String citta;
    private double distanzaCentro;
    private double distanzaMezzoPubblico;
    private Integer numeroMembriFamiglia;
    private Integer numeroTotalePostiLetto;
    private List<Periodo> calendario;
    private List<PostoLetto> postiLetto;

    
    public Alloggio(String indirizzo, String citta, double distanzaCentro, double distanzaMezzoPubblico, Integer numeroMembriFamiglia, Integer numeroTotalePostiLetto) {
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.distanzaCentro = distanzaCentro;
        this.distanzaMezzoPubblico = distanzaMezzoPubblico;
        this.numeroMembriFamiglia = numeroMembriFamiglia;
        this.numeroTotalePostiLetto = numeroTotalePostiLetto;
        postiLetto = new ArrayList();
        calendario = new ArrayList();
    }

    public boolean inserisciPeriodo(Date inizio,Date fine){
         Periodo periodo; 
                for(int i=0;i<calendario.size();i++){
                    if(!inizio.before(fine)  || (inizio.after(calendario.get(i).getDataInizio())  && inizio.before(calendario.get(i).getDataFine()) || inizio.compareTo(calendario.get(i).getDataInizio())==0) || (fine.after(calendario.get(i).getDataInizio()) && fine.before(calendario.get(i).getDataFine()) || fine.compareTo(calendario.get(i).getDataFine())==0) ){
                        return false;
                    }
                }
        periodo=new Periodo(inizio,fine);
        calendario.add(periodo);
        return true;
    } 
    
    public Periodo visualizzaPeriodo(Integer indicePeriodo){ 
            if(indicePeriodo>=calendario.size())return null;
        return calendario.get(indicePeriodo);
    } 
    
    public boolean modificaPeriodo(Integer indicePeriodo,Date inizio,Date fine){
            for(int i=0;i<calendario.size();i++){
                if(indicePeriodo!=i)
                if(!inizio.before(fine) || (inizio.after(calendario.get(i).getDataInizio()) && inizio.before(calendario.get(i).getDataFine())) || (fine.after(calendario.get(i).getDataInizio()) && fine.before(calendario.get(i).getDataFine())) ){
                    return false;
                }
            }
        calendario.get(indicePeriodo).setDataInizio(inizio);
        calendario.get(indicePeriodo).setDataFine(fine);
        return true;
    } 
    
    public boolean eliminaPeriodo(int indicePeriodo){
            if(indicePeriodo>=calendario.size())return false;
        calendario.remove(indicePeriodo);
        return true;
    } 
    
    public void setPostoLetto(List<PostoLetto> postiLetto) {
        this.postiLetto = postiLetto;
    } 
    
    private boolean aggiornaNumPostiLettoTot(Integer numero){
        this.numeroTotalePostiLetto+=numero;
        return true;
    } 
    
    public PostoLetto inserisciPostiLetto(Integer idLetto, Integer numeroStanza, String tipologiaStanza, String tipologiaPostoLetto, Integer numeroPostiLetto){
        PostoLetto pLetto; 
            if( tipologiaStanza.isEmpty() || tipologiaPostoLetto.isEmpty() || numeroPostiLetto == 0){
                return null;
            }
            for(int i=0;i<postiLetto.size();i++){
                if(postiLetto.get(i).getIdLetto().compareTo(idLetto)==0){
                    return null;
                }
            }
            if(numeroPostiLetto>2)return null;
        pLetto = new PostoLetto(idLetto, numeroStanza, tipologiaStanza, tipologiaPostoLetto, numeroPostiLetto);
        this.postiLetto.add(pLetto);
        this.aggiornaNumPostiLettoTot(numeroPostiLetto);
        return pLetto;
    } 
    
    public PostoLetto visualizzaPostoLetto(Integer idLetto){ 
            for(int i=0;i<postiLetto.size();i++){
                if(postiLetto.get(i).getIdLetto().intValue() == idLetto.intValue()){
                   return postiLetto.get(i);
                }
            }
        return null;
    }
    
    public boolean modificaDatiPostiLetto(Integer idLetto, Integer numeroStanza,String tipologiaStanza,String tipologiaPostoLetto, Integer numeroPostiLetto){ 
            if( tipologiaStanza.isEmpty() || tipologiaPostoLetto.isEmpty() || numeroPostiLetto == 0){
                return false;
            }
            for(int i=0;i<postiLetto.size();i++){
                if(postiLetto.get(i).getIdLetto().intValue() == idLetto.intValue()){
                   postiLetto.get(i).setNumeroStanza(numeroStanza);
                   postiLetto.get(i).setTipologiaPostoLetto(tipologiaPostoLetto);
                   postiLetto.get(i).setTipologiaStanza(tipologiaStanza);
                   postiLetto.get(i).setNumeroPostiLetto(numeroPostiLetto);
                   return true;
                }
            }
        return false;
    } 
    
    public boolean eliminaPostoLetto(Integer idLetto){
            for(int i=0;i<postiLetto.size();i++){
                if(postiLetto.get(i).getIdLetto().intValue() == idLetto.intValue()){
                    this.numeroTotalePostiLetto-=postiLetto.get(i).getNumeroPostiLetto(); 
                    postiLetto.remove(i);
                    return true;
                }
            }
        return false;
    } 
    
    public boolean verificaDisponibilita(Date inizio,Date fine){
            for(int i=0;i<calendario.size();i++){
                if(calendario.get(i).confrontaPeriodo(inizio,fine)==true)
                    return true;
            }
        return false;
    } 
    
    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public double getDistanzaCentro() {
        return distanzaCentro;
    }

    public double getDistanzaMezzoPubblico() {
        return distanzaMezzoPubblico;
    }

    public Integer getNumeroMembriFamiglia() {
        return numeroMembriFamiglia;
    }

    public Integer getNumeroTotalePostiLetto() {
        return numeroTotalePostiLetto;
    }

    public List<Periodo> getCalendario() {
        return calendario;
    }

    public List<PostoLetto> getPostiLetto() {
        return postiLetto;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setDistanzaCentro(double distanzaCentro) {
        this.distanzaCentro = distanzaCentro;
    }

    public void setDistanzaMezzoPubblico(double distanzaMezzoPubblico) {
        this.distanzaMezzoPubblico = distanzaMezzoPubblico;
    }

    public void setNumeroMembriFamiglia(Integer numeroMembriFamiglia) {
        this.numeroMembriFamiglia = numeroMembriFamiglia;
    }

    public void setNumeroTotalePostiLetto(Integer numeroTotalePostiLetto) {
        this.numeroTotalePostiLetto = numeroTotalePostiLetto;
    }
    
    @Override
    public String toString() {
        return "Alloggio{" + "indirizzo=" + indirizzo + ", citta=" + citta + ", distanzaCentro=" + distanzaCentro + ", distanzaMezzoPubblico=" + distanzaMezzoPubblico + ", numeroMembriFamiglia=" + numeroMembriFamiglia + ", numeroTotalePostiLetto=" + numeroTotalePostiLetto + '}';
    }

}
