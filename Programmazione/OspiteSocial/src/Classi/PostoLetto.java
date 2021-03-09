
package Classi;

public class PostoLetto {
    private Integer idLetto;
    private Integer numeroStanza;
    private String tipologiaStanza;
    private String tipologiaPostoLetto;
    private Integer numeroPostiLetto; // c'è bisogno per contare il numero di posti letto in una specifica stanza
    private boolean  risultatoRicerca;

    public PostoLetto(Integer idLetto, Integer numeroStanza, String tipologiaStanza, String tipologiaPostoLetto, Integer numeroPostiLetto) {
        this.idLetto = idLetto;
        this.numeroStanza = numeroStanza;
        this.tipologiaStanza = tipologiaStanza;
        this.tipologiaPostoLetto = tipologiaPostoLetto;
        this.numeroPostiLetto = numeroPostiLetto;
        this.risultatoRicerca=true;
    }

    public Integer getIdLetto() {
        return idLetto;
    }

    public Integer getNumeroStanza() {
        return numeroStanza;
    }

    public String getTipologiaStanza() {
        return tipologiaStanza;
    }

    public String getTipologiaPostoLetto() {
        return tipologiaPostoLetto;
    }
    
    public Integer getNumeroPostiLetto() {
        return numeroPostiLetto;
    }
    
    public boolean isRisultatoRicerca() {
        return risultatoRicerca;
    }

    public void setNumeroStanza(Integer numeroStanza) {
        this.numeroStanza = numeroStanza;
    }

    public void setTipologiaStanza(String tipologiaStanza) {
        this.tipologiaStanza = tipologiaStanza;
    }

    public void setTipologiaPostoLetto(String tipologiaPostoLetto) {
        this.tipologiaPostoLetto = tipologiaPostoLetto;
    }
    
    public void setNumeroPostiLetto(Integer numeroPostiLetto) {
        this.numeroPostiLetto = numeroPostiLetto;
    }
    
    public void setRisultatoRicerca(boolean risultatoRicerca) {
        this.risultatoRicerca = risultatoRicerca;
    }
    
    @Override
    public String toString() {
        return "PostoLetto{" + "idLetto=" + idLetto + ", numeroStanza=" + numeroStanza + ", tipologiaStanza=" + tipologiaStanza + ", tipologiaPostoLetto=" + tipologiaPostoLetto + '}';
    }
    
}
