package emne03_klasserOgObjekter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BiblioteksBog {

    private String titel;
    private String forfatter;
    private int udgivelsesår;
    private String isbn;
    private boolean erUdLånt;
    private String lånerNavn;
    private LocalDate udlånsdato;



    public BiblioteksBog(String titel, String forfatter, int udgivelsesår, String isbn) {
        this.titel = titel;
        this.forfatter = forfatter;
        this.udgivelsesår = udgivelsesår;
        this.isbn = isbn;
        erUdLånt = false;
        lånerNavn = null;
        udlånsdato = null;
    }

    public boolean udlånBog(String lånerNavn, LocalDate udlånsdato) {
        boolean udlånt = false;

        if(!erUdLånt) {
            this.lånerNavn = lånerNavn;
            this.udlånsdato = udlånsdato;
            erUdLånt = true;
            udlånt = true;

        }
        return udlånt;
    }

    public double afleverBog(LocalDate afleveringsDato) {
        double bøde = 0;

        if(!erUdLånt) {
            bøde = -1;
        }
        else if( ChronoUnit.DAYS.between(udlånsdato,afleveringsDato) > 30) {
            bøde = 10 *  (ChronoUnit.DAYS.between(udlånsdato,afleveringsDato) - 30);
        }
        erUdLånt = false;
        udlånsdato = null;
        lånerNavn = null;

        return bøde;
    }

    public String getBogStatus(){
        if(erUdLånt) {
       return titel + " af " + forfatter + " - Udlånt til " + lånerNavn + " den " + udlånsdato;
        }
        else {
            return titel + " af " + forfatter + " - Tilgængelig.";
        }
    }

    public LocalDate getForfaldsdato(int standardLånePeriodeDage) {
        LocalDate forfaldsdato = null;

        if(erUdLånt) {
            forfaldsdato = udlånsdato.plusDays(standardLånePeriodeDage);
        }
        return forfaldsdato;
    }

    @Override
    public String toString() {
        return "Titel: " + titel + " Forfatter: " + forfatter + " Isbn: " +isbn + " Udlånt: " + erUdLånt
                + " Låner navn: " + lånerNavn + " Udlånsdato: " + udlånsdato;
    }

    public String getTitel() {
        return titel;
    }

    public String getForfatter() {
        return forfatter;
    }

    public int getUdgivelsesår() {
        return udgivelsesår;
    }

    public String getIsbn() {
        return isbn;
    }

    public Boolean erUdlånt() {
        return erUdLånt;
    }

    public String getLånerNavn() {
        return lånerNavn;
    }

    public LocalDate getUdlånsdato() {
        return udlånsdato;
    }
}
