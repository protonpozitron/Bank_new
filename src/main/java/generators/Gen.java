package generators;


public class Gen {
    final String kir = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    final String lat = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    final String num = "1234567890";
    final String allSymb = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюяAaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890~!@#$%^&*()_=-/?.,";


    public String randomStrLat(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(kir.charAt((int) (Math.random() * kir.length())));
        }

        return s.toString();
    }


    public String randomStrKir(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(lat.charAt((int) (Math.random() * lat.length())));
        }
        return s.toString();
    }
    public String randomNum(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(num.charAt((int) (Math.random() * num.length())));
        }
        return s.toString();
    }
    public String randomAll(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(allSymb.charAt((int) (Math.random() * allSymb.length())));
        }
        return s.toString();
    }
}
