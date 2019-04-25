/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Challenge Link: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 */

package hackerrank.Algorithms.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author FAITH.A
 */
public class JumpingOnClouds {
    public static int jumpingOnClouds(int[] c) {
        ArrayList<int[]> poss = new ArrayList<int[]>();
        int steps = 0;
        for(int i = 0; i < c.length; i++) {
            if (c[i] == 1) {
                int[] pos = {i-1, i+1};
                poss.add(pos);
            }
        }
        
        steps = poss.size();
                
        for(int[] pos: poss) {
            int index = poss.indexOf(pos);
            int start2 = 0; int stop1 = 0;
            
            if(index == 0) {
                int diff = poss.get(0)[0] - 0;
                steps += diff/2;
                if(diff % 2 == 1) steps++;
                
                //System.out.println("[" + 0 + ", " + poss.get(0)[0] + "]");
            }
            
            if(index < poss.size()-1) {
                stop1 = pos[1];
                start2 = poss.get(index+1)[0];
                
                //System.out.println(Arrays.toString(pos));
                //System.out.println("[" + (pos[1]) + ", " + (poss.get(index+1)[0]) + "]");
                
            } else {
                stop1 = poss.get(poss.size()-1)[1];
                start2 = c.length-1;
                   
                //System.out.println(Arrays.toString(pos));
                //System.out.println("[" + (poss.get(poss.size()-1)[1]) + ", " + (c.length-1) + "]");
            }
            
            // System.out.println("[" + stop1 + ", " + start2 + "]");
            
            int diff = start2 - stop1;
            if(diff == 0) continue;
            steps += diff/2;
            if(diff % 2 == 1) steps++;
        }
        
        if(poss.isEmpty()) {
            int diff = (c.length-1) - 0;
            steps += diff/2;
            if(diff % 2 == 1) steps++;
        }
           
        return steps;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of clouds n.");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        int[] C = new int[n];
        
        System.out.println("Enter " + n + " space-separated integers describing the clouds.");
        String[] clouds = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(clouds[i]);
            C[i] = SItem;
        }

        int result = jumpingOnClouds(C);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
