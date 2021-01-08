package scanner;

import java.util.Scanner;

//next() - символ до пробела
//nextLine() - строку
//nextByte()
//nextShort()
//nextLong()
//nextInt()
//nextFloat()
//nextDouble()
//nextBoolean()
//while(hasNext())

public class Scanner1 {

    public static void main(String[] args) {

        //отсканировать то что было введено с консоли
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Vvedite chislo");
//        int i = scanner.nextInt();
//        System.out.println("Vvedennoe chislo " + i);

//        System.out.println("Napishite 2 chisla");
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//
//        System.out.println("Chastnoe = " + x/y);
//        System.out.println("Ostatok = " + x%y);

//        System.out.println("Napishite paru slov");
//        String s1 = scanner.nextLine(); //передаем значение всей строки
//        String s2 = scanner.next(); //передаем значение одного введенного слова
//        System.out.println("Vu napisali "+s1+ " "+s2);

//        System.out.println("Napishite drobnoe chislo");
//        double d = scanner.nextDouble(); //как разделитель следует использовать не . а ,
//        System.out.println("Vu napisali "+d);

        //Будем работать не с консолью
        Scanner scanner = new Scanner("Privet moy drug!\nKak pojivaesh?\nChto xoroshego?");
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }


    }

}
