/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank;

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
public class RepeatedString {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long stringLength = s.length();
        int occurences = 0;
        ArrayList<Integer> positions = new ArrayList<Integer>();
        
        
        for(int i = 0; i < stringLength; i++) {
            if(s.charAt(i) == 'a') {
                occurences++;
                positions.add(i);
            }
        }
        
        long fullOccurences = (n / stringLength) * occurences;
        
        long remainingStringLength = (n % stringLength);
        long partialOccurences = 0;
        
        for(int i = 0; i < positions.size(); i++) {
            if(positions.get(i) < remainingStringLength) {
                partialOccurences++;
            } else {
                break;
            }
        }
        
        // System.out.println(positions.toString() + " " + fullOccurences);
        
        fullOccurences += partialOccurences;
        return fullOccurences;
    }

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Enter String");
        String s = scanner.nextLine();
        System.out.println("Enter number");
        long n = scanner.nextLong();
        
        long result = repeatedString(s, n);
        System.out.println(result);
    }
}
