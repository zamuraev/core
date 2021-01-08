package nested_classes.anonymous_class;

import java.util.concurrent.Executors;

public class AnnonymousClass {

    public static void main(String[] args) {

        //анонимный класс
        //используется когда на ходу нужно изменить какой-либо метод
        //это обьявление класса и одновременное создание обьекта
        //невозможно написать конструктор - нет имени
        //может обращатся к private элементам внешнего класса, но нужно создать обьект этого класса
        //lambda expression - это краткая форма для написания анонимных классов
        //понятие анонимных интерфейсов не существует

        Math m1 = new Math() {
            @Override
            public int doOperation(int a, int b) {
                return a+b;

            }
        };

        Math m2 = new Math() {
            @Override
            public int doOperation(int a, int b) {
                return a*b;
            }
        };




        System.out.println(m1.doOperation(5,7));
        System.out.println(m2.doOperation(5,7));
    }
}


interface Math {
    int doOperation(int a, int b);
}


