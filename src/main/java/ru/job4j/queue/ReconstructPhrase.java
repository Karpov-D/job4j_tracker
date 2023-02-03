package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder builder = new StringBuilder();
        int i = 1;
        for (Character ch : evenElements) {
            if (i % 2 != 0) {
                builder.append(ch);
                i++;
            } else {
                i--;
            }
        }
        String result = builder.toString();
        return result;
    }

    private String getDescendingElements() {
        StringBuilder builder = new StringBuilder();
        for (Character ch : descendingElements) {
            builder.insert(0, ch);
        }
        String result = builder.toString();
        return result;
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
