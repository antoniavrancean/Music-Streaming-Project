package clase;
import interfete.Clasabil;
import java.util.ArrayList;

public class Album implements Clasabil {
    private String id;
    private String titlu;
    private Artist artist;
    private ArrayList<Piesa> piese;

    public Album(String id, String titlu, Artist artist) {
        this.id = id;
        this.titlu = titlu;
        this.artist = artist;
        this.piese = new ArrayList<>();
    }

    //adaugam o piesa in album
    public void adaugaPiesa(Piesa piesa) {
        piese.add(piesa);
    }

    //implementare metode din Clasabil
    @Override
    public int getScor() {
        int totalAscultari = 0;
        for (Piesa piesa : piese) {
            totalAscultari += piesa.getAscultariGlobale();
        }
        return totalAscultari;
    }
    public int getNumarPiese(){
        return piese.size();
    }

    //getters si setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitlu() {
        return titlu;
    }
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }
    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    public ArrayList<Piesa> getPiese() {
        return piese;
    }
    public void setPiese(ArrayList<Piesa> piese) {
        this.piese = piese;
    }
}
