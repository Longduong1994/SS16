package BT.bt13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BT13 {
    public static void main(String[] args) {
        String sourceFilename = "path/to/your/sourcefile.txt"; // Đường dẫn tới tệp văn bản nguồn
        String targetFilename = "path/to/your/targetfile.txt"; // Đường dẫn tới tệp văn bản đích

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFilename))) {
            String line;
            int wordCount = 1;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Tách từng từ trong dòng

                for (int i = 0; i < words.length; i++) {
                    writer.write(String.valueOf(wordCount)); // Ghi số nguyên tăng dần vào tệp đích
                    writer.write(" ");
                    wordCount++;
                }

                writer.newLine();
            }

            System.out.println("Tạo bản sao của tệp thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
