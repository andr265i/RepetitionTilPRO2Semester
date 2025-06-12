package emne02_multiarrays; // Husk at sætte den korrekte package øverst i din fil

import javax.xml.transform.Result;

/**
 * Generel Beskrivelse for Opgavesættet Emne 2: Arrays i Flere Dimensioner
 * =======================================================================
 * Dette opgavesæt dækker Emne 2: Arrays i Flere Dimensioner.
 * Formålet er at øve oprettelse, initialisering, traversering og manipulation
 * af 2D arrays (matricer/tabeller).
 * Du skal selv overveje og implementere håndtering af edge cases.
 */
public class Emne02OpgaverMultiArrays {

    /**
     * Opgave 2.1: Initialisering af Skakbrætmønster
     * ---------------------------------------------
     * Beskrivelse:
     * Skriv en statisk metode `opgave2_1_createChessboard(int size)` der returnerer
     * et 2D `char` array (`char[][]`) af dimensionerne `size` x `size`.
     * Arrayet skal repræsentere et skakbrætmønster, hvor felterne skiftevis
     * indeholder 'S' (for sort) og 'H' (for hvid). Det øverste venstre felt (0,0)
     * kan f.eks. være 'H'.
     * <p>
     * Eksempel (size = 3):
     * H S H
     * S H S
     * H S H
     * <p>
     */
    public static char[][] opgave2_1_createChessboard(int size) {
        // TODO: Implementer createChessboard.
        // Håndter size <= 0 (return f.eks. et tomt 0x0 array eller null).
        // Opret et char[size][size] array.
        // Brug indlejrede løkker til at gennemgå alle felter.
        // Tildel 'H' eller 'S' baseret på om summen af række- og kolonneindeks (i+j) er lige eller ulige.
        // (Hvis (i+j) % 2 == 0, så 'H', ellers 'S' - eller omvendt, vælg en konsekvent start).

        char[][] charArray2D = null;

        if(size > 0) {
            charArray2D = new char[size][size];
            for(int i = 0; i < charArray2D.length; i++){
                for(int j = 0; j < charArray2D[1].length; j++ ){
                    if((i+j) % 2 == 0) {
                        charArray2D[i][j] = 'H';
                    }
                    else {
                        charArray2D[i][j] = 'S';
                    }
                }
            }
    }
        return charArray2D;
    }

    /**
     * Opgave 2.2: Sum af Diagonal(er) i en Kvadratisk Matrix
     * -----------------------------------------------------
     * Beskrivelse:
     * Skriv to statiske metoder til en kvadratisk (lige mange rækker og kolonner) matrix af heltal:
     * 1. `opgave2_2_sumMainDiagonal(int[][] matrix)`: Returnerer summen af elementerne på
     * hoveddiagonalen (fra øverste venstre til nederste højre).
     * 2. `opgave2_2_sumAntiDiagonal(int[][] matrix)`: Returnerer summen af elementerne på
     * antidiagonalen (fra øverste højre til nederste venstre).
     * <p>
     * Eksempel (matrix = {{1,2,3},{4,5,6},{7,8,9}}):
     * sumMainDiagonal => 1 + 5 + 9 = 15
     * sumAntiDiagonal => 3 + 5 + 7 = 15
     * <p>
     * Relation til noter:
     * Øver specifikke traverseringsmønstre i et 2D array og summering af elementer.
     * Kræver tjek for, om matricen er kvadratisk.
     */
    public static int opgave2_2_sumMainDiagonal(int[][] matrix) {
        // Håndter null matrix, ikke-kvadratisk matrix, eller tom matrix
        // (f.eks. returner 0 eller kast IllegalArgumentException, hvis den ikke er kvadratisk).
        // Iterer og summer elementerne hvor rækkeindeks == kolonneindeks.

        int sum = 0;
        if(matrix == null || matrix.length == 0 || matrix.length != matrix[1].length){
            return 0;
        }
        else {
            for(int i = 0; i < matrix.length ; i++) {
                sum += matrix[i][i];
            }
        }
        return sum; // Skal erstattes
    }

    public static int opgave2_2_sumAntiDiagonal(int[][] matrix) {
        // Håndter null matrix, ikke-kvadratisk matrix, eller tom matrix.
        // For en N x N matrix, er elementerne på antidiagonalen matrix[i][N-1-i].
        // Iterer og summer disse elementer.

        int sum = 0;
        if(matrix == null || matrix.length == 0 || matrix.length != matrix[1].length){
            return 0;
        }
        else {
            for(int i = matrix.length-1; i >= 0; i--) {
                sum += matrix[i][i];
            }
        }
        return sum; // Skal erstattes
    }

    /**
     * Opgave 2.3: Find Største Værdi i en Matrix
     * -----------------------------------------
     * Beskrivelse:
     * Skriv en statisk metode `opgave2_3_findMaxValueInMatrix(int[][] matrix)`
     * der tager en 2D matrix af heltal (behøver ikke være kvadratisk) som input
     * og returnerer den største værdi, der findes i hele matricen.
     * <p>
     * Eksempel:
     * matrix = {{1, 9, 2}, {8, 3, 7}, {4, 6, 5}} => returnerer 9
     * matrix = {{-5, -2}, {-10, -1}} => returnerer -1
     * <p>
     * Relation til noter:
     * Øver iteration gennem alle elementer i et 2D array ved hjælp af indlejrede
     * løkker og basal sammenligningslogik for at finde en maksimumværdi.
     */
    public static int opgave2_3_findMaxValueInMatrix(int[][] matrix) {
        // TODO: Implementer findMaxValueInMatrix.
        // Håndter edge cases:
        //  - Hvad hvis 'matrix' er null? (Returner f.eks. Integer.MIN_VALUE eller kast en fejl).
        //  - Hvad hvis 'matrix' er tom (matrix.length == 0)?
        //  - Hvad hvis 'matrix' indeholder rækker, der er null eller tomme?
        // Initialiser en variabel 'maxValue' til den mindst mulige int-værdi.
        // Brug indlejrede løkker til at gennemgå hvert element i matricen.
        // Hvis et element er større end 'maxValue', opdater 'maxValue'.
        // Returner 'maxValue'. Hvis ingen elementer blev fundet (f.eks. kun tomme rækker),
        // hvad er så en passende returværdi? (Måske stadig Integer.MIN_VALUE).
        return Integer.MIN_VALUE; // Skal erstattes
    }


    /**
     * Opgave 2.4: Find Række med Største Sum
     * ---------------------------------------
     * Beskrivelse:
     * Skriv en statisk metode `opgave2_4_findRowWithLargestSum(int[][] data)`
     * der tager et 2D array af heltal (behøver ikke være kvadratisk) og returnerer
     * indekset på den række, der har den største sum af sine elementer.
     * Hvis flere rækker har samme største sum, kan indekset på den første af disse
     * returneres.
     * <p>
     * Eksempel:
     * data = {{1,5,2},{10,2,1},{0,0,1}} => Række 1 (indeks 1) har summen 13, hvilket er størst. Metoden returnerer 1.
     * data = {{10},{1,2},{5}} => Række 0 har summen 10. Metoden returnerer 0.
     * <p>
     * Relation til noter:
     * Kombinerer iteration over ydre array (rækker) og indre array (kolonner for hver række)
     * med logik til at holde styr på en maksimumværdi og det tilhørende indeks.
     */
    public static int opgave2_4_findRowWithLargestSum(int[][] data) {
        // TODO: Implementer findRowWithLargestSum.
        // Håndter null eller tomt 'data' array (f.eks. returner -1 eller kast exception).
        // Initialiser 'maxSum' (f.eks. til Integer.MIN_VALUE) og 'rowIndexWithMaxSum' (f.eks. til -1 eller 0).
        // Iterer gennem hver række:
        //   Beregn summen af elementerne i den aktuelle række.
        //   Hvis denne sum er større end 'maxSum', opdater 'maxSum' og 'rowIndexWithMaxSum'.
        //   Husk at håndtere den allerførste rækkes sum korrekt ift. initial 'maxSum'.
        // Returner 'rowIndexWithMaxSum'.
        return -1; // Skal erstattes
    }

    /**
     * Opgave 2.5: Valider Sudoku Undernet (3x3)
     * -----------------------------------------
     * Beskrivelse:
     * Skriv en statisk metode `opgave2_5_isValidSudokuSubgrid(int[][] sudokuBoard, int subgridStartRow, int subgridStartCol)`
     * der tager et 9x9 `sudokuBoard` (repræsenteret som `int[][]`), samt startrække og startkolonne
     * for et 3x3 undernet. Metoden skal returnere `true`, hvis det specificerede 3x3 undernet
     * er gyldigt ifølge Sudoku-reglerne (dvs. det indeholder tallene 1-9 præcis én gang hver),
     * og `false` ellers. Du kan antage, at tomme felter er repræsenteret med 0. Et undernet
     * med 0'er er ikke gyldigt i denne sammenhæng for "fuldendt" validering, men for denne opgave
     * fokuserer vi på, om tallene 1-9 optræder uden gentagelser indenfor 3x3-feltet.
     * Et simpelt tjek er, at der ikke er gentagelser af tal > 0 inden for 1-9.
     * <p>
     * Eksempel:
     * Hvis et 3x3 undernet er {{5,3,0},{6,0,0},{0,9,8}}, og vi kun tjekker for unikke tal > 0 (1-9), er det gyldigt.
     * Hvis et 3x3 undernet er {{5,3,5},{6,0,0},{0,9,8}}, er det ugyldigt pga. gentagelse af 5.
     * <p>
     * Returner `true` hvis alle tal fra 1-9, der er til stede i 3x3-undernettet,
     * kun optræder én gang. Returner `false` hvis et tal (1-9) gentages. 0'er ignoreres.
     * <p>
     * Relation til noter:
     * Anvender adgang til specifikke dele af et 2D array (et under-array/submatrix)
     * og kræver logik til at tjekke for unikke værdier inden for dette område.
     */

    public static boolean opgave2_5_isValidSudokuSubgrid(int[][] sudokuBoard, int subgridStartRow, int subgridStartCol) {
        // TODO: Implementer isValidSudokuSubgrid.
        // Håndter ugyldige input (f.eks. sudokuBoard er ikke 9x9, startRow/Col er udenfor 0-6, eller board er null).
        // 1. Opret en måde at holde styr på de tal, du har set i 3x3 undernettet (f.eks. et boolean array `seen[10]` eller et HashSet).
        // 2. Iterer gennem 3x3 undernettet (fra subgridStartRow til subgridStartRow+2,
        //    og fra subgridStartCol til subgridStartCol+2).
        // 3. For hvert tal i undernettet:
        //    a. Hvis tallet er mellem 1 og 9:
        //       i.  Hvis du allerede har set dette tal, returner `false` (ugyldigt).
        //       ii. Marker tallet som set.
        //    b. Hvis tallet er udenfor 0-9 (f.eks. negativt eller >9), kan det også gøre subgridden ugyldig - overvej dette.
        //       (For denne opgave er fokus på unikke 1-9, 0'er er OK og ignoreres for unikhedstjek).
        // 4. Hvis du gennemgår hele 3x3 undernettet uden at finde gentagelser af 1-9, returner `true`.
        return false; // Skal erstattes
    }

    /**
     * Opgave 2.6: Få Formateret Matrix som Streng
     * -------------------------------------------
     * Beskrivelse:
     * Skriv en statisk metode `opgave2_6_getFormattedMatrixString(int[][] matrix)`,
     * der tager en 2D `int[][] matrix` som input og returnerer en **enkelt streng**,
     * der repræsenterer den formaterede matrix.
     * Hver række i matricen skal være på en ny linje i strengen (brug `System.lineSeparator()`
     * eller `\n`). Elementerne inden for hver række skal være adskilt af et
     * tabulator-tegn (`\t`). Der skal *ikke* være en tabulator efter det sidste
     * element i en række, kun et ny-linje tegn (hvis det ikke er den allersidste linje).
     * <p>
     * Håndtering af edge cases:
     * - Hvis `matrix` er `null`, returner strengen "Matrix er null.".
     * - Hvis `matrix` er tom (0 rækker, dvs. `matrix.length == 0`), returner en tom streng `""`.
     * - Hvis en række i `matrix` er `null`, repræsenteres den som en linje med teksten "[null række]".
     * - Hvis en række i `matrix` er tom (0 kolonner), repræsenteres den som en tom linje i outputstrengen
     * (kun et ny-linje tegn, hvis der kommer flere rækker efter).
     * <p>
     * Eksempel for matrix = {{1,2,3},{40,5,600}}:
     * Returnerer strengen: "1\t2\t3\n40\t5\t600" (eller med System.lineSeparator())
     * <p>
     * Eksempel for matrix = {{1},{2},{3}}:
     * Returnerer strengen: "1\n2\n3"
     * <p>
     * Relation til noter:
     * Grundlæggende øvelse i at iterere over et 2D array (rækker og kolonner)
     * og bygge en formateret streng-repræsentation. Kræver brug af `StringBuilder` for effektivitet.
     */
    public static String opgave2_6_getFormattedMatrixString(int[][] matrix) {
        // TODO: Implementer getFormattedMatrixString.
        // Håndter null matrix først.
        // Håndter tom matrix (0 rækker).
        // Brug en StringBuilder til at bygge outputstrengen.
        // Iterer gennem rækker. For hver række:
        //   Håndter hvis rækken er null.
        //   Håndter hvis rækken er tom (0 kolonner).
        //   Iterer gennem elementer i rækken, tilføj til StringBuilder med '\t' imellem.
        //   Undgå afsluttende '\t' på en linje.
        //   Tilføj ny-linje tegn (System.lineSeparator()) efter hver række (undtagen evt. den sidste hvis den er tom).
        // Returner sb.toString().
        return null; // Skal erstattes
    }

    /**
     * Opgave 2.7: Initialiser Matrix med Stigende Tal
     * -----------------------------------------------
     * Beskrivelse:
     * Skriv en statisk metode `opgave2_7_initializeWithSequentialNumbers(int rows, int cols)`,
     * der opretter og returnerer en ny `int[rows][cols]` matrix.
     * Matricens elementer skal initialiseres med stigende heltal startende fra 1.
     * Tallene skal udfyldes række for række (dvs. `matrix[0][0]=1, matrix[0][1]=2, ... ,
     * `matrix[0][cols-1]=cols, matrix[1][0]=cols+1`, osv.).
     * <p>
     * Eksempel (rows=2, cols=3):
     * {{1, 2, 3},
     * {4, 5, 6}}
     * <p>
     * Relation til noter:
     * Øvelse i at oprette et 2D array af specificerede dimensioner og initialisere
     * dets elementer systematisk baseret på en tæller.
     */
    public static int[][] opgave2_7_initializeWithSequentialNumbers(int rows, int cols) {
        // TODO: Implementer initializeWithSequentialNumbers.
        // Håndter hvis rows eller cols er <= 0 (returner f.eks. et tomt 0x0 array eller null).
        // Opret matricen. Initialiser en tæller (f.eks. 'currentNumber = 1').
        // Brug indlejrede løkker til at tildele 'currentNumber' til hvert element og inkrementere tælleren.
        return null; // Skal erstattes
    }

    /**
     * Opgave 2.8: Summer Elementer i en Bestemt Kolonne
     * -------------------------------------------------
     * Beskrivelse:
     * Skriv en statisk metode `opgave2_8_sumColumn(int[][] matrix, int colIndex)`,
     * der beregner og returnerer summen af alle elementer i den kolonne, der er
     * specificeret ved `colIndex`.
     * Hvis `colIndex` er uden for grænserne for matricen, eller hvis matricen er
     * `null`, tom, eller rækkerne er `null`/for korte, skal metoden returnere 0.
     * <p>
     * Eksempel:
     * matrix = {{1,2,3},{4,5,6},{7,8,9}}, colIndex = 1 => returnerer 2+5+8 = 15.
     * <p>
     * Relation til noter:
     * Øvelse i at traversere en specifik kolonne i et 2D array og udføre en simpel beregning.
     */
    public static int opgave2_8_sumColumn(int[][] matrix, int colIndex) {
        // TODO: Implementer sumColumn.
        // Håndter ugyldige input (null matrix, tom matrix, ugyldigt colIndex).
        // Iterer ned gennem rækkerne. For hver række, tjek om den er lang nok til at indeholde colIndex.
        // Hvis ja, adder elementet matrix[række][colIndex] til en sum.
        // Returner summen.
        return 0; // Skal erstattes
    }

    /**
     * Opgave 2.9: Find Koordinater til Første Forekomst af Værdi
     * ----------------------------------------------------------
     * Beskrivelse:
     * Skriv en statisk metode `opgave2_9_findFirstOccurrence(int[][] matrix, int value)`,
     * der søger efter den *første* forekomst af `value` i `matrix`.
     * Matricen skal gennemsøges række for række, og inden for hver række fra venstre mod højre.
     * Metoden skal returnere et `int[]` array med to elementer: `{rækkeIndeks, kolonneIndeks}`
     * for den første fundne forekomst.
     * Hvis `value` ikke findes i matricen, eller hvis matricen er `null` eller tom,
     * skal metoden returnere `null` (eller f.eks. `new int[]{-1, -1}`).
     * <p>
     * Eksempel:
     * matrix = {{1,2,3},{4,5,2},{7,8,9}}, value = 2 => returnerer {0,1}
     * matrix = {{1,2,3},{4,5,6}}, value = 7 => returnerer null (eller {-1,-1})
     * <p>
     * Relation til noter:
     * Øvelse i systematisk gennemsøgning (iteration) af et 2D array for at finde
     * et specifikt element og returnere dets position.
     */
    public static int[] opgave2_9_findFirstOccurrence(int[][] matrix, int value) {
        // TODO: Implementer findFirstOccurrence.
        // Håndter null eller tom matrix.
        // Brug indlejrede løkker til at søge. Hvis 'value' findes ved matrix[r][k]:
        //   Opret et int-array {r, k} og returner det.
        // Hvis løkkerne gennemføres uden fund, returner null (eller {-1,-1}).
        return null; // Skal erstattes
    }

    /**
     * Opgave 2.10: Tæl Positive Tal i Matrix
     * ---------------------------------------
     * Beskrivelse:
     * Skriv en statisk metode `opgave2_10_countPositiveNumbers(int[][] matrix)`,
     * der tæller og returnerer det samlede antal positive heltal (> 0) i hele matricen.
     * <p>
     * Eksempel:
     * matrix = {{1,-2,3},{0,5,-6},{-7,8,9}} => returnerer 5 (tallene 1, 3, 5, 8, 9)
     * <p>
     * Relation til noter:
     * Grundlæggende øvelse i at iterere over alle elementer i et 2D array og anvende
     * en simpel betingelse for at tælle.
     */
    public static int opgave2_10_countPositiveNumbers(int[][] matrix) {
        // TODO: Implementer countPositiveNumbers.
        // Håndter null eller tom matrix (returner 0).
        // Initialiser en tæller til 0.
        // Brug indlejrede løkker til at gennemgå hvert element.
        // Hvis et element er > 0, inkrementer tælleren.
        // Returner tælleren.
        return 0; // Skal erstattes
    }

    public static void main(String[] args) {
        System.out.println("=== Emne 2: Arrays i Flere Dimensioner - Main metode til VALGFRI manuel test ===");
        System.out.println("=== Brug JUnit-tests (Emne02OpgaverMultiArraysTest.java) til primær verificering. ===");
    }
}
