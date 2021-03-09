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
        System.out.println(" ");
        
        //Dati per l'utente:
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
        System.out.println("[Metodo]: inserisci utente");
        System.out.println("[Dati utente]:" + " " + utente.toString());
        System.out.println(" ");
        
        Utente visualizzaUtente = os.vissualizzaUtente(email);
        System.out.println("[Metodo]: visulizza utente");
        System.out.println("[Dati utente]:" + " " + visualizzaUtente);
        System.out.println(" ");
        
        
        boolean modificaUtente = os.modificaDatiUtente(nome, cognome, sesso, eta, email, cittaResidenza, "3215698714", "baio96");
        System.out.println("[Metodo]: modifica utente");
        System.out.println("[Result metodo]:" + " " + modificaUtente);
        System.out.println("[Dati utente modificati]:" + " "+ utente.toString());
        System.out.println(" ");
        
        
        //Dati per l'alloggio:
        String indirizzo = "Via Santa Sofia 64";
        String citta = "Catania";
        double distanzaCentro = 1.0;
        double distanzaMezzoPubblico = 1.5;
        Integer numeroMembriFamiglia = 4;
        //Integer numeroTotalePostiLetto = 0;
        
        
        alloggio = utente.inserisciAlloggio(indirizzo, citta, distanzaCentro, distanzaMezzoPubblico, numeroMembriFamiglia);
        System.out.println("[Metodo]: inserisci alloggio");
        System.out.println("[Dati alloggio]:" + " " + alloggio);
        System.out.println(" ");
        
        
        Alloggio visualizzaAlloggio = utente.visualizzaAlloggio(indirizzo);
        System.out.println("[Metodo]: visualizza alloggio");
        System.out.println("[Dati alloggio]:" + " " + visualizzaAlloggio);
        System.out.println(" ");
        
        
        //Dati per posto letto:
        Integer idLetto = 1;
        Integer numeroStanza = 1;
        String tipologiaStanza = "Privata";
        String tipologiaPostoLetto = "Letto";
        Integer numeroPostiLetto = 1;
        
        PostoLetto postoLetto1 = alloggio.inserisciPostiLetto(idLetto, numeroStanza, tipologiaStanza, tipologiaPostoLetto, numeroPostiLetto);
        PostoLetto postoLetto2 = alloggio.inserisciPostiLetto(2, 1, "Comune", "Divano Letto", 2);
        System.out.println("[Metodo]: inserisci posto letto");
        System.out.println("[Dati posto letto 1]:" + " " + postoLetto1);
        System.out.println("[Dati posto letto 2]:" + " " + postoLetto2);
        System.out.println(" ");
        
        PostoLetto visualizzaPostoLetto = alloggio.visualizzaPostoLetto(idLetto);
        System.out.println("[Metodo]: visualizza posto letto");
        System.out.println("[Dati posto letto1]:" + " " + visualizzaPostoLetto);
        
        visualizzaPostoLetto = alloggio.visualizzaPostoLetto(2);
        System.out.println("[Dati posto letto2]:" + " " + visualizzaPostoLetto);
        System.out.println(" ");
        
        
        boolean modificaPostoLetto = alloggio.modificaDatiPostiLetto(idLetto, 2, "Comune", "Divano Letto", numeroPostiLetto);
        System.out.println("[Metodo]: modifica posto letto");
        System.out.println("[Result metodo]:" + " " + modificaPostoLetto);
        System.out.println("[Dati modificati posto letto 1]:" + " " + postoLetto1);
        System.out.println(" ");
        
        
        boolean eliminaPostoLetto = alloggio.eliminaPostoLetto(idLetto);
        System.out.println("[Metodo]: elimina posto letto");
        System.out.println("[Result metodo]:" + " " + eliminaPostoLetto);
        System.out.println(" ");
        
        
        boolean modificaAlloggio = utente.modificaDatiAlloggio(indirizzo, citta, 2.0, 3.0, numeroMembriFamiglia);
        System.out.println("[Metodo]: modifica alloggio");
        System.out.println("[Result metodo]:" + " " + modificaAlloggio);
        System.out.println("[Dati alloggio modificati]:" + " " + alloggio);
        System.out.println(" ");
        
        //Dati per il periodo:
        Date dataInizioSoggiorno = Date.valueOf("2021-03-10");
        Date dataFineSoggiorno = Date.valueOf("2021-03-18");
        
        boolean periodo = alloggio.inserisciPeriodo(dataInizioSoggiorno, dataFineSoggiorno);
        System.out.println("[Metodo]: inserisci periodo");
        System.out.println("[Result metodo]:" + " " + periodo);
        System.out.println("[Dati periodo]:" + alloggio.getCalendario().get(0));
        System.out.println(" ");
        
        
        Periodo visualizzaPeriodo = alloggio.visualizzaPeriodo(0);
        System.out.println("[Metodo]: visualizza periodo");
        System.out.println("[Dati periodo]:" + visualizzaPeriodo);
        System.out.println(" ");
        
        
        periodo = alloggio.modificaPeriodo(0, Date.valueOf("2021-03-13"), Date.valueOf("2021-03-20"));
        System.out.println("[Metodo]: modificaPeriodo");
        System.out.println("[Result metodo]:" + " " + periodo);
        System.out.println("[Dati periodo]:" + alloggio.getCalendario().get(0));
        System.out.println(" ");
        
        
        boolean elimina = alloggio.eliminaPeriodo(0);
        System.out.println("[Metodo]: eliminaPeriodo");
        System.out.println("[Result metodo]:" + " " + elimina);
        System.out.println(" ");
        
        
        elimina = utente.eliminaAlloggio(indirizzo);
        System.out.println("[Metodo]: eliminaAlloggio");
        System.out.println("[Result metodo]:" + " " + elimina);
        System.out.println(" ");
        
        
        elimina = os.eliminaUtente(email);
        System.out.println("[Metodo]: eliminaUtente");
        System.out.println("[Result metodo]:" + " " + elimina);
        
    }
    
}

