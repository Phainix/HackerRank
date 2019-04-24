/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Challenge Link: https://www.hackerrank.com/challenges/non-divisible-subset/problem
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
    static int nonDivisibleSubset2(int k, int[] S) {
        int max = 0;
        for(int i = 0; i < S.length; i++) {
            for(int j = (i+1); j < S.length; j++) {
                
                Map<Integer, Integer> excluded = new HashMap<Integer, Integer>();
                
                int tempSum = S[i] + S[j];
                int arrayCount = (tempSum % k) == 0 ? 0 : 2;
                if(arrayCount == 2) {
                    if(max < 2) max = 2;
                    //System.out.println(S[i] + "+" + S[j] + "= Inivisible");
                    excluded.put(i, S[i]);
                    excluded.put(j, S[j]);
                    Map<Integer, Integer> excludedIndexesMod = excluded;
                    
                    int start = j+1;
                    
                    here:
                    for(int l = start; l < S.length; l++) {
                        //System.out.println("        " + excludedIndexesMod.values().toString());

                        for (int number : excludedIndexesMod.values()) {
                            int tempSum2 = S[l] + number;
                            Boolean sumIsFactor = (tempSum2 % k) == 0;

                            if(sumIsFactor == true) continue here;

                        }
                        excludedIndexesMod.put(l, S[l]);
                        if(max < excludedIndexesMod.size()) max = excludedIndexesMod.size();
                    }
                } else {
                    //System.out.println(S[i] + "+" + S[j] + "= Divisible");
                    continue;
                    // System.out.println(S[i] + "+" + S[j] + "=" + tempSum + " : " + excluded.values().toString() + " = " + excluded.size());
                }
            }
        }
        return max;
    }
    
    static int nonDivisibleSubset(int k, int[] S) {
        int[] rem_arrays = new int[k];
        int count = 0;
        for(int i = 0; i < S.length; i++) {
            int rem = S[i] % k;
            rem_arrays[rem]++;
            // System.out.print(rem + " ");
        }
        // System.out.println("");
        // System.out.println(Arrays.toString(rem_arrays));
        
        for(int i = 1; i <= rem_arrays.length/2; i++) {
            if(i == k-i) {
                if(rem_arrays[i] > 0) count++;
            } else {
                count += Math.max(rem_arrays[i], rem_arrays[k-i]);
            }
        }
        if(rem_arrays[0] > 0) count++;
        return count;
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
