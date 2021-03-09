package Classi;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OspiteSocial {
    private static OspiteSocial instance = null;
    private Utente utente;
    private List<Utente> utenti;
    private List<Prenotazione> prenotazioni; 
    
    
    //Il costruttore private impedisce l'istanza di oggetti da parte di classi esterne
    private OspiteSocial(){
        utenti = new ArrayList(); 
        prenotazioni = new ArrayList();
    }
    
    // Metodo della classe impiegato per accedere al singleton
    public static synchronized OspiteSocial getInstance() {
        if (instance == null ) {
            System.err.println("Istanza creata");
            instance = new OspiteSocial();
        }
        return instance;
    }
    
    public boolean logIn(String email,String password){
            for(int i=0;i<utenti.size();i++){
                if(utenti.get(i).getEmail().compareTo(email)==0 && utenti.get(i).getPassword().compareTo(password)==0){
                    this.utente=utenti.get(i);
                    return true;
                }
            }
        return false;
    }
    
    public String EmailLoggato(){
        return this.utente.getEmail();
    }
    
    public Utente inserisciUtente(String nome, String cognome, char sesso, Integer eta, String email, String cittaResidenza, String cellulare, String password){
        Utente utente1; 
            if(nome.isEmpty() || cognome.isEmpty() || cellulare.isEmpty() || password.isEmpty() || email.isEmpty() || cittaResidenza.isEmpty() || (sesso!='M' && sesso!='F') || eta<=0 ){
                System.out.println("Parametri inseriti non validi!");
                return null;
            }
            for(int i=0;i<utenti.size();i++){
                System.out.println(i);
                if(utenti.get(i).getEmail().compareTo(email)==0){
                    System.out.println("Utente già inserito!");
                    return null;
                }
            }
        utente1 = new Utente(nome,cognome,sesso,eta,email,cittaResidenza,cellulare,password);
        this.utenti.add(utente1);
        return utente1;
    }
    
    public Utente vissualizzaUtente(String email){
            for(int i=0;i<utenti.size();i++){
                if(utenti.get(i).getEmail().compareTo(email)==0){
                    return utenti.get(i);
                }
            }
        return null;
    }
    
    public boolean modificaDatiUtente(String nome, String cognome, char sesso, Integer eta, String email, String cittaResidenza, String cellulare, String password){
            for(int i=0;i<utenti.size();i++){
                if(utenti.get(i).getEmail().compareTo(email)==0){
                    utenti.get(i).setNome(nome);
                    utenti.get(i).setCognome(cognome);
                    utenti.get(i).setCittaResidenza(cittaResidenza);
                    utenti.get(i).setSesso(sesso);
                    utenti.get(i).setEta(eta);
                    utenti.get(i).setCellulare(cellulare);
                    utenti.get(i).setPassword(password);
                    this.utente=utenti.get(i);
                    return true;
                }
            }
        return false;
    }
    
    public boolean eliminaUtente(String email){
            for(int i=0;i<utenti.size();i++){
                if(utenti.get(i).getEmail().compareTo(email)==0){
                    utenti.remove(i);
                    utente=null;
                    return true;
                }
            }
        return false;
    }
    
    public List<Alloggio> ricercaAlloggio(String cittaDestinazione,Integer numeroPostiLetto,Date dataInizioSoggiorno,Date dataFineSoggiorno){
       
        List<Alloggio> alloggi = new ArrayList();
        Alloggio alloggioTmp; //alloggio temporaneo
        Integer posti;
       
        List<Integer> indici = new ArrayList();
        List<Alloggio> alloggioNew = new ArrayList();
        
        
            for(int z=0;z<utenti.size();z++){        
                List<Alloggio> listaAlloggiTmp=utenti.get(z).getAlloggi();
                    for(int j=0;j<listaAlloggiTmp.size();j++){
                        alloggi.add(listaAlloggiTmp.get(j));
                           for(int i=0;i<listaAlloggiTmp.get(j).getPostiLetto().size();i++){
                                listaAlloggiTmp.get(j).getPostiLetto().get(i).setRisultatoRicerca(true);
                            }
                    }
            } /* Per prima cosa vengono inseriti tutti gli alloggi appartenenti agli utenti iscritti alla piattaforma ovvero all'interno
              della classe utenti in una lista alloggi tempoaranea. Secondo for vengono inseriti tutti gli alloggi appartenenti agli utenti 
              presenti nella lista alloggi temporanea nella lista alloggi. Terzo for prende tutti gli alloggi e tutti i posti letto e viene
              settata la variabile risultatoRicerca a TRUE e viene creata una lista di alloggi con i postiLetto disponibili.*/
            
            
            for(int i=0;i<alloggi.size();i++){
                alloggioTmp=alloggi.get(i);
                
                    if(alloggioTmp.getCitta().compareTo(cittaDestinazione)==0 && utente.getAlloggi().contains(alloggioTmp)==false){
                        if(alloggioTmp.verificaDisponibilita(dataInizioSoggiorno,dataFineSoggiorno)){
                            posti=alloggioTmp.getNumeroTotalePostiLetto();
                                for(int j=0;j<prenotazioni.size();j++){
                                    Prenotazione prenotazione=prenotazioni.get(j);
                                        if(prenotazione.getStato().compareTo("Confermata")==0 || prenotazione.getStato().compareTo("In corso")==0 || prenotazione.getStato().compareTo("Da confermare")==0){
                                            if(prenotazione.getAlloggio().equals(alloggioTmp) ){                                         
                                                posti=prenotazione.controlloPostiLetto(posti,dataInizioSoggiorno,dataFineSoggiorno);
                                                List<PostoLetto> PostiLettoPrenotati=prenotazione.getPostiLetto();
                                                    if(prenotazione.controlloPeriodo(dataInizioSoggiorno,dataFineSoggiorno)==true){
                                                        for(int k=0;k<PostiLettoPrenotati.size();k++){
                                                                for(int l=0;l<alloggi.get(i).getPostiLetto().size();l++){ // Lista dei posti letto contenuta in alloggi
                                                                       if(alloggi.get(i).getPostiLetto().get(l).getIdLetto().intValue()==PostiLettoPrenotati.get(k).getIdLetto().intValue() && alloggi.get(i).getIndirizzo().compareTo(prenotazione.getAlloggio().getIndirizzo())==0){
                                                                          alloggi.get(i).getPostiLetto().get(l).setRisultatoRicerca(false);
                                                                        }
                                                                }
                                                        }
                                                    }
                                            }
                                        }
                                }
                             
                            if(posti<numeroPostiLetto){
                                indici.add(i);
                            }
                        }else indici.add(i);
                    }else indici.add(i);
                    
            }
           
            for(Integer z=0;z<alloggi.size();z++){
                if(!indici.contains(z))
                alloggioNew.add(alloggi.get(z));
            }
            
        return alloggioNew;
    }
    
    public boolean richiestaPrenotazione(List<PostoLetto> postiLetto, List<String> ospiti,Date dataArrivo,Date dataPartenza, Alloggio alloggio){
        Utente utenteTmp=null;
        Utente ospitante=null;
        List<Utente> listaOspiti=new ArrayList();
        boolean presente=false;
        
            //Dati non nulli e data coerente
            if(ospiti.isEmpty() || postiLetto.isEmpty() || dataArrivo.after(dataPartenza))return false;
            //controlla se esiste l'abitazione correlata a quell'ospitante
            for(int i=0;i<utenti.size();i++){
                utenteTmp=utenti.get(i);
                
                    if(utenteTmp.getAlloggi().contains(alloggio)==true)
                          ospitante=utenteTmp;
            }
            if(ospitante==null)return false;
            
            
            //controllo se il numero di ospitanti coincide con la reale disponibilità di posti letto nell'abitazione
            Integer posti=0;
            for(int i=0;i<postiLetto.size();i++){
                posti+=postiLetto.get(i).getNumeroPostiLetto(); 
            }
            if( ! (posti==ospiti.size() || posti==(ospiti.size()+1))  )return false;
            
            //cotrollo se gli utenti inseriti sono registrati sulla piattaforma
            for(int i=0;i<ospiti.size();i++){
                    for(int j=0;j<utenti.size();j++){
                        if(utenti.get(j).getEmail().compareTo(ospiti.get(i))==0){
                            listaOspiti.add(utenti.get(j));
                            if(utenti.get(j).getEmail().compareTo(this.EmailLoggato())==0){
                                presente=true;
                            }
                            
                            //non si può indicare l'ospitante fra gli ospiti
                            if(ospitante.getEmail().compareTo(utenti.get(j).getEmail())==0)return false;
                        }
                    }
            } 
            if(listaOspiti.size()!=ospiti.size())return false;
            
            //deve esistere fra gli ospiti l'utente loggato
            if(presente==false)return false;
            
        //Prenotazione
        Prenotazione prenotazione;
        prenotazione=new Prenotazione(ospitante, listaOspiti, dataPartenza, dataArrivo, alloggio, postiLetto);
        prenotazioni.add(prenotazione);
        return true;
    }
    
    public boolean accettaRichiesta(Prenotazione prenotazione){
           if(prenotazione.getUtenteOspitante().getEmail().compareTo(this.EmailLoggato())!=0)return false;
           if(prenotazione.getStato().compareTo("Da confermare")!=0)return false;
        prenotazione.setStato("Confermata");
        return true;
    }
    
    public boolean rifiutaRichiesta(Prenotazione prenotazione,String motivazione){
           if(prenotazione.getUtenteOspitante().getEmail().compareTo(this.EmailLoggato())!=0)return false;
           if(prenotazione.getStato().compareTo("Da confermare")!=0)return false;
        prenotazione.setStato("Rifiutata");
        prenotazione.setMotivazione(motivazione);
        return true;
    }
    
    public List<Prenotazione> visualizzaRichiesta(){
        List<Prenotazione> prenotazioniNew = new ArrayList();
        
        Prenotazione prenotazione;
            for(int i=0;i<prenotazioni.size();i++){
                prenotazione = prenotazioni.get(i);
                    if(prenotazione.getUtenteOspitante().getEmail().compareTo(this.EmailLoggato())==0){
                        prenotazioniNew.add(prenotazione);
                    }
            }
        return prenotazioniNew;
    }
    
    public List<Prenotazione> elencoPrenotazioni(){
        List<Prenotazione> prenotazioniNew = new ArrayList();
       
        Prenotazione prenotazione;
            for(int i=0;i<prenotazioni.size();i++){
                prenotazione=prenotazioni.get(i);
                    if(prenotazione.getOspiti().contains(this.utente)==true){
                        prenotazioniNew.add(prenotazione);
                    }
            }
        return prenotazioniNew;
    }
    
    public boolean modificaPrenotazione(Date dataInizioSoggiorno, Date dataFineSoggiorno, Prenotazione prenotazione){
        Alloggio alloggioPre;
        Alloggio a;
        int posti = 0;
        
        a = prenotazione.getAlloggio();
        if(a.verificaDisponibilita(dataFineSoggiorno, dataFineSoggiorno) == true){
            for(int i =0; i<prenotazione.getAlloggio().getCalendario().size(); i++){
               Periodo p = prenotazione.getAlloggio().getCalendario().get(i);
               p.confrontaPeriodo(dataInizioSoggiorno, dataFineSoggiorno);
            }
                posti = prenotazione.getAlloggio().getNumeroTotalePostiLetto();
        }
        if(prenotazione.getStato().compareTo("Confermata")==0 || prenotazione.getStato().compareTo("In corso")==0 || prenotazione.getStato().compareTo("Da confermare")==0){
            for(int i =0; i<prenotazioni.size(); i++){
                Prenotazione pre = prenotazioni.get(i);
                alloggioPre = pre.getAlloggio();

                if(alloggioPre == a){
                    posti = prenotazione.controlloPostiLetto(posti, dataFineSoggiorno, dataFineSoggiorno);
                    if(prenotazione.controlloPeriodo(dataInizioSoggiorno, dataFineSoggiorno)){
                        int pos = alloggioPre.getNumeroTotalePostiLetto();
                    }
                }
            }
        }
        //controllo se il numero di ospitanti coincide con la reale disponibilità di posti letto nell'abitazione
        for(int i=0;i<prenotazione.getPostiLetto().size();i++){
            posti+=prenotazione.getPostiLetto().get(i).getNumeroPostiLetto(); 
        }
        if( ! (posti== prenotazione.getOspiti().size() || posti==(prenotazione.getOspiti().size() + 1))  )return false;
        return false;  
    }
    
    public boolean eliminaPrenotazione(Prenotazione prenotazione){
        if (prenotazioni.contains(prenotazione) == true){
            prenotazione.setStato("Annullata");
            return true;
        }
        return false;
    }
    
    public Utente getUtente() {
        return utente;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
    
}

