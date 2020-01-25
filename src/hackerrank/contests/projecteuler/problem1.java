/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Challenge Link: https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem
 */

package hackerrank.contests.projecteuler;

import java.util.*;

public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(getSum(n));
        }
    }

    private static long getSum(int n) {
        if(n < 3 && n < 5) return 0;

        long multiplesOf3 = (n-1) / 3;
        long multiplesOf5 = (n-1) / 5;
        long multiplesOf15 = (n-1) / 15;

        long sumOfMultiplesOf3 = 3 * ((multiplesOf3 * (multiplesOf3 + 1)) / 2);
        long sumOfMultiplesOf5 = 5 * ((multiplesOf5 * (multiplesOf5 + 1)) / 2);
        long sumOfMultiplesOf15 = 15 * ((multiplesOf15 * (multiplesOf15 + 1)) / 2);

        long ans = sumOfMultiplesOf3 + sumOfMultiplesOf5 - sumOfMultiplesOf15;
        return ans;
    }
}
