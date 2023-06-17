package org.blbulyandavbulyan.jseminars.seminar4.classwork.stringstorage;

import java.util.ArrayList;
import java.util.function.Consumer;

public class BaseStringStorage implements StringStorage{
    private final ArrayList<String> list = new ArrayList<>();
    private int indexOfLastAddedElement = -1;
    @Override
    public void revert() {
        if(indexOfLastAddedElement != -1){
            list.remove(indexOfLastAddedElement);
            indexOfLastAddedElement = -1;
        }
    }

    @Override
    public void insert(String s, int position) {
        list.add(position, s);

        indexOfLastAddedElement = position;
    }

    @Override
    public String get(int index) {
        return list.get(index);
    }

    @Override
    public void forEachReversed(Consumer<String> stringConsumer) {
        if(!isEmpty()){
            var fromEndIterator = list.listIterator(list.size());
            while (fromEndIterator.hasPrevious()){
                stringConsumer.accept(fromEndIterator.previous());
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void remove(int index) {
        list.remove(index);
        if(index == indexOfLastAddedElement)
            indexOfLastAddedElement = -1;
    }
}
