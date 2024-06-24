//Omnia Osama Ahmed - 1084505
import java.util.Comparator;

class ScoreComparator_51_G2 implements Comparator<PriorityService_51_G2> {
    //Based on the priority score, it ensures the person with the highest priority exits first.
    @Override
    public int compare(PriorityService_51_G2 p1, PriorityService_51_G2 p2) {

        return Integer.compare(p2.getPriorityScore(), p1.getPriorityScore());
    }
}
