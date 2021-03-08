package Classi;

import java.sql.Date;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;


public class NewMain {

    public static void main(String[] args) {
        Alloggio alloggio;
        OspiteSocial os = null;
        os = OspiteSocial.getInstance();
        
        String nome = "saro";
        String cognome = "Baiomazzola";
        char sesso = 'M';
        Integer eta = 24;
        String email = "saro.baiomazzola@studium.unict.it";
        String cittaResidenza = "Caltanissetta";
        String cellulare = "3287456159";
        String password = "baio";
        Utente utente;
        
        
        
        utente = os.inserisciUtente(nome, cognome, sesso, eta, email, cittaResidenza, cellulare, password);
        //System.out.println(utente.toString());
        
        utente = os.vissualizzaUtente(email);
        
        //Per la prenotazione
        Prenotazione prenotazione;
        
        Utente ospite1; String email1 = "ospite1.baiomazzola@studium.unict.it";
        Utente ospite2; String email2 = "ospite2.baiomazzola@studium.unict.it";
        
        ospite1 = os.inserisciUtente(nome, cognome, sesso, eta, email1, cittaResidenza, cellulare, password);
        ospite2 = os.inserisciUtente(nome, cognome, sesso, eta, email2, cittaResidenza, cellulare, password);
        
        
        List<Utente> ospiti = new ArrayList();
        
        ospiti.add(ospite1);
        ospiti.add(ospite2);
        
        
        //System.out.println(os.vissualizzaUtente(email));*/
        
        String indirizzo = "Via Santa Sofia 64";
        String citta = "Catania";
        double distanzaCentro = 1.0;
        double distanzaMezzoPubblico = 1.5;
        Integer numeroMembriFamiglia = 4;
        Integer numeroTotalePostiLetto = 3;
        
        
        alloggio = new Alloggio(indirizzo, citta, distanzaCentro, distanzaMezzoPubblico, numeroMembriFamiglia, numeroTotalePostiLetto);
        //System.out.println(alloggio);
        
        Integer idLetto = 1;
        Integer numeroStanza = 1;
        String tipologiaStanza = "Privata";
        String tipologiaPostoLetto = "Letto";
        Integer numeroPostiLetto = 1;
        
        System.out.println(alloggio.inserisciPostiLetto(idLetto, numeroStanza, tipologiaStanza, tipologiaPostoLetto, numeroPostiLetto));
        PostoLetto postoLetto1 = alloggio.inserisciPostiLetto(2, 1, "Comune", "Divano Letto", 2);
        //System.out.println(postoLetto1);
        
        List<PostoLetto> postiLetto = new ArrayList();
        postiLetto.add(postoLetto1);
        
        prenotazione = new Prenotazione(utente, ospiti, Date.valueOf("2021-03-10"), Date.valueOf("2021-03-18"), alloggio, postiLetto);
        
        /*System.out.println(alloggio.visualizzaPostoLetto(idLetto));
        System.out.println(alloggio.visualizzaPostoLetto(2));
        System.out.println(alloggio.inserisciPeriodo(Date.valueOf("2021-03-10"), Date.valueOf("2021-03-18")));
        System.out.println(alloggio.modificaDatiPostiLetto(idLetto, 2, "COmune", "Divano Letto", numeroPostiLetto));*/
        
        //System.out.println(alloggio.eliminaPostoLetto(idLetto));
        
        System.out.println(prenotazione);
        System.out.println(alloggio.getNumeroTotalePostiLetto());
        System.out.println(os.ricercaAlloggio("Catania", 5, Date.valueOf("2021-03-10"), Date.valueOf("2021-03-18")));
        
        
        List<String> listaOspiti = new ArrayList();
        listaOspiti.add(email1);
        listaOspiti.add(email2);
        List<Prenotazione> listaPrenotazioni = new ArrayList();
        listaPrenotazioni.add(prenotazione);
        /*System.out.println(listaPrenotazioni);
        System.out.println(os.richiestaPrenotazione(postiLetto, listaOspiti,  Date.valueOf("2021-03-18"), Date.valueOf("2021-03-10"), alloggio));
        System.out.println(os.visualizzaRichiesta());*/
    }
    
}

