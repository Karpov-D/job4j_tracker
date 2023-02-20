package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int stringLen = Math.min(left.length(), right.length());
        int res = 0;
        for (int i = 0; i <stringLen; i++) {
            char CharLeft = left.charAt(i);
            char CharRight = right.charAt(i);
            if (CharLeft != CharRight) {
                res = Character.compare(CharLeft, CharRight);
                break;
            }
        }
        if (res == 0 && left.length() != right.length()) {
            res = Integer.compare(left.length(), right.length());
        }
        return res;
    }
}
