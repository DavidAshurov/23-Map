package telran.words.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Anagram {
    public static boolean isAnagram(String word,String part) {
        if (part == null || part == "") {
            return false;
        }
        word = word.toLowerCase();
        part = part.toLowerCase();
        Map<Character,Integer> letters = new HashMap<>();
        for (Character c : word.toCharArray()) {
            letters.merge(c,1,(oldValue,value) -> oldValue + value);
        }
        for (Character c : part.toCharArray()) {
            if (letters.get(c) == null || letters.get(c) == 0) {
                return false;
            }
            letters.computeIfPresent(c,(k,v) -> v - 1);
        }
        return true;
    }
}
