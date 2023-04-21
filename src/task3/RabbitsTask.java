package task3;

import java.util.Scanner;

public class RabbitsTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final char carrot = 'c';
        //Fill garden with carrots
        System.out.println("Enter garden length: ");
        int size = scanner.nextInt();
        char[][] garden = new char[size][size];
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                System.out.println("Enter input: ");
                System.out.println("Row: " + (i + 1) + " Col: " + (j + 1));
                char input = scanner.next().charAt(0);
                if (input == carrot) {
                    garden[i][j] = carrot;
                }
            }
        }

        int jumps = 0;
        // Count jumps
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //Jumping when there are carrots and steal all of them
                if (garden[i][j] == carrot) {
                    jumps++;
                    clearGroup(garden, size, i, j);
                }
            }
        }
        System.out.println(jumps + " jump needed for the rabbit to steal all carrots!");
    }

    private static void clearGroup(char[][] garden, int size, int i, int j) {
        if (j < 0 || j >= size || i < 0 || i >= size || garden[i][j] == ' ') {
            return;
        }
        garden[i][j] = ' ';

        // Stealing all near carrots
        clearGroup(garden, size, i, j - 1);
        clearGroup(garden, size, i, j + 1);
        clearGroup(garden, size, i - 1, j);
        clearGroup(garden, size, i + 1, j);
    }
}
