package Exercises.Ex9Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Scanner;

public class WordCount {

    @Test
    public void countWordsInText() throws FileNotFoundException {
        Map<String,Integer> freq = new UnsortedArrayMap<>();
        Scanner doc = null;
        doc = new Scanner(new File("text.txt"));
        while (doc.hasNextLine()) {
            String[] data = doc.nextLine().split(" ");
            for (String word : data) {
                String key = word.toLowerCase();
                if (freq.containsKey(key)){
                    freq.put(key, freq.get(key) + 1);
                }
                else{
                    freq.put(key, 1);
                }
            }
        }
        Assertions.assertFalse(freq.isEmpty());
        int maxCount = 0;
        String maxWord = "No word?";
        for (Entry<String,Integer> ent : freq.entrySet()) {
            if (ent.getValue() > maxCount) {
                maxWord = ent.getKey();
                maxCount = ent.getValue();
            }
        }
        System.out.print("The most frequent word is '" + maxWord);
        System.out.println("' with " + maxCount + " occurrences.");
        Assertions.assertEquals("de", maxWord);
        Assertions.assertEquals(21, maxCount);
    }

}
