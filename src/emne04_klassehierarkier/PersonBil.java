package emne04_klassehierarkier;

public class PersonBil extends Køretøj {

    private int antalSæder;
    private int bagagerumKapacitetLiter;
    private int nuværendeLastLiter = 0;

   public PersonBil(String regNr, int vægt, int maksHastighed, int antalSæder, int bagagerumKapacitet){
        super(regNr,vægt,maksHastighed);
        this.antalSæder = antalSæder;
        this.bagagerumKapacitetLiter = bagagerumKapacitet;
    }

    @Override
    public void  accelerer(int kmTimeTilvækst) {
        if(kmTimeTilvækst > 0) {
            if(nuværendeHastighedKmt + (kmTimeTilvækst * 1.2) > maksHastighedKmt) {
                nuværendeHastighedKmt = maksHastighedKmt;
            }
            else {
                nuværendeHastighedKmt += (int) (kmTimeTilvækst * 1.2);
            }
        }
    }

    @Override
    public String getGenerelBeskrivelse() {
        return "Køretøj " + registreringsNummer + " Vægt: " + vægtKg + " Maks Fart: " + maksHastighedKmt + " Antal sæder: " +
                antalSæder + " bagagerumKapacitetLiter: " + bagagerumKapacitetLiter;
    }

    public boolean pakBagagerum(int liter) {
        boolean pakket = false;

        if(nuværendeLastLiter + liter <= bagagerumKapacitetLiter) {
            nuværendeLastLiter += liter;
            pakket = true;
        }
        return pakket;
    }

    public int getLedigBagagePladsLiter() {
       return bagagerumKapacitetLiter - nuværendeLastLiter;
    }

}
