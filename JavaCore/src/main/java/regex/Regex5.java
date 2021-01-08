package regex;

import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex5 {
    public static void main(String[] args) {

        String myString = "12345678901234560811234;"+
                "12345678912345670901234;"+
                "12345678902345670123456";
        // 03/25 1234 5678 9123 4567 (987)

        Pattern pattern =
                Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = pattern.matcher(myString);
        //matcher делит все по группам, начинается с 1й группы
//        String myNewString = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
//        System.out.println(myNewString);
        while (matcher.find()) {
            System.out.println(matcher.group(7));
        }



    }
}
