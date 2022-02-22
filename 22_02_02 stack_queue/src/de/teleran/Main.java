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
     * @param brackets
     * @return
     */

    // необходимо использовать стек для хранения открытых в данный момент скобок.
    public boolean areBracketsCorrect(char[] brackets) {


        Deque<Character> bracket = new ArrayDeque<>();

        for(char letter: bracket){
            if(letter=='('|| letter=='{' || letter=='[')
                bracket.addFirst(letter);
            else if (letter==')'&&bracket.getFirst()=='(' ||
                    letter=='}'&&bracket.getFirst()=='{' ||
                    letter==']'&&bracket.getFirst()=='[')
                bracket.removeFirst();

        }
        if (bracket.size()==0)
            return true;

        return false;
    }


}

