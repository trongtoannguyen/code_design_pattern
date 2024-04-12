// Programming to Implementations

import java.util.Map;
import java.util.Map.Entry;

public class HashMapPrinter {
    public void printMap(final Map<?, ?> map) {
      for (final Entry<?, ?> entry : map.entrySet()) {
          System.out.println(entry.getKey() + " " + entry.getValue());
      }
  }
}
