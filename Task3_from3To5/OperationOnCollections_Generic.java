package Task3_from3To5;

import javafx.print.Collation;

import java.util.*;

public class OperationOnCollections_Generic {

    public static void main(String[] args) {
        Collection col = createCollection();
        System.out.println(removeDuplicates(col));
        Map map = createMap();
        System.out.println(swapMap(map));
    }
    private static Collection<ArrayList> createCollection() {
        Collection col = new ArrayList();
        col.add("1");
        col.add("2");
        col.add("3");
        col.add("4");
        col.add("5");
        col.add("2");
        col.add("3");
        col.add("5");
        return col;
    }
    private static Map createMap() {
        Map map = new HashMap();
        map.put(2, "Строка вторая");
        map.put(1, "Строка первая");
        map.put(3, "Строка третья");
        map.put(2, "Строка вторая");

        return map;
    }
    //Задача 3
    private static <T>Collection<T> removeDuplicates(Collection<T> collection){
        return new HashSet<>(collection);
    }
    //Задача 4
    private static <K,V> Map<V, Collection<K>> swapMap (Map<K,V> initMap){
        Map <V,Collection<K>> resultMap = new LinkedHashMap<>();
        for (Map.Entry<K,V> entry : initMap.entrySet()){
            if (resultMap.containsKey(entry.getValue())){
                resultMap.get(entry.getValue()).add(entry.getKey());
            }
            else {
                List<K> list = new ArrayList<>();
                list.add(entry.getKey());
                resultMap.put(entry.getValue(), list);
            }
        }
        return resultMap;
    }
}
