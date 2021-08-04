package retake2021.maps;

import java.util.Iterator;
import java.util.Spliterator;

public class EmptyMap<K,V> extends Map<K,V> {

    //// een optie men kan een array gebruiken dat hetzelfde is over alle objecten en hiervogen we dan elke keer het map object aan toe
    //// maakt de tail dan wel obsolete
    public static<K,T> EmptyMap<K,T> of() {
        return new EmptyMap<>();
    }

    private EmptyMap() {
    }


    @Override
    public Iterator<Map<K, V>> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Map<K,V> next() {
                return null;
            }
        };
    }

    @Override
    public Spliterator<Map<K,V>> spliterator() {
        return null;
    }
}
