package emne08_indkapsling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map; // Kan blive relevant for nogle scenarier i fulde klasser

/**
 * Generel Beskrivelse for Opgavesættet Emne 8: Indkapsling og Afskærmning (Teori)
 * ================================================================================
 * Dette opgavesæt fokuserer på Emne 8: Indkapsling og Afskærmning.
 * Formålet er at teste din forståelse af principperne bag indkapsling,
 * korrekt brug af access modifiers (private, public, protected, package-private),
 * design af getters/setters, validering, og beskyttelse af intern tilstand.
 * For hver opgave skal du sætte den tilhørende 'ditSvar'-variabel i metoden
 * til nummeret på den svarmulighed, du anser for mest korrekt.
 */
public class Emne08IndkapslingTeoriOpgaver {

    /**
     * Opgave 8.1: Access Modifier for Følsom Data
     * -------------------------------------------
     * Problemstilling:
     * En klasse `BankKonto` har en attribut `double saldo`. Det er vigtigt, at saldoen
     * ikke kan ændres direkte udefra uden om klassens metoder (f.eks. `indsæt` og `hæv`),
     * som indeholder valideringslogik.
     *
     * Spørgsmål:
     * Hvilken access modifier er mest passende for attributten `saldo` for at opnå
     * stærkest mulig indkapsling og kontrol?
     *
     * Svarmuligheder:
     * 1. public
     * 2. private
     * 3. protected
     * 4. (ingen modifier - package-private)
     */
    public static int opgave8_1_svarAccessModifierSaldo() {
        // TODO: Sæt variablen til det korrekte svar-nummer (1-4).
        int ditSvar = 2;
        return ditSvar;
    }

    /**
     * Opgave 8.2: Getter for en Mutabel Liste
     * ---------------------------------------
     * Problemstilling:
     * En klasse `Indkøbskurv` har en privat attribut `ArrayList<Vare> varer`.
     * Klassen har en `public ArrayList<Vare> getVarer()` metode.
     *
     * Spørgsmål:
     * Hvad er et potentielt problem med denne `getVarer()` implementering, hvis den
     * returnerer en direkte reference til den interne `varer` liste, og hvordan
     * bør det ideelt løses for at bevare indkapslingen af `Indkøbskurv`?
     *
     * Svarmuligheder:
     * 1. Intet problem, det er effektivt at returnere den direkte reference.
     * 2. Problemet er, at ekstern kode kan modificere listen (f.eks. tilføje/fjerne varer) uden om `Indkøbskurv`'s metoder. Løsning: Returner en kopi af listen.
     * 3. Problemet er, at listen ikke kan være `final`. Løsning: Gør listen `final`.
     * 4. Problemet er, at `ArrayList` er langsom. Løsning: Brug et `Vare[]` array i stedet.
     */
    public static int opgave8_2_svarGetterForMutabelListe() {
        // TODO: Sæt variablen til det korrekte svar-nummer (1-4).
        int ditSvar = 2;
        return ditSvar;
    }

    /**
     * Opgave 8.3: Validering i en Setter-metode
     * ------------------------------------------
     * Problemstilling:
     * En klasse `Person` har en privat attribut `int alder`. Den har en public setter-metode
     * `public void setAlder(int nyAlder)`. Alderen skal altid være >= 0.
     *
     * Spørgsmål:
     * Hvis `setAlder` modtager en ugyldig alder (f.eks. -5), hvad er den bedste praksis
     * for metoden at reagere på, ifølge principperne for robust objektorienteret design?
     *
     * Svarmuligheder:
     * 1. Ignorere den ugyldige værdi og lade alderen forblive uændret.
     * 2. Sætte alderen til en default-værdi (f.eks. 0) uden at signalere en fejl.
     * 3. Kaste en `IllegalArgumentException` for at signalere, at inputtet var ugyldigt.
     * 4. Automatisk konvertere den negative alder til en positiv (f.eks. -5 bliver til 5).
     */
    public static int opgave8_3_svarSetterValidering() {
        // TODO: Sæt variablen til det korrekte svar-nummer (1-4).
        int ditSvar = 3;
        return ditSvar;
    }

    /**
     * Opgave 8.4: Ansvarsplacering for Metode
     * ----------------------------------------
     * Problemstilling:
     * En klasse `Ordre` indeholder en `private ArrayList<OrdreLinje> linjer` og en
     * `private double totalPrisMedMoms`. Hver `OrdreLinje` har en pris.
     * Der er behov for en metode, der beregner `totalPrisMedMoms` baseret på summen
     * af priserne på alle `OrdreLinje`-objekter plus moms.
     * Denne `totalPrisMedMoms` skal altid være konsistent med indholdet af `linjer`.
     *
     * Spørgsmål:
     * Hvor bør logikken til at opdatere `totalPrisMedMoms` primært placeres eller kaldes fra
     * for at sikre dataintegritet og god indkapsling?
     *
     * Svarmuligheder:
     * 1. I en public static metode i en hjælpeklasse `PrisBeregner`, som `Ordre`-klassen så kalder.
     * 2. Som en public metode i `Ordre`-klassen, som klientkoden er ansvarlig for at kalde, hver gang linjerne ændres.
     * 3. Som en private metode i `Ordre`-klassen, der automatisk kaldes internt hver gang en `OrdreLinje` tilføjes, fjernes eller ændres.
     * 4. Direkte i klientkoden, der bruger `Ordre`-objektet, ved at tilgå linjerne og beregne summen manuelt.
     */
    public static int opgave8_4_svarAnsvarsplacering() {
        // TODO: Sæt variablen til det korrekte svar-nummer (1-4).
        int ditSvar = 3;
        return ditSvar;
    }

    /**
     * Opgave 8.5: Utilsigtet Modifikation af Intern Tilstand
     * ----------------------------------------------------
     * Problemstilling:
     * En klasse `Bil` har en privat attribut `private Motor minMotor = new Motor();`.
     * `Bil`-klassen har en public metode: `public Motor getMotor() { return this.minMotor; }`.
     * `Motor`-klassen har en public metode: `public void setOmdrejningstal(int omdr) { ... }`.
     *
     * Spørgsmål:
     * Er der et potentielt problem med indkapslingen af `Bil`-klassen i dette setup?
     *
     * Svarmuligheder:
     * 1. Nej, `minMotor` er privat, så indkapslingen er perfekt.
     * 2. Ja, fordi `getMotor()` returnerer en reference til det interne `Motor`-objekt, hvilket tillader ekstern kode at ændre motorens tilstand direkte (f.eks. omdrejningstal) uden om `Bil`-klassens kontrol.
     * 3. Ja, problemet er, at `setOmdrejningstal` i `Motor` burde være privat.
     * 4. Nej, så længe `Bil`-klassen ikke selv ændrer motorens omdrejningstal, er der intet problem.
     */
    public static int opgave8_5_svarUtilsigtetModifikation() {
        // TODO: Sæt variablen til det korrekte svar-nummer (1-4).
        int ditSvar = 2;
        return ditSvar;
    }

    /**
     * Opgave 8.6: Immutabilitet og `final`
     * -----------------------------------
     * Problemstilling:
     * En klasse `GPSKoordinat` skal repræsentere et uforanderligt (immutable) geografisk punkt.
     * Den har attributterne `private final double breddegrad;` og `private final double laengdegrad;`.
     * Disse initialiseres i konstruktøren.
     *
     * Spørgsmål:
     * Hvilke typer metoder er typisk passende for disse `final` attributter i en immutable klasse
     * for at understøtte indkapsling og immutabilitet?
     *
     * Svarmuligheder:
     * 1. Public get-metoder og public set-metoder.
     * 2. Kun public get-metoder. Ingen set-metoder.
     * 3. Hverken get- eller set-metoder; attributterne skal være public final.
     * 4. Kun public set-metoder (get-metoder er unødvendige, da værdierne er konstante).
     */
    public static int opgave8_6_svarImmutabilitetFinal() {
        // TODO: Sæt variablen til det korrekte svar-nummer (1-4).
        int ditSvar = 2;
        return ditSvar;
    }

    /**
     * Opgave 8.7: `protected` vs. `private` i Superklasse
     * ----------------------------------------------------
     * Problemstilling:
     * En superklasse `BasisRapport` har en metode `genererInternStatusKode()`, som den selv bruger.
     * Det overvejes, om subklasser af `BasisRapport` også skal have direkte adgang til at kalde
     * `genererInternStatusKode()`, men metoden skal absolut ikke være en del af klassens
     * offentlige API (dvs. ikke kaldes af kode uden for hierarkiet).
     *
     * Spørgsmål:
     * Hvilken access modifier er mest passende for `genererInternStatusKode()` i `BasisRapport`
     * for at opfylde disse krav?
     *
     * Svarmuligheder:
     * 1. public
     * 2. private
     * 3. protected
     * 4. (ingen modifier - package-private), hvis super- og subklasser altid er i samme pakke.
     */
    public static int opgave8_7_svarProtectedVsPrivate() {
        // TODO: Sæt variablen til det korrekte svar-nummer (1-4).
        // (Antag at subklasser kan være i andre pakker, medmindre andet er specificeret).
        int ditSvar = 3;
        return ditSvar;
    }

    /**
     * Opgave 8.8: Princippet om Information Hiding
     * --------------------------------------------
     * Spørgsmål:
     * Hvad er det primære formål med princippet "Information Hiding" (informationsskjul)
     * i objektorienteret programmering?
     *
     * Svarmuligheder:
     * 1. At gøre koden kortere ved at skjule unødvendige detaljer.
     * 2. At forbedre programmets ydeevne ved at begrænse adgang til data.
     * 3. At øge programmets sikkerhed ved at kryptere interne data.
     * 4. At reducere kompleksitet og afhængigheder mellem klasser ved at skjule interne implementeringsdetaljer og kun eksponere et stabilt interface.
     */
    public static int opgave8_8_svarInformationHiding() {
        // TODO: Sæt variablen til det korrekte svar-nummer (1-4).
        int ditSvar = 4;
        return ditSvar;
    }

    /**
     * Opgave 8.9: Konsekvens af Public Attributter
     * --------------------------------------------
     * Problemstilling:
     * En klasse `SpilFigur` har en attribut `public int healthPoints;`.
     *
     * Spørgsmål:
     * Hvad er en væsentlig negativ konsekvens af, at `healthPoints` er `public`?
     *
     * Svarmuligheder:
     * 1. Det gør det umuligt at nedarve fra `SpilFigur`.
     * 2. Andre dele af programmet kan direkte ændre `healthPoints` til ugyldige værdier (f.eks. negative) eller på måder, der bryder spillets logik.
     * 3. Det vil altid gøre programmet langsommere end hvis attributten var privat.
     * 4. Der er ingen negativ konsekvens; public attributter er altid mest fleksible.
     */
    public static int opgave8_9_svarPublicAttributKonsekvens() {
        // TODO: Sæt variablen til det korrekte svar-nummer (1-4).
        int ditSvar = 2;
        return ditSvar;
    }

    /**
     * Opgave 8.10: Fordele ved Indkapsling for en Kompleks Klasse
     * ----------------------------------------------------------
     * Problemstilling:
     * En klasse `VejrSimulator` har en meget kompleks intern model med mange private attributter
     * og private hjælpemetoder til at simulere vejrudvikling. Den eksponerer kun et par
     * simple public metoder som `startSimulering(int dage)` og `getVejrRapportForDag(int dag)`.
     *
     * Spørgsmål:
     * Hvordan bidrager indkapsling til designet af `VejrSimulator`?
     *
     * Svarmuligheder:
     * 1. Indkapsling gør `VejrSimulator` klassen unødvendigt restriktiv og svær at udvide.
     * 2. Indkapsling tvinger klassen til at have færre public metoder, hvilket begrænser dens funktionalitet.
     * 3. Indkapsling skjuler den interne kompleksitet, gør klassen nemmere at bruge, og tillader interne ændringer (f.eks. forbedring af simuleringsalgoritmen) uden at påvirke de klasser, der bruger `VejrSimulator`.
     * 4. Indkapsling er primært relevant for små, simple klasser, ikke for komplekse simulatorer.
     */
    public static int opgave8_10_svarFordelVedIndkapsling() {
        // TODO: Sæt variablen til det korrekte svar-nummer (1-4).
        int ditSvar = 3;
        return ditSvar;
    }

    public static void main(String[] args) {
        System.out.println("=== Emne 8: Indkapsling og Afskærmning (Teoriopgaver) ===");
        System.out.println("Udfyld 'ditSvar' variablerne i hver opgavemetode.");
        System.out.println("Kør derefter Emne08IndkapslingTeoriOpgaverTest.java for at verificere dine svar.");

        // Eksempel på manuel tjek (valgfrit):
        // System.out.println("Svar på Opgave 8.1: " + opgave8_1_svarAccessModifierSaldo());
        // System.out.println("Svar på Opgave 8.2: " + opgave8_2_svarGetterForMutabelListe());
        // ... osv.
    }
}