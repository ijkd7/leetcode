package bm.leetcode_tests.medium;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Problem981_timeBasedKeyValueStore {

    class TimeMap {

        final HashMap<String, List<Pair<Integer, String>>> map = new HashMap<>();

        public TimeMap() {
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            List<Pair<Integer, String>> list = map.get(key);
            return search(list, timestamp);
        }

        public String search(List<Pair<Integer, String>> list, int timestamp) {
            int start = 0;
            int end = list.size() - 1;
            while (start < end) {
                int mid = start + (end - start + 1) / 2; //3 + (6 - 3 + 1) / 2
                if (list.get(mid).k() <= timestamp) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }
            return list.get(start).k() <= timestamp
                    ? list.get(start).v()
                    : "";
        }

        record Pair<K, V>(K k, V v) {
        }
    }
}
