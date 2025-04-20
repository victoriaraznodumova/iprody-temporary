package maps;

import java.util.*;

public class Maps {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
//        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("ev", 8854);
        map.put("kaz", 1458);
        map.put("pik", 2450);
        map.put(null, 4);
        System.out.println(map.get(null));

        System.out.println("is empty: " + map.isEmpty());
        System.out.println("size: " + map.size());
        System.out.println("contains key: " + map.containsKey("kaz"));
        System.out.println("contains key: " + map.containsKey("ural"));
        System.out.println("contains value: " + map.containsValue(1458));
        System.out.println("contains value: " + map.containsValue(9000));
        System.out.println("contains for ev: " + map.get("ev"));
        System.out.println("contains for v: " + map.get("v"));

        System.out.println(map.remove("pik"));


        //итерируемся по парам ключ-значение
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()){
            String key = stringIntegerEntry.getKey();
            Integer value = stringIntegerEntry.getValue();
            System.out.println(key + " " + value);
        }
    }
}