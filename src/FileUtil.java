import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileUtil {

    public static Map<String, Map<String, Food>> readFromFileOrDirectory(String pathToFile) {
        Map<String, Map<String, Food>> result;
        File file = new File(pathToFile);
        if (file.isDirectory()) {
            result = readFromDirectory(file);
        } else {
            result = new HashMap<>();
            result.put(FilenameUtils.removeExtension(file.getName()), readFromFile(file));
        }
        return result;
    }

    public static Map<String, Map<String, Food>> readFromXls(String pathToXls) {
        Map<String, Map<String, Food>> result;
        File file = new File(pathToXls);
        result = new HashMap<>();
        result.put(FilenameUtils.removeExtension(file.getName()), parseXls(file));
        return result;
    }

    private static Map<String, Food> parseXls(File file) {
        Map<String, Food> result = new HashMap<>();
        try {
            InputStream in = new FileInputStream(file);
            HSSFWorkbook book = new HSSFWorkbook(in);
            ExcelExtractor extractor = new ExcelExtractor(book);
            String txt = extractor.getText();
            Scanner sc = new Scanner(txt);
            System.out.println(sc.nextLine());
            while (sc.hasNext()) {
                Food food = parseStringToFood(sc.nextLine());
                result.put(food.getFoodName(), food);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println(" File cannot be parsed.");
        }
        return result;
    }

    private static Map<String, Food> readFromFile(File file) {
        Map<String, Food> result = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String stringLine;
            while ((stringLine = br.readLine()) != null) {
                System.out.println(stringLine);
                Food food = parseStringToFood(stringLine);
                result.put(food.getFoodName(), food);
            }
        } catch (FileNotFoundException e) {
            System.out.println(file.getName() + " not found.");
        } catch (IOException e) {
            System.out.println(file.getName() + " cannot be parsed.");
        }
        return result;
    }

    private static Map<String, Map<String, Food>> readFromDirectory(File fileDirectory) {
        Map<String, Map<String, Food>> result = new HashMap<>();
        for (File innerFile : fileDirectory.listFiles()) {
            result.put(FilenameUtils.removeExtension(innerFile.getName()), readFromFile(innerFile));
        }
        return result;
    }

    private static Food parseStringToFood(String string) {
        String[] foodFields = string.replaceAll(",", "\\.")
                .replaceAll("-", "0")
                .split("\\t");
        return Food.initFromParams(foodFields);
    }
}
