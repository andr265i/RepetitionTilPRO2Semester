package emne03_klasserOgObjekter; // Sørg for at denne matcher din pakke

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Importer dine nye klasser her, når du har oprettet dem i separate .java filer:
// (Sørg for at fjerne kommenteringen når klasserne er oprettet)
/*
import emne03_klasserobjekter.BiblioteksBog;
import emne03_klasserobjekter.StuderendeTilKursus;
import emne03_klasserobjekter.Kursus;
import emne03_klasserobjekter.Terning;
import emne03_klasserobjekter.BankKonto;
import emne03_klasserobjekter.Vare;
import emne03_klasserobjekter.Sang;
import emne03_klasserobjekter.Playlist;
import emne03_klasserobjekter.Ingrediens;
import emne03_klasserobjekter.Opskrift;
import emne03_klasserobjekter.ElevScore;
import emne03_klasserobjekter.ValutaOmregner;
import emne03_klasserobjekter.HttpHeader;
*/

class Emne03KlasserOgObjekterTest {

    // --- Tests for Opgave 3.1: BiblioteksBog ---
    private BiblioteksBog bog_3_1;
    private final LocalDate idag_3_1 = LocalDate.now();

    @BeforeEach
    void setUpBiblioteksBog_3_1() {
        bog_3_1 = new BiblioteksBog("Hobitten", "J.R.R. Tolkien", 1937, "978-0547928227");
    }

    @Test
    void testBiblioteksBog_KonstruktorOgGettere_3_1() {
        assertEquals("Hobitten", bog_3_1.getTitel());
        assertEquals("J.R.R. Tolkien", bog_3_1.getForfatter());
        assertEquals(1937, bog_3_1.getUdgivelsesår());
        assertEquals("978-0547928227", bog_3_1.getIsbn());
        assertFalse(bog_3_1.erUdlånt());
        assertNull(bog_3_1.getLånerNavn());
        assertNull(bog_3_1.getUdlånsdato());
    }

    @Test
    void testBiblioteksBog_UdlånOgStatus_3_1() {
        assertTrue(bog_3_1.udlånBog("Frodo Sækker", idag_3_1));
        assertTrue(bog_3_1.erUdlånt());
        assertEquals("Frodo Sækker", bog_3_1.getLånerNavn());
        assertEquals(idag_3_1, bog_3_1.getUdlånsdato());
        String expectedStatus = "Hobitten af J.R.R. Tolkien - Udlånt til Frodo Sækker den " + idag_3_1.toString();
        assertEquals(expectedStatus, bog_3_1.getBogStatus());
    }

    @Test
    void testBiblioteksBog_UdlånAlleredeUdlånt_3_1() {
        bog_3_1.udlånBog("Frodo Sækker", idag_3_1);
        assertFalse(bog_3_1.udlånBog("Sam Gammegod", idag_3_1.plusDays(1)));
        assertEquals("Frodo Sækker", bog_3_1.getLånerNavn()); // Stadig Frodo
    }

    @Test
    void testBiblioteksBog_AfleverBogIngenBøde_3_1() {
        bog_3_1.udlånBog("Gandalf Grå", idag_3_1);
        assertEquals(0.0, bog_3_1.afleverBog(idag_3_1.plusDays(29)), 0.01); // Låneperiode 30 dage
        assertFalse(bog_3_1.erUdlånt());
        String expectedStatus = "Hobitten af J.R.R. Tolkien - Tilgængelig.";
        assertEquals(expectedStatus, bog_3_1.getBogStatus());
    }

    @Test
    void testBiblioteksBog_AfleverBogMedBøde_3_1() {
        bog_3_1.udlånBog("Bilbo Sækker", idag_3_1);
        assertEquals(50.0, bog_3_1.afleverBog(idag_3_1.plusDays(30 + 5)), 0.01); // 5 dage for sent
        assertFalse(bog_3_1.erUdlånt());
    }

    @Test
    void testBiblioteksBog_AfleverBogIkkeUdlånt_3_1() {
        assertEquals(-1.0, bog_3_1.afleverBog(idag_3_1), 0.01);
    }

    @Test
    void testBiblioteksBog_GetForfaldsdato_3_1() {
        assertNull(bog_3_1.getForfaldsdato(30));
        bog_3_1.udlånBog("Thorin Egeskjold", idag_3_1);
        assertEquals(idag_3_1.plusDays(14), bog_3_1.getForfaldsdato(14));
    }

    // --- Tests for Opgave 3.2: StuderendeTilKursus og Kursus ---
    private StuderendeTilKursus stud1_3_2, stud2_3_2, stud3_3_2, stud1Dup_3_2;
    private Kursus kursus_3_2;

    @BeforeEach
    void setUpStuderendeOgKursus_3_2() {
        stud1_3_2 = new StuderendeTilKursus("Peter Pan", 201);
        stud2_3_2 = new StuderendeTilKursus("Wendy Darling", 202);
        stud3_3_2 = new StuderendeTilKursus("Kaptajn Klo", 203);
        stud1Dup_3_2 = new StuderendeTilKursus("Peter Plys", 201); // Samme ID
        kursus_3_2 = new Kursus("Flyveteknik for Begyndere", 2);
    }

    @Test
    void testStuderendeTilKursus_EqualsHashCodeToString_3_2() {
        assertEquals(stud1_3_2, stud1Dup_3_2);
        assertNotEquals(stud1_3_2, stud2_3_2);
        assertEquals(stud1_3_2.hashCode(), stud1Dup_3_2.hashCode());
        assertTrue(stud1_3_2.toString().contains("Peter Pan"));
    }

    @Test
    void testKursus_TilmeldFrameld_3_2() {
        assertTrue(kursus_3_2.tilmeldStuderende(stud1_3_2));
        assertTrue(kursus_3_2.tilmeldStuderende(stud2_3_2));
        assertFalse(kursus_3_2.tilmeldStuderende(stud3_3_2)); // Kursus fuldt
        assertFalse(kursus_3_2.tilmeldStuderende(stud1Dup_3_2)); // Allerede tilmeldt via ID
        assertFalse(kursus_3_2.tilmeldStuderende(null));

        assertEquals(stud1_3_2, kursus_3_2.findStuderende(201));
        assertTrue(kursus_3_2.frameldStuderende(201));
        assertNull(kursus_3_2.findStuderende(201));
        assertFalse(kursus_3_2.frameldStuderende(201)); // Allerede frameldt
    }

    @Test
    void testKursus_GetStuderendeMedLængsteNavn_3_2() {
        assertNull(kursus_3_2.getStuderendeMedLængsteNavn());
        kursus_3_2.tilmeldStuderende(stud2_3_2); // "Wendy Darling" (13)
        kursus_3_2.tilmeldStuderende(stud1_3_2); // "Peter Pan" (9)
        assertEquals(stud2_3_2, kursus_3_2.getStuderendeMedLængsteNavn());
    }

    @Test
    void testKursus_GetKursusCertifikater_3_2() {
        assertTrue(kursus_3_2.getKursusCertifikater().isEmpty());
        kursus_3_2.tilmeldStuderende(stud1_3_2);
        kursus_3_2.tilmeldStuderende(stud2_3_2);
        ArrayList<String> certs = kursus_3_2.getKursusCertifikater();
        assertEquals(2, certs.size());
        assertTrue(certs.get(0).contains("Peter Pan") && certs.get(0).contains("Flyveteknik for Begyndere"));
    }

    // --- Tests for Opgave 3.3: Terning ---
//    private Terning terning6sider_3_3, terning20sider_3_3;

    @BeforeEach
    void setUpTerning_3_3() {
//        terning6sider_3_3 = new Terning();
//        terning20sider_3_3 = new Terning(20);
    }

    @Test
    void testTerning_KonstruktorOgGettere_3_3() {
//        assertEquals(6, terning6sider_3_3.getAntalSider());
//        assertEquals(0, terning6sider_3_3.getSenesteSlag());
//        assertEquals(0, terning6sider_3_3.getAntalSlagTotal());
//        assertEquals(20, terning20sider_3_3.getAntalSider());
//        Terning invalidSider = new Terning(0);
//        assertEquals(6, invalidSider.getAntalSider(), "Ugyldigt antal sider bør default'e til 6");
    }

    @Test
    void testTerning_Kast_3_3() {
//        int slag = terning6sider_3_3.kast();
//        assertTrue(slag >= 1 && slag <= 6);
//        assertEquals(slag, terning6sider_3_3.getSenesteSlag());
//        assertEquals(1, terning6sider_3_3.getAntalSlagTotal());
//        assertEquals(slag, terning6sider_3_3.getSumAfAlleSlag()); // Ny getter for test
    }

    // Hjælpemetode til Terning for at få sumAfAlleSlag (skal tilføjes i Terning.java for denne test)
    // public long getSumAfAlleSlag() { return sumAfAlleSlag; }

    @Test
    void testTerning_GennemsnitOgNulstil_3_3() {
//        assertEquals(0.0, terning6sider_3_3.getGennemsnitligtSlag(), 0.01);
//        terning6sider_3_3.kast(); // Antag slag er X
//        terning6sider_3_3.kast(); // Antag slag er Y
//        // double forventetGns = (double)(X+Y) / 2; // Kan ikke testes præcist uden mock
//        terning6sider_3_3.nulstilStatistik();
//        assertEquals(0, terning6sider_3_3.getSenesteSlag());
//        assertEquals(0, terning6sider_3_3.getAntalSlagTotal());
//        assertEquals(0, terning6sider_3_3.getSumAfAlleSlag());
//        assertEquals(0.0, terning6sider_3_3.getGennemsnitligtSlag(), 0.01);
    }

    @Test
    void testTerning_KastIndtil_3_3() {
//        int antalKast = terning6sider_3_3.kastIndtil(3);
//        assertTrue(antalKast >= 1 && antalKast <= 6 * 100 + 5); // Inkl. safety
//        assertEquals(3, terning6sider_3_3.getSenesteSlag());
//
//        assertEquals(-1, terning6sider_3_3.kastIndtil(7)); // Ugyldig
//        assertEquals(-1, terning6sider_3_3.kastIndtil(0));  // Ugyldig
    }

    @Test
    void testTerning_GetFordelingAfSlag_3_3() {
//        Terning d3 = new Terning(3);
//        String fordeling = d3.getFordelingAfSlag(300);
//        assertNotNull(fordeling);
//        assertTrue(fordeling.contains("1'ere:"));
//        assertTrue(fordeling.contains("2'ere:"));
//        assertTrue(fordeling.contains("3'ere:"));
//        assertFalse(fordeling.contains("4'ere:"));
    }


    // --- Tests for Opgave 3.4: BankKonto ---
//    private BankKonto kontoA_3_4, kontoB_3_4;

    @BeforeEach
    void setUpBankKonto_3_4() {
//        kontoA_3_4 = new BankKonto("K100", 1000.0, "Anders And");
//        kontoB_3_4 = new BankKonto("K200", 500.0, "Mickey Mouse");
    }

    @Test
    void testBankKonto_IndsætHæv_3_4() {
//        assertTrue(kontoA_3_4.indsætBeløb(200.0));
//        assertEquals(1200.0, kontoA_3_4.getSaldo());
//        assertFalse(kontoA_3_4.indsætBeløb(-50)); // Ugyldigt
//
//        assertTrue(kontoA_3_4.hævBeløb(300.0));
//        assertEquals(900.0, kontoA_3_4.getSaldo());
//        assertFalse(kontoA_3_4.hævBeløb(900.0 - BankKonto.MINIMUM_SALDO_TILLADT + 0.01)); // Lige over grænsen
//        assertTrue(kontoA_3_4.hævBeløb(900.0 - BankKonto.MINIMUM_SALDO_TILLADT)); // Præcis på grænsen
    }

    @Test
    void testBankKonto_OverførselOgHistorik_3_4() {
//        assertTrue(kontoA_3_4.overførTil(kontoB_3_4, 100.0, "Fødselsdagsgave"));
//        assertEquals(900.0, kontoA_3_4.getSaldo());
//        assertEquals(600.0, kontoB_3_4.getSaldo());
//
//        List<String> historikA = kontoA_3_4.getTransaktionsHistorik(5);
//        List<String> historikB = kontoB_3_4.getTransaktionsHistorik(5);
//        assertEquals(1, historikA.size());
//        assertEquals(1, historikB.size());
//        assertTrue(historikA.get(0).contains("Overførsel til K200: 100.0"));
//        assertTrue(historikB.get(0).contains("Overførsel fra K100: 100.0. Besked: Fødselsdagsgave"));
//
//        assertFalse(kontoA_3_4.overførTil(kontoB_3_4, 10000.0, "Fejl")); // Ikke nok penge
    }
    @Test
    void testBankKonto_OverførselTilNullKonto_3_4() {
//        assertFalse(kontoA_3_4.overførTil(null, 100.0, "Test"));
//        assertEquals(1000.0, kontoA_3_4.getSaldo()); // Uændret
    }


    // --- Tests for Opgave 3.5: Vare ---
//    private Vare vare_3_5;

    @BeforeEach
    void setUpVare_3_5() {
//        vare_3_5 = new Vare("V007", "AgentSaks", "Til hemmelige missioner", 199.95, 10);
    }

    @Test
    void testVare_KonstruktorOgGettere_3_5() {
//        assertEquals("V007", vare_3_5.getVareNummer());
//        assertEquals(199.95, vare_3_5.getPrisPrStyk());
//        assertEquals(10, vare_3_5.getLagerAntal());
//        Vare ugyldigVare = new Vare("V000", "Ugyldig", "", -10, -5);
//        assertEquals(0, ugyldigVare.getPrisPrStyk());
//        assertEquals(0, ugyldigVare.getLagerAntal());
    }

    @Test
    void testVare_JusterLager_3_5() {
//        assertTrue(vare_3_5.justerLager(5)); // 10 + 5 = 15
//        assertEquals(15, vare_3_5.getLagerAntal());
//        assertTrue(vare_3_5.justerLager(-10)); // 15 - 10 = 5
//        assertEquals(5, vare_3_5.getLagerAntal());
//        assertFalse(vare_3_5.justerLager(-6)); // Ville blive -1, ikke tilladt
//        assertEquals(5, vare_3_5.getLagerAntal()); // Uændret
    }

    @Test
    void testVare_SælgVare_3_5() {
//        assertEquals(199.95 * 2, vare_3_5.sælgVare(2), 0.01);
//        assertEquals(8, vare_3_5.getLagerAntal());
//        assertEquals(0.0, vare_3_5.sælgVare(10), 0.01); // Ikke nok
//        assertEquals(8, vare_3_5.getLagerAntal());
//        assertEquals(0.0, vare_3_5.sælgVare(0), 0.01); // Ugyldigt antal
    }

    @Test
    void testVare_GivRabatProcent_3_5() {
//        vare_3_5.givRabatProcent(10.0); // 10%
//        assertEquals(199.95 * 0.9, vare_3_5.getPrisPrStyk(), 0.001);
//        vare_3_5.givRabatProcent(100.0);
//        assertEquals(0.0, vare_3_5.getPrisPrStyk(), 0.001);
//
//        vare_3_5.setPrisPrStyk(50);
//        vare_3_5.givRabatProcent(200); // Ugyldig, over 100, pris skal være 0
//        assertEquals(0.0, vare_3_5.getPrisPrStyk(), 0.001);
//
//        vare_3_5.setPrisPrStyk(50);
//        vare_3_5.givRabatProcent(-10); // Ugyldig, under 0, pris uændret
//        assertEquals(50.0, vare_3_5.getPrisPrStyk(), 0.001);
    }


    // --- Tests for Opgave 3.6: Sang og Playlist ---
//    private Sang sang1_3_6, sang2_3_6, sang3_3_6;
//    private Playlist playlist_3_6;

    @BeforeEach
    void setUpPlaylist_3_6() {
//        sang1_3_6 = new Sang("Bohemian Rhapsody", "Queen", 354); // 05:54
//        sang2_3_6 = new Sang("Stairway to Heaven", "Led Zeppelin", 482); // 08:02
//        sang3_3_6 = new Sang("Hotel California", "Eagles", 390); // 06:30
//        playlist_3_6 = new Playlist("Classic Rock");
    }

    @Test
    void testSang_FormattedLængde_3_6() {
//        assertEquals("05:54", sang1_3_6.getFormattedLængde());
//        assertEquals("08:02", sang2_3_6.getFormattedLængde());
//        Sang kortSang = new Sang("Short", "S", 50);
//        assertEquals("00:50", kortSang.getFormattedLængde());
//        Sang langSang = new Sang("Long", "L", 3661); // 1 time, 1 minut, 1 sekund
//        // Denne test er baseret på MM:SS format, så for 3661 sek = 61 min 1 sek
//        assertEquals("61:01", langSang.getFormattedLængde());
    }

    @Test
    void testPlaylist_TilføjFjernOgAntal_3_6() {
//        assertTrue(playlist_3_6.tilføjSang(sang1_3_6));
//        assertTrue(playlist_3_6.tilføjSang(sang2_3_6));
//        assertEquals(2, playlist_3_6.getAntalSange());
//        assertFalse(playlist_3_6.tilføjSang(sang1_3_6)); // Duplikat
//        assertEquals(2, playlist_3_6.getAntalSange());
//
//        assertTrue(playlist_3_6.fjernSang(sang1_3_6));
//        assertEquals(1, playlist_3_6.getAntalSange());
//        assertFalse(playlist_3_6.fjernSang(sang1_3_6)); // Allerede fjernet
    }

    @Test
    void testPlaylist_SamletLængde_3_6() {
//        playlist_3_6.tilføjSang(sang1_3_6); // 354s
//        playlist_3_6.tilføjSang(sang2_3_6); // 482s
//        // Total: 836s = 13 min, 56 sek
//        assertEquals("13:56", playlist_3_6.getSamletLængdeFormatted());
//
//        Playlist emptyPl = new Playlist("Empty");
//        assertEquals("00:00", emptyPl.getSamletLængdeFormatted());
//
//        Sang longSang = new Sang("Epic", "E", 3600 + 120 + 5); // 1:02:05
//        playlist_3_6.tilføjSang(longSang); // 836 + 3725 = 4561s
//        // 4561s = 76 min 1 sek = 01:16:01
//        assertEquals("01:16:01", playlist_3_6.getSamletLængdeFormatted());
    }

    @Test
    void testPlaylist_SpilOgBland_3_6() {
//        playlist_3_6.tilføjSang(sang1_3_6);
//        playlist_3_6.tilføjSang(sang2_3_6);
//        playlist_3_6.tilføjSang(sang3_3_6);
//
//        List<Sang> originalOrder = new ArrayList<>(playlist_3_6.getSangeForTest()); // Kræver getSangeForTest() i Playlist
//
//        assertEquals(sang1_3_6, playlist_3_6.spilNæsteSang());
//        assertEquals(2, playlist_3_6.getAntalSange());
//
//        playlist_3_6.blandPlaylist();
//        // Det er svært at teste randomisering præcist, men vi kan tjekke at listen stadig har samme elementer
//        // og at rækkefølgen *potentielt* er anderledes (ikke garanteret for små lister).
//        // Her tjekker vi bare at antal er det samme efter blanding.
//        List<Sang> mixedOrder = playlist_3_6.getSangeForTest();
//        assertEquals(2, mixedOrder.size());
//        assertTrue(mixedOrder.contains(sang2_3_6) && mixedOrder.contains(sang3_3_6));
    }
    // Til Playlist, tilføj evt. public ArrayList<Sang> getSangeForTest() { return new ArrayList<>(sange); }


    // --- Tests for Opgave 3.7: Ingrediens og Opskrift ---
//    private Ingrediens mel_3_7, sukker_3_7, kakao_3_7;
//    private Opskrift kageOpskrift_3_7;

    @BeforeEach
    void setUpOpskrift_3_7() {
//        mel_3_7 = new Ingrediens("Mel", 200, "g");
//        sukker_3_7 = new Ingrediens("Sukker", 100, "g");
//        kakao_3_7 = new Ingrediens("Kakao", 25, "g");
//        kageOpskrift_3_7 = new Opskrift("Chokoladekage", 4, "Bland alt og bag.");
//        kageOpskrift_3_7.tilføjIngrediens(mel_3_7);
//        kageOpskrift_3_7.tilføjIngrediens(sukker_3_7);
    }

    @Test
    void testOpskrift_SkalerOpskrift_3_7() {
//        assertTrue(kageOpskrift_3_7.skalerOpskrift(8)); // Dobbelt op
//        assertEquals(8, kageOpskrift_3_7.getAntalPortioner());
//        assertEquals(400, kageOpskrift_3_7.findIngrediens("Mel").getMængde(), 0.01);
//        assertEquals(200, kageOpskrift_3_7.findIngrediens("Sukker").getMængde(), 0.01);
//
//        assertTrue(kageOpskrift_3_7.skalerOpskrift(2)); // Ned til 2 portioner (fra 8)
//        assertEquals(2, kageOpskrift_3_7.getAntalPortioner());
//        assertEquals(100, kageOpskrift_3_7.findIngrediens("Mel").getMængde(), 0.01); // 400 / 4 = 100
//
//        assertFalse(kageOpskrift_3_7.skalerOpskrift(0)); // Ugyldigt
//        assertEquals(2, kageOpskrift_3_7.getAntalPortioner()); // Uændret
    }

    @Test
    void testOpskrift_FindIngrediens_3_7(){
//        assertEquals(mel_3_7, kageOpskrift_3_7.findIngrediens("mel")); // Case insensitive
//        assertNull(kageOpskrift_3_7.findIngrediens("Gær"));
    }

    @Test
    void testOpskrift_GetDelOpskrift_3_7() {
//        kageOpskrift_3_7.tilføjIngrediens(kakao_3_7);
//        List<String> udvalgteNavne = Arrays.asList("Mel", "Kakao");
//        Opskrift delOpskrift = kageOpskrift_3_7.getDelOpskrift(udvalgteNavne);
//
//        assertNotNull(delOpskrift);
//        assertTrue(delOpskrift.getNavn().contains("(udvalg)"));
//        assertEquals(kageOpskrift_3_7.getAntalPortioner(), delOpskrift.getAntalPortioner());
//        assertNotNull(delOpskrift.findIngrediens("Mel"));
//        assertEquals(200, delOpskrift.findIngrediens("Mel").getMængde(), 0.01); // Original mængde
//        assertNotNull(delOpskrift.findIngrediens("Kakao"));
//        assertNull(delOpskrift.findIngrediens("Sukker")); // Skulle ikke være med
    }


    // --- Tests for Opgave 3.8: ElevScore ---
//    private ElevScore elev_3_8;

    @BeforeEach
    void setUpElevScore_3_8() {
//        elev_3_8 = new ElevScore("Børge Mogensen");
    }

    @Test
    void testElevScore_RegistrerOgGetScore_3_8() {
//        assertTrue(elev_3_8.registrerScore("Matematik", 88));
//        assertTrue(elev_3_8.registrerScore("Dansk", 72));
//        assertFalse(elev_3_8.registrerScore("Engelsk", 101)); // Ugyldig
//        assertFalse(elev_3_8.registrerScore("Historie", -5)); // Ugyldig
//        assertEquals(Integer.valueOf(88), elev_3_8.getScore("Matematik"));
//        assertNull(elev_3_8.getScore("Fysik"));
    }

    @Test
    void testElevScore_GennemsnitHøjesteBestået_3_8() {
//        assertEquals(0.0, elev_3_8.getGennemsnitsScore(), 0.01); // Ingen scores
//        assertNull(elev_3_8.getFagMedHøjesteScore());
//        assertTrue(elev_3_8.erBeståetIAlleFag(60)); // Ingen fag -> bestået
//
//        elev_3_8.registrerScore("Matematik", 90);
//        elev_3_8.registrerScore("Dansk", 70);
//        elev_3_8.registrerScore("Engelsk", 80);
//        assertEquals((90.0+70.0+80.0)/3.0, elev_3_8.getGennemsnitsScore(), 0.01);
//        assertEquals("Matematik", elev_3_8.getFagMedHøjesteScore());
//        assertTrue(elev_3_8.erBeståetIAlleFag(70));
//        assertFalse(elev_3_8.erBeståetIAlleFag(75));
    }

    @Test
    void testElevScore_GetKarakterBeskrivelser_3_8() {
//        elev_3_8.registrerScore("Matematik", 95); // Fremragende
//        elev_3_8.registrerScore("Dansk", 72);   // Godt
//        elev_3_8.registrerScore("Engelsk", 55); // Under middel (hvis 0-69 er det)
//        elev_3_8.registrerScore("Kunst", 85);   // Godt (hvis 70-89 er det)
//
//        HashMap<Integer, String> skala = new HashMap<>();
//        skala.put(90, "Fremragende");
//        skala.put(70, "Godt");
//        skala.put(0, "Under middel"); // Minimumsgrænse
//
//        Map<String, String> beskrivelser = elev_3_8.getKarakterBeskrivelser(skala);
//        assertEquals("Fremragende", beskrivelser.get("Matematik"));
//        assertEquals("Godt", beskrivelser.get("Dansk"));
//        assertEquals("Under middel", beskrivelser.get("Engelsk"));
//        assertEquals("Godt", beskrivelser.get("Kunst")); // Antager at 85 falder under "Godt"
    }


    // --- Tests for Opgave 3.9: ValutaOmregner ---
//    private ValutaOmregner vo_3_9;

    @BeforeEach
    void setUpValutaOmregner_3_9() {
//        vo_3_9 = new ValutaOmregner(); // Bruger default kurser
    }

    @Test
    void testValutaOmregner_DefaultKurserOgOmregn_3_9() {
//        // Antager default: "USD" -> 1.10, "GBP" -> 0.85, "DKK" -> 7.45, "SEK" -> 11.20, "EUR" -> 1.0
//        assertEquals(100.0, vo_3_9.omregnTilEUR(110.0, "USD"), 0.001);
//        assertEquals(85.0, vo_3_9.omregnFraEUR(100.0, "GBP"), 0.001); // 100 EUR * 0.85 = 85 GBP
//        assertEquals(10.0 * 7.45 / 1.10, vo_3_9.omregnMellemValutaer(10.0, "USD", "DKK"), 0.001);
//        assertEquals(-1.0, vo_3_9.omregnTilEUR(100.0, "XYZ"), 0.001); // Ukendt valuta
    }

    @Test
    void testValutaOmregner_TilføjOpdaterKurs_3_9() {
//        assertTrue(vo_3_9.tilføjEllerOpdaterKurs("NOK", 11.50));
//        assertEquals(1150.0, vo_3_9.omregnFraEUR(100.0, "NOK"), 0.001);
//        assertTrue(vo_3_9.tilføjEllerOpdaterKurs("NOK", 11.60)); // Opdater
//        assertEquals(1160.0, vo_3_9.omregnFraEUR(100.0, "NOK"), 0.001);
//        assertFalse(vo_3_9.tilføjEllerOpdaterKurs("nok", 11.0)); // Ugyldig kode (små bogstaver)
//        assertFalse(vo_3_9.tilføjEllerOpdaterKurs("NORWAY", 11.0)); // Ugyldig kode (for lang)
//        assertFalse(vo_3_9.tilføjEllerOpdaterKurs("CHF", -1.0)); // Ugyldig kurs
    }

    @Test
    void testValutaOmregner_GetUnderstøttedeValutaer_3_9() {
//        List<String> valutaer = vo_3_9.getUnderstøttedeValutaer();
//        assertTrue(valutaer.containsAll(Arrays.asList("USD", "GBP", "DKK", "SEK", "EUR")));
//        assertEquals(5, valutaer.size()); // Antal default valutaer
//        vo_3_9.tilføjEllerOpdaterKurs("JPY", 160.0);
//        valutaer = vo_3_9.getUnderstøttedeValutaer();
//        assertTrue(valutaer.contains("JPY"));
//        assertEquals(6, valutaer.size());
//        // Tjek sortering hvis specificeret i opgaven
    }


    // --- Tests for Opgave 3.10: HttpHeader ---
    @Test
    void testHttpHeader_ParseOgMetoder_3_10() {
//        HttpHeader h1 = new HttpHeader("Content-Type: application/json");
//        assertEquals("Content-Type", h1.getNavn());
//        assertEquals("application/json", h1.getVærdi());
//        assertEquals("Content-Type: application/json", h1.tilHeaderStreng());
//        assertTrue(h1.erVigtigHeader());
//
//        HttpHeader h2 = HttpHeader.parse("  User-Agent  : MyClient/1.0  ");
//        assertNotNull(h2);
//        assertEquals("User-Agent", h2.getNavn());
//        assertEquals("MyClient/1.0", h2.getVærdi());
//        assertTrue(h2.erVigtigHeader());
    }

    @Test
    void testHttpHeader_InvalidParse_3_10() {
//        HttpHeader invalid1 = new HttpHeader("NoColonHere");
//        assertNull(invalid1.getNavn()); // Eller tom streng, afhængig af implementering
//        assertNull(invalid1.getVærdi());
//
//        HttpHeader invalid2 = HttpHeader.parse("");
//        assertNull(invalid2);
//
//        HttpHeader invalid3 = HttpHeader.parse(null);
//        assertNull(invalid3);
    }

    @Test
    void testHttpHeader_VærdiLængdeUdenWhitespace_3_10() {
//        HttpHeader h = new HttpHeader("X-Data:  some value with spaces  ");
//        assertEquals(24, h.getVærdi().length()); // "  some value with spaces  "
//        assertEquals(20, h.getVærdiLængdeUdenWhitespace()); // "some value with spaces"
//
//        HttpHeader hNoSpace = new HttpHeader("X-Simple:value");
//        assertEquals(5, hNoSpace.getVærdiLængdeUdenWhitespace());
    }
}