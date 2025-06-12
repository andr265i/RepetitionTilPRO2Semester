package emne03_klasserOgObjekter;

import java.util.ArrayList;
import java.util.List;

public class Kursus {

    private String kursusNavn;
    private int maxAntalStuderende;
    private final List<StuderendeTilKursus> tilmeldteStuderende = new ArrayList<>();

    public Kursus(String kursusNavn, int maxAntalStuderende) {
        this.kursusNavn = kursusNavn;
        this.maxAntalStuderende = maxAntalStuderende;
    }

    public boolean tilmeldStuderende(StuderendeTilKursus stud) {
        boolean blevetTilmeldt = false;
        if(tilmeldteStuderende.size() < maxAntalStuderende) {
            if (!tilmeldteStuderende.contains(stud) && stud != null) {
                tilmeldteStuderende.add(stud);
                blevetTilmeldt = true;
            }
        }
        return blevetTilmeldt;
    }

    public boolean frameldStuderende(int studieId) {
        boolean frameldt = false;

        for(StuderendeTilKursus studerende : tilmeldteStuderende) {
            if(studerende.getStudieId() == studieId){
                tilmeldteStuderende.remove(studerende);
                frameldt = true;
            }
        }
        return frameldt;
    }

    public StuderendeTilKursus findStuderende(int studieId) {
        boolean found = false;
        int i = 0;
        StuderendeTilKursus fundetStuderende = null;

        while(! found && i < tilmeldteStuderende.size()) {
            StuderendeTilKursus s = tilmeldteStuderende.get(i);
            if(s.getStudieId() == studieId) {
                fundetStuderende = s;
                found = true;
            }
            else {
                i++;
            }
        }

        return fundetStuderende;
    }

    public void printDeltagerliste() {
        StringBuilder s = new StringBuilder();
        s.append("Studerende \n");

        for(StuderendeTilKursus studerendeTilKursus : tilmeldteStuderende){
            s.append(studerendeTilKursus.getNavn()).append(" Studie id: ").append(studerendeTilKursus.getStudieId()).append("\n");
        }
    }

    StuderendeTilKursus getStuderendeMedLængsteNavn() {
        StuderendeTilKursus studerendeMedLængesteNavn = null;
        int længsteNavn = 0;

        for(StuderendeTilKursus s : tilmeldteStuderende){
            if(s.getNavn().length() > længsteNavn) {
                studerendeMedLængesteNavn = s;
                længsteNavn = s.getNavn().length();
            }
        }
        return studerendeMedLængesteNavn;
    }

    ArrayList<String> getKursusCertifikater() {
        ArrayList<String> certifikater = new ArrayList<>();

        for(StuderendeTilKursus studerendeTilKursus : tilmeldteStuderende) {
            certifikater.add(studerendeTilKursus.getNavn() + " " + kursusNavn);
        }
        return certifikater;
    }

    public String getKursusNavn() {
        return kursusNavn;
    }

    public int getMaxAntalStuderende() {
        return maxAntalStuderende;
    }

    public List<StuderendeTilKursus> getTilmeldteStuderende() {
        return new ArrayList<>(tilmeldteStuderende);
    }
}
