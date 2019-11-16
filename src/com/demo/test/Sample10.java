package com.demo.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample10 {

    public static void main(String[] args) {
        /*4 <h1>Nayeem loves counseling</h1>
            <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
            <Amee>safat codes like a ninja</amee>
            <SA premium>Imtiaz has a secret crush</SA premium> */

        String line = "<h1>Nayeem loves counseling</h1>";
        String regex = "<(.+)>([^<]+)</\\1>";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        boolean matchFound = false;
        while (matcher.find()) {
            System.out.println(matcher.group(2));
            matchFound = true;
        }

        if (!matchFound) {
            System.out.println("None");
        }
    }
}
