package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class AuthReader {

    /**
     * @param readAuth пользователь вводит значение-ключ,а метод читает данные логина пароля из файла application.yml
     * @return значение в виде строки
     */
    public User readAuth() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.yml");

        User user = yaml.loadAs(inputStream, User.class);
            return user;
    }
}






