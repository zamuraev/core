package nested_classes.local_inner_class;

import org.w3c.dom.ls.LSOutput;

public class LocalInner1 {

    public static void main(String[] args) {
        Math math = new Math();
        math.getResult();
    }
}

class Math {
    final int a=10;

    //можно инициализировать через пареметры метода
    //public void getResult(int final delimoe, final int delitel)

    public void getResult() {
        //local inner class находится внутри блока кода - внутри метода или конструктора
        //не доступен вне метода или конструктора
        //не может быть статическим
        //access modifiers нельзя указать
        //область видимости - это блок, в котором он находится
        //может обращатся даже к private элементам внешнего класса
        //local inner class может обращатся к элементам блока, в котором он написан при условии, что они final или effectively final
        //effectively final -> переменная не обозначена как final, но после ее инициализации ее значение не меняется
        int delimoe = 21;
        class Delenie {
            //private int delimoe;
            private int delitel;

//            public int getDelimoe() {
//                return delimoe;
//            }

//            public void setDelimoe(int delimoe) {
//                this.delimoe = delimoe;
//            }
//
            public int getDelitel() {
                return delitel;
            }

            public void setDelitel(int delitel) {
                this.delitel = delitel;
            }

            public int getChastnoe() {
                return delimoe/delitel;
            }

            public int getOstatok() {
                System.out.println("a="+a);
                return delimoe%delitel;
            }
        }

        Delenie delenie = new Delenie();
//        delenie.setDelimoe(21);
        delenie.setDelitel(4);

//        System.out.println("Delimoe "+delenie.getDelimoe());
        System.out.println("Delimoe "+ delimoe);
        System.out.println("Delitel "+delenie.getDelitel());
        System.out.println("Chastnoe "+delenie.getChastnoe());
        System.out.println("Ostatok "+delenie.getOstatok());
    }
}
