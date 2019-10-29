/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Challenge Link: https://www.hackerrank.com/challenges/counting-valleys/problem
 */

package hackerrank.Algorithms.Implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        String valley = "DDU";
        int valleyCount = 0;
        int lastUpTraversalScore = 0;

        int traverseScore = 0;
        for (int i = 0; i < n; i++) {
            char direction = s.charAt(i);
            char altDirection = direction == 'U' ? 'D' : 'U';
            int score = direction == 'U' ? 1 : -1;
            int nextAlt = s.indexOf(altDirection, i);
            if(nextAlt == -1) nextAlt = n;

            traverseScore += (nextAlt - i) * score;
            System.out.println(direction + ": " + traverseScore);

            if(nextAlt - i > 1) {
                i += (nextAlt - i) - (nextAlt == n ? 0 : 1);
            }

            if(direction == 'D' && traverseScore < 0 && lastUpTraversalScore >= 0) valleyCount++;

            if(direction == 'U') lastUpTraversalScore = traverseScore;
        }

        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of steps in Gary's hike");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the characters that describe his path");
        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        System.out.println("Gary traversed " + result + " valley(s)");
    }

}
