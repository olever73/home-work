package de.teleran.list;

import org.junit.jupiter.api.BeforeEach;

public class CastomLinkedListTest extends CustomListTest{
    @BeforeEach
    public void init() {
        intList = new CustomLinkedList<>();
        stringList = new CustomLinkedList<>();
    }
}
