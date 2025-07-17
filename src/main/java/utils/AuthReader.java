package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

public class AuthReader {
    public String readAuth(String key) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.yaml");
        Map<String, Object> obj = yaml.load(inputStream);
       return obj.get(key).toString();
    }
}





