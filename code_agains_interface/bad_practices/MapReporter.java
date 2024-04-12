package bad_practices;

import java.util.HashMap;
import java.util.Map.Entry;

public class MapReporter {

      private final HashMap<?, ?> map;
  
      public MapReporter(final HashMap<?, ?> map) {
          this.map = map;
      }
  
      public void printMap() {
          for (final Entry<?, ?> entry : this.map.entrySet()) {
              System.out.println(entry.getKey() + " " + entry.getValue());
          }
      }
  }
  
