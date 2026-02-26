package servicii;
import clase.*;
import java.util.ArrayList;

public class StatisticiManager {
    //afisam topul global al pieselor
    public static void afiseazaTopGlobal(ArrayList<Piesa> piese, int numar){
        System.out.println("\n*****TOP-ul PIESELOR GLOBALE******");

        int pozitie = 1;
        for(Piesa piesa : piese){
            System.out.printf("%2d. %-30s | %-20s | %s | %,6d ascultari%n", pozitie++, piesa.getTitlu(), piesa.getArtist().getNume(), piesa.getDurataFormatata(), piesa.getAscultariGlobale());
        }
    }

    //afisam statistici pentru un artist
    public static void afiseazaStatisticiArtist(Artist artist){
        System.out.println("\n***** STATISTICI ARTIST: " + artist.getNume() + "******");
        System.out.println("Gen muzical: " + artist.getGen());
        System.out.println("Total streams: " + artist.getTotalStreams());
        System.out.println("Numar de piese lansate: " + artist.getPiese().size());
        System.out.println("Numar de albume lansate:" + artist.getAlbume().size());

        if(!artist.getPiese().isEmpty()){
            System.out.println("\nPiesele Artistului: \n");
            for(Piesa piesa : artist.getPiese()){
                System.out.printf("%-30s | %s | %,6d ascultari%n", piesa.getTitlu(), piesa.getDurataFormatata(), piesa.getAscultariGlobale());
            }
        }

        if(!artist.getAlbume().isEmpty()){
            System.out.println("\nAlbumele Artistului: \n");
            for( Album album : artist.getAlbume()){
                System.out.printf("  - %-30s | %2d piese | %,6d ascultari totale%n", album.getTitlu(), album.getNumarPiese(), album.getScor());
            }
        }
    }

    //afisam statistici ascultator
    public static void afiseazaStatisticiAscultator(Ascultator ascultator, ArrayList<Piesa> toatePiesele){
        System.out.println("\n***** STATISTICI ASCULTATOR: " + ascultator.getNume() + "******");
        System.out.println("Email: " + ascultator.getEmail());
        System.out.println("Piese unice ascultate: " + ascultator.getIstoricAscultari().size());

        //calc total ascultari
        int totalAscultari = 0;
        for(int count: ascultator.getIstoricAscultari().values()){
            totalAscultari += count;
        }
        System.out.println("Total ascultari: " + totalAscultari);

        //afisam top piese personale
        ArrayList<Piesa> topPersonal = ascultator.getTopPieseAscultator(5, toatePiesele);
        if(!topPersonal.isEmpty()){
            System.out.println("\nTop 5 piese preferate:");
            int pozitie = 1;
            for(Piesa piesa : topPersonal){
                int ascultariPersonale = ascultator.getIstoricAscultari().get(piesa.getId());
                System.out.printf("%2d. %-30s | %-20s | %3d ascultari%n", pozitie++, piesa.getTitlu(), piesa.getArtist().getNume(), ascultariPersonale);
            }
        }
    }

    // Genereaza raport general pentru platforma
    public static void genereazaRaportPlatforma(PlatformaStreaming platforma) {
        System.out.println("\n****** RAPORT GENERAL PLATFORMA DE STREAMING ******");

        // Statistici generale
        int numarUtilizatori = platforma.getUtilizatori().size();
        int numarPiese = platforma.getToatePiesele().size();

        int numarArtisti = 0;
        int numarAscultatori = 0;
        for (Utilizator u : platforma.getUtilizatori().values()) {
            if (u instanceof Artist) {
                numarArtisti++;
            } else if (u instanceof Ascultator) {
                numarAscultatori++;
            }
        }

        // Calculeaza total streamuri
        int totalStreamuri = 0;
        for (Piesa piesa : platforma.getToatePiesele()) {
            totalStreamuri += piesa.getAscultariGlobale();
        }

        System.out.println("Total utilizatori: " + numarUtilizatori);
        System.out.println("  - Artisti: " + numarArtisti);
        System.out.println("  - Ascultatori: " + numarAscultatori);
        System.out.println("Total piese: " + numarPiese);
        System.out.println("Total streamuri: " + String.format("%,d", totalStreamuri));

        // Top 3 artisti
        System.out.println("\nTop 3 artisti:");
        ArrayList<Artist> topArtisti = platforma.getTopArtisti(3);
        int pozitie = 1;
        for (Artist artist : topArtisti) {
            System.out.printf("%d. %-20s | %,8d streamuri%n",
                    pozitie++,
                    artist.getNume(),
                    artist.getTotalStreams());
        }

        // Top 3 piese
        System.out.println("\nTop 3 piese:");
        ArrayList<Piesa> topPiese = platforma.getTopPieseGlobal(3);
        pozitie = 1;
        for (Piesa piesa : topPiese) {
            System.out.printf("%d. %-30s | %,6d ascultari%n",
                    pozitie++,
                    piesa.getTitlu(),
                    piesa.getAscultariGlobale());
        }

        System.out.println("=".repeat(70) + "\n");
    }

    // Afiseaza toate piesele dintr-un album
    public static void afiseazaDetaliiAlbum(Album album) {
        System.out.println("\n****** ALBUM: " + album.getTitlu() + "******");
        System.out.println("Artist: " + album.getArtist().getNume());
        System.out.println("Numar piese: " + album.getNumarPiese());
        System.out.println("Total ascultari album: " + String.format("%,d", album.getScor()));

        if (album.getNumarPiese() > 0) {
            System.out.println("\nTracklist:");
            int track = 1;
            for (Piesa piesa : album.getPiese()) {
                System.out.printf("%2d. %-30s | %s | %,6d ascultari%n",
                        track++,
                        piesa.getTitlu(),
                        piesa.getDurataFormatata(),
                        piesa.getAscultariGlobale());
            }
        }
    }
}


