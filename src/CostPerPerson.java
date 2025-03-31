public class CostPerPerson implements Comparable<CostPerPerson> {
    private final int bunker1Cost;
    private final int bunker2Cost;

    public CostPerPerson(int bunker1Cost, int bunker2Cost) {
        this.bunker1Cost = bunker1Cost;
        this.bunker2Cost = bunker2Cost;
    }

    public int getBunker1Cost() { return bunker1Cost; }

    public int getBunker2Cost() { return bunker2Cost; }

    public boolean bunker1LessOrEqual() { return bunker1Cost <= bunker2Cost; }

    public int getMinimum() { return Math.min(bunker1Cost, bunker2Cost); }

    public int costDifference() { return Math.abs(bunker1Cost - bunker2Cost); }

    @Override
    public int compareTo(CostPerPerson person) {
        if (costDifference() <= person.costDifference()) { return 1; }

        else { return 0; }
    }

    @Override
    public String toString() { return bunker1Cost + " " + bunker2Cost; }
}
