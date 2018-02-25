import java.util.Map;

public class DataBase {

    private static final String PATH_TO_FILE = "src/resources/Food/";
    private static final String PATH_TO_XLS = "src/resources/xls/bobs.xls/";
    //private Map<String, Map<String, Food>> database = FileUtil.readFromXls(PATH_TO_XLS);
    private Map<String, Map<String, Food>> database = FileUtil.readFromFileOrDirectory(PATH_TO_FILE);

    public Food getFoodByName(String name) {
        Food foodResult = null;
        for (Map<String, Food> innerMap : database.values()) {
            foodResult = innerMap.get(name);
            if (foodResult != null) {
                break;
            }
        }
        return foodResult;
    }
}
