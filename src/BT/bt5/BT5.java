package BT.bt5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BT5 {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt5\\file.txt"; // Đường dẫn tới tệp văn bản

        String fileContent = readFile(filename);
        if (fileContent != null) {
            String[] words = fileContent.split("\\s+"); // Tách từng từ trong văn bản

            List<String> longestWords = findLongestWords(words); // Tìm các từ có độ dài lớn nhất

            if (!longestWords.isEmpty()) {
                System.out.println("Các từ có độ dài lớn nhất trong tệp:");
                for (String word : longestWords) {
                    System.out.println("Từ: " + word + ", Độ dài: " + word.length());
                }
            } else {
                System.out.println("Không có từ nào trong tệp.");
            }
        } else {
            System.out.println("Không thể đọc tệp.");
        }
    }

    private static String readFile(String filename) {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            return fileContent.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> findLongestWords(String[] words) {
        int maxLength = 0;
        List<String> longestWords = new ArrayList<>();

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", ""); // Loại bỏ các ký tự không phải chữ cái

            if (!word.isEmpty()) {
                int length = word.length();

                if (length > maxLength) {
                    maxLength = length;
                    longestWords.clear();
                    longestWords.add(word);
                } else if (length == maxLength) {
                    longestWords.add(word);
                }
            }
        }

        return longestWords;
    }
}
