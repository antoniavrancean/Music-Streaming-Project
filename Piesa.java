package clase;
import interfete.Ascultabil;
import interfete.Clasabil;

public class Piesa implements Comparable<Piesa>, Ascultabil, Clasabil{
    private String id;
    private String titlu;
    private Artist artist;
    private int durata;//in secunde
    private String gen;
    private int ascultariGlobale;

    public Piesa(String id, String titlu, Artist artist, int durata, String gen){
        this.id = id;
        this.titlu = titlu;
        this.artist = artist;
        this.durata = durata;
        this.gen = gen;
        this.ascultariGlobale = 0;
    }

    public Piesa(String id, String titlu) {
        this.id = id;
        this.titlu = titlu;
        this.durata = 0;
        this.artist = null;
    }

    //implementam met din Ascultabil
    @Override
    public void redare(){
        System.out.println("Se reda: " + titlu + " - " + artist.getNume());
        System.out.println("Durata: " + getDurataFormatata() + " | Gen: " + gen);
    }
    @Override
    public void incrementeazaAscultari(){
        this.ascultariGlobale++;
    }

    //implementam met din Clasabil
    @Override
    public int getScor() {
        return ascultariGlobale;
    }
    @Override
    public String getTitlu() {
        return titlu;
    }

    //implementam Comparable (sort descresc dupa ascultari)
    @Override
    public int compareTo(Piesa other) {
        return Integer.compare(other.ascultariGlobale, this.ascultariGlobale);
    }
    //met pt formatare durata
    public String getDurataFormatata() {
        int minute = durata / 60;
        int secunde = durata % 60;
        return String.format("%d:%02d", minute, secunde);
    }

    //setters si getters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public int getDurata() {
        return durata;
    }
    public void setDurata(int durata) {
        this.durata = durata;
    }
    public String getGen() {
        return gen;
    }
    public void setGen(String gen) {
        this.gen = gen;
    }
    public int getAscultariGlobale() {
        return ascultariGlobale;
    }
    public void setAscultariGlobale(int ascultariGlobale) {
        this.ascultariGlobale = ascultariGlobale;
    }

    @Override
    public String toString(){
        return titlu + " - " + artist.getNume() + " (" + getDurataFormatata() + ") - " + ascultariGlobale + " ascultari";
    }
}

