package BT.bt2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BT2 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt2\\file.txt";

        try {
            // Đếm số dòng trong tệp văn bản
            int lineCount = countLines(filePath);

            // Hiển thị số lượng dòng
            System.out.println("Số lượng dòng trong file là: " + lineCount);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc tệp văn bản: " + e.getMessage());
        }
    }

    public static int countLines(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int lineCount = 0;

        while (reader.readLine() != null) {
            lineCount++;
        }

        reader.close();
        return lineCount;
    }
}
