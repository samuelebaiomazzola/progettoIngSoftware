
package Classi;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
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
public class AlloggioTest {
    private static Alloggio alloggioController;
    
    
    @BeforeClass
    public static void setUp() throws ParseException{
        String indirizzo = "Via Santa Sofia 64";
        String citta = "Catania";
        Double distanzaCentro = 1.0;
        Double distanzaMezzoPubblico = 1.5;
        Integer numeroMembriFamiglia = 4;
        Integer numeroTotalePostiLetto = 3;
        
        alloggioController = new Alloggio(indirizzo, citta, distanzaCentro, distanzaMezzoPubblico, numeroMembriFamiglia, numeroTotalePostiLetto);
        //System.out.println(alloggioController);
    }
    
    @Test // Test of inserisciPeriodo method, of class Alloggio.
    public void test1InserisciPeriodo() {
        System.out.println("inserisciPeriodo");
        Date inizio = Date.valueOf("2021-03-10");
        Date fine = Date.valueOf("2021-03-18");
        
        boolean result = alloggioController.inserisciPeriodo(inizio, fine);
        assertTrue(result);
        
        // fail("The test case is a prototype.");
    }

    @Test // Test of visualizzaPeriodo method, of class Alloggio.
    public void test2VisualizzaPeriodo() {
        System.out.println("visualizzaPeriodo");
        
        Periodo result = alloggioController.visualizzaPeriodo(0);
        assertNotNull(result);
        
        // fail("The test case is a prototype.");
    }

   
    @Test // Test of modificaPeriodo method, of class Alloggio.
    public void test3ModificaPeriodo() {
        System.out.println("modificaPeriodo");
        Date inizio = Date.valueOf("2021-03-12");
        Date fine = Date.valueOf("2021-03-22");
        
        boolean result = alloggioController.modificaPeriodo(0, inizio, fine);
        assertTrue(result);
        
        // fail("The test case is a prototype.");
    }

    
    @Test // Test of eliminaPeriodo method, of class Alloggio.
    public void test4EliminaPeriodo() {
        System.out.println("eliminaPeriodo");
        
        boolean result = alloggioController.eliminaPeriodo(0);
        assertTrue(result);
        
        // fail("The test case is a prototype.");
    }

    
    @Test // Test of inserisciPostiLetto method, of class Alloggio.
    public void test5InserisciPostiLetto() {
        System.out.println("inserisciPostiLetto");
        Integer idLetto = 1;
        Integer numeroStanza = 1;
        String tipologiaStanza = "Privata";
        String tipologiaPostoLetto = "Letto";
        Integer numeroPostiLetto = 1;
        
        
        PostoLetto result = alloggioController.inserisciPostiLetto(idLetto, numeroStanza, tipologiaStanza, tipologiaPostoLetto, numeroPostiLetto);
        //System.out.println(result);
        assertNotNull(result);
        
        // fail("The test case is a prototype.");
    }

    
    @Test // Test of visualizzaPostoLetto method, of class Alloggio.
    public void test6VisualizzaPostoLetto() {
        System.out.println("visualizzaPostoLetto");
        Integer idLetto = 1;
        
        PostoLetto result = alloggioController.visualizzaPostoLetto(idLetto);
        //System.out.println(result);
        assertNotNull(result);
        
        //fail("The test case is a prototype.");
    }

    
    @Test // Test of modificaDatiPostiLetto method, of class Alloggio.
    public void test7ModificaDatiPostiLetto() {
        System.out.println("modificaDatiPostiLetto");
        Integer idLetto = 1;
        Integer numeroStanza = 1;
        String tipologiaStanza = "Comune";
        String tipologiaPostoLetto = "Divano";
        Integer numeroPostiLetto = 2;
        
        boolean result = alloggioController.modificaDatiPostiLetto(idLetto, numeroStanza, tipologiaStanza, tipologiaPostoLetto, numeroPostiLetto);
        assertTrue(result);
        
        // fail("The test case is a prototype.");
    }

    
    @Test // Test of eliminaPostoLetto method, of class Alloggio.
    public void test8EliminaPostoLetto() {
        System.out.println("eliminaPostoLetto");
        Integer idLetto = 1;
        
        boolean result = alloggioController.eliminaPostoLetto(idLetto);
        assertTrue(result);
       
        // fail("The test case is a prototype.");
    }
    
}
