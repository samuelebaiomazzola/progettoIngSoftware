package Classi;

import Classi.*;
import java.text.ParseException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtenteTest {
    private static Utente utenteController;
    
    @BeforeClass
    public static void setUp() throws ParseException{
        String  nome = "Samuele";
        String  cognome = "Baiomazzola";
        char  sesso = 'M';
        Integer  eta = 24;
        String  email = "samuele.baiomazzola@studium.unict.it";
        String  cittaResidenza = "Caltanissetta";
        String  cellulare ="3287958774";
        String  password = "SAM96";
        
        utenteController = new Utente(nome, cognome, sesso, eta, email, cittaResidenza, cellulare, password);
    }

    @Test // Test of inserisciAlloggio method, of class Utente.
    public void testInserisciAlloggio() {
        System.out.println("inserisciAlloggio");
        String indirizzo = "Via Roma 45";
        String citta = "Bari";
        double distanzaCentro = 1.0;
        double distanzaMezzoPubblico = 1.5;
        Integer numeroMembriFamiglia = 5;
       
        Alloggio result = utenteController.inserisciAlloggio(indirizzo, citta, distanzaCentro, distanzaMezzoPubblico, numeroMembriFamiglia);
        assertNotNull(result);
        
        //fail("The test case is a prototype.");
    }

    
    @Test // Test of visualizzaAlloggio method, of class Utente.
    public void testVisualizzaAlloggio() {
        System.out.println("visualizzaAlloggio");
        String indirizzo = "Via Roma 45";
        
        
        Alloggio result = utenteController.visualizzaAlloggio(indirizzo);
        assertNotNull(result);
        
        //fail("The test case is a prototype.");
    }

    
    @Test // Test of modificaDatiAlloggio method, of class Utente.
    public void testModificaDatiAlloggio() {
        System.out.println("modificaDatiAlloggio");
        String indirizzo = "Via Roma 45";
        String citta = "Bari";
        double distanzaCentro = 20.0;
        double distanzaMezzoPubblico = 2.5;
        Integer numeroMembriFamiglia = 7;
        Integer numeroTotalePostiLetto = 7;
        
        boolean result = utenteController.modificaDatiAlloggio(indirizzo, citta, distanzaCentro, distanzaMezzoPubblico, numeroMembriFamiglia, numeroTotalePostiLetto);
        assertTrue(result);
        
        //fail("The test case is a prototype.");
    }

    
    @Test // Test of eliminaAlloggio method, of class Utente.
    public void testEliminaAlloggio() {
        System.out.println("eliminaAlloggio");
        String indirizzo = "Via Roma 45";
        
        boolean result = utenteController.eliminaAlloggio(indirizzo);
        assertTrue(result);
        
        //fail("The test case is a prototype.");
    }
    
    //dire a Giulia dell'idAlloggio.
}
