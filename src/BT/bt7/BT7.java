package BT.bt7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BT7 {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt7\\file.txt"; // Đường dẫn tới tệp gốc
        String destinationFile = "C:\\Users\\Admin\\Desktop\\game\\ss16\\src\\BT\\bt7\\newfile.txt"; // Đường dẫn tới tệp đích mới

        String fileContent = readFile(sourceFile);
        if (fileContent != null) {
            String reversedContent = reverseWords(fileContent); // Đảo ngược thứ tự các từ

            boolean success = writeFile(destinationFile, reversedContent);
            if (success) {
                System.out.println("Tạo bản sao với tên mới và các từ đảo ngược thành công.");
            } else {
                System.out.println("Không thể tạo bản sao với tên mới và các từ đảo ngược.");
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

    private static String reverseWords(String content) {
        String[] words = content.split("\\s+");
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);

        StringBuilder reversedContent = new StringBuilder();
        for (String word : wordList) {
            reversedContent.append(word).append(" ");
        }
        return reversedContent.toString().trim();
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

