package Task3_3;

import java.util.*;

public class OperationOnCollections {

    public static void main(String[] args) {
        Collection col = createCollection();
        System.out.println(Arrays.toString(col.toArray()));
        removeDuplicates(col);
        System.out.println(Arrays.toString(col.toArray()));

        Map map = createMap();
        map = replacementWithPlaces(map);
        for (Object entry : map.entrySet()) {
            System.out.println(entry.toString());
        }
        String[] playersAndPoints = {"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"};
        System.out.println("Имя победителя, набравшего максимальное количество очков: " + winnerWithMaxPoints(playersAndPoints));
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
        map.put(1, "Строка первая");
        map.put(2, "Строка вторая");
        map.put(3, "Строка третья");
        return map;
    }

    //Задача 3
    public static Collection<ArrayList> removeDuplicates(Collection col) {
        Set<String> s = new HashSet<>(col);
        col.clear();
        col.addAll(s);
        return col;
    }

    //Задача 4
    public static Map replacementWithPlaces(Map<Integer, String> initialMap) {
        Collection<Integer> valCollection = new ArrayList<>();
        Map rvp = new HashMap<String, Collection>();
        for (Map.Entry<Integer, String> entry : initialMap.entrySet()) {
            String key = entry.getValue();
            Integer val = entry.getKey();

            valCollection.add(val);
            rvp.put(key, valCollection);
        }
        return rvp;
    }

    //Задача 5
    public static String winnerWithMaxPoints(String[] playersAndPoints) {
        Map <String, Integer> playersMap = new HashMap<>();
        int maxPoints = 0;
        String winner = "";
        if (playersAndPoints.length != 0){
            for (String player : playersAndPoints){
                String nameOfPlayer = player.substring(0, player.indexOf(" "));
                Integer points = Integer.parseInt(player.substring(player.indexOf(" ")+1));
                if (playersMap.containsKey(nameOfPlayer)){
                    int pointsEachPlayer = points + playersMap.get(nameOfPlayer);
                    playersMap.put (nameOfPlayer, pointsEachPlayer);

                    if (pointsEachPlayer > maxPoints){
                        maxPoints = pointsEachPlayer;
                        winner = nameOfPlayer;
                    }
                }
                else {
                    playersMap.put (nameOfPlayer, points);
                    if (points > maxPoints) maxPoints = points;
                }
            }
        }
        return winner;
    }
}

