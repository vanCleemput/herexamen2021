package retake2021.maps;

public abstract class Map<K extends Object,V extends Object> implements Iterable<Map<K,V>>{

    public boolean equals(Map<K,V> mapToCompare){
        if (this instanceof NonemptyMap && mapToCompare instanceof NonemptyMap){
            return ((NonemptyMap<K,V>) this).compareFields((NonemptyMap<K,V>) mapToCompare);
        }
        if (this instanceof EmptyMap && mapToCompare instanceof EmptyMap){
            return true;
        }
        return false;

    }

    /// it kan ook in emptymap staan
    public V get(K key) {
        return null;
    }

    ///zou ook in emptymap mogen staan kan nicer zijn want dan kan deze clase naar een interface omgezet worden waardoor
    //ge meer dingens kunt overnemen van verschillende interfaces en nog steeds de optie hebben om een abstrace class te gebruiken
    public K getKey() {
        return null;
    }
    public V getValue(){return null;}
    public Map<K,V> getTail(){return null;}

}
