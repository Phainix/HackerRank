/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Challenge Link: https://www.hackerrank.com/challenges/drawing-book/problem
 */

package hackerrank.Algorithms.Implementation;

import java.util.Scanner;
/**
 *
 * @author FAITH.A
 */
public class DrawingBook {
    
    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        int flips = n / 2;
        int frontFlip = p / 2;
        int backFlip = flips - frontFlip;
        return Math.min(frontFlip, backFlip);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int p = scan.nextInt();
        
        int result = pageCount(n, p);
        System.out.println(result);
    }
    
}
