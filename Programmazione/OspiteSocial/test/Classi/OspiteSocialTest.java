
package Classi;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OspiteSocialTest {
    private static OspiteSocial os;
    
    @BeforeClass
    public static void setUp() throws ParseException{
        os = OspiteSocial.getInstance();
        
        String nome = "Salvo";
        String cognome = "Mengoni";
        char sesso = 'M';
        Integer eta = 32;
        String email = "salvo.mengoni@studium.uncit.it";
        String cittaResidenza = "Catanzaro";
        String cellulare = "3284587456";
        String password = "Mengoni32";
        Alloggio alloggio1;
        Alloggio alloggio2;
        
        Utente result = os.inserisciUtente(nome, cognome, sesso, eta, email, cittaResidenza, cellulare, password);
        //System.out.println(result);
        
        alloggio1 = result.inserisciAlloggio("Via Roma 43", "Catania", 1.0, 1.0, 3);
        //System.out.println(alloggio1);
        alloggio1.inserisciPostiLetto(1, 1, "comune", "Divano Letto", 2);
        alloggio1.inserisciPostiLetto(2, 2, "privata", "letto", 1);
        alloggio1.inserisciPeriodo(Date.valueOf("2021-03-10"), Date.valueOf("2021-03-18"));
        
        //System.out.println(result.getAlloggi());
        
        alloggio2 = result.inserisciAlloggio("Via Venezia 43", "Catania", 1.0, 1.0, 3);
        //System.out.println(alloggio2);
        alloggio2.inserisciPostiLetto(1, 1, "comune", "Divano Letto", 2);
        alloggio2.inserisciPostiLetto(2, 2, "privata", "letto", 1);
        alloggio2.inserisciPeriodo(Date.valueOf("2021-03-10"), Date.valueOf("2021-03-18"));
        
        
        result = os.inserisciUtente(nome, cognome, sesso, eta, "mario.remo@studium.unict.it", cittaResidenza, cellulare, password);
    }

    
    @Test // Test of iserisciUtente method, of class OspiteSocial.
    public void test1InserisciUtente() {
        System.out.println("inserisciUtente");
        String nome = "Samuele";
        String cognome = "Baiomazzola";
        char sesso = 'M';
        Integer eta = 24;
        String email = "samuele.baiomazzola@studium.unict.it";
        String cittaResidenza = "Catania";
        String cellulare = "3287456159";
        String password = "baio";
        
        Utente result = os.inserisciUtente(nome, cognome, sesso, eta, email, cittaResidenza, cellulare, password);
        assertNotNull(result);
       
        // fail("The test case is a prototype.");
    }
    
    
    @Test // Test of logIn method, of class OspiteSocial.
    public void test2LogIn() {
        System.out.println("logIn");
        String email = "salvo.mengoni@studium.uncit.it";
        String password = "Mengoni32";
        
        boolean result = os.logIn(email, password);
        assertTrue(result);
        
        // fail("The test case is a prototype.");
    }
    
    
    @Test // Test of vissualizzaUtente method, of class OspiteSocial.
    public void test3VissualizzaUtente() {
        System.out.println("vissualizzaUtente");
        String email = "salvo.mengoni@studium.uncit.it";
       
        Utente result = os.vissualizzaUtente(email);
        assertNotNull(result);
        
        // fail("The test case is a prototype.");
    }

    
    @Test // Test of modificaDatiUtente method, of class OspiteSocial.
    public void test4ModificaDatiUtente() {
        System.out.println("modificaDatiUtente");
        String nome = "Mario";
        String cognome = "Baiomazzola";
        char sesso = 'M';
        Integer eta = 26;
        String email = "samuele.baiomazzola@studium.unict.it";
        String cittaResidenza = "Catania";
        String cellulare = "3287456159";
        String password = "baio96";
        
        boolean result = os.modificaDatiUtente(nome, cognome, sesso, eta, email, cittaResidenza, cellulare, password);
        assertTrue(result);
        
        // fail("The test case is a prototype.");
    }
    
    @Test // Test of eliminaUtente method, of class OspiteSocial.
    public void test5EliminaUtente() {
        System.out.println("eliminaUtente");
        String email = "samuele.baiomazzola@studium.unict.it";
        
        boolean result = os.eliminaUtente(email);
        assertTrue(result);
        
        // fail("The test case is a prototype.");
    }

    /*
    @Test // Test of ricercaAlloggio method, of class OspiteSocial.
    public void test5RicercaAlloggio() {
        System.out.println("ricercaAlloggio");
        String cittaDestinazione = "Catania";
        Integer numeroPostiLetto = 3;
        Date dataInizioSoggiorno = Date.valueOf("2021-03-04");
        Date dataFineSoggiorno = Date.valueOf("2021-03-15");
        List<Alloggio> result;
        
        result = os.ricercaAlloggio(cittaDestinazione, numeroPostiLetto, dataInizioSoggiorno, dataFineSoggiorno);
        System.out.println(result.size());
        assertNotEquals(0, result.size());
         
        // fail("The test case is a prototype.");
    }*/

    /*
    @Test // Test of richiestaPrenotazione method, of class OspiteSocial.
    public void test6RichiestaPrenotazione() {
        System.out.println("richiestaPrenotazione");
        List<PostoLetto> postiLetto;
        List<Alloggio> alloggio;
        List<String> ospiti = new ArrayList();
        ospiti.add("samuele.baiomazzola@studium.unict.it");
        boolean result = false;
        
        Date dataArrivo = Date.valueOf("2021-03-15");
        Date dataPartenza = Date.valueOf("2021-03-04");
        
        alloggio = os.ricercaAlloggio("Catania", 3, dataArrivo, dataArrivo);
        if(!alloggio.isEmpty())
        
            result = os.richiestaPrenotazione(alloggio.get(0).getPostiLetto(), ospiti, dataArrivo, dataPartenza, alloggio.get(0));
        System.out.println(result);
        assertTrue(result);
        
        // fail("The test case is a prototype.");
    }
    
    
    @Test // Test of visualizzaRichiesta method, of class OspiteSocial.
    public void test7VisualizzaRichiesta() {
        System.out.println("visualizzaRichiesta");
        
        List<Prenotazione> prenotazioni;
        os.logIn("salvo.mengoni@studium.uncit.it", "Mengoni32");
        
        prenotazioni = os.visualizzaRichiesta();
        System.out.println(prenotazioni);
        assertNotEquals(0,prenotazioni.size());
         
        // fail("The test case is a prototype.");
    }

    
    @Test // Test of accettaRichiesta method, of class OspiteSocial.  
    public void test8AccettaRichiesta() {
        System.out.println("accettaRichiesta");
        List<Prenotazione> listaPrenotazioni;
        
        //listaPrenotazioni.add(prenotazione);
        listaPrenotazioni = os.visualizzaRichiesta();
        System.out.println(listaPrenotazioni);
        
        boolean result = os.accettaRichiesta(listaPrenotazioni.get(0));
        assertTrue(result);
         
        // fail("The test case is a prototype.");
    }
    

    /*
    @Test // Test of rifiutaRichiesta method, of class OspiteSocial.
    public void test10RifiutaRichiesta() {
        System.out.println("rifiutaRichiesta");
        Prenotazione prenotazione = null;
        String motivazione = "";
        
        boolean result = os.rifiutaRichiesta(prenotazione, motivazione);
        assertTrue(result);
         
        // fail("The test case is a prototype.");
    }
    */
}
