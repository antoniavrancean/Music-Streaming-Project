package clase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ascultator extends Utilizator{
    private HashMap<String, Integer> istoricAscultari;

    public Ascultator(String id, String nume, String email){
        super(id, nume, email);
        this.istoricAscultari = new HashMap<>();
    }

    //inregistram ascultarea unei piese
    public void inregistreazaAscultare(Piesa piesa){
        String pieseId = piesa.getId();
        istoricAscultari.put(pieseId, istoricAscultari.getOrDefault(pieseId, 0) + 1);
    }
    //obtine top piese ascultate de ascultator
    public ArrayList<Piesa> getTopPieseAscultator(int numar, ArrayList<Piesa> toatePiesele){
        ArrayList<PiesaCuScor> pieseScor = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : istoricAscultari.entrySet()){
            String pieseId = entry.getKey();
            int ascultari = entry.getValue();

            for(Piesa piesa : toatePiesele){
                if(piesa.getId().equals(pieseId)){
                    pieseScor.add(new PiesaCuScor(piesa, ascultari));
                    break;
                }
            }
        }

        pieseScor.sort((a, b) -> Integer.compare(b.ascultari, a.ascultari));

        int limit = Math.min(numar, pieseScor.size());
        ArrayList<Piesa> rezultat = new ArrayList<>();
        for(int i = 0; i < limit; i++){
            rezultat.add(pieseScor.get(i).piesa);
        }

        return rezultat;
    }
    //clasa interna pt sortare
    private static class PiesaCuScor{
        Piesa piesa;
        int ascultari;
        PiesaCuScor(Piesa piesa, int ascultari){
            this.piesa = piesa;
            this.ascultari = ascultari;
        }
    }

    //implementare met abstracte
    @Override
    public String getTipUtilizator(){
        return "Ascultator";
    }
    @Override
    public void afiseazaProfil(){
        System.out.println("******PROFIL ASCULTATOR******");
        System.out.println("ID: " + getId());
        System.out.println("Nume: " + getNume());
        System.out.println("Email: " + getEmail());
        System.out.println("Piese unice ascultate: " + istoricAscultari.size());

    }

    //getter si setter

    public HashMap<String, Integer> getIstoricAscultari() {
        return istoricAscultari;
    }
    public void setIstoricAscultari(HashMap<String, Integer> istoricAscultari) {
        this.istoricAscultari = istoricAscultari;
    }
}

