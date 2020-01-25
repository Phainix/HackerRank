package hackerrank.Algorithms.ConstructiveAlgorithms;

import java.io.*;
import java.util.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribes = 0;
        int switches = 0;
        for (int i = 0; i < q.length; i++) {
            int inPos = q[i];
            int currPos = i+1;

            if(inPos == currPos) continue;

            int moves = Math.abs(inPos - currPos);
            if(moves > 2) {
                System.out.println("Too chaotic");
                return;
            } else {
                switches++;
            }
        }
        bribes = switches > 0 ? ((switches / 2) + switches % 2) : 0;
        System.out.println(bribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = Integer.parseInt(scanner.nextLine());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(scanner.nextLine());

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }

}
