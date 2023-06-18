package org.blbulyandavbulyan.jseminars.seminar4.homework.queue;

import java.util.LinkedList;

public class LLQueue<T> implements Queue<T>{
    private LinkedList<T> data = new LinkedList<>();
    @Override
    public void enqueue(T element) {
        data.add(element);
    }

    @Override
    public T dequeue() {
        return data.removeFirst();
    }

    @Override
    public T first() {
        return data.getFirst();
    }
}
