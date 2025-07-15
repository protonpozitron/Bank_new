package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class AuthReader {
//    public  Map<String, Object> read(String path) throws IOException {
//        InputStream in = Files.newInputStream(Paths.get(path));
//        Yaml yaml = new Yaml();
//        return (Map<String, Object>) yaml.load(in);
//  }
//    public String Testread(String field) throws IOException {
//
//        Yaml yaml = new Yaml();
//        InputStream inputStream = AuthReader.class.getResourceAsStream("/auth.yml");
//
    /// / Создание нового ObjectMapper как YAMLFactory
//        Map<String, Object> data = yaml.load(inputStream);
//        String value = data.get(field).toString();
//        System.out.println("Login is " + ", field's value " + value);
//        return value;
//    }
    public String readAuth(String key) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.yaml");
        Map<String, Object> obj = yaml.load(inputStream);
       return obj.get(key).toString();
    }
}

