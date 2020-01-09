package me.jkkim.example;

import java.util.ArrayList;
import java.util.List;

class CrossWordPuzzle {

    static List<String> solve(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        int posA = -1;
        int posB = -1;
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] == arrayB[j]) {
                    posA = i;
                    posB = j;
                    break;
                }
            }
            if (0 <= posA) break;
        }

        List<String> result = new ArrayList<>();
        for (int j = 0; j < arrayB.length; j++) {
            if (j == posB) {
                result.add(a);
            } else {
                char[] row = new char[arrayA.length];
                for (int i = 0; i < arrayA.length; i++) {
                    row[i] = i == posA ? arrayB[j] : '.';
                }
                result.add(String.valueOf(row));
            }
        }

        return result;
    }
}
