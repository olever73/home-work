package de.teleran.list;

import org.junit.jupiter.api.BeforeEach;

class AdvancedArrayListTest extends CustomListTest {
    @BeforeEach
    public void init() {
        intList = new AdvancedArrayList<>();
        stringList = new AdvancedArrayList<>();
    }
}