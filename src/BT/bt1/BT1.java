package BT.bt1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BT1 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt1\\file.txt";

        try {
            // Đọc nội dung từ tệp văn bản
            String fileContent = readFile(filePath);

            // Đếm số lượng từ trong nội dung
            int wordCount = countWords(fileContent);

            // Hiển thị số lượng từ
            System.out.println("Số lượng từ trong file là: " + wordCount);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc tệp văn bản: " + e.getMessage());
        }
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        reader.close();
        return content.toString();
    }

    public static int countWords(String fileContent) {
        String[] words = fileContent.split("\\s+");
        return words.length;
    }
}

