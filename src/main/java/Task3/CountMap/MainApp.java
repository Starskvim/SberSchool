package Task3.CountMap;

import java.util.Map;

public class MainApp {

    public static void main(String[] args) {
        CountMap<Integer> map1=gen();
        CountMap<Integer> map2=gen();
        System.out.println(map1);
        map1.addAll(map2);

        System.out.println("---После добавления---");
        System.out.println(map1);

        System.out.println("---Удаление---");
        map1.remove(10);
        System.out.println(map1);
        map1.addAll(map2);

        System.out.println("---После добавления---");
        System.out.println(map1);

        System.out.println("---toMap()---");
        Map<Integer,Integer> testmap = map1.toMap();
        System.out.println(testmap);
    }

    public static CountMap<Integer> gen(){
        CountMap<Integer> map = new MyCountHashMap<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        return map;
    }
}
