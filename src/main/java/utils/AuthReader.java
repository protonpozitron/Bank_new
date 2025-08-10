package utils;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class AuthReader {

    /**
     * @param readAuth пользователь вводит значение-ключ,а метод читает данные логина пароля из файла application.yml
     * @return значение в виде строки
     */
    public String readAuth(String key) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.yml");
        Map<String, Object> obj = yaml.load(inputStream);
       return obj.get(key).toString();
    }
}





