import clase.*;
import servicii.*;
import comparator.PiesaDurataComparator;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        try {
            rulareAplicatie();
        } catch (RuntimeException e) {
            System.out.println("Eroare la rularea aplicatiei: " + e.getMessage());
        } finally {
            System.out.println("Aplicatia s-a inchis!");
        }
    }
    private static void rulareAplicatie(){
        //creem platforma
        PlatformaStreaming platforma = new PlatformaStreaming();

        System.out.println("***************Platforma de Streaming Muzical***************");

        //inregistram artistii
        System.out.println("---Inregistram artistii---");
        Artist artist1 = new Artist("a1", "The Weeknd", "the.weeknd@gmail.com", "Pop");
        Artist artist2 = new Artist("a2", "Dua Lipa", "dua.lipa@gmail.com", "Pop");
        Artist artist3 = new Artist("a3", "Ed Sheeran", "ed.sheeran@gmail.com", "Pop");
        Artist artist4 = new Artist("a4", "Billie Eilish", "billie.eilish@gmail.com", "Alternative");
        Artist artist5 = new Artist("a5", "Imagine Dragons", "imagine.dragons@gmail.com", "Rock");
        platforma.inregistreazaUtilizator(artist1);
        platforma.inregistreazaUtilizator(artist2);
        platforma.inregistreazaUtilizator(artist3);
        platforma.inregistreazaUtilizator(artist4);
        platforma.inregistreazaUtilizator(artist5);
        System.out.println();

        //inregistram ascultatorii
        System.out.println("---Inregistram ascultatorii---");
        Ascultator ascultator1 = new Ascultator("u1", "Vrancean Antonia", "antonia.vrancean@gmail.com" );
        Ascultator ascultator2 = new Ascultator("u2", "Rusen Alexandra", "alexandra.rusen@gmail.com");
        Ascultator ascultator3 = new Ascultator("u3", "Barna Razvan", "razvan.barna@gmail.com");
        Ascultator ascultator4 = new Ascultator("u4", "Popescu Mihai", "mihai.popescu@gmail.com");
        Ascultator ascultator5 = new Ascultator("u5", "Ionescu Ioana", "ioana.ionescu@gmail.com");
        platforma.inregistreazaUtilizator(ascultator1);
        platforma.inregistreazaUtilizator(ascultator2);
        platforma.inregistreazaUtilizator(ascultator3);
        platforma.inregistreazaUtilizator(ascultator4);
        platforma.inregistreazaUtilizator(ascultator5);
        System.out.println();

        //adaugam piese
        System.out.println("---Adaugam Piese---");
        Piesa p1 = new Piesa("p1", "Blinding Lights", artist1, 200, "Pop");
        Piesa p2 = new Piesa("p2", "Save Your Tears", artist1, 215, "Pop");
        Piesa p3 = new Piesa("p3", "Starboy", artist1, 230, "Pop");


        Piesa p4 = new Piesa("p4", "Levitating", artist2, 203, "Pop");
        Piesa p5 = new Piesa("p5", "Don't Start Now", artist2, 183, "Pop");

        Piesa p6 = new Piesa("p6", "Shape of You", artist3, 233, "Pop");
        Piesa p7 = new Piesa("p7", "Perfect", artist3, 263, "Pop");

        Piesa p8 = new Piesa("p8", "Bad Guy", artist4, 194, "Alternative");
        Piesa p9 = new Piesa("p9", "Happier Than Ever", artist4, 298, "Alternative");

        Piesa p10 = new Piesa("p10", "Believer", artist5, 204, "Rock");
        Piesa p11 = new Piesa("p11", "Thunder", artist5, 187, "Rock");
        Piesa p12 = new Piesa("p12", "Demons", artist5, 177, "Rock");

        platforma.adaugaPiesa(p1);
        platforma.adaugaPiesa(p2);
        platforma.adaugaPiesa(p3);
        platforma.adaugaPiesa(p4);
        platforma.adaugaPiesa(p5);
        platforma.adaugaPiesa(p6);
        platforma.adaugaPiesa(p7);
        platforma.adaugaPiesa(p8);
        platforma.adaugaPiesa(p9);
        platforma.adaugaPiesa(p10);
        platforma.adaugaPiesa(p11);
        platforma.adaugaPiesa(p12);
        //platforma.adaugaPiesa(p13);
        System.out.println();

        //adaugam albume
        System.out.println("---Creare Albume---");
        Album album1 = new Album("alb1", "After Hours", artist1);
        album1.adaugaPiesa(p1);
        album1.adaugaPiesa(p2);
        album1.adaugaPiesa(p3);
        artist1.adaugaAlbum(album1);

        Album album2 = new Album("alb2", "Future Nostalgia", artist2);
        album2.adaugaPiesa(p4);
        album2.adaugaPiesa(p5);
        artist2.adaugaAlbum(album2);
        System.out.println();

        Album album3 = new Album("alb3", "Divide", artist3);
        album3.adaugaPiesa(p6);
        album3.adaugaPiesa(p7);
        artist3.adaugaAlbum(album3);

        Album album4 = new Album("alb4", "Happier Than Ever", artist4);
        album4.adaugaPiesa(p8);
        album4.adaugaPiesa(p9);
        artist4.adaugaAlbum(album4);

        Album album5 = new Album("alb5", "Evolve", artist5);
        album5.adaugaPiesa(p10);
        album5.adaugaPiesa(p11);
        album5.adaugaPiesa(p12);
        artist5.adaugaAlbum(album5);

        //simulam ascultatorii asc piese
        System.out.println("---Simulare redari---");
        //Antonia asculta
        platforma.redaPiesa("p1", "u1"); // Blinding Lights
        platforma.redaPiesa("p1", "u1"); // Blinding Lights (din nou)
        platforma.redaPiesa("p1", "u1"); // Blinding Lights (a 3-a oara)
        platforma.redaPiesa("p4", "u1"); // Levitating
        platforma.redaPiesa("p6", "u1"); // Shape of You
        platforma.redaPiesa("p8", "u1"); // Bad guy
        platforma.redaPiesa("p10", "u1");// Believer
        platforma.redaPiesa("p10", "u1");// Believer
        //Alexandra asculta
        platforma.redaPiesa("p1", "u2"); // Blinding Lights
        platforma.redaPiesa("p2", "u2"); // Save Your Tears
        platforma.redaPiesa("p4", "u2"); // Levitating
        platforma.redaPiesa("p4", "u2"); // Levitating (din nou)
        platforma.redaPiesa("p2", "u2");
        platforma.redaPiesa("p5", "u2");
        platforma.redaPiesa("p9", "u2");
        platforma.redaPiesa("p11", "u2");
        //Razvan asculta
        platforma.redaPiesa("p1", "u3"); // Blinding Lights
        platforma.redaPiesa("p6", "u3"); // Shape of You
        platforma.redaPiesa("p6", "u3"); // Shape of You (din nou)
        platforma.redaPiesa("p7", "u3"); // Perfect
        platforma.redaPiesa("p3", "u3");
        platforma.redaPiesa("p6", "u3");
        platforma.redaPiesa("p12", "u3");
        // Mihai ascultă
        platforma.redaPiesa("p7", "u4");
        platforma.redaPiesa("p8", "u4");
        platforma.redaPiesa("p10", "u4");
        // Ioana ascultă
        platforma.redaPiesa("p1", "u5");
        platforma.redaPiesa("p5", "u5");
        platforma.redaPiesa("p9", "u5");
        platforma.redaPiesa("p11", "u5");
        platforma.redaPiesa("p12", "u5");
        System.out.println();

        //afisam profilurile
        System.out.println("---Afisare profiluri---");
        artist1.afiseazaProfil();
        artist2.afiseazaProfil();
        artist3.afiseazaProfil();
        artist4.afiseazaProfil();
        artist5.afiseazaProfil();
        ascultator1.afiseazaProfil();
        ascultator2.afiseazaProfil();
        ascultator3.afiseazaProfil();
        ascultator4.afiseazaProfil();
        ascultator5.afiseazaProfil();

        ///TOP-uri SI STATISTICI
        //top piese global
        ArrayList<Piesa> topGlobal = platforma.getTopPieseGlobal(5);
        StatisticiManager.afiseazaTopGlobal(topGlobal, 5);

        //statistici artisti
        StatisticiManager.afiseazaStatisticiArtist(artist1);
        StatisticiManager.afiseazaStatisticiArtist(artist2);
        StatisticiManager.afiseazaStatisticiArtist(artist3);

        //statistici ascultatori
        StatisticiManager.afiseazaStatisticiAscultator(ascultator1, platforma.getToatePiesele());
        StatisticiManager.afiseazaStatisticiAscultator(ascultator2, platforma.getToatePiesele());
        StatisticiManager.afiseazaStatisticiAscultator(ascultator3, platforma.getToatePiesele());

        //detalii albume
        StatisticiManager.afiseazaDetaliiAlbum(album1);
        StatisticiManager.afiseazaDetaliiAlbum(album2);

        //raport general de platforma
        StatisticiManager.genereazaRaportPlatforma(platforma);

        ///DEMONSTRATIE COMPARATOR
        System.out.println("---SORTARE DUPA DURATA (COMPARATOR)---");
        ArrayList<Piesa> pieseDupaDurata = new ArrayList<>(platforma.getToatePiesele());
        pieseDupaDurata.sort(new PiesaDurataComparator());

        System.out.println("Piese sortate dupa durata (crescator):");
        for (Piesa piesa : pieseDupaDurata) {
            System.out.println("  - " + piesa.getTitlu() + " (" + piesa.getDurataFormatata() + ")");
        }
        System.out.println();

        ///CAUTARE PIESE
        System.out.println("---Cautare Piese---");
        //cautare dupa gen
        ArrayList<Piesa> piesePop = platforma.cautaPieseDupaGen("Pop");
        System.out.println("Piese gen Pop: " + piesePop.size() + " piese");
        //cautare dupa artist
        ArrayList<Piesa> pieseTheWeeknd = platforma.cautaPieseDupaArtist("a1");
        System.out.println("Piese de la The Weeknd: " + pieseTheWeeknd.size() + " piese");
        for (Piesa piesa : pieseTheWeeknd) {
            System.out.println("  - " + piesa.getTitlu());
        }
        System.out.println();

        ///TOP ARTISTI
        System.out.println("---Top Artisti---");
        ArrayList<Artist> topArtisti = platforma.getTopArtisti(3);
        int pozitie = 1;
        for (Artist artist : topArtisti) {
            System.out.println(pozitie + ". " + artist.getNume() + " - " +
                    artist.getTotalStreams() + " streamuri totale");
            pozitie++;
        }
        System.out.println();
    }

}

