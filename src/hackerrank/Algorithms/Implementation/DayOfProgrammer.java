/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Challenge Link: https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 */

package hackerrank.Algorithms.Implementation;

import java.util.Scanner;

/**
 *
 * @author FAITH.A
 */
public class DayOfProgrammer {
    static String dayOfProgrammer(int year) {
        String day = "";
        if(year < 1918) {
            day = (year % 4) == 0 ? "12" : "13";
            day += ".09." + Integer.toString(year);
        }
        if(year == 1918) {
            day = "26.09." + Integer.toString(year);
        }
        if(year > 1918) {
            day = ((year % 400) == 0) || ((year % 4) == 0 && (year % 100) != 0) ? "12" : "13";
            day += ".09." + Integer.toString(year);
        }
        return day;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        String result = dayOfProgrammer(year);

        System.out.println(result);
    }
}
