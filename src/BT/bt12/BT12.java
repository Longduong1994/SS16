package BT.bt12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BT12 {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt12\\file.txt"; // Đường dẫn tới tệp văn bản

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.trim().split("\\s+"); // Tách từng từ trong dòng và loại bỏ khoảng trắng thừa
                if (lineWords.length > 0) {
                    System.out.println("Từ đầu tiên trong dòng: " + lineWords[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
