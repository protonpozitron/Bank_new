package utils;
import java.util.LinkedHashMap;

public class SaveCache {

    private LinkedHashMap newCache ;
    int amount;

    public SaveCache (int amount) {
        this.amount = amount;
        newCache = new LinkedHashMap();
    }
    public String getCache(String key) {
        Object o = newCache.get(key);
        if (newCache.get(key) == null) return "Такой элемент не сохранен в кэше.";
        else return o.toString();
    }
    public void putCache(String value) {
        if (value == null) System.out.println("Значение отсутствует");
        else newCache.put(value,value);
    }


    }

