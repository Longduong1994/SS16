package BT.bt11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BT11 {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt11\\file.txt"; // Đường dẫn tới tệp văn bản

        List<String> words = readFileWords(filename);
        if (words != null) {
            List<String> foundWords = findWordsWithSubstring(words);

            System.out.println("Các từ chứa chuỗi ký tự đã cho:");
            for (String word : foundWords) {
                System.out.println(word);
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

    private static List<String> findWordsWithSubstring(List<String> words) {
        List<String> foundWords = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi ký tự để tìm: ");
        String substring = scanner.nextLine().toLowerCase(); // Nhập chuỗi ký tự từ người dùng và chuyển thành chữ thường

        for (String word : words) {
            if (word.contains(substring)) {
                foundWords.add(word);
            }
        }

        return foundWords;
    }
}
