package enums;

import java.util.Arrays;

public class Enum1 {

    public static void main(String[] args) {
        WeekDays w1 = WeekDays.SUNDAY;
        Today today = new Today(w1);
        today.daysInfo();
        System.out.println(today.weekDay);
        WeekDays w2 = WeekDays.SUNDAY;
        WeekDays w3 = WeekDays.FRIDAY;
        System.out.println(w1==w2);
        System.out.println(w2==w3);
        WeekDays w15 = WeekDays.valueOf("MONDAY");  //позволяет создать enum из String значения
        System.out.println(w15);
        //список всех значений передает в массив
        WeekDays [] array = WeekDays.values();
        System.out.println(Arrays.toString(array));
    }



}

//enum - способ ограничению информации конкретным списком -> делает код typesafe
//enum можно создать как inner class, но не получится сделать его local inner class
//extend нельзя делать
//можно сравнивать оператором конструкторы одного типа ==, конструкторы разного типа сравниваем через equals

    enum WeekDays {
        MONDAY ("bad"),
        TUESDAY ("bad"),
        WEDNESDAY("so-so"),
        THURSDAY("so-so"),
        FRIDAY(),
        SATURDAY("great"),
        SUNDAY("good");

        private String mood;
        //конструктор приватный, срабатывает автоматически
        private WeekDays(String mood) {
            this.mood = mood;
        }
        //может быть несколько конструкторов
        WeekDays() {
        }
        //метод может быть публичным
        public String getMood() {
            return mood;
        }
    }

    class Today {
        WeekDays weekDay;

        public Today(WeekDays weekDay) {
            this.weekDay = weekDay;
        }
         void daysInfo () {
            switch (weekDay){
                case MONDAY:
                case TUESDAY:
                case WEDNESDAY:
                case THURSDAY:
                case FRIDAY:
                    System.out.println("Go to work");
                    break;
                case SATURDAY:
                case SUNDAY:
                    System.out.println("You can stay at home and rest");
                    break;
            }
             System.out.println("Nastroenie v etot den:" + weekDay.getMood());
         }

    }



