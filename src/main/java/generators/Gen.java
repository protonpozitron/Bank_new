package generators;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

public class Gen {
    final Random random = new Random();
    ArrayList<String> alphaNum = new ArrayList<String>();

    //https://ru.stackoverflow.com/questions/240262/%D0%9A%D0%B0%D0%BA-%D1%81%D0%B4%D0%B5%D0%BB%D0%B0%D1%82%D1%8C-%D0%B3%D0%B5%D0%BD%D0%B5%D1%80%D0%B0%D1%82%D0%BE%D1%80-%D1%81%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D1%8B%D1%85-%D0%B1%D1%83%D0%BA%D0%B2
    public String randomStrLat(Integer length) {
        for (char i = 'a'; i <= 'Z'; i++) {
            String s = new String();
            s += i;
            alphaNum.add(s);
        }
        return alphaNum.get((int) (Math.random() * alphaNum.size()));
    }

    public String randomStrKir(Integer length) {
        for (int i = 0; i < length; i++) {
            for (char v = 'а'; v <= 'Я'; v++) {
                String s = new String();
                s += v;
                alphaNum.add(s);
            }
        }

        return alphaNum.toArray().toString();

    }

}
