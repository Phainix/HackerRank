/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank.Algorithms.Implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *
 * @author FAITH.A
 */
public class NonDivisibleSubset {
    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
        int[][] arrays = new int[S.length][S.length];
//        ArrayList<Integer> excluded = new ArrayList<Integer>();
        for(int i = 0; i < S.length; i++) {
            for(int j = (i+1); j < S.length; j++) {
                
                Map<Integer, Integer> excluded = new HashMap<Integer, Integer>();
                
                arrays[i][j] = S[i] + S[j];
                int tempSum = S[i] + S[j];
                int arrayCount = (tempSum % k) == 0 ? 0 : 2;
                if(arrayCount == 2) {
                    excluded.put(i, S[i]);
                    excluded.put(j, S[j]);
                    excluded = recursivelyTraverseAndCompare(excluded, k, S);
                    System.out.println(S[i] + "+" + S[j] + "=" + tempSum + " : " + excluded.values().toString() + " = " + excluded.size());
                } else {
                    System.out.println(S[i] + "+" + S[j] + "=" + tempSum + " : " + excluded.values().toString() + " = " + excluded.size());
                }
            }
        }
        return k;
    }
    
    static Map<Integer, Integer> recursivelyTraverseAndCompare(Map<Integer, Integer> excludedIndexes, int k, int[] S) {
        
        here:
        for(int i = 0; i < S.length; i++) {
            if(excludedIndexes.containsKey(S[i])) continue;
            
            for (int number : excludedIndexes.values()) {
                // int index = excludedIndexes.indexOf(number);
                int tempSum2 = S[i] + number;
                Boolean sumIsFactor = (tempSum2 % k) == 0;
                
                if(sumIsFactor == true) break here;
                
            }
            // System.out.println(S[i]);
            excludedIndexes.put(i, S[i]);
        } 
        // System.out.println(excludedIndexes.toString());
        return excludedIndexes;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 2 space-separated integers, n and k, the number of values in S and the non factor. ");
        String[] nk = scanner.nextLine().split(" ");
        
        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];
        
        System.out.println("Enter " + n + " space-separated integers describing S[i], the unique values of the set.");
        String[] SItems = scanner.nextLine().split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
