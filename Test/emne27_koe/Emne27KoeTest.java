package emne27_koe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*; // Importerer hele util for nemheds skyld

// Når du har oprettet dine klasser og exceptions, fjern kommenteringen for de relevante imports.
/*
// Opgave 27.1
import emne27_koe.KøFuldException; // Din custom exception
import emne27_koe.ArrayKø;

// Opgave 27.2
import emne27_koe.MinKædetKø;

// Opgave 27.3
import emne27_koe.MinSimpelDeque;
// Antager at MinDobbeltKædetListe fra Emne 25 er tilgængelig eller genimplementeret her for MinSimpelDeque.
// import emne25_kaededestrukturer.MinDobbeltKædetListe;


// Opgave 27.4
import emne27_koe.PrintJob;
import emne27_koe.PrinterManager;

// Opgave 27.5
import emne27_koe.PalindromTjekker;

// Opgave 27.6
import emne27_koe.HotPotatoSpil;

// Opgave 27.7 (hvis statisk metode i en klasse KøOperationer)
// import emne27_koe.KøOperationer;

// Opgave 27.8
import emne27_koe.Kundesag;
import emne27_koe.KundeserviceCenter;

// Opgave 27.9 (hvis statisk metode i en klasse KøManipulation)
// import emne27_koe.KøManipulation;
*/

class Emne27KoeTest {

    // --- Opgave 27.1: Array-baseret Kø (Cirkulær Buffer, Fast Størrelse) ---
    @Test
    void testArrayKø_Operationer_27_1() {
        // TODO: Afkommenter og kør når ArrayKø og KøFuldException er implementeret.

        ArrayKø<Integer> kø = new ArrayKø<>(3);
        assertTrue(kø.erTom());
        assertEquals(0, kø.size());
        assertFalse(kø.erFuld());

        kø.enqueue(10);
        kø.enqueue(20);
        assertEquals(2, kø.size());
        assertEquals(Integer.valueOf(10), kø.peek());

        kø.enqueue(30);
        assertTrue(kø.erFuld());
        assertThrows(KøFuldException.class, () -> kø.enqueue(40));

        assertEquals(Integer.valueOf(10), kø.dequeue());
        assertFalse(kø.erFuld());
        assertEquals(Integer.valueOf(20), kø.dequeue());
        assertEquals(Integer.valueOf(30), kø.dequeue());
        assertTrue(kø.erTom());
        assertThrows(NoSuchElementException.class, () -> kø.dequeue());
        assertThrows(NoSuchElementException.class, () -> kø.peek());

        // Test cirkulær buffer funktionalitet
        kø.enqueue(1); kø.enqueue(2); // Fyld igen [1, 2, _]
        kø.dequeue(); // Fjern 1, front flyttes. Kø: [_, 2, _] -> [2]
        kø.enqueue(3); // Kø: [2, 3, _]
        kø.enqueue(4); // Kø: [2, 3, 4] (fuld)
        assertEquals(Integer.valueOf(2), kø.dequeue());
        assertEquals(Integer.valueOf(3), kø.dequeue());
        assertEquals(Integer.valueOf(4), kø.dequeue());
        assertTrue(kø.erTom());

        assertTrue(true, "Test for 27.1 afventer implementering af ArrayKø og KøFuldException.");
    }

    // --- Opgave 27.2: Kædet Kø (Implementering) ---
    @Test
    void testMinKædetKø_Operationer_27_2() {
        // TODO: Afkommenter og kør når MinKædetKø er implementeret.
        /*
        MinKædetKø<String> kø = new MinKædetKø<>();
        assertTrue(kø.erTom());
        assertEquals(0, kø.size());

        kø.enqueue("A");
        kø.enqueue("B");
        assertFalse(kø.erTom());
        assertEquals(2, kø.size());
        assertEquals("A", kø.peek());

        kø.enqueue("C");
        assertEquals(3, kø.size());

        assertEquals("A", kø.dequeue());
        assertEquals("B", kø.dequeue());
        assertEquals("C", kø.dequeue());
        assertTrue(kø.erTom());
        assertThrows(NoSuchElementException.class, () -> kø.dequeue());
        assertThrows(NoSuchElementException.class, () -> kø.peek());
        */
        assertTrue(true, "Test for 27.2 afventer implementering af MinKædetKø.");
    }

    // --- Opgave 27.3: Implementer Deque med MinDobbeltKædetListe ---
    @Test
    void testMinSimpelDeque_Operationer_27_3() {
        // TODO: Afkommenter og kør når MinSimpelDeque (og dens underliggende MinDobbeltKædetListe) er implementeret.
        /*
        MinSimpelDeque<Integer> deque = new MinSimpelDeque<>();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
        assertNull(deque.peekFirst());
        assertNull(deque.peekLast());

        deque.addFirst(10); // [10]
        deque.addLast(20);  // [10, 20]
        deque.addFirst(5);   // [5, 10, 20]
        assertEquals(3, deque.size());
        assertEquals(Integer.valueOf(5), deque.peekFirst());
        assertEquals(Integer.valueOf(20), deque.peekLast());

        assertEquals(Integer.valueOf(5), deque.removeFirst()); // [10, 20]
        assertEquals(Integer.valueOf(20), deque.removeLast());  // [10]
        assertEquals(1, deque.size());

        assertEquals(Integer.valueOf(10), deque.removeFirst()); // []
        assertTrue(deque.isEmpty());

        assertThrows(NoSuchElementException.class, () -> deque.removeFirst());
        assertThrows(NoSuchElementException.class, () -> deque.removeLast());
        */
        assertTrue(true, "Test for 27.3 afventer implementering af MinSimpelDeque.");
    }

    // --- Opgave 27.4: Simuler Printerkø ---
    @Test
    void testPrinterManager_JobHåndtering_27_4() {
        // TODO: Afkommenter og kør når PrintJob og PrinterManager er implementeret.
        /*
        PrinterManager manager = new PrinterManager();
        assertEquals(0, manager.getAntalJobsIKø());

        PrintJob job1 = new PrintJob("Rapport.docx", 5);
        PrintJob job2 = new PrintJob("Billede.png", 1);
        manager.tilføjPrintJob(job1);
        manager.tilføjPrintJob(job2);
        assertEquals(2, manager.getAntalJobsIKø());
        assertTrue(manager.seAlleJobs().contains("Rapport.docx") && manager.seAlleJobs().contains("Billede.png"));

        assertEquals(job1, manager.behandlNæstePrintJob());
        assertEquals(1, manager.getAntalJobsIKø());
        assertEquals(job2, manager.behandlNæstePrintJob());
        assertEquals(0, manager.getAntalJobsIKø());
        assertNull(manager.behandlNæstePrintJob()); // Tom kø
        */
        assertTrue(true, "Test for 27.4 afventer implementering af PrintJob og PrinterManager.");
    }

    // --- Opgave 27.5: Palindrom Tjek med Stak og Kø ---
    @Test
    void testErPalindromMedStakOgKø_27_5() {
        // TODO: Afkommenter og kør når PalindromTjekker er implementeret.
        /*
        assertTrue(PalindromTjekker.erPalindrom("Regninger"));
        assertTrue(PalindromTjekker.erPalindrom("Madam, I'm Adam"));
        assertTrue(PalindromTjekker.erPalindrom("A Toyota's a Toyota"));
        assertTrue(PalindromTjekker.erPalindrom(""));
        assertTrue(PalindromTjekker.erPalindrom("a"));
        assertTrue(PalindromTjekker.erPalindrom(null)); // Som specificeret

        assertFalse(PalindromTjekker.erPalindrom("Hej"));
        assertFalse(PalindromTjekker.erPalindrom("Dette er ikke et palindrom"));
        */
        assertTrue(true, "Test for 27.5 afventer implementering af PalindromTjekker.");
    }

    // --- Opgave 27.6: "Hot Potato" Spil Simulering ---
    @Test
    void testSpilHotPotato_27_6() {
        // TODO: Afkommenter og kør når HotPotatoSpil er implementeret.
        /*
        List<String> spillere1 = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        assertEquals("D", HotPotatoSpil.spilHotPotato(spillere1, 3)); // C, A, E, B udgår -> D vinder

        List<String> spillere2 = new ArrayList<>(Arrays.asList("Ole", "Pia", "Bo"));
        assertEquals("Pia", HotPotatoSpil.spilHotPotato(spillere2, 1)); // Ole, Bo udgår -> Pia vinder

        List<String> enSpiller = new ArrayList<>(Arrays.asList("Vinder"));
        assertEquals("Vinder", HotPotatoSpil.spilHotPotato(enSpiller, 5));

        assertEquals("Ingen spillere", HotPotatoSpil.spilHotPotato(new ArrayList<>(), 3));
        assertEquals("Ugyldigt hop", HotPotatoSpil.spilHotPotato(spillere1, 0)); // Antager en fejlbesked eller lignende for hop < 1
        */
        assertTrue(true, "Test for 27.6 afventer implementering af HotPotatoSpil.");
    }

    // --- Opgave 27.7: Sammenflet To Køer Alternativt ---
    @Test
    void testSammenfletKøerAlternativt_27_7() {
        Queue<Integer> koe1 = new ArrayDeque<>(Arrays.asList(1, 3, 5));
        Queue<Integer> koe2 = new ArrayDeque<>(Arrays.asList(2, 4, 6, 7, 8));
        Queue<Integer> forventet1 = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        // Antager at Emne27Koe.opgave27_7_sammenfletKøerAlternativt er metoden
        Queue<Integer> resultat1 = Emne27Koe.opgave27_7_sammenfletKøerAlternativt(koe1, koe2);
        assertEquals(new ArrayList<>(forventet1), new ArrayList<>(resultat1)); // Sammenlign indhold
        assertTrue(koe1.isEmpty() && koe2.isEmpty(), "Inputkøer skal være tomme efter fletning");

        Queue<Integer> koeA = new ArrayDeque<>(Arrays.asList(10, 20));
        Queue<Integer> koeB = new ArrayDeque<>(Arrays.asList(100, 200, 300));
        Queue<Integer> forventet2 = new ArrayDeque<>(Arrays.asList(10, 100, 20, 200, 300));
        Queue<Integer> resultat2 = Emne27Koe.opgave27_7_sammenfletKøerAlternativt(koeA, koeB);
        assertEquals(new ArrayList<>(forventet2), new ArrayList<>(resultat2));

        Queue<Integer> tomKoe1 = new ArrayDeque<>();
        Queue<Integer> koeC = new ArrayDeque<>(Arrays.asList(1,2,3));
        Queue<Integer> forventet3 = new ArrayDeque<>(Arrays.asList(1,2,3));
        Queue<Integer> resultat3 = Emne27Koe.opgave27_7_sammenfletKøerAlternativt(tomKoe1, new ArrayDeque<>(koeC));
        assertEquals(new ArrayList<>(forventet3), new ArrayList<>(resultat3));

        Queue<Integer> resultat4 = Emne27Koe.opgave27_7_sammenfletKøerAlternativt(new ArrayDeque<>(koeC), tomKoe1);
        assertEquals(new ArrayList<>(forventet3), new ArrayList<>(resultat4));

        Queue<Integer> resultat5 = Emne27Koe.opgave27_7_sammenfletKøerAlternativt(new ArrayDeque<>(), new ArrayDeque<>());
        assertTrue(resultat5.isEmpty());
    }

    // --- Opgave 27.8: Kundeservice Ventekø System ---
    @Test
    void testKundeserviceCenter_27_8() {
        // TODO: Afkommenter og kør når Kundesag og KundeserviceCenter er implementeret.
        /*
        KundeserviceCenter center = new KundeserviceCenter(2); // Max 2 i kø
        assertTrue(center.erBufferTom()); // Antager en erBufferTom() eller lign.
        assertFalse(center.erBufferFuldt());

        Kundesag sag1 = new Kundesag(1, "Ole", "Internet nede");
        Kundesag sag2 = new Kundesag(2, "Pia", "Kan ikke logge ind");
        Kundesag sag3 = new Kundesag(3, "Bo", "Glemt password");

        assertTrue(center.modtagNySag(sag1));
        assertTrue(center.modtagNySag(sag2));
        assertEquals(2, center.getAntalSagerIVent());
        assertTrue(center.erBufferFuldt());

        assertFalse(center.modtagNySag(sag3), "Køen skulle være fuld");
        assertEquals(2, center.getAntalSagerIVent());

        assertEquals(sag1, center.ekspederNæsteSag());
        assertEquals(1, center.getAntalSagerIVent());
        assertFalse(center.erBufferFuldt());

        assertEquals(sag2, center.ekspederNæsteSag());
        assertTrue(center.erBufferTom());
        assertNull(center.ekspederNæsteSag()); // Tom kø
        */
        assertTrue(true, "Test for 27.8 afventer implementering af Kundesag og KundeserviceCenter.");
    }

    // --- Opgave 27.9: Omvend de Første K Elementer i en Kø ---
    @Test
    void testOmvendFørsteKElementerIKø_27_9() {
        Queue<Integer> koe1 = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Emne27Koe.opgave27_9_omvendFørsteKElementerIKø(koe1, 3);
        // Forventet: [3, 2, 1, 4, 5, 6]
        assertEquals(Integer.valueOf(3), koe1.poll());
        assertEquals(Integer.valueOf(2), koe1.poll());
        assertEquals(Integer.valueOf(1), koe1.poll());
        assertEquals(Integer.valueOf(4), koe1.poll());
        assertEquals(Integer.valueOf(5), koe1.poll());
        assertEquals(Integer.valueOf(6), koe1.poll());

        Queue<Integer> koe2 = new ArrayDeque<>(Arrays.asList(10, 20, 30));
        Emne27Koe.opgave27_9_omvendFørsteKElementerIKø(koe2, 5); // k > size -> omvend hele
        // Forventet: [30, 20, 10]
        assertEquals(Integer.valueOf(30), koe2.poll());
        assertEquals(Integer.valueOf(20), koe2.poll());
        assertEquals(Integer.valueOf(10), koe2.poll());

        Queue<Integer> koe3 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        Emne27Koe.opgave27_9_omvendFørsteKElementerIKø(koe3, 0); // k=0 -> ingen ændring
        assertEquals(Integer.valueOf(1), koe3.poll());

        Queue<Integer> koe4 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        Emne27Koe.opgave27_9_omvendFørsteKElementerIKø(koe4, 1); // k=1 -> ingen ændring
        assertEquals(Integer.valueOf(1), koe4.poll());

        Queue<Integer> koe5 = new ArrayDeque<>();
        Emne27Koe.opgave27_9_omvendFørsteKElementerIKø(koe5, 3); // Tom kø
        assertTrue(koe5.isEmpty());
    }

    // --- Opgave 27.10: Teoretisk - FIFO vs. LIFO ---
    @Test
    void testSvarFifoLifo_27_10() {
        // Korrekt svar: 2 (FIFO - implementeret med en Kø)
        assertEquals(2, Emne27Koe.opgave27_10_svarFifoLifo());
    }
}