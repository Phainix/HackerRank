/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Challenge Link: https://www.hackerrank.com/challenges/queens-attack-2/problem
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
public class QueensAttack {
    
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int possible_attack_postions = 0;
        int up_moves = n - r_q;
        int down_moves = r_q - 1;
        int right_moves = n - c_q;
        int left_moves = c_q - 1;
        int left_up_diagonal = Math.min(left_moves, up_moves);
        int right_up_diagonal = Math.min(right_moves, up_moves);
        int left_down_diagonal = Math.min(left_moves, down_moves);
        int right_down_diagonal = Math.min(right_moves, down_moves);
                
        for(int[] obstacle: obstacles) {
            // System.out.println(Arrays.toString(obstacle));
            if(obstacle[0] == r_q && obstacle[1] > c_q) { // move right
                right_moves = (obstacle[1]-1) - c_q;
                // System.out.println("right_moves: "+right_moves);
            }
            if(obstacle[0] == r_q && obstacle[1] < c_q) { // move left
                left_moves = c_q - (obstacle[1] + 1);
                // System.out.println("left_moves: "+left_moves);
            }
            if(obstacle[1] == c_q && obstacle[0] < r_q) { // move down
                down_moves = r_q - (obstacle[0] + 1);
                // System.out.println("down_moves: "+down_moves);
            }
            if(obstacle[1] == c_q && obstacle[0] > r_q) { // move up
                up_moves = (obstacle[0] - 1) - r_q;
                // System.out.println("up_moves: "+up_moves);
            }
            if(Math.abs(obstacle[0] - r_q) == Math.abs(obstacle[1] - c_q)) { // is diagonal
                if(obstacle[0] < r_q && obstacle[1] < c_q) { // move left_down_diagonal
                    left_down_diagonal = Math.min(left_down_diagonal, Math.min(c_q - (obstacle[1] + 1), r_q - (obstacle[0] + 1)));
                    // System.out.println("left_down_diagonal: "+left_down_diagonal);
                }
                if(obstacle[0] > r_q && obstacle[1] > c_q) { // move right_up_diagonal
                    right_up_diagonal = Math.min(right_up_diagonal, Math.min((obstacle[1]-1) - c_q, (obstacle[0] - 1) - r_q));
                    // System.out.println("right_up_diagonal: "+right_up_diagonal);
                }
                if(obstacle[0] < r_q && obstacle[1] > c_q) { // move right_down_diagonal
                    right_down_diagonal = Math.min(right_down_diagonal, Math.min((obstacle[1]-1) - c_q, r_q - (obstacle[0] + 1)));
                    // System.out.println("right_down_diagonal: "+right_down_diagonal);
                }
                if(obstacle[0] > r_q && obstacle[1] < c_q) { // move left_up_diagonal
                    left_up_diagonal = Math.min(left_up_diagonal, Math.min(c_q - (obstacle[1] + 1), (obstacle[0] - 1) - r_q));
                    // System.out.println("left_up_diagonal: "+left_up_diagonal);
                }
            }
        }
        
        possible_attack_postions = up_moves + down_moves + right_moves + left_moves + left_up_diagonal + right_up_diagonal + left_down_diagonal + right_down_diagonal;
        return possible_attack_postions;
    }

    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the length of the board's sides and the number of obstacles, 'n' and 'k'");
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);
        
        System.out.println("Enter the queen's row and column position, 'r' and 'c'");
        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];
        
        System.out.println("Enter the row and column position for " + k + " obstacles");
        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
