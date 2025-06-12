package emne04_klassehierarkier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Når du har oprettet dine klasser, fjern kommenteringen for de relevante imports
// og sørg for, at de matcher dine filnavne og pakke.
/*
// For Opgave 4.1
import emne04_klassehierarkier.Køretøj;
import emne04_klassehierarkier.PersonBil;
import emne04_klassehierarkier.LastBil;

// For Opgave 4.2
import emne04_klassehierarkier.Medie;
import emne04_klassehierarkier.BogMedie;
import emne04_klassehierarkier.FilmMedie;
import emne04_klassehierarkier.MusikAlbum;

// For Opgave 4.3
import emne04_klassehierarkier.GrafiskElement;
import emne04_klassehierarkier.PunktGE;
import emne04_klassehierarkier.LinjeGE;
import emne04_klassehierarkier.CirkelGE;
import emne04_klassehierarkier.RektangelGE;

// For Opgave 4.4
import emne04_klassehierarkier.Konto;
import emne04_klassehierarkier.SparekontoPlus;
import emne04_klassehierarkier.BrugerKontoPlus;

// For Opgave 4.5
import emne04_klassehierarkier.SpilFigur;
import emne04_klassehierarkier.SpillerFigur;
import emne04_klassehierarkier.FjendeFigur;
import emne04_klassehierarkier.NPCFigur;

// For Opgave 4.6 (Revideret)
import emne04_klassehierarkier.Musikinstrument;
import emne04_klassehierarkier.StrengeInstrument;
import emne04_klassehierarkier.ElektriskGuitar;
import emne04_klassehierarkier.Keyboard;

// For Opgave 4.7 (Revideret)
import emne04_klassehierarkier.Publikation;
import emne04_klassehierarkier.BogFormat;
import emne04_klassehierarkier.ArtikelFormat;
import emne04_klassehierarkier.Ebog;

// For Opgave 4.8 (Revideret)
import emne04_klassehierarkier.ElektroniskEnhed;
import emne04_klassehierarkier.MobilEnhed;
import emne04_klassehierarkier.SmartphonePlus;
import emne04_klassehierarkier.BaarbarComputer;

// For Opgave 4.9
import emne04_klassehierarkier.SkolePerson;
import emne04_klassehierarkier.Lærer;
import emne04_klassehierarkier.Elev;

// For Opgave 4.10
import emne04_klassehierarkier.Ordre;
import emne04_klassehierarkier.StandardOrdre;
import emne04_klassehierarkier.ExpressOrdre;
*/

class Emne04KlassehierarkierTest {

    // --- Opgave 4.1: Avanceret Køretøj Hierarki ---
    @Test
    void testKøretøj_PersonBil_LastBil_GrundFunktioner() {
        Køretøj generisk = new Køretøj("GEN001", 1000, 180);
        assertEquals(0, generisk.getNuværendeHastighedKmt());
        generisk.accelerer(50);
        assertEquals(50, generisk.getNuværendeHastighedKmt());
        generisk.accelerer(200); // Skal ramme maksHastighed
        assertEquals(180, generisk.getNuværendeHastighedKmt());
        generisk.brems(100);
        assertEquals(80, generisk.getNuværendeHastighedKmt());
        generisk.brems(100); // Skal ramme 0
        assertEquals(0, generisk.getNuværendeHastighedKmt());

        PersonBil pBil = new PersonBil("PB123", 1500, 200, 5, 400);
        pBil.accelerer(50); // 50 * 1.2 = 60 (hvis faktoren er 1.2)
        // Nøjagtig forventet værdi afhænger af din implementerede faktor i PersonBil
        assertTrue(pBil.getNuværendeHastighedKmt() > 50 && pBil.getNuværendeHastighedKmt() <= 60, "Personbil acceleration forkert");
        assertTrue(pBil.pakBagagerum(300));
        assertEquals(100, pBil.getLedigBagagePladsLiter());
        assertFalse(pBil.pakBagagerum(150)); // For meget

        LastBil lBil = new LastBil("LB789", 5000, 120, 10000);
        lBil.accelerer(50); // 50 * 0.8 = 40 (uden anhænger)
        assertTrue(lBil.getNuværendeHastighedKmt() >= 35 && lBil.getNuværendeHastighedKmt() <= 45, "Lastbil acceleration (uden anhænger) forkert");
        lBil.tilkoblAnhænger();
        lBil.brems(100); // Sæt til 0
        lBil.accelerer(50); // 50 * 0.5 = 25 (med anhænger)
        assertTrue(lBil.getNuværendeHastighedKmt() >= 20 && lBil.getNuværendeHastighedKmt() <= 30, "Lastbil acceleration (med anhænger) forkert");
    }

    // --- Opgave 4.2: Medie Hierarki ---
    @Test
    void testMedie_BogFilmMusik_UdlånStatus() {
//        BogMedie bog = new BogMedie("Ringenes Herre", 1954, "J.R.R. Tolkien", "12345", 1000);
//        FilmMedie film = new FilmMedie("Inception", 2010, "Christopher Nolan", 148, "Sci-Fi");
//        MusikAlbum album = new MusikAlbum("The Dark Side of the Moon", 1973, "Pink Floyd");
//        album.tilføjSpor("Speak to Me");
//        album.tilføjSpor("Breathe");
//
//        assertTrue(bog.udlån("Læser1"));
//        assertTrue(bog.erUdlånt());
//        assertEquals(LocalDate.now().plusDays(28), bog.getReturDato()); // Antager BogMedie sætter 28 dages lån
//        assertTrue(bog.erOverdue(LocalDate.now().plusDays(30)));
//        assertFalse(bog.erOverdue(LocalDate.now().plusDays(10)));
//        assertTrue(bog.aflever());
//        assertFalse(bog.erUdlånt());
//
//        assertTrue(film.getStatus().contains("Inception") && film.getStatus().contains("Tilgængelig"));
//        // Test getDetaljeretInfo for hver type
    }

    // --- Opgave 4.3: Grafisk Element Hierarki ---
    @Test
    void testGrafiskElement_FlytOgTegn() {
//        GrafiskElement el = new GrafiskElement(10, 20, "Blå");
//        el.flyt(5, -5);
//        assertEquals(15, el.getPositionX());
//        assertEquals(15, el.getPositionY());
//        assertTrue(el.tegn().contains("Blå") && el.tegn().contains("[15,15]"));
//
//        CirkelGE cirkel = new CirkelGE("Rød", 0, 0, 10);
//        assertEquals(Math.PI * 100, cirkel.getAreal(), 0.01);
//        assertTrue(cirkel.tegn().contains("Cirkel") && cirkel.tegn().contains("radius 10"));
//
//        RektangelGE rekt = new RektangelGE("Grøn", 1,1, 4, 5);
//        assertEquals(20, rekt.getAreal());
//        assertFalse(rekt.erKvadratisk());
//        assertTrue(rekt.tegn().contains("Rektangel"));
    }


    // --- Opgave 4.4: Konto Hierarki med Gebyrer og Renter ---
    @Test
    void testKontoHierarki_Funktioner() {
//        SparekontoPlus sp = new SparekontoPlus("S1", 1000, "Ida", 0.02, 1, 10.0); // 1 gratis hæv, 10kr gebyr
//        assertEquals("Sparekonto Plus", sp.getKontoType());
//        sp.tilskrivMånedligRente();
//        assertTrue(sp.getSaldo() > 1000 && sp.getSaldo() < 1002); // Lille rente
//
//        assertTrue(sp.hæv(50)); // 1. gratis hævning
//        assertEquals(1, sp.getHævningerDenneMåned());
//        double saldoEfterFørsteHæv = sp.getSaldo();
//
//        assertTrue(sp.hæv(20)); // 2. hævning, koster 10kr gebyr
//        assertEquals(2, sp.getHævningerDenneMåned());
//        assertEquals(saldoEfterFørsteHæv - 20 - 10, sp.getSaldo(), 0.01);
//        sp.nulstilMånedligeHævninger();
//        assertEquals(0, sp.getHævningerDenneMåned());
//
//        BrugerKontoPlus bp = new BrugerKontoPlus("B1", 100, "Bo", 15.0, 500.0);
//        assertEquals("Brugerkonto Plus", bp.getKontoType());
//        assertTrue(bp.hæv(550)); // 100 (saldo) + 450 (kredit)
//        assertEquals(100 - 550, bp.getSaldo(), 0.01);
//        assertFalse(bp.hæv(100)); // Vil overstige kreditlimit
//        bp.trækMånedligtGebyr();
//        assertEquals(100 - 550 - 15.0, bp.getSaldo(), 0.01);
    }


    // --- Opgave 4.5: SpilFigur Hierarki ---
    @Test
    void testSpilFigur_Interaktioner() {
//        SpillerFigur spiller = new SpillerFigur("Helt", 100, 15, 50, 1);
//        FjendeFigur ork = new FjendeFigur("Ork Kriger", 80, 10, "Ork", 20);
//        NPCFigur npc = new NPCFigur("Købmand", 50, 0, "Velkommen, rejsende!", true);
//
//        ork.angrib(spiller); // Antager at SpillerFigur tager skade
//        assertTrue(spiller.getCurrentHealth() < spiller.getMaxHealth());
//
//        spiller.angrib(ork);
//        assertTrue(ork.getCurrentHealth() < ork.getMaxHealth());
//
//        spiller.tilføjErfaring(100); // Antager dette kan give level up
//        // Test level up logik her, hvis implementeret
//
//        assertEquals("Velkommen, rejsende!", npc.talTil());
//        npc.angrib(spiller); // Skulle intet gøre hvis venlig
//        // Test at spillerens health er uændret efter NPC angreb hvis venlig
    }


    // --- Tests for Opgave 4.6: Musikinstrumenter (Revideret) ---
    @Test
    void testMusikinstrumenter_PolymorfiOgSpecifikFunktionalitet() {
//        Musikinstrument generisk = new Musikinstrument("Lyre", "Antik Aps", 1.5);
//        assertEquals("Lyre spiller tonen A.", generisk.spilTone("A"));
//        assertFalse(generisk.kræverStrøm());
//
//        StrengeInstrument guitar = new StrengeInstrument("Akustisk Guitar", "Martin", 2.0, 6, "Stål");
//        assertEquals("Akustisk Guitar spiller A på sine 6 Stål strenge.", guitar.spilTone("A"));
//        assertTrue(guitar.getVedligeholdelsesInstruks().contains("stemme strengene"));
//
//        ElektriskGuitar elGuitar = new ElektriskGuitar("Stratocaster", "Fender", 3.5, 6, "Nikkel", 3, "Rørforstærker");
//        assertTrue(elGuitar.kræverStrøm());
//        assertTrue(elGuitar.spilTone("E").contains("Elektrisk guitar"));
//        // elGuitar.brugEffektPedal("Distortion"); // Test output hvis metoden printer
//
//        Keyboard keyboard = new Keyboard("DX7", "Yamaha", 5.0, 61);
//        assertTrue(keyboard.kræverStrøm());
//        keyboard.tilføjLyd("Piano");
//        keyboard.tilføjLyd("Strings");
//        assertEquals("DX7 spiller Piano lyd.", keyboard.vælgOgSpilLyd("Piano"));
//        assertEquals("DX7 kender ikke lyden Fløjte.", keyboard.vælgOgSpilLyd("Fløjte"));
    }

    // --- Tests for Opgave 4.7: Publikationer (Revideret) ---
    @Test
    void testPublikationer_CitationOgLogik() {
//        BogFormat bog = new BogFormat("Java: The Complete Reference", "Oracle Press", LocalDate.of(2021,1,1), "Herbert Schildt", "978-1260463415", 1000);
//        assertTrue(bog.getBibliografiskCitation().startsWith("Herbert Schildt (2021)."));
//        assertEquals(10, bog.beregnPrisPrSide(10000), 0.01); // 10000 / 1000
//        assertTrue(bog.erAnbefaletTilBørn()); // Default antagelse
//
//        List<String> forfattere = Arrays.asList("Doe, J.", "Smith, A.");
//        ArtikelFormat artikel = new ArtikelFormat("AI Research", "Tech Publisher", LocalDate.of(2022,5,10), forfattere, "Journal of AI", 5, 2, 10, 25);
//        assertTrue(artikel.getBibliografiskCitation().contains("Doe, J. & Smith, A. (2022)."));
//        assertEquals(16, artikel.getAntalSiderIArtikel()); // 25-10+1
//        assertFalse(artikel.erAnbefaletTilBørn());
//
//        Ebog ebog = new Ebog("Ebog Titel", "Digitalt Forlag", LocalDate.now(), "E. Forfatter", "000-111", 300, "EPUB", 2.5);
//        assertTrue(ebog.getBibliografiskCitation().contains("[Ebog - EPUB]"));
//        assertTrue(ebog.kanLæsesPåEnhed("epub"));
//        assertFalse(ebog.kanLæsesPåEnhed("PDF"));
    }

    // --- Tests for Opgave 4.8: Elektroniske Enheder (Revideret) ---
    @Test
    void testElektroniskeEnheder_StrømOgFunktioner() {
//        ElektroniskEnhed enhed = new ElektroniskEnhed("Model X", "Producent A", 2000);
//        assertEquals(100, enhed.getNuværendeBatteriPct());
//        enhed.oplad(10, 5); // 10 min * 5mAh/min = 50mAh.
//        // Denne opladningslogik skal testes nærmere ift. hvordan den påvirker Pct.
//        // For nu, antager vi at oplad() virker som specificeret (øger batteriPct).
//        // Hvis den øger med pct point direkte:
//        // enhed.oplad(10, 0); // Antag oplad tager pct point for simpel test
//        // assertEquals(100, enhed.getNuværendeBatteriPct()); // Kan ikke overstige 100
//
//        SmartphonePlus mobil = new SmartphonePlus("Galaxy S50", "Samsung", 4000, "2560x1440", "Android 15", 108);
//        assertTrue(mobil.tænd());
//        assertEquals(100, mobil.getNuværendeBatteriPct());
//        assertTrue(mobil.installerApp("SuperApp")); // Forbruger 5%
//        assertEquals(95, mobil.getNuværendeBatteriPct());
//        assertEquals("Klik! Billede taget med 108MP kamera.", mobil.tagBillede()); // Forbruger 2%
//        assertEquals(93, mobil.getNuværendeBatteriPct());
//
//        BaarbarComputer laptop = new BaarbarComputer("MacBook ProMax", "Apple", 8000, "M5 Pro", 32, true);
//        assertTrue(laptop.tænd());
//        assertEquals("Kører IntelliJ...", laptop.kørProgram("IntelliJ", 15));
//        assertEquals(85, laptop.getNuværendeBatteriPct());
    }


    // --- Tests for Opgave 4.9: Personale på Skole ---
    @Test
    void testSkolePersonale_BeskrivelserOgLogik() {
//        Lærer lær = new Lærer("Børge", 50, "Matematik", 20);
//        assertTrue(lær.getDetaljeretBeskrivelse().contains("Lærer") && lær.getDetaljeretBeskrivelse().contains("Matematik"));
//        assertTrue(lær.kanGåPåPension()); // 50 + 20 = 70
//
//        Elev elev = new Elev("Ida", 17, 11, 7.5); // 11. årgang
//        assertTrue(elev.getDetaljeretBeskrivelse().contains("Elev") && elev.getDetaljeretBeskrivelse().contains("årgang 11"));
//        assertTrue(elev.erBeståetÅrgang(6.0));
//        assertFalse(elev.erBeståetÅrgang(8.0));
    }

    // --- Tests for Opgave 4.10: Ordre Hierarki med Rabat/Gebyr ---
    @Test
    void testOrdreHierarki_PrisBeregning() {
//        StandardOrdre stdOrdre = new StandardOrdre(1, "Kunde A", 50.0);
//        stdOrdre.tilføjVare("Bog", 100.0);
//        stdOrdre.tilføjVare("Pen", 20.0);
//        // subTotal = 120.0. TotalPris = 120.0 + 50.0 (forsendelse) = 170.0
//        assertEquals(170.0, stdOrdre.beregnTotalPris(), 0.01);
//        assertTrue(stdOrdre.getOrdreDetaljer().contains("Forsendelsesgebyr: 50.0"));
//
//        ExpressOrdre expOrdre = new ExpressOrdre(2, "Kunde B", 0.10); // 10% express gebyr
//        expOrdre.tilføjVare("USB Stik", 80.0);
//        expOrdre.tilføjVare("Mus", 120.0);
//        // subTotal = 200.0. TotalPris = 200.0 * (1 + 0.10) = 220.0
//        assertEquals(220.0, expOrdre.beregnTotalPris(), 0.01);
//        assertTrue(expOrdre.getOrdreDetaljer().contains("Express Gebyr (10.0%)"));
    }
}