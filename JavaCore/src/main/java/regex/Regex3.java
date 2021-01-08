package regex;


import java.util.Arrays;

public class Regex3 {

    public static void main(String[] args) {

        String s = "Ivanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48, " +
                "email: vivanov@mail.ru, Postcode: AA99, Phone Number: +123456789;" +
                "Petrova Mariya, Ukraine, Kiyev, Lomonosov street, 33, Flat 18," +
                "email: masha@yandex.ru, Postcode: UKR54, Phone Number: +987654321;" +
                "Chuck Norris, USA, Hollywood, All start street, 87, Flat 21," +
                "email: chuck@gmail.com, Postcode: USA23, Phone Number: +136478952.";

        //matches вернет true, если строка соответствует условию регулярного выражения
        System.out.println("============");
        String s2 = "chuck@gmail.com";
        boolean result = s2.matches("\\w+@\\w+\\.\\w+");
        System.out.println(result);

        //split разделит строку по условиям регулярного выражения
        System.out.println("============");
        String[] array = s.split(" ");
        Arrays.stream(array).forEach(System.out::println);



    }
}
