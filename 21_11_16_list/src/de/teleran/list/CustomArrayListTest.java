package de.teleran.list;

import org.junit.jupiter.api.BeforeEach;

class CustomArrayListTest extends CustomListTest{
    @BeforeEach
    public void init() {
        intList = new CustomArrayList<>();
        stringList = new AdvancedArrayList<>();
    }


}