/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Challenge Link: https://www.hackerrank.com/challenges/equality-in-a-array/problem
 */

package hackerrank.Algorithms.Implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author FAITH.A
 */
public class EqualizeArray {
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> frequencyMap =  new HashMap<Integer, Integer> ();
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            int count = 0;
            if(frequencyMap.containsKey(arr[i])) count = frequencyMap.get(arr[i]);
            
            if(count+1 > max) max = count+1;
            
            frequencyMap.put(arr[i], count+1);
        }
        return arr.length - max;
    } 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of elements n.");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        int[] C = new int[n];
        
        System.out.println("Enter " + n + " space-separated integers.");
        String[] s = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(s[i]);
            C[i] = SItem;
        }

        int result = equalizeArray(C);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
