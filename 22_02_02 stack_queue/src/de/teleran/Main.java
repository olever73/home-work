package de.teleran;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    /**
     * Метод принимает массив, состоящий из трех видов скобок (6 различных символов): (), {}, []. Необходимо определить, является
     * ли порядок скобок в массиве корректным.
     * <p>
     * {}([]) - корректный порядок
     * {}([]{()}) - корректный порядок
     * {(] - некорректный порядок
     * {}([])} - некорректный порядок
     * {}([])( - некорректный порядок
     * {(}) - некорректный порядок
     *
     *
     * @return
     */

    // необходимо использовать стек для хранения открытых в данный момент скобок.
    public boolean balancedBrackets(String str){
        char[] chars = str.toCharArray();
        Deque<Character> brackets = new ArrayDeque<>();

        for(char letter: chars){
            if(letter=='('|| letter=='{' || letter=='[')
                brackets.addFirst(letter);
            else if (letter==')'&&brackets.getFirst()=='(' ||
                    letter=='}'&&brackets.getFirst()=='{' ||
                    letter==']'&&brackets.getFirst()=='[')
                brackets.removeFirst();

        }
        if (brackets.size()==0)
            return true;

        return false;
    }


}
class EmptyListExeption extends Exception {}


