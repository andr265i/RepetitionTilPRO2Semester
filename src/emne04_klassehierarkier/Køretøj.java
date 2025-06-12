package emne04_klassehierarkier;

public class Køretøj {

    protected String registreringsNummer;
    protected int vægtKg;
    protected int maksHastighedKmt;
    protected int nuværendeHastighedKmt = 0;

    public Køretøj(String registreringsNummer, int vægtKg, int maksHastighedKmt) {
        this.registreringsNummer = registreringsNummer;
        this.vægtKg = vægtKg;
        this.maksHastighedKmt = maksHastighedKmt;
    }

    public void accelerer(int kmTimeTilvækst) {

        if(kmTimeTilvækst > 0) {
        if(nuværendeHastighedKmt + kmTimeTilvækst > maksHastighedKmt) {
            nuværendeHastighedKmt = maksHastighedKmt; //Måske skal der ikke ske noget?
        }
        else {
            nuværendeHastighedKmt += kmTimeTilvækst;
        }
        }
    }

    void brems(int kmTimeReduktion) {
        if(kmTimeReduktion > 0) {
            if(nuværendeHastighedKmt - kmTimeReduktion >= 0 ) {
                nuværendeHastighedKmt = nuværendeHastighedKmt - kmTimeReduktion;
            }
            else {
                nuværendeHastighedKmt = 0;
            }
        }
    }

    public String getGenerelBeskrivelse() {
        return "Køretøj " + registreringsNummer + " Vægt: " + vægtKg + " Maks Fart: " + maksHastighedKmt;
    }

    public int getNuværendeHastighedKmt() {
        return nuværendeHastighedKmt;
    }
}
