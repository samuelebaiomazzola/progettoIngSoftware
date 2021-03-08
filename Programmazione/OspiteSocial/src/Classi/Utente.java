package Classi;

import java.util.ArrayList;
import java.util.List;

public class Utente {

    private String nome;
    private String cognome;
    private char sesso;
    private Integer eta;
    private String email;
    private String cittaResidenza;
    private String cellulare;
    private String password;
    private List<Alloggio> alloggi;

    public Utente(String nome, String cognome, char sesso, Integer eta, String email, String cittaResidenza, String cellulare, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.eta = eta;
        this.email = email;
        this.cittaResidenza = cittaResidenza;
        this.cellulare = cellulare;
        this.password = password;
        alloggi = new ArrayList();
    }
    
    public Alloggio inserisciAlloggio(String indirizzo, String citta, double distanzaCentro, double distanzaMezzoPubblico, Integer numeroMembriFamiglia){
            Alloggio alloggio; 
                if(indirizzo.isEmpty() || distanzaCentro<0 || distanzaMezzoPubblico<0){
                    return null;
                }
                for(int i=0;i<alloggi.size();i++){
                    if(alloggi.get(i).getIndirizzo().compareTo(indirizzo)==0){
                        return null;
                    }
                }
        alloggio = new Alloggio(indirizzo, citta, distanzaCentro, distanzaMezzoPubblico, numeroMembriFamiglia, 0);
        this.alloggi.add(alloggio);
        return alloggio;
    }
    
    public Alloggio visualizzaAlloggio(String indirizzo){
            for(int i=0;i<alloggi.size();i++){
                if(alloggi.get(i).getIndirizzo().compareTo(indirizzo)==0){
                    return alloggi.get(i);
                }
            }
        return null;
    }
    
    public boolean modificaDatiAlloggio(String indirizzo, String citta, double distanzaCentro, double distanzaMezzoPubblico, Integer numeroMembriFamiglia, Integer numeroTotalePostiLetto){
            for(int i=0;i<alloggi.size();i++){
                if(alloggi.get(i).getIndirizzo().compareTo(indirizzo)==0){
                    alloggi.get(i).setCitta(citta);
                    alloggi.get(i).setDistanzaCentro(distanzaCentro);
                    alloggi.get(i).setDistanzaMezzoPubblico(distanzaMezzoPubblico);
                    alloggi.get(i).setNumeroMembriFamiglia(numeroMembriFamiglia);
                    alloggi.get(i).setNumeroTotalePostiLetto(numeroTotalePostiLetto);
                    return true;
                }
            }
        return false;
    } 
    
    public boolean eliminaAlloggio(String indirizzo){
            for(int i=0;i<alloggi.size();i++){
                if(alloggi.get(i).getIndirizzo().compareTo(indirizzo)==0){
                    alloggi.remove(i);
                    return true;
                }
            }
        return false;
    } 
    
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public char getSesso() {
        return sesso;
    }

    public Integer getEta() {
        return eta;
    }

    public String getEmail() {
        return email;
    }

    public String getCittaResidenza() {
        return cittaResidenza;
    }

    public String getCellulare() {
        return cellulare;
    }

    public String getPassword() {
        return password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public void setCittaResidenza(String cittaResidenza) {
        this.cittaResidenza = cittaResidenza;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<Alloggio> getAlloggi() {
        return alloggi;
    }

    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", eta=" + eta + ", email=" + email + ", cittaResidenza=" + cittaResidenza + ", cellulare=" + cellulare + ", password=" + password + ", alloggi=" + alloggi + '}';
    }
    
}


