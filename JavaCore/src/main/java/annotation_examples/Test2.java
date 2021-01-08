package annotation_examples;

import java.lang.annotation.*;

public class Test2 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class xiaomiClass = Class.forName("annotation_examples.Xiaomi");
        Class iPhoneClass = Class.forName("annotation_examples.iPhone");
        Annotation annotation1 = xiaomiClass.getAnnotation(SmartPhone.class);
        Annotation annotation2 = iPhoneClass.getAnnotation(SmartPhone.class);
        SmartPhone sm1 = (SmartPhone) annotation1;
        SmartPhone sm2 = (SmartPhone) annotation2;
        System.out.println("Annotation info from Xiaomi class"+sm1.OS()+", "+sm1.yearOfCompanyCreation());
        System.out.println("Annotation info from iPhone class"+sm2.OS()+", "+sm2.yearOfCompanyCreation());
    }
}


@Target(ElementType.TYPE) //можем использовать для классов и интерфейсов
@Retention(RetentionPolicy.RUNTIME) //видно в runtime -> можно использовать рефлексию
    //можно прописывать дефолтные значения
@interface SmartPhone {
    String OS() default "Android";
    int yearOfCompanyCreation() default 2010;

}

@SmartPhone()
class Xiaomi {
    //можно использовать примитивные типы данных
    //можно использовать массивы
    //нельзя использовать ссылочные типы данных, типо StringBuilder

    String model;
    Double price;
}

@SmartPhone(OS = "iOS", yearOfCompanyCreation = 1976)
class iPhone {
    String model;
    Double price;
}