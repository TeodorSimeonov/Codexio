package task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BallCountingTask {
    public static void main(String[] args) {

        Map<String, Integer> box = new HashMap<>();
        //Filling the box with different balls
        fillBox(box);

        //Finding which balls are the most
        int removedCounter = getSmallestCountOfDifferentBalls(box);
        System.out.println(removedCounter);

    }

    private static void fillBox(Map<String, Integer> box) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value:");
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(":\\s+");
            String color = tokens[0];
            int countOfBalls = Integer.parseInt(tokens[1]);

            if (countOfBalls < 1) {
                continue;
            }
            addBall(color, countOfBalls, box);
            System.out.println("Enter value:");
            input = scanner.nextLine();
        }
    }

    private static int getSmallestCountOfDifferentBalls(Map<String, Integer> box) {
        int count = 0;
        int max = -1;

        for (Map.Entry<String, Integer> entry : box.entrySet()) {
            if (entry.getValue() > max) {
                if (max == -1) {
                    max = entry.getValue();
                    continue;
                }
                count += max;
                max = entry.getValue();
                continue;
            }
            count += box.get(entry.getKey());
        }

        return count;
    }

    private static void addBall(String color, int count, Map<String, Integer> box) {
        if (!box.containsKey(color)) {
            box.put(color, count);
            return;
        }
        box.put(color, box.get(color) + count);

    }
}
