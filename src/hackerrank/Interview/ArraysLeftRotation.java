/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Challenge Link: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 */

package hackerrank.Interview;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class ArraysLeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int index = (i-d) >= 0 ? i-d : i-d + a.length;
            result[index] = a[i];
        }

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println(" ");
            }
        }

        scanner.close();
    }
}
