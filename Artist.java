package clase;
import java.util.ArrayList;

public class Artist extends Utilizator{
    private ArrayList<Piesa> piese;
    private ArrayList<Album> albume;
    private String gen;
    private int totalStreams;

    public Artist(String id, String nume, String email, String gen){
        super(id, nume, email);
        this.piese = new ArrayList<>();
        this.albume = new ArrayList<>();
        this.gen = gen;
        this.totalStreams = 0;
    }

    //adauga piesa
    public void adaugaPiesa(Piesa piesa){
        piese.add(piesa);
    }
    //adauga album
    public void adaugaAlbum(Album album){
        albume.add(album);
    }
    //actualizeaza totalul de streams
    public void updateTotalStreams(){
        totalStreams = 0;
        for(Piesa piesa : piese){
            totalStreams += piesa.getAscultariGlobale();
        }
    }

    //implementam met abstracte
    @Override
    public String getTipUtilizator(){
        return "Artist";
    }
    @Override
    public void afiseazaProfil(){
        System.out.println("******PROFIL ARTIST******");
        System.out.println("ID: " + getId());
        System.out.println("Nume: " + getNume());
        System.out.println("Email: " + getEmail());
        System.out.println("Gen muzical: " + gen);
        updateTotalStreams();
        System.out.println("Total streams: " + totalStreams);
        System.out.println("Numar de piese lansate: " + piese.size());
        System.out.println("Numar de albume lansate: " + albume.size());
    }

    //getters si setters
    public ArrayList<Piesa> getPiese() {
        return piese;
    }
    public void setPiese(ArrayList<Piesa> piese) {
        this.piese = piese;
    }
    public ArrayList<Album> getAlbume() {
        return albume;
    }
    public void setAlbume(ArrayList<Album> albume) {
        this.albume = albume;
    }
    public String getGen() {
        return gen;
    }
    public void setGen(String gen) {
        this.gen = gen;
    }
    public int getTotalStreams() {
        updateTotalStreams();
        return totalStreams;
    }
    public void setTotalStreams(int totalStreams) {
        this.totalStreams = totalStreams;
    }
}
