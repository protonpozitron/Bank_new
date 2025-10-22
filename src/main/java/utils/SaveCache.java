package utils;
import java.util.HashMap;

public class SaveCache {
    private HashMap<String, String> newCache ;
    int amount;

    public SaveCache (int amount) {
        this.amount = amount;
        this.newCache = new HashMap();
    }
    /**
     * param getCache отдает значение из putCache
     * @return значение в виде строки
     */
    public String getCache(String key) {
        if (newCache.get(key) == null) return "Такой элемент не сохранен в кэше.";
        else  System.out.println("Значение ="+newCache.get(key)); return newCache.get(key);
    }
    public void putCache(String name,String value) {
        if (value == null) System.out.println("Значение отсутствует");
        else {
            newCache.put(name, value);
        }
    }



    }

