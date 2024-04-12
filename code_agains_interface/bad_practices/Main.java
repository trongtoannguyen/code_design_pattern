package bad_practices;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
      public static void main(String[] args) {
            Map<String, String> map = new HashMap<>();
            HashMap<String, String> hashMap = new HashMap<>();
            TreeMap<String, String> treeMap = new TreeMap<>();

            // Example 1
            HashMapPrinter hashMapPrinter = new HashMapPrinter();
            hashMapPrinter.printMap(hashMap);
            // hashMapPrinter.printMap(treeMap); Compile time error
            // hashMapPrinter.printMap(map); Compile time error

            // Example 2
            MapReporter hashMapReporter = new MapReporter(hashMap);
//             MapReporter mapReporter = new MapReporter(map); // Compile time error
//             MapReporter treeMapReporter = new MapReporter(treeMap); // Compile time error
            hashMapReporter.printMap();
      }

}
