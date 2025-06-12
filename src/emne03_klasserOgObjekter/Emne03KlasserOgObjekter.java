package emne03_klasserOgObjekter; // Pakken hvor dine separate klasser skal ligge

/**
 * Generel Beskrivelse for Opgavesættet Emne 3: Klasser og Objekter (10 Opgaver)
 * =============================================================================
 * Dette opgavesæt fokuserer på Emne 3: Klasser og Objekter.
 * Formålet er at øve definition af separate klasser med passende attributter,
 * konstruktører, og metoder der indeholder problemløsning.
 * Hver opgave (3.1 til 3.10) beder dig om at definere en eller flere nye klasser
 * i deres egne .java filer. Beskrivelserne fokuserer på KRAV til klassen/metoden.
 * Undgå at give detaljeret pseudo-kode i dine implementeringer; fokusér på at
 * opfylde kravene.
 */
public class Emne03KlasserOgObjekter {

    /**
     * Opgave 3.1: Klasse `BiblioteksBog`
     * ----------------------------------
     * Filnavn: BiblioteksBog.java
     *
     * Beskrivelse:
     * Definér en klasse `BiblioteksBog` til at håndtere information og status for en bog i et bibliotek.
     * Attributter (private):
     * - `titel` (String), `forfatter` (String), `udgivelsesår` (int), `isbn` (String)
     * - `erUdlånt` (boolean), `lånerNavn` (String), `udlånsdato` (LocalDate)
     *
     * Metoder:
     * 1. Konstruktør: `BiblioteksBog(String titel, String forfatter, int udgivelsesår, String isbn)`
     * - Initialiserer bogens detaljer. `erUdlånt` sættes til false, `lånerNavn` og `udlånsdato` til `null`.
     * 2. Get-metoder for alle attributter.
     * 3. `boolean udlånBog(String lånerNavn, LocalDate dato)`:
     * - Udlåner bogen hvis den er tilgængelig. Opdaterer status. Returnerer succes.
     * 4. `double afleverBog(LocalDate afleveringsDato)`:
     * - Markerer bogen som afleveret. Beregner og returnerer eventuel bøde (10.0 kr pr. overskredet dag
     * efter 30 dages standardlån). Returnerer 0.0 hvis ingen bøde, -1.0 hvis bogen ikke var udlånt.
     * 5. `String getBogStatus()`: Returnerer informativ statusstreng.
     * 6. `LocalDate getForfaldsdato(int standardLånePeriodeDage)`:
     * - Returnerer forfaldsdato hvis udlånt, ellers `null`.
     * 7. `toString()`: Relevant strengrepræsentation.
     *
     */

    /**
     * Opgave 3.2: Klasserne `StuderendeTilKursus` og `Kursus`
     * -------------------------------------------------------
     * Filnavne: StuderendeTilKursus.java, Kursus.java
     *
     * Beskrivelse for `StuderendeTilKursus.java`:
     * Attributter: `navn` (String), `studieId` (int).
     * Metoder: Konstruktør, Getters, `equals/hashCode` (baseret på `studieId`), `toString`.
     * TODO: Opret filen StuderendeTilKursus.java og implementer klassen.
     *
     * Beskrivelse for `Kursus.java`:
     * Attributter: `kursusNavn` (String), `maxAntalStuderende` (int), `tilmeldteStuderende` (ArrayList<StuderendeTilKursus>).
     * Metoder:
     * 1. Konstruktør: `Kursus(String kursusNavn, int maxAntalStuderende)`.
     * 2. `boolean tilmeldStuderende(StuderendeTilKursus stud)`: Tilføjer studerende hvis plads og ikke allerede tilmeldt.
     * 3. `boolean frameldStuderende(int studieId)`: Fjerner studerende baseret på ID.
     * 4. `StuderendeTilKursus findStuderende(int studieId)`: Finder studerende.
     * 5. `void printDeltagerliste()`: Udskriver pæn deltagerliste.
     * 6. `StuderendeTilKursus getStuderendeMedLængsteNavn()`: Finder studerende med længste navn. Null hvis ingen.
     * 7. `ArrayList<String> getKursusCertifikater()`: Returnerer liste af certifikat-strenge. Tom hvis ingen.
     * TODO: Opret filen Kursus.java og implementer klassen.
     */

    /**
     * Opgave 3.3: Klasse `Terning`
     * ---------------------------
     * Filnavn: Terning.java
     *
     * Beskrivelse:
     * Attributter: `antalSider`, `senesteSlag`, `antalSlagTotal`, `sumAfAlleSlag`.
     * Metoder:
     * 1. Konstruktører: Default (6 sider), Overloaded (N sider, valider N > 1).
     * 2. `int kast()`: Simulerer et terningkast, opdaterer statistik, returnerer slag.
     * 3. Get-metoder for `senesteSlag`, `antalSider`, `antalSlagTotal`.
     * 4. `double getGennemsnitligtSlag()`: Returnerer gennemsnit af alle slag (0.0 hvis ingen slag).
     * 5. `void nulstilStatistik()`: Nulstiller al statistik.
     * 6. `int kastIndtil(int målværdi)`: Kaster til `målværdi` opnås. Returner antal kast.
     * Returner -1 for ugyldig `målværdi`. Returner -2 hvis en sikkerhedsgrænse (f.eks. 100 * `antalSider`) nås.
     * 7. `String getFordelingAfSlag(int antalSimuleredeKast)`: Simulerer `antalSimuleredeKast` nye kast,
     * tæller hyppighed pr. side, og returnerer en streng med fordelingen.
     * TODO: Opret filen Terning.java og implementer klassen.
     */

    /**
     * Opgave 3.4: Klasse `BankKonto`
     * -----------------------------
     * Filnavn: BankKonto.java
     *
     * Beskrivelse:
     * Attributter: `kontoNummer`, `saldo`, `kundeNavn`, `MINIMUM_SALDO_TILLADT` (konstant, f.eks. -1000.0),
     * `transaktionsHistorik` (ArrayList<String>).
     * Metoder:
     * 1. Konstruktør: `BankKonto(String kontoNummer, double startSaldo, String kundeNavn)`. Valider startSaldo. Initialiser historik.
     * 2. Get-metoder for `kontoNummer`, `saldo`, `kundeNavn`.
     * 3. `boolean indsætBeløb(double beløb)`: Øger saldo. Log transaktion. Returner succes.
     * 4. `boolean hævBeløb(double beløb)`: Reducerer saldo (check mod `MINIMUM_SALDO_TILLADT`). Log transaktion. Returner succes.
     * 5. `String getKontoDetaljer()`: Returnerer info om konto.
     * 6. `boolean overførTil(BankKonto modtagerKonto, double beløb, String beskedTilModtager)`:
     * Udfører overførsel. Logger transaktion på *begge* konti. Håndter `null` modtager.
     * 7. `List<String> getTransaktionsHistorik(int maxAntal)`: Returnerer de seneste `maxAntal` transaktioner (nyeste først).
     * TODO: Opret filen BankKonto.java og implementer klassen.
     */

    /**
     * Opgave 3.5: Klasse `Vare`
     * -------------------------
     * Filnavn: Vare.java
     *
     * Beskrivelse:
     * Attributter: `vareNummer`, `navn`, `beskrivelse` (alle String), `prisPrStyk` (double), `lagerAntal` (int).
     * Metoder:
     * 1. Konstruktør: Initialiserer alle. Valider `prisPrStyk` og `startLagerAntal` (>=0).
     * 2. Get-metoder for alle attributter.
     * 3. Set-metoder for `prisPrStyk` (valider >=0) og `beskrivelse`.
     * 4. `boolean justerLager(int antal)`: Justerer lager. `lagerAntal` må ikke blive < 0. Returner succes.
     * 5. `double beregnSamletPris(int antalKøbes)`: Returner totalpris. 0.0 hvis `antalKøbes` <= 0.
     * 6. `boolean erPåLager()`: Returnerer `true` hvis `lagerAntal > 0`.
     * 7. `String getProduktInfo()`: Returnerer formateret streng med varenummer, navn og pris.
     * 8. `double sælgVare(int antal)`: Forsøger at sælge. Reducerer lager hvis muligt og returnerer salgspris. Ellers 0.0.
     * 9. `void givRabatProcent(double rabatProcent)`: Reducerer `prisPrStyk`. Valider `rabatProcent` (0-100). Pris kan ikke < 0.
     * TODO: Opret filen Vare.java og implementer klassen.
     */

    /**
     * Opgave 3.6: Klasse `Sang` og `Playlist`
     * --------------------------------------
     * Filnavne: Sang.java, Playlist.java
     *
     * Beskrivelse for `Sang.java`:
     * Attributter: `titel` (String), `kunstner` (String), `længdeISekunder` (int).
     * Metoder: Konstruktør (valider længde >=0), Getters, `getFormattedLængde()` ("MM:SS"),
     * `toString()`, `equals/hashCode` (baseret på alle attributter).
     * TODO: Opret filen Sang.java og implementer klassen.
     *
     * Beskrivelse for `Playlist.java`:
     * Attributter: `navn` (String), `sange` (ArrayList<Sang>).
     * Metoder:
     * 1. Konstruktør: `Playlist(String navn)`.
     * 2. `boolean tilføjSang(Sang s)`: Tilføjer sang hvis ikke null og ikke allerede på listen.
     * 3. `boolean fjernSang(Sang s)`: Fjerner sang.
     * 4. `String getSamletLængdeFormatted()`: Returnerer total spilletid ("HH:MM:SS" eller "MM:SS").
     * 5. `Sang spilNæsteSang()`: Fjerner og returnerer første sang. Null hvis tom.
     * 6. `void blandPlaylist()`: Blander sangene (`Collections.shuffle`).
     * 7. `int getAntalSange()`.
     * TODO: Opret filen Playlist.java og implementer klassen.
     */

    /**
     * Opgave 3.7: Klasse `Ingrediens` og `Opskrift`
     * --------------------------------------------
     * Filnavne: Ingrediens.java, Opskrift.java
     *
     * Beskrivelse for `Ingrediens.java`:
     * Attributter: `navn` (String), `mængde` (double), `enhed` (String).
     * Metoder: Konstruktør, Getters, `toString()` (f.eks. "100.0 g mel").
     * TODO: Opret filen Ingrediens.java og implementer klassen.
     *
     * Beskrivelse for `Opskrift.java`:
     * Attributter: `navn` (String), `ingredienser` (ArrayList<Ingrediens>), `fremgangsmåde` (String), `antalPortioner` (int > 0).
     * Metoder:
     * 1. Konstruktør: `Opskrift(String navn, int antalPortioner, String fremgangsmåde)`. Valider `antalPortioner`.
     * 2. `boolean tilføjIngrediens(Ingrediens i)`.
     * 3. `boolean skalerOpskrift(int nytAntalPortioner)`: Justerer ingrediensmængder proportionalt. Returner false ved ugyldigt `nytAntalPortioner`.
     * 4. `Ingrediens findIngrediens(String navn)`: Finder ingrediens (case-insensitive). Null hvis ikke fundet.
     * 5. `void printOpskrift()`: Udskriver pænt.
     * 6. `Opskrift getDelOpskrift(List<String> ingrediensNavne)`:
     * Returnerer en *ny* `Opskrift` (med samme navn + " (udvalg)", samme portioner, samme fremgangsmåde)
     * men kun indeholdende de ingredienser, hvis navne er i `ingrediensNavne`-listen.
     * Ingrediensmængderne i den nye opskrift skal være de samme som i den oprindelige.
     * TODO: Opret filen Opskrift.java og implementer klassen.
     */

    /**
     * Opgave 3.8: Klasse `ElevScore`
     * -----------------------------
     * Filnavn: ElevScore.java
     *
     * Beskrivelse:
     * Attributter: `elevNavn` (String), `fagScores` (HashMap<String, Integer>).
     * Metoder:
     * 1. Konstruktør: `ElevScore(String elevNavn)`.
     * 2. `boolean registrerScore(String fag, int score)`: Registrerer score (0-100). Returner succes.
     * 3. `Integer getScore(String fag)`: Returnerer score, eller `null` hvis faget ikke findes.
     * 4. `double getGennemsnitsScore()`: Returnerer gns. score (0.0 hvis ingen scores).
     * 5. `String getFagMedHøjesteScore()`: Returnerer fagnavn med højeste score. Null hvis ingen scores. (Første ved lighed)
     * 6. `boolean erBeståetIAlleFag(int beståelsesGrænse)`: True hvis alle scores >= grænse. True hvis ingen fag.
     * 7. `Map<String, String> getKarakterBeskrivelser(Map<Integer, String> scoreTilBeskrivelse)`:
     * Tager et map der mapper en minimumsscore til en beskrivelse (f.eks. 90->"Fremragende", 70->"Godt", 0->"Under middel").
     * Returnerer et nyt map `HashMap<String, String>` hvor nøglen er fagnavn og værdien er den
     * tilsvarende beskrivelse baseret på scoren i faget. Hvis en score ikke matcher nogen
     * grænse i `scoreTilBeskrivelse`, kan værdien være "Ukendt" eller lignende.
     * TODO: Opret filen ElevScore.java og implementer klassen.
     */

    /**
     * Opgave 3.9: Klasse `ValutaOmregner`
     * -----------------------------------
     * Filnavn: ValutaOmregner.java
     * Kræver import af `java.util.HashMap` og `java.util.Map`.
     *
     * Beskrivelse:
     * Attributter (private): `omregningskurserTilEUR` (HashMap<String, Double>). Key: Valutakode (f.eks. "USD"), Value: kurs mod 1 EUR.
     * Metoder:
     * 1. Konstruktør: `ValutaOmregner()`: Initialiserer med faste kurser for "USD", "GBP", "DKK", "SEK" og "EUR" (kurs 1.0).
     * 2. `boolean tilføjEllerOpdaterKurs(String valutaKode, double kursTilEUR)`: Valider input (kode=3 store bogstaver, kurs>0). Returner succes.
     * 3. `double omregnTilEUR(double beløb, String fraValutaKode)`: Omregn til EUR. Returner -1.0 ved fejl.
     * 4. `double omregnFraEUR(double eurBeløb, String tilValutaKode)`: Omregn fra EUR. Returner -1.0 ved fejl.
     * 5. `double omregnMellemValutaer(double beløb, String fraValutaKode, String tilValutaKode)`: Omregn mellem to valutaer via EUR. Returner -1.0 ved fejl.
     * 6. `List<String> getUnderstøttedeValutaer()`: Returnerer en sorteret liste af alle valutakoder (keys) som omregneren kender.
     * TODO: Opret filen ValutaOmregner.java og implementer klassen.
     */

    /**
     * Opgave 3.10: Klasse `HttpHeader`
     * -------------------------------
     * Filnavn: HttpHeader.java
     * <p>
     * Beskrivelse:
     * Attributter (private): `navn` (String), `værdi` (String).
     * Metoder:
     * 1. Konstruktør: `HttpHeader(String headerLinje)`: Parser "Navn: Værdi" streng. Håndter manglende kolon eller null/tom linje.
     * 2. Get-metoder for `getNavn()` og `getVærdi()`.
     * 3. `String tilHeaderStreng()`: Returnerer "Navn: Værdi".
     * 4. `boolean erVigtigHeader()`: True hvis `navn` (case-insensitive) er "Content-Type", "Authorization", "User-Agent", "Host", eller "Accept".
     * 5. `static HttpHeader parse(String headerLinje)`: Factory-metode. Returnerer `HttpHeader` objekt eller `null` ved ugyldig linje.
     * 6. `int getVærdiLængdeUdenWhitespace()`: Returnerer længden af `værdi` efter fjernelse af førende/efterfølgende whitespace.
     * TODO: Opret filen HttpHeader.java og implementer klassen.
     */

    public static void main(String[] args) {
        System.out.println("=== Emne 3: Klasser og Objekter - Main metode til VALGFRI manuel test ===");
        System.out.println("=== Opret separate .java filer for hver klasse og brug JUnit-tests til verificering. ===");
    }
}