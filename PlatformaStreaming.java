package servicii;
import clase.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PlatformaStreaming {
    private HashMap<String, Utilizator> utilizatori;
    private ArrayList<Piesa> toatePiesele;
    //private HashMap<String, Integer> globalStreams;

    public PlatformaStreaming(){
        this.utilizatori = new HashMap<>();
        this.toatePiesele = new ArrayList<>();
        //this.globalStreams = new HashMap<>();
    }

    //inregistram un utilizator nou
    public void inregistreazaUtilizator(Utilizator utilizator){
        if (utilizator == null) {
            throw new IllegalArgumentException("Utilizator null.");
        }
        if(utilizator.getId() == null || utilizator.getId().isBlank()){
            throw new IllegalArgumentException("ID utilizator invalid");
        }
        if(utilizatori.containsKey(utilizator.getId())){
            throw new IllegalStateException("Utilizator deja existent: id = " + utilizator.getId());
        }

        utilizatori.put(utilizator.getId(), utilizator);
        System.out.println("Utilizator inregistrat: " + utilizator.getNume() + " (" + utilizator.getTipUtilizator() + ")");
    }

    //cautam un utilizator dupa id
    public Utilizator cautaUtilizator(String id){
        return utilizatori.get(id);
    }
    // Cauta piesa dupa ID
    private Piesa cautaPiesaDupaId(String id) {
        for (Piesa piesa : toatePiesele) {
            if (piesa.getId().equals(id)) {
                return piesa;
            }
        }
        return null;
    }

    //adaugam o piesa in sistem
    public void adaugaPiesa(Piesa piesa){
        if (piesa == null) {
            throw new IllegalArgumentException("Piesa null.");
        }
        if (piesa.getId() == null || piesa.getId().isBlank()) {
            throw new IllegalArgumentException("ID piesa invalid.");
        }
        if (cautaPiesaDupaId(piesa.getId()) != null) {
            throw new IllegalStateException("Piesa deja existenta: id=" + piesa.getId());
        }

        toatePiesele.add(piesa);

        //adauga piesa si la artist
        if(piesa.getArtist() != null){
            piesa.getArtist().adaugaPiesa(piesa);
        }

        System.out.println("PiesaAdaugata: " + piesa.getTitlu());
    }

    //reda o piesa
    public void redaPiesa(String pieseId, String ascultatorId){
        Piesa piesa = cautaPiesaDupaId(pieseId);
        if (piesa == null) {
            throw new java.util.NoSuchElementException("Piesa inexistenta: id=" + pieseId);
        }

        Utilizator utilizator = cautaUtilizator(ascultatorId);
        if (utilizator == null) {
            throw new java.util.NoSuchElementException("Utilizator inexistent: id=" + ascultatorId);
        }

        if (!(utilizator instanceof Ascultator)) {
            throw new UnsupportedOperationException("Doar ascultatorii pot reda piese. Tip=" + utilizator.getTipUtilizator());
        }

        // Reda piesa
        piesa.redare();

        // Incrementeaza ascultarile globale
        piesa.incrementeazaAscultari();
        //globalStreams.put(pieseId, globalStreams.getOrDefault(pieseId, 0) + 1);

        // Inregistreaza in istoricul ascultatorului
        Ascultator ascultator = (Ascultator) utilizator;
        ascultator.inregistreazaAscultare(piesa);

        System.out.println("Redare inregistrata!\n");
    }

    // Obtine top piese global
    public ArrayList<Piesa> getTopPieseGlobal(int numar) {
        ArrayList<Piesa> pieseSortate = new ArrayList<>(toatePiesele);
        pieseSortate.sort(null); // foloseste compareTo din Piesa

        int limit = Math.min(numar, pieseSortate.size());
        return new ArrayList<>(pieseSortate.subList(0, limit));
    }

    // Obtine top artisti dupa total streamuri
    public ArrayList<Artist> getTopArtisti(int numar) {
        ArrayList<Artist> artisti = new ArrayList<>();

        for (Utilizator utilizator : utilizatori.values()) {
            if (utilizator instanceof Artist) {
                artisti.add((Artist) utilizator);
            }
        }

        // Sortare dupa total streamuri (descrescator)
        artisti.sort((a, b) -> Integer.compare(b.getTotalStreams(), a.getTotalStreams()));

        int limit = Math.min(numar, artisti.size());
        return new ArrayList<>(artisti.subList(0, limit));
    }

    // Cauta piese dupa gen
    public ArrayList<Piesa> cautaPieseDupaGen(String gen) {
        ArrayList<Piesa> rezultat = new ArrayList<>();
        for (Piesa piesa : toatePiesele) {
            if (piesa.getGen().equalsIgnoreCase(gen)) {
                rezultat.add(piesa);
            }
        }
        return rezultat;
    }

    // Cauta piese dupa artist
    public ArrayList<Piesa> cautaPieseDupaArtist(String artistId) {
        ArrayList<Piesa> rezultat = new ArrayList<>();
        for (Piesa piesa : toatePiesele) {
            if (piesa.getArtist() != null && piesa.getArtist().getId().equals(artistId)) {
                rezultat.add(piesa);
            }
        }
        return rezultat;
    }
    // Getteri
    public HashMap<String, Utilizator> getUtilizatori() {
        return utilizatori;
    }

    public ArrayList<Piesa> getToatePiesele() {
        return toatePiesele;
    }

}

