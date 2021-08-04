package retake2021.maps.tests;

import retake2021.maps.EmptyMap;
import retake2021.maps.Map;
import retake2021.maps.NonemptyMap;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class Maps_Test {
    @Test
    public void test() {
        Map<String,Integer> internalMap = NonemptyMap.of("two", 2, NonemptyMap.of("three", 3, EmptyMap.of()));
        Map<String,Integer> map = NonemptyMap.of("one", 1,internalMap );
        Map<String,Integer> map2 = EmptyMap.<String,Integer>of();

        assertEquals(map, map);
        System.out.println(map.equals(map));

        assertFalse(map.equals(map2));
        System.out.println(map.equals(map2));

        //checks if the right value is returned for a given key
        assertEquals(map.get("one"),1);
        assertEquals(map.get("two"),2);
        assertEquals(map.get("four"),null);
        assertEquals(map2.get(null),null);

        //checking if the getters provide right values
        assertEquals(map.getKey(),"one");
        assertEquals(map.getValue(),1);
        assertEquals(map.getTail(),internalMap);

        // iterator test
        Iterator<Map<String,Integer>> iterator = map.iterator();
        // dit zou niet klopen voor een empty map
        int index = 0;
        while (iterator.hasNext()){
            index++;
            Map <String,Integer>iteratorMap = iterator.next();
            iterator = iteratorMap.iterator();
        }
        index++;
        System.out.println(index);
        assertEquals(3,index);

        /// nog een test schrijven die nakijkt of dat er geen element kunnen toegevoeg worden aan een bestaande map met als key en value een andere soort
    }

}
