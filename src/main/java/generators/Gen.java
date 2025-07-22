package generators;

import java.util.ArrayList;

public class Gen {
    ArrayList<String> alphaNum = new ArrayList<String>();
    final String kir = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    final String lat = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    final String num = "1234567890";
    final String allSymb = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюяAaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890~!@#$%^&*()_=-/?.,";


    public String randomStrLat(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(kir.charAt(0 + (int) (Math.random() * kir.length())));
        }

        return s.toString();
    }


    public String randomStrKir(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(lat.charAt(0 + (int) (Math.random() * lat.length())));
        }
        return s.toString();
    }
    public String randomNum(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(num.charAt(0 + (int) (Math.random() * num.length())));
        }
        return s.toString();
    }
    public String randomAll(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(allSymb.charAt(0 + (int) (Math.random() * allSymb.length())));
        }
        return s.toString();
    }
}
