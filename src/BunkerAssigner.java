// Ivan Espinoza
// Project 2

import java.util.ArrayList;
import java.util.List;

public class BunkerAssigner {
    private final List<CostPerPerson> bunkerCosts;
    private final int numPeople;

    public BunkerAssigner(int numPeople, List<CostPerPerson> bunkerCosts) {
        this.numPeople = numPeople;
        this.bunkerCosts = bunkerCosts;
    }

    public int assignMinimum() {
        int sum = 0;

        for (int person = 0; person < numPeople; person++)
            sum += bunkerCosts.get(person).getMinimum();

        return sum;
    }

    public int assignEvenly() {
        List<Integer> bunker1 = new ArrayList<>();
        List<Integer> bunker2 = new ArrayList<>();
        int sum = 0;

        for (int person = 0; person < numPeople; person++) {
            if (bunkerCosts.get(person).bunker1LessOrEqual())
                bunker1.add(person);
            else
                bunker2.add(person);
        }

        while (bunker1.size() > bunker2.size()) {
            bunker2.add(bunker1.get(0));
            bunker1.remove(0);
        }

        while (bunker1.size() < bunker2.size()) {
            bunker1.add(bunker2.get(0));
            bunker2.remove(0);
        }

        for (int i = 0; i < bunker1.size(); i++) {
            sum += bunkerCosts.get(bunker1.get(i)).getBunker1Cost() +
                    bunkerCosts.get(bunker2.get(i)).getBunker2Cost();
        }

        return sum;
    }
}
