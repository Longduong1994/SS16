package BT.bt6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BT6 {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt6\\file.txt"; // Đường dẫn tới tệp gốc
        String destinationFile = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt6\\newfile.txt"; // Đường dẫn tới tệp đích mới

        String fileContent = readFile(sourceFile);
        if (fileContent != null) {
            String uppercaseContent = fileContent.toUpperCase(); // Chuyển đổi nội dung thành chữ hoa

            boolean success = writeFile(destinationFile, uppercaseContent);
            if (success) {
                System.out.println("Tạo bản sao với tên mới và các từ viết hoa thành công.");
            } else {
                System.out.println("Không thể tạo bản sao với tên mới và các từ viết hoa.");
            }
        } else {
            System.out.println("Không thể đọc tệp gốc.");
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

    private static boolean writeFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
