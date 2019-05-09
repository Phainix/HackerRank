/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Challenge Link: https://www.hackerrank.com/challenges/bon-appetit/problem
 */

package hackerrank.Algorithms.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author FAITH.A
 */
public class BonAppetit {
    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {
        
        int totalCost = 0;
        for(int i = 0; i < bill.size(); i++) {
            totalCost += (i == k) ? 0 : bill.get(i);
        }
        if((totalCost/2) == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println( b - (totalCost/2));
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nk = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] billItems = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> bill = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int billItem = Integer.parseInt(billItems[i]);
            bill.add(billItem);
        }

        int b = Integer.parseInt(scanner.nextLine().trim());

        bonAppetit(bill, k, b);
    }
}
