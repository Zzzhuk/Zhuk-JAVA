package com.lab1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<String> result = find(s);
        System.out.print(result.isEmpty() ? "Have not appropriate words" : result);
    }

    public static List<String> find(String s) {
        String[] arr = s.split("\\s+");
        List<String> list = new ArrayList<>();
        for (String word: arr) {
            if(isAppropriate(word))
                list.add(word);
        }

        return list;
    }

    public static Boolean isAppropriate(String word) {
        int code = (int) word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if ((int) word.charAt(i) >= code)
                code = (int) word.charAt(i);
            else
                return false;
        }

        return true;
    }
}