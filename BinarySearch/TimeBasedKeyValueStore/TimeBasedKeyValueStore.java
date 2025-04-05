import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

class TimeMap {
    private Map<String, List<Pair<Integer, String>>> timeMap;
    // private Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new Pair<>(timestamp, value));

        // timeMap.putIfAbsent(key, new TreeMap<>());
        // timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        List<Pair<Integer, String>> values = timeMap.getOrDefault(key, new ArrayList<>());
        int l = 0, r = values.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (values.get(m).getKey() <= timestamp) {
                res = values.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    // public String get(String key, int timestamp) {
    //     if (!timeMap.containsKey(key)) {
    //         return "";
    //     }
    //     TreeMap timestamps = timeMap.get(key);
    //     Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);
    //     return entry == null ? "" : entry.getValue();
    // }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please give instructions");
            return;
        }
        TimeMap timeMap = new TimeMap();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("set")) {
                i++;
                String[] commands = args[i].replace("[", "").replace("]", "").replace(" ", "").replace("\"", "").split(",");
                timeMap.set(commands[0], commands[1], Integer.parseInt(commands[2]));
                System.out.println("null");
            } else {
                i++;
                String[] commands = args[i].replace("[", "").replace("]", "").replace(" ", "").replace("\"", "").split(",");
                String val = timeMap.get(commands[0], Integer.parseInt(commands[1]));
                System.out.println(val);
            } 
        }
    }

}