// Ivan Espinoza
// Project 2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReader {
    private Scanner scanner;

    public FileReader() {
        try {
            File fileIn = new File("input.txt");
            scanner = new Scanner(fileIn);
        }
        catch (FileNotFoundException e) {
            System.out.println("Error. File not found.\n");
            e.printStackTrace();
        }
    }

    public int getNumPeople() {
        return Integer.parseInt(scanner.nextLine());
    }

    public List<CostPerPerson> getBunkerCosts() {
        List<CostPerPerson> bunkerCosts = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();

            StringTokenizer input = new StringTokenizer(data);
            int bunker1Cost = Integer.parseInt(input.nextToken());
            int bunker2Cost = Integer.parseInt(input.nextToken());

            bunkerCosts.add(new CostPerPerson(bunker1Cost, bunker2Cost));
        }

        System.out.println(bunkerCosts);

        Sorter.mergeSort(bunkerCosts);

        scanner.close();

        return bunkerCosts;
    }
}
