package emne04_klassehierarkier;

public class LastBil  extends  Køretøj{

    private int lasteevneKg;
    private int nuværendeLastKg = 0;
    private boolean harAnhænger;

    public LastBil(String regNr, int vægt, int maksHastighed, int lasteevne) {
        super(regNr,vægt,maksHastighed);
        this.lasteevneKg = lasteevne;
    }

    @Override
    public void accelerer(int kmTimeTilvækst) {
        if(kmTimeTilvækst > 0) {
            if(nuværendeHastighedKmt + (kmTimeTilvækst * 0.8) <= maksHastighedKmt && !harAnhænger) {
                nuværendeHastighedKmt += (int) (kmTimeTilvækst * 0.8);
            }
            else if(nuværendeHastighedKmt + (kmTimeTilvækst * 0.5) <= maksHastighedKmt && harAnhænger) {
                nuværendeHastighedKmt += (int) (kmTimeTilvækst * 0.5);
            }
            else {
                nuværendeHastighedKmt = maksHastighedKmt;
            }
        }
    }
    @Override
    public String getGenerelBeskrivelse() {
        return "Køretøj " + registreringsNummer + " Vægt: " + vægtKg + " Maks Fart: " + maksHastighedKmt + " Lastevne: " + lasteevneKg + " Anhænger: " + harAnhænger;
    }

    public boolean lastFrag(int kg) {
        boolean lastet = false;
        if(kg > 0) {
            if(nuværendeLastKg + kg <= lasteevneKg) {
                nuværendeLastKg += kg;
                lastet = true;
            }
        }
        return lastet;
    }

    public void tilkoblAnhænger() {
        harAnhænger = true;
    }
    public void frakoblAnhænger() {
        harAnhænger = false;
    }
    }

