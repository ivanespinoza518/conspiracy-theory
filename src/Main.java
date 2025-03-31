// Ivan Espinoza
// Project 2
// COMP482
// Professor Noga

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();

        int numPeople = fileReader.getNumPeople();
        List<CostPerPerson> bunkerCosts = fileReader.getBunkerCosts();

        BunkerAssigner assigner = new BunkerAssigner(numPeople, bunkerCosts);
        System.out.println(assigner.assignMinimum());
        System.out.println(assigner.assignEvenly());
    }
}
