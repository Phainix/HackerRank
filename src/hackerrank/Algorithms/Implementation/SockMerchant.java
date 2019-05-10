/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Challenge Link: https://www.hackerrank.com/challenges/sock-merchant/problem
 */

package hackerrank.Algorithms.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author FAITH.A
 */
public class SockMerchant {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> frequencyMap =  new HashMap<Integer, Integer> ();
        int pairs = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            if(frequencyMap.containsKey(ar[i])) count = frequencyMap.get(ar[i]);
            frequencyMap.put(ar[i], count+1);
        }
        for(int i: frequencyMap.values()) {
            pairs += i/2;
        }
        // System.out.println(frequencyMap.toString());
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.nextLine();

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
