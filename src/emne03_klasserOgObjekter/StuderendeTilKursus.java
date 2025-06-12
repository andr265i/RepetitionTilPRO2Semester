package emne03_klasserOgObjekter;

import java.util.Objects;

public class StuderendeTilKursus {

    private String navn;
    private int studieId;

    public StuderendeTilKursus(String navn, int studieId) {
        this.navn = navn;
        this.studieId = studieId;
    }

    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        StuderendeTilKursus that = (StuderendeTilKursus) obj;

        return that.studieId == this.studieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studieId);
    }

    public String getNavn() {
        return navn;
    }

    public int getStudieId() {
        return studieId;
    }

    @Override
    public String toString() {
        return "Navn: " + navn + " StudieNr: " + studieId;
    }
}


