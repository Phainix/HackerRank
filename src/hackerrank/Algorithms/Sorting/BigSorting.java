/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Challenge Link: https://www.hackerrank.com/challenges/big-sorting/problem
 */

package hackerrank.Algorithms.Sorting;

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
public class BigSorting {
    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, new BigSort());
        return unsorted;
    }

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Enter total of unsorted numbers");
        int n = scanner.nextInt();
        String[] unsorted = new String[n];
        
        for(int i = 0; i < n; i++) {
            unsorted[i] = scanner.next();
        }
     
        String[] result = bigSorting(unsorted);
        
        System.out.println("Result:");
        
        StringBuilder output = new StringBuilder("");
        for(int i = 0; i < result.length; i++) {
            output.append(result[i]+"\n");
        }
        System.out.println(output);
    }
}

class BigSort2 implements Comparator<String> {
    public int compare(String x, String y) {
        if(x.length() == y.length()) {
            return x.compareTo(y);
        }
        return x.length() - y.length();
    }
}

class BigSort implements Comparator<String> {
    public int compare(String x, String y) {
        if(x.length() > y.length()) return 1;
        if(x.length() < y.length()) return -1;

        for (int i = 0; i < x.length(); i++) {
            if(x.charAt(i) > y.charAt(i)) return 1;
            if(x.charAt(i) < y.charAt(i)) return -1;
        }
        return 0;
    }
}