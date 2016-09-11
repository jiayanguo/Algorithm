/**
 * Created by jiayanguo on 9/11/16.
 */

import java.util.Iterator;

/**
 * Definition of OutputCollector:
 */

  abstract  class OutputCollector<K, V> {
      public abstract void collect(K key, V value);
          // Adds a key/value pair to the output buffer
  }

public class WordCount {

    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);

            String[] array = value.split(" ");

            for (String str : array){
                output.collect (str, 1);
            }

        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }

            output.collect (key, sum);
        }
    }
}

