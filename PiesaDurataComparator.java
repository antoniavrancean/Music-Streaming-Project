package comparator;
import clase.Piesa;
import java.util.Comparator;

public class PiesaDurataComparator implements Comparator<Piesa>{
    @Override
    public int compare(Piesa p1, Piesa p2){
        //sort cresc dupa durata
        return Integer.compare(p1.getDurata(), p2.getDurata());
    }
}
