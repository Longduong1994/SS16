package BT.bt10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BT10 {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt10\\file.txt"; // Đường dẫn tới tệp văn bản

        List<String> words = readFileWords(filename);
        if (words != null) {
            Map<String, Integer> wordCountMap = countWordOccurrences(words);
            List<String> mostFrequentWords = getMostFrequentWords(wordCountMap);

            System.out.println("Các từ được sử dụng nhiều nhất trong tệp:");
            for (String word : mostFrequentWords) {
                System.out.printf(word + " ");
            }
        } else {
            System.out.println("Không thể đọc tệp.");
        }
    }

    private static List<String> readFileWords(String filename) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+"); // Tách từng từ trong dòng
                for (String word : lineWords) {
                    word = word.replaceAll("[^a-zA-Z]", ""); // Loại bỏ các ký tự không phải chữ cái
                    if (!word.isEmpty()) {
                        words.add(word.toLowerCase()); // Thêm từ vào danh sách và chuyển thành chữ thường
                    }
                }
            }
            return words;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Map<String, Integer> countWordOccurrences(List<String> words) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    private static List<String> getMostFrequentWords(Map<String, Integer> wordCountMap) {
        List<String> mostFrequentWords = new ArrayList<>();

        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            int count = entry.getValue();
            if (count > maxCount) {
                mostFrequentWords.clear();
                mostFrequentWords.add(entry.getKey());
                maxCount = count;
            } else if (count == maxCount) {
                mostFrequentWords.add(entry.getKey());
            }
        }

        return mostFrequentWords;
    }
}

