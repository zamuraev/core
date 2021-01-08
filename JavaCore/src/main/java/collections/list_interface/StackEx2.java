package collections.list_interface;

import java.util.Stack;

public class StackEx2 {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        //добавление в голову стека
        stack.push("Sergey");
        stack.push("Misha");
        stack.push("Oleg");
        stack.push("Katya");
        System.out.println(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());//возвращает елемент из головы и сразу его удаляет
            System.out.println(stack);
        }

        System.out.println(stack.peek()); //возвращает головной элемент, но не удаляет его



    }
}
