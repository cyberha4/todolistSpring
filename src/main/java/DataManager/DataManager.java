package DataManager;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 21.02.2017.
 */
public class DataManager {
    private static ConcurrentHashMap<String, HashSet<Integer>> hashMap = new ConcurrentHashMap<String, HashSet<Integer>>();
    private static ConcurrentHashMap<String, HashSet<Integer>> tableRecordsId = new ConcurrentHashMap<String, HashSet<Integer>>();
    private static final Object obj = new Object();

    public static void writeTableRecordsId(String classname, int id){
        if(tableRecordsId.containsKey(classname)){
            tableRecordsId.get(classname).add(id);
        } else {
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(id);
            tableRecordsId.put(classname, hashSet);
        }
    }

    public static boolean isContainsRecordsId(String classname, int id) {
        return tableRecordsId.containsKey(classname) && tableRecordsId.get(classname).contains(id);
    }

    public static void printHashMap(){
        System.out.println("-------------Print Hash Map--------------");

        for (String key : tableRecordsId.keySet()) {
            System.out.println("Key : "+key);
            HashSet<Integer> values = tableRecordsId.get(key);
            for (Integer value :
                    values){
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("------------------------------------");

    }
}
