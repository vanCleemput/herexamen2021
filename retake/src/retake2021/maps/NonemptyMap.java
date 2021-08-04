package retake2021.maps;

import java.util.Iterator;
import java.util.Spliterator;

public class NonemptyMap<K extends Object, V extends Object> extends Map<K, V> {
    private final K key;
   // private static final ArrayList<K> listOfKeys = new ArrayList<>();
    private final V value;
    private Map<K, V> tail;

    protected NonemptyMap(K key, V value, Map<K, V> tail) {
        this.key = key;
        this.value = value;
        this.tail = tail;
    }

    @Override
    public K getKey() {
        return key;
    }
    @Override
    public V getValue() {
        return value;
    }

    @Override
    public Map<K,V> getTail() {
        return tail;
    }

    /// hoe weet ik of de key al present is in de map ?
    /// de parameters mogen gwn object zijn
    // TODO
    public static <K,T> Map<K,T> of(K key, T value, Map<K,T> tail) {

        return new NonemptyMap<>(key,value,tail);

    }
    //// alle velden worden vergeleken met elkaar dus functie equals wordt opgeroepen tot we bij de laatse map.(bij volledige gelijke mapobjecten)
    //// het kan zijn dat ik hier equals moet gebruiken om dat het over objecten gaat testen is nodig
    // TODO
    protected boolean compareFields(NonemptyMap<K,V> mapToCompare){
        return this.key == mapToCompare.key && this.value == mapToCompare.value && this.tail.equals(mapToCompare.tail);
    }

    @Override
    /// deze is relatief gemaklijk e map is een linked list dus we itterate over heel de lijst kijken elke keer de tail na tot deze null/emptymap is
    // ik denk dat dit zou moeten werken, recursief als we bij een emtpy map terecht komen dan is de return value null, als the keys gelijk zijn dan
    // is de retrun value value
    public V get(K key) {
        Map<K,V> newNodeToCheck = this.tail;
        if (!this.key.equals(key)){
            return newNodeToCheck.get(key);
        }
        else {
            return value;
        }

    }

    @Override
    public Iterator<Map<K, V>> iterator() {

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return tail instanceof NonemptyMap;
            }

            @Override
            public Map<K,V> next() {
                return tail;
            }
        };
    }

    @Override
    public Spliterator<Map<K,V>> spliterator() {
        return null;
    }
}
