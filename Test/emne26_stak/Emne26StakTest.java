package emne26_stak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

// Når du har oprettet dine klasser og exceptions, fjern kommenteringen for de relevante imports.
/*
// Opgave 26.1
import emne26_stak.StakFuldException; // Din custom exception
import emne26_stak.ArrayStak;

// Opgave 26.2
import emne26_stak.DynamiskArrayStak;

// Opgave 26.3
import emne26_stak.MinKædetStak;

// Opgave 26.4, 26.5, 26.6, 26.8 (hvis statiske metoder er i Emne26Stak)
// Ellers import fra f.eks. emne26_stak.StakAnvendelser;

// Opgave 26.7
import emne26_stak.TekstEditorMedUndo;

// Opgave 26.8 (hvis i separat klasse)
// import emne26_stak.StakSortering;

// Opgave 26.9, 26.10 (hvis statiske metoder er i Emne26Stak eller StakManipulation)
// import emne26_stak.StakManipulation;
*/

class Emne26StakTest {

    // --- Opgave 26.1: Array-baseret Stak (Fast Størrelse) ---
    @Test
    void testArrayStak_FastStørrelse_26_1() {
        // TODO: Afkommenter og kør når ArrayStak og StakFuldException er implementeret.

        ArrayStak<Integer> stak = new ArrayStak<>(3);
        assertTrue(stak.erTom());
        assertEquals(0, stak.size());

        stak.push(10);
        stak.push(20);
        assertFalse(stak.erTom());
        assertEquals(2, stak.size());
        assertFalse(stak.erFuld());
        assertEquals(Integer.valueOf(20), stak.peek());

        stak.push(30);
        assertTrue(stak.erFuld());
        assertEquals(3, stak.size());
        assertThrows(StakFuldException.class, () -> stak.push(40));

        assertEquals(Integer.valueOf(30), stak.pop());
        assertFalse(stak.erFuld());
        assertEquals(Integer.valueOf(20), stak.pop());
        assertEquals(Integer.valueOf(10), stak.pop());
        assertTrue(stak.erTom());
        assertThrows(EmptyStackException.class, () -> stak.pop());
        assertThrows(EmptyStackException.class, () -> stak.peek());

    }

    // --- Opgave 26.2: Array-baseret Stak (Dynamisk Størrelse) ---
    @Test
    void testDynamiskArrayStak_Udvidelse_26_2() {
        // TODO: Afkommenter og kør når DynamiskArrayStak er implementeret.
        /*
        DynamiskArrayStak<String> stak = new DynamiskArrayStak<>(); // Antager default startkapacitet
        for (int i = 0; i < 15; i++) { // Push flere elementer end default kapacitet
            stak.push("Element " + i);
        }
        assertEquals(15, stak.size());
        assertEquals("Element 14", stak.peek());

        for (int i = 14; i >= 0; i--) {
            assertEquals("Element " + i, stak.pop());
        }
        assertTrue(stak.erTom());
        assertThrows(EmptyStackException.class, () -> stak.pop());
        */
    }

    // --- Opgave 26.3: Kædet Stak (Implementering) ---
    @Test
    void testMinKædetStak_Operationer_26_3() {
        // TODO: Afkommenter og kør når MinKædetStak er implementeret.
        /*
        MinKædetStak<Character> stak = new MinKædetStak<>();
        assertTrue(stak.erTom());
        stak.push('A');
        stak.push('B');
        assertEquals(2, stak.size());
        assertEquals(Character.valueOf('B'), stak.peek());
        assertEquals(Character.valueOf('B'), stak.pop());
        assertEquals(Character.valueOf('A'), stak.pop());
        assertTrue(stak.erTom());
        assertThrows(EmptyStackException.class, () -> stak.peek());
        */
    }

    // --- Opgave 26.4: Omvend en Streng med en Stak ---
    @Test
    void testOmvendStrengMedStak_26_4() {
        assertEquals("avaj", Emne26Stak.opgave26_4_omvendStrengMedStak("java"));
        assertEquals("!nedreV jeH", Emne26Stak.opgave26_4_omvendStrengMedStak("Hej Verden!"));
        assertEquals("a", Emne26Stak.opgave26_4_omvendStrengMedStak("a"));
        assertEquals("", Emne26Stak.opgave26_4_omvendStrengMedStak(""));
        // Afhængig af specifikation for null input (her antager vi null retur)
        assertNull(Emne26Stak.opgave26_4_omvendStrengMedStak(null));
    }

    // --- Opgave 26.5: Balancerede Parenteser Tjek ---
    @Test
    void testErParenteserBalanceret_26_5() {
        assertTrue(Emne26Stak.opgave26_5_erParenteserBalanceret("()"));
        assertTrue(Emne26Stak.opgave26_5_erParenteserBalanceret("()[]{}"));
        assertTrue(Emne26Stak.opgave26_5_erParenteserBalanceret("({[]})"));
        assertTrue(Emne26Stak.opgave26_5_erParenteserBalanceret("(a * (b + c) - [d / e])"));
        assertTrue(Emne26Stak.opgave26_5_erParenteserBalanceret("")); // Tom streng er balanceret
        assertTrue(Emne26Stak.opgave26_5_erParenteserBalanceret(null)); // Null streng anses som balanceret

        assertFalse(Emne26Stak.opgave26_5_erParenteserBalanceret("([)]"));
        assertFalse(Emne26Stak.opgave26_5_erParenteserBalanceret("{{"));
        assertFalse(Emne26Stak.opgave26_5_erParenteserBalanceret("]("));
        assertFalse(Emne26Stak.opgave26_5_erParenteserBalanceret("((("));
        assertFalse(Emne26Stak.opgave26_5_erParenteserBalanceret("())"));
    }

    // --- Opgave 26.6: Evaluer Simpelt Postfix Udtryk ---
    @Test
    void testEvaluerPostfix_26_6() {
        assertEquals(14, Emne26Stak.opgave26_6_evaluerPostfix("3 4 + 2 *"));
        assertEquals(46, Emne26Stak.opgave26_6_evaluerPostfix("10 2 3 + * 4 -")); // 10 * (2+3) - 4 = 10 * 5 - 4 = 50 - 4 = 46
        assertEquals(6, Emne26Stak.opgave26_6_evaluerPostfix("5 1 2 + 4 * + 3 -")); // 5 + (1+2)*4 - 3 = 5 + 3*4 - 3 = 5 + 12 - 3 = 14
        assertEquals(2, Emne26Stak.opgave26_6_evaluerPostfix("4 2 /"));

        assertThrows(IllegalArgumentException.class, () -> Emne26Stak.opgave26_6_evaluerPostfix("1 2 3 +")); // For få operatorer
        assertThrows(IllegalArgumentException.class, () -> Emne26Stak.opgave26_6_evaluerPostfix("1 +")); // For få operander
        assertThrows(ArithmeticException.class, () -> Emne26Stak.opgave26_6_evaluerPostfix("5 0 /")); // Division med nul
        assertThrows(IllegalArgumentException.class, () -> Emne26Stak.opgave26_6_evaluerPostfix("5 2 %")); // Ukendt operator
    }

    // --- Opgave 26.7: Simuler "Undo" Funktion for Tekstinput ---
    @Test
    void testTekstEditorMedUndo_26_7() {
        // TODO: Afkommenter og kør når TekstEditorMedUndo er implementeret.
        /*
        TekstEditorMedUndo editor = new TekstEditorMedUndo();
        assertEquals("", editor.getTekst());

        editor.tilføjTekst("Hej");
        assertEquals("Hej", editor.getTekst());

        editor.tilføjTekst(" Verden");
        assertEquals("Hej Verden", editor.getTekst());

        assertTrue(editor.fortryd());
        assertEquals("Hej", editor.getTekst());

        assertTrue(editor.fortryd());
        assertEquals("", editor.getTekst());

        assertFalse(editor.fortryd(), "Undo på tom stak skal returnere false.");
        assertEquals("", editor.getTekst()); // Stadig tom

        editor.tilføjTekst("Ny start");
        editor.tilføjTekst(", og ny slutning.");
        assertEquals("Ny start, og ny slutning.", editor.getTekst());
        */
        assertTrue(true, "Test for 26.7 afventer implementering af TekstEditorMedUndo.");
    }

    // --- Opgave 26.8: Stak-baseret Sortering (Simpel "To-Stakke" Sortering) ---
    @Test
    void testSorterListeMedToStakke_26_8() {
        // TODO: Afkommenter og kør når metoden/klassen for 26.8 er implementeret.
        /*
        List<Integer> usorteret1 = new ArrayList<>(Arrays.asList(5, 1, 9, 3, 7, 2, 8, 6, 4));
        List<Integer> forventet1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(forventet1, Emne26Stak.opgave26_8_sorterListeMedToStakke(usorteret1));

        List<Integer> usorteret2 = new ArrayList<>(Arrays.asList(1, 2, 3)); // Allerede sorteret
        List<Integer> forventet2 = Arrays.asList(1, 2, 3);
        assertEquals(forventet2, Emne26Stak.opgave26_8_sorterListeMedToStakke(usorteret2));

        List<Integer> usorteret3 = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1)); // Omvendt sorteret
        List<Integer> forventet3 = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(forventet3, Emne26Stak.opgave26_8_sorterListeMedToStakke(usorteret3));

        List<Integer> usorteret4 = new ArrayList<>(Arrays.asList(3, 1, 3, 2, 1)); // Med duplikater
        List<Integer> forventet4 = Arrays.asList(1, 1, 2, 3, 3);
        assertEquals(forventet4, Emne26Stak.opgave26_8_sorterListeMedToStakke(usorteret4));

        List<Integer> tomListe = new ArrayList<>();
        assertTrue(Emne26Stak.opgave26_8_sorterListeMedToStakke(tomListe).isEmpty());
        assertTrue(Emne26Stak.opgave26_8_sorterListeMedToStakke(null).isEmpty());
        */
        assertTrue(true, "Test for 26.8 afventer implementering af sorterListeMedToStakke.");
    }

    // --- Opgave 26.9: Overfør Elementer mellem Stakke med Bevaret Rækkefølge ---
    @Test
    void testOverførOgBevarOrden_26_9() {
        Deque<Integer> kilde = new ArrayDeque<>();
        Deque<Integer> destination = new ArrayDeque<>();

        kilde.addFirst(3); kilde.addFirst(2); kilde.addFirst(1); // Kilde: [1, 2, 3] (top->bund)
        destination.addFirst(5); destination.addFirst(4);      // Dest: [4, 5] (top->bund)

        Emne26Stak.opgave26_9_overførOgBevarOrden(kilde, destination);

        assertTrue(kilde.isEmpty(), "Kildestakken skal være tom efter overførsel.");
        // Forventet destination (top->bund): [1, 2, 3, 4, 5]
        assertEquals(Integer.valueOf(1), destination.removeFirst());
        assertEquals(Integer.valueOf(2), destination.removeFirst());
        assertEquals(Integer.valueOf(3), destination.removeFirst());
        assertEquals(Integer.valueOf(4), destination.removeFirst());
        assertEquals(Integer.valueOf(5), destination.removeFirst());
        assertTrue(destination.isEmpty());

        // Test med tom kilde
        kilde.clear(); destination.clear();
        destination.addFirst(10);
        Emne26Stak.opgave26_9_overførOgBevarOrden(kilde, destination);
        assertEquals(Integer.valueOf(10), destination.peekFirst());
        assertEquals(1, destination.size());

        // Test med tom destination
        kilde.clear(); destination.clear();
        kilde.addFirst(7); kilde.addFirst(6);
        Emne26Stak.opgave26_9_overførOgBevarOrden(kilde, destination);
        assertEquals(Integer.valueOf(6), destination.removeFirst());
        assertEquals(Integer.valueOf(7), destination.removeFirst());
    }

    // --- Opgave 26.10: Fjern Specifikke Elementer fra en Stak (Bevar Orden) ---
    @Test
    void testFjernSpecifiktElementFraStak_26_10() {
        Deque<String> stak = new ArrayDeque<>();
        // Stak (top->bund): ["A", "B", "C", "A", "D", "A"]
        stak.addFirst("A"); stak.addFirst("D"); stak.addFirst("A");
        stak.addFirst("C"); stak.addFirst("B"); stak.addFirst("A");

        Emne26Stak.opgave26_10_fjernSpecifiktElementFraStak(stak, "A");
        // Forventet (top->bund): ["B", "C", "D"]
        assertEquals("B", stak.pop()); // pop = removeFirst
        assertEquals("C", stak.pop());
        assertEquals("D", stak.pop());
        assertTrue(stak.isEmpty());

        // Test med element der ikke findes
        stak.clear();
        stak.addFirst("X"); stak.addFirst("Y"); stak.addFirst("Z");
        Emne26Stak.opgave26_10_fjernSpecifiktElementFraStak(stak, "A");
        assertEquals(3, stak.size()); // Uændret
        assertEquals("Z", stak.pop());

        // Test med tom stak
        stak.clear();
        Emne26Stak.opgave26_10_fjernSpecifiktElementFraStak(stak, "A");
        assertTrue(stak.isEmpty());

        // Test med fjernelse af null (hvis det skal håndteres specifikt)
        stak.clear();
        stak.addFirst("X"); stak.addFirst(null); stak.addFirst("Y");
        Emne26Stak.opgave26_10_fjernSpecifiktElementFraStak(stak, null);
        // Forventet: ["Y", "X"]
        assertEquals("Y", stak.pop());
        assertEquals("X", stak.pop());
        assertTrue(stak.isEmpty());
    }
}