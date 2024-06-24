import java.util.Comparator;

class ScoreComparator implements Comparator<PriorityService> {
    //Based on the priority score, it ensures the person with the highest priority exits first.
    @Override
    public int compare(PriorityService p1, PriorityService p2) {

        return Integer.compare(p2.getPriorityScore(), p1.getPriorityScore());
    }
}
