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
        Iterator<Character> iterator = evenElements.iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
            iterator.next();
        }
        String result = builder.toString();
        return result;
    }

    private String getDescendingElements() {
        StringBuilder builder = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }
        String result = builder.toString();
        return result;
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
