package org.example.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @date 2021/01/08
 * @time 下午5:37
 */
public class WordCount {

    public static void main(String[] args) {
        String str = "They go up, up, up into the air! They are flying!\n"
            + "up , ! They go into the air are flying";
        str = str.replaceAll("[\\pP‘’“”]", "").replaceAll("\n", " ");

        String[] words = str.split(" ");

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            Integer count = wordCounts.getOrDefault(word, 0);
            wordCounts.put(word, count + 1);
        }

        ArrayList<Entry<String, Integer>> entries = new ArrayList<>(wordCounts.entrySet());

        Collections.sort(entries, new Comparator<Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }

        });

        for (Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
