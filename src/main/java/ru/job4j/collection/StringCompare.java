package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int stringLen = Math.min(left.length(), right.length());
        int res = 0;
        for (int i = 0; i < stringLen; i++) {
            char charLeft = left.charAt(i);
            char charRight = right.charAt(i);
            if (charLeft != charRight) {
                res = Character.compare(charLeft, charRight);
                break;
            }
        }
        return res == 0 && left.length() != right.length() ? Integer.compare(left.length(), right.length()) :
                res;
    }
}
