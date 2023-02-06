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
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                builder.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        String result = builder.toString();
        return result;
    }

    private String getDescendingElements() {
        StringBuilder builder = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            builder.append(descendingElements.pollLast());

        }
        String result = builder.toString();
        return result;
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
