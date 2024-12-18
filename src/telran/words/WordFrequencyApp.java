package telran.words;

import java.util.*;

public class WordFrequencyApp {
    public static void main(String[] args) {
        String[] words = {"abc","ab","limn","limn","ab","limn","a"};
        printWordsFrequency(words);
    }

    private static void printWordsFrequency(String[] words) {
        Map<String,Integer> res = new HashMap<>();
        for (String s : words) {
//            if (res.putIfAbsent(s,1) != null) {
//                res.put(s,res.get(s) + 1);
//            }

//            res.computeIfPresent(s, (k,v) -> v + 1);
//            res.computeIfAbsent(s,k -> 1);
            res.merge(s,1,(oldValue,value) -> oldValue + value);
        }
        ArrayList<String> keys = new ArrayList<>(res.keySet());
        Collections.sort(keys,(k1,k2) -> Integer.compare(res.get(k2),res.get(k1)));
        for (String k : keys) {
            System.out.println(k + " -> " + res.get(k));
        }
    }
}
