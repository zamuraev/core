package regex;

public class Regex4 {


    //replaceAll and group
    public static void main(String[] args) {

        String s1 = "Privet,    moy     drug!    Kak idet    izuchenie    Java   ?";
        System.out.println(s1);
        s1 = s1.replace("Java", "SQL");
        s1 = s1.replaceAll(" {2,}", " ");
        s1 = s1.replaceAll("\\bi\\w+", "4444");  //граница слова начинается на i
        s1 = s1.replaceFirst("\\bi\\w+", "4444");
        System.out.println(s1);


    }

}
