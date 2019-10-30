/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Challenge Link: https://www.hackerrank.com/challenges/2d-array/problem
 */

package hackerrank.Algorithms.DataStructures;

import java.io.*;
import java.util.*;

public class TwoDimenArrayDS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int[] hourglasses = new int[16];
        int hourglassIndex = 0;
        int max = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(j+2 < 6 && i+2 < 6) {
                    hourglasses[hourglassIndex] = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                    max = (i == 0 && j == 0) ? hourglasses[hourglassIndex] : Math.max(hourglasses[hourglassIndex], max);
                    hourglassIndex++;
                }
            }
        }
        System.out.println(Arrays.toString(hourglasses));
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[6][6];
        System.out.println("Enter the lines in the matrix");
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println("Largest Hour Glass " + result);
    }
}
