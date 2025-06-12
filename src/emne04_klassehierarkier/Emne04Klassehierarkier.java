package emne04_klassehierarkier; // Din pakke for dette emne

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects; // For equals/hashCode
import java.util.Random;  // For Terning

/**
 * Generel Beskrivelse for Opgavesættet Emne 4: Klassehierarkier (Revideret V2 - Øget Sværhedsgrad)
 * ==============================================================================================
 * Dette opgavesæt fokuserer på Emne 4: Klassehierarkier (Nedarvning).
 * Formålet er at designe og implementere klasser i arvehierarkier, hvor subklasser
 * specialiserer superklasser med mere distinkt adfærd og data.
 * Fokus på korrekt brug af konstruktører (med super()), method overriding, og
 * design af metoder med mere involveret logik.
 * Opret separate .java filer for hver klasse.
 */
public class Emne04Klassehierarkier {

    /**
     * Opgave 4.1: Avanceret Køretøj Hierarki
     * --------------------------------------
     * Filnavne: Køretøj.java, PersonBil.java, LastBil.java
     *
     * Beskrivelse:
     * 1. Klasse `Køretøj`:
     * - Attributter (protected): `registreringsNummer` (String), `vægtKg` (int),
     * `maksHastighedKmt` (int), `nuværendeHastighedKmt` (int, initialt 0).
     * - Konstruktør: `Køretøj(String regNr, int vægt, int maksHastighed)`.
     * - Metoder (public):
     * - `void accelerer(int kmTimeTilvækst)`: Øger `nuværendeHastighedKmt` men ikke over `maksHastighedKmt`.
     * Tilvækst skal være positiv.
     * - `void brems(int kmTimeReduktion)`: Reducerer `nuværendeHastighedKmt` men ikke under 0.
     * Reduktion skal være positiv.
     * - `int getNuværendeHastighedKmt()`.
     * - `String getGenerelBeskrivelse()`: Returnerer f.eks. "Køretøj [regNr], Vægt: [vægt] kg, Maks Fart: [maksFart] km/t".
     * 2. Klasse `PersonBil` (nedarver fra `Køretøj`):
     * - Attributter (private): `antalSæder` (int), `bagagerumKapacitetLiter` (int), `nuværendeLastLiter` (int).
     * - Konstruktør: `PersonBil(String regNr, int vægt, int maksHastighed, int antalSæder, int bagagerumKapacitet)`.
     * - Metoder (public):
     * - Override `accelerer(int kmTimeTilvækst)`: Personbiler accelererer måske lidt hurtigere (f.eks. tilvækst * 1.2), men stadig begrænset af `maksHastighedKmt`.
     * - Override `getGenerelBeskrivelse()`: Tilføj info om sæder og bagagerum.
     * - `boolean pakBagagerum(int liter)`: Tilføjer `liter` til `nuværendeLastLiter` hvis der er plads. Returnerer succes.
     * - `int getLedigBagagePladsLiter()`.
     * 3. Klasse `LastBil` (nedarver fra `Køretøj`):
     * - Attributter (private): `lasteevneKg` (int), `nuværendeLastKg` (int), `harAnhænger` (boolean).
     * - Konstruktør: `LastBil(String regNr, int vægt, int maksHastighed, int lasteevne)`.
     * - Metoder (public):
     * - Override `accelerer(int kmTimeTilvækst)`: Acceleration er langsommere (f.eks. tilvækst * 0.8). Hvis `harAnhænger` er true, er den endnu langsommere (f.eks. tilvækst * 0.5).
     * - Override `getGenerelBeskrivelse()`: Tilføj info om lasteevne og anhænger.
     * - `boolean lastFrag(int kg)`: Tilføjer `kg` til `nuværendeLastKg` hvis der er kapacitet. Returnerer succes.
     * - `void tilkoblAnhænger()`, `void frakoblAnhænger()`.
     *
     */

    /**
     * Opgave 4.2: Medie Hierarki
     * --------------------------
     * Filnavne: Medie.java, BogMedie.java, FilmMedie.java, MusikAlbum.java
     *
     * Beskrivelse:
     * 1. Klasse `Medie`:
     * - Attributter (protected): `titel` (String), `udgivelsesår` (int), `udlånsPeriodeDage` (int, f.eks. default 14).
     * - Attributter (private): `erUdlånt` (boolean), `udlåntTil` (String), `returDato` (LocalDate).
     * - Konstruktør: `Medie(String titel, int udgivelsesår)`.
     * - Metoder (public):
     * - `boolean udlån(String personNavn)`: Udlåner mediet hvis ikke allerede udlånt, sætter `returDato` (`udlånsPeriodeDage` frem i tiden). Returnerer succes.
     * - `boolean aflever()`: Afleverer mediet. Returnerer succes.
     * - `String getStatus()`: Returnerer status (titel, udlånt til/af, returdato hvis udlånt).
     * - `boolean erOverdue(LocalDate dagsDato)`: Returnerer true hvis udlånt og `returDato` er overskredet.
     * 2. Klasse `BogMedie` (extends `Medie`):
     * - Attributter (private): `forfatter` (String), `isbn` (String), `antalSider` (int).
     * - Konstruktør. Sætter `udlånsPeriodeDage` til f.eks. 28 for bøger via `super` eller en setter i `Medie` (hvis lavet).
     * - Override `getStatus()` for at inkludere bog-specifik info.
     * - Metode `int beregnAnslåetLæsetidTimer(int siderPrTime)`.
     * 3. Klasse `FilmMedie` (extends `Medie`):
     * - Attributter (private): `instruktør` (String), `længdeMinutter` (int), `genre` (String).
     * - Konstruktør. Sætter `udlånsPeriodeDage` til f.eks. 7 for film.
     * - Override `getStatus()`.
     * 4. Klasse `MusikAlbum` (extends `Medie`):
     * - Attributter (private): `kunstner` (String), `sporListe` (ArrayList<String>).
     * - Konstruktør. Sætter `udlånsPeriodeDage` til f.eks. 10.
     * - Override `getStatus()`.
     * - Metoder: `void tilføjSpor(String sporTitel)`, `int getAntalSpor()`.
     *
     * TODO: Opret de fire .java filer og implementer klasserne.
     */

    /**
     * Opgave 4.3: Grafisk Element Hierarki
     * ------------------------------------
     * Filnavne: GrafiskElement.java, PunktGE.java, LinjeGE.java, CirkelGE.java, RektangelGE.java
     *
     * Beskrivelse:
     * 1. Klasse `GrafiskElement`:
     * - Attributter (protected): `positionX` (int), `positionY` (int), `farve` (String).
     * - Konstruktør.
     * - Metode (public): `void flyt(int deltaX, int deltaY)`.
     * - Metode (public): `String tegn()` (returnerer streng "Tegner generisk element på ([X],[Y]) med farve [farve].").
     * 2. Klasse `PunktGE` (extends `GrafiskElement`): Konstruktør. Override `tegn()`.
     * 3. Klasse `LinjeGE` (extends `GrafiskElement`): Attributter `endPositionX`, `endPositionY`. Konstruktør. Override `tegn()`. Metode `double getLængde()`.
     * 4. Klasse `CirkelGE` (extends `GrafiskElement`): Attribut `radius`. Konstruktør. Override `tegn()`. Metode `double getAreal()`. Metode `double getOmkreds()`.
     * 5. Klasse `RektangelGE` (extends `GrafiskElement`): Attributter `bredde`, `højde`. Konstruktør. Override `tegn()`. Metode `double getAreal()`. Metode `boolean erKvadratisk()`.
     *
     * TODO: Opret de fem .java filer. Implementer klasserne. `tegn()` metoderne skal returnere en streng
     * der beskriver, hvad der tegnes, inklusiv specifikke attributter.
     */

    /**
     * Opgave 4.4: Konto Hierarki med Gebyrer og Renter
     * -----------------------------------------------
     * Filnavne: Konto.java, SparekontoPlus.java, BrugerKontoPlus.java
     *
     * Beskrivelse:
     * 1. Klasse `Konto`:
     * - Attributter (protected): `kontoId` (String), `ejerNavn` (String), `saldo` (double).
     * - Konstruktør: `Konto(String id, String ejer, double startSaldo)`. Startsaldo må ikke være negativ.
     * - Metoder (public): `getSaldo()`, `getKontoId()`, `getEjerNavn()`.
     * - `boolean indsæt(double beløb)` (beløb > 0).
     * - `boolean hæv(double beløb)` (beløb > 0 og `saldo - beløb >= 0`).
     * - `String getKontoType()` (returnerer "Standard Konto").
     * 2. Klasse `SparekontoPlus` (extends `Konto`):
     * - Attributter (private): `årligRenteSatsPct` (double), `månedligeGratisHævninger` (int), `hæveGebyr` (double), `hævningerDenneMåned` (int).
     * - Konstruktør: Initialiserer også rentesats, gratis hævninger (f.eks. 3), gebyr (f.eks. 25.0).
     * - Override `hæv(double beløb)`: Hvis `hævningerDenneMåned >= månedligeGratisHævninger`, trækkes `hæveGebyr` fra `beløb` der hæves (eller saldo). Inkrementer `hævningerDenneMåned`.
     * - Metode `void tilskrivMånedligRente()`: Beregner (saldo * (årligRenteSatsPct/100) / 12) og indsætter på konto.
     * - Metode `void nulstilMånedligeHævninger()`: Sætter `hævningerDenneMåned` til 0.
     * - Override `getKontoType()` (returnerer "Sparekonto Plus").
     * 3. Klasse `BrugerKontoPlus` (extends `Konto`):
     * - Attributter (private): `månedligtKontogebyr` (double), `kreditLimit` (double, positiv værdi for overtræk).
     * - Konstruktør: Initialiserer også gebyr og kreditlimit.
     * - Override `hæv(double beløb)`: Tillader saldo at gå i minus, men ikke mere end `-kreditLimit`.
     * - Metode `void trækMånedligtGebyr()`: Trækker gebyret fra saldoen (kan gøre saldoen mere negativ).
     * - Override `getKontoType()` (returnerer "Brugerkonto Plus").
     *
     * TODO: Opret de tre .java filer og implementer klasserne med den beskrevne logik.
     */

    /**
     * Opgave 4.5: SpilFigur Hierarki
     * ------------------------------
     * Filnavne: SpilFigur.java, SpillerFigur.java, FjendeFigur.java, NPCFigur.java
     *
     * Beskrivelse:
     * 1. Klasse `SpilFigur`:
     * - Attributter (protected): `navn` (String), `maxHealth` (int), `currentHealth` (int), `angrebsStyrke` (int).
     * - Konstruktør: `SpilFigur(String navn, int maxHealth, int angrebsStyrke)`. `currentHealth` = `maxHealth`.
     * - Metoder: `void tagSkade(int skadeAmount)`, `boolean erBesejret()` (true hvis `currentHealth <= 0`), `angrib(SpilFigur mål)`.
     * `getFigurStatus()` (returnerer navn og health).
     * 2. Klasse `SpillerFigur` (extends `SpilFigur`):
     * - Attributter (private): `erfaringPoints` (int), `level` (int).
     * - Konstruktør.
     * - Override `tagSkade(int skadeAmount)`: Måske med en chance for at undvige baseret på level.
     * - Metoder: `void tilføjErfaring(int points)` (kan føre til level up, hvilket øger maxHealth og angrebsStyrke).
     * `String getDetaljeretStatus()` (inkluderer level og XP).
     * 3. Klasse `FjendeFigur` (extends `SpilFigur`):
     * - Attributter (private): `fjendeType` (String, f.eks. "Ork", "Spøgelse"), `giverErfaringVedNederlag` (int).
     * - Konstruktør.
     * - Override `angrib(SpilFigur mål)`: Kan have speciel logik, f.eks. chance for kritisk hit.
     * 4. Klasse `NPCFigur` (extends `SpilFigur`):
     * - Attributter (private): `standardDialog` (String), `erVenlig` (boolean). `angrebsStyrke` er typisk 0.
     * - Konstruktør.
     * - Metoder: `String talTil()` (returnerer `standardDialog`), Override `angrib` (gør ingenting hvis venlig).
     *
     * TODO: Opret de fire .java filer. Fokuser på nedarvning og simple specialiseringer.
     */

    /**
     * Opgave 4.6: Musikinstrumenter (Revideret - Øget sværhedsgrad)
     * -------------------------------------------------------------
     * Filnavne: Musikinstrument.java, StrengeInstrument.java, ElektriskGuitar.java, Keyboard.java
     *
     * Beskrivelse:
     * 1. Klasse `Musikinstrument`:
     * - Attributter (protected): `navn` (String), `producent` (String).
     * - Attributter (private): `vægtKg` (double).
     * - Konstruktør: `Musikinstrument(String navn, String producent, double vægtKg)`.
     * - Metoder (public):
     * - `String getNavn()`, `String getProducent()`, `double getVægtKg()`.
     * - `String spilTone(String tone)` (f.eks. "C", "G#"): Returnerer "[Navn] spiller tonen [tone].").
     * - `boolean kræverStrøm()`: Returnerer `false` (default for akustiske instrumenter).
     * - `String getVedligeholdelsesInstruks()`: Returnerer "Generel vedligeholdelse for [Navn].".
     * 2. Klasse `StrengeInstrument` (nedarver fra `Musikinstrument`):
     * - Attributter (private): `antalStrenge` (int), `materialeStrenge` (String, f.eks. "Nylon", "Stål").
     * - Konstruktør: Tager alle nødvendige parametre.
     * - Metoder (public):
     * - Override `spilTone(String tone)`: Returnerer f.eks. "[Navn] spiller [tone] på sine [antal] [materiale] strenge.".
     * - Override `getVedligeholdelsesInstruks()`: Tilføjer "Husk at stemme strengene og tjekke for slitage.".
     * - `void skiftStrenge()`: Printer besked om at strenge skiftes.
     * 3. Klasse `ElektriskGuitar` (nedarver fra `StrengeInstrument`):
     * - Attributter (private): `antalPickups` (int), `forstærkerType` (String).
     * - Konstruktør.
     * - Metoder (public):
     * - Override `kræverStrøm()`: Returnerer `true`.
     * - Override `spilTone(String tone)`: Returnerer f.eks. "Elektrisk guitar ([Navn]) spiller [tone] med [antalPickups] pickups gennem en [forstærkerType]!".
     * - `void brugEffektPedal(String effekt)`: Printer f.eks. "[Navn] bruger [effekt] effekt.".
     * 4. Klasse `Keyboard` (nedarver fra `Musikinstrument`):
     * - Attributter (private): `antalTangenter` (int), `indbyggedeLyde` (ArrayList<String>).
     * - Konstruktør: Tager navn, producent, vægt, antalTangenter. Initialiserer `indbyggedeLyde`.
     * - Metoder (public):
     * - Override `kræverStrøm()`: Returnerer `true`.
     * - `void tilføjLyd(String lyd)`: Tilføjer en ny lyd til `indbyggedeLyde`.
     * - `String vælgOgSpilLyd(String lyd)`: Hvis lyden findes i `indbyggedeLyde`, returner "[Navn] spiller [lyd] lyd.". Ellers returner "[Navn] kender ikke lyden [lyd].".
     * - Override `getVedligeholdelsesInstruks()`: Tilføjer "Hold tangenterne rene og tjek strømforsyning.".
     *
     * TODO: Opret de fire .java filer og implementer klasserne.
     */

    /**
     * Opgave 4.7: Publikationer (Revideret - Øget sværhedsgrad)
     * ---------------------------------------------------------
     * Filnavne: Publikation.java, BogFormat.java, ArtikelFormat.java, Ebog.java
     *
     * Beskrivelse:
     * 1. Klasse `Publikation`:
     * - Attributter (protected): `titel` (String), `forlag` (String), `udgivelsesDato` (LocalDate).
     * - Attributter (private): `læstStatus` (boolean, default false).
     * - Konstruktør: `Publikation(String titel, String forlag, LocalDate udgivelsesDato)`.
     * - Metoder (public):
     * - `String getTitel()`, `String getForlag()`, `LocalDate getUdgivelsesDato()`.
     * - `void markerSomLæst()`, `boolean erLæst()`.
     * - `int getAlderIDage(LocalDate dagsDato)`: Beregner og returnerer publikationens alder i dage.
     * - `String getBibliografiskCitation()`: Returnerer en basis citation.
     * 2. Klasse `BogFormat` (nedarver fra `Publikation`):
     * - Attributter (private): `forfatter` (String), `isbn` (String), `sideAntal` (int).
     * - Konstruktør.
     * - Metoder (public):
     * - Override `getBibliografiskCitation()`: Returnerer en citation i formatet: "[Forfatter] ([Årstal]). *[Titel]*. [Forlag]."
     * - `double beregnPrisPrSide(double bogPris)`: Returnerer pris pr. side. Returner -1.0 hvis `sideAntal` er 0.
     * 3. Klasse `ArtikelFormat` (nedarver fra `Publikation`):
     * - Attributter (private): `forfattere` (List<String>), `journalNavn` (String), `volume` (int), `issue` (int), `startSide` (int), `slutSide` (int).
     * - Konstruktør.
     * - Metoder (public):
     * - Override `getBibliografiskCitation()`: Returnerer citation i formatet: "[Forfatter1] & [Forfatter2] ([Årstal]). [Titel]. *[JournalNavn]*, *[Volume]*([Issue]), [StartSide]-[SlutSide]." (Håndter 1 vs. flere forfattere pænt).
     * - `int getAntalSiderIArtikel()`.
     * 4. Klasse `Ebog` (nedarver fra `BogFormat`):
     * - Attributter (private): `filFormat` (String, f.eks. "PDF", "EPUB"), `filStørrelseMB` (double).
     * - Konstruktør.
     * - Metoder (public):
     * - Override `getBibliografiskCitation()`: Tilføjer "[Ebog - [filFormat]]" til sidst i superklassens citation.
     * - `boolean kanLæsesPåEnhed(String enhedsFormat)`: Returnerer `true` hvis `filFormat` matcher `enhedsFormat` (case-insensitive).
     *
     * TODO: Opret de fire .java filer og implementer klasserne.
     */

    /**
     * Opgave 4.8: Elektroniske Enheder (Revideret - Øget sværhedsgrad)
     * ----------------------------------------------------------------
     * Filnavne: ElektroniskEnhed.java, MobilEnhed.java, SmartphonePlus.java, BaarbarComputer.java
     *
     * Beskrivelse:
     * 1. Klasse `ElektroniskEnhed`:
     * - Attributter (protected): `model` (String), `producent` (String).
     * - Attributter (private): `batteriKapacitetmAh` (int), `nuværendeBatteriPct` (int, 0-100), `erTændt` (boolean).
     * - Konstruktør: `ElektroniskEnhed(String model, String producent, int batteriKapacitetmAh)`. Sætter `nuværendeBatteriPct` til 100, `erTændt` til `false`.
     * - Metoder (public):
     * - `boolean tænd()`: Tænder enheden hvis `nuværendeBatteriPct > 0`. Returnerer succes.
     * - `void sluk()`: Slukker enheden.
     * - `boolean isTændt()`, `int getNuværendeBatteriPct()`.
     * - `void oplad(int opladningsTidMinutter, int mAhPrMinut)`: Øger `nuværendeBatteriPct` baseret på opladning, op til 100%.
     * - `boolean forbrugStrøm(int pctPoint)`: Reducerer `nuværendeBatteriPct`. Hvis batteriet løber tør (`<=0`), slukkes enheden. Returnerer `true` hvis enheden stadig er tændt efter forbrug.
     * - `String getStatusRapport()`: Basis status.
     * 2. Klasse `MobilEnhed` (nedarver fra `ElektroniskEnhed`):
     * - Attributter (private): `skærmOpløsning` (String, f.eks. "1920x1080"), `harSIMkort` (boolean).
     * - Konstruktør.
     * - Override `getStatusRapport()`: Tilføj info om skærm og SIM.
     * 3. Klasse `SmartphonePlus` (nedarver fra `MobilEnhed`):
     * - Attributter (private): `kameraMegapixel` (int), `operativSystem` (String). `harSIMkort` sættes altid til `true`.
     * - Konstruktør.
     * - Override `getStatusRapport()`.
     * - Metode `String tagBillede()`: Returnerer "Klik! Billede taget med [megapixel]MP kamera." hvis tændt og batteri > 5%. Forbruger 2% batteri. Ellers "Kan ikke tage billede.".
     * 4. Klasse `BaarbarComputer` (nedarver fra `ElektroniskEnhed`):
     * - Attributter (private): `processorType` (String), `ramGB` (int), `harTouchskærm` (boolean).
     * - Konstruktør.
     * - Override `getStatusRapport()`.
     * - Metode `String kørProgram(String programNavn, int strømForbrugPct)`: Hvis tændt og nok batteri, "kører" programmet, reducerer batteri, og returnerer "Kører [programNavn]...". Ellers passende fejlbesked.
     *
     * TODO: Opret de fire .java filer og implementer klasserne.
     */

    /**
     * Opgave 4.9: `MusikinstrumentAvanceret` Hierarki (Protected & Final)
     * Filnavne: MusikinstrumentAvanceret.java, Guitar.java, ElGuitar.java
     * Beskrivelse:
     * 1. `MusikinstrumentAvanceret`: `navn` (String), `producent` (String).
     * `final String getProducent()`
     * `protected String getBasisLyd()` (returnerer "Generisk instrumentlyd")
     * `public String spil()` (returnerer f.eks. "Spiller: [basislyd] fra [navn]")
     * 2. `Guitar` (extends `MusikinstrumentAvanceret`): `antalStrenge` (int). Konstruktør.
     * Override `getBasisLyd()` (returnerer "Guitar-klimpren").
     * `final void stemGuitar()` (printer "Guitar stemmes...").
     * 3. `ElGuitar` (extends `Guitar`): `forstærkerModel` (String). Konstruktør.
     * Override `getBasisLyd()` (returnerer "Elektrisk guitar-riff!").
     * Metode `skruOpForForstærker()`. (Kan *ikke* override `stemGuitar()`).
     * TODO: Implementer klasserne med fokus på access modifiers og final.
     */

    /**
     * Opgave 4.10: `Ordre` Hierarki med Rabat/Gebyr
     * Filnavne: Ordre.java, StandardOrdre.java, ExpressOrdre.java
     * Beskrivelse:
     * 1. `Ordre`: `ordreNummer` (int), `kundeNavn` (String), `varer` (ArrayList<String>), `subTotal` (double).
     * Metoder: `tilføjVare(String vareNavn, double pris)` (opdaterer `subTotal`), `double beregnTotalPris()` (returnerer `subTotal`). `getOrdreDetaljer()`.
     * 2. `StandardOrdre` (extends `Ordre`): `forsendelsesGebyr` (double). Konstruktør (sætter gebyr).
     * Override `beregnTotalPris()` (returnerer `super.beregnTotalPris() + forsendelsesGebyr`).
     * 3. `ExpressOrdre` (extends `Ordre`): `expressGebyrProcent` (double, f.eks. 0.15 for 15%).
     * Konstruktør (sætter gebyrprocent).
     * Override `beregnTotalPris()` (returnerer `super.beregnTotalPris() * (1 + expressGebyrProcent)`).
     * Override `getOrdreDetaljer()` (tilføj info om express).
     * TODO: Implementer klasserne.
     */


    public static void main(String[] args) {
        System.out.println("=== Emne 4: Klassehierarkier - Main metode til VALGFRI manuel test ===");
    }
}