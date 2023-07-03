package BT.bt4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BT4 {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt4\\file.txt"; // Đường dẫn tới tệp văn bản

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
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(words); // Sắp xếp các từ

        System.out.println("Các từ đã được sắp xếp theo thứ tự bảng chữ cái:");
        for (String word : words) {
            System.out.printf(word + " ");
        }
    }
}

