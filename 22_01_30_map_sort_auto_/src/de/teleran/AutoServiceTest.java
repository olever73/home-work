package de.teleran;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AutoServiceTest {
    private final Auto car_1 = new Auto("Opel", "Astra",12000);
    private final Auto car_2 = new Auto("BMW", "White",15000);
    private final Auto car_3 = new Auto("Audi", "Red",17000);
    private final Auto car_4 = new Auto("Audi", "Blue",20000);
    private final Auto car_5 = new Auto("BMW", "Black",30000);


    AutoService autoService = new AutoService();

    @Test
    void testGroupByMake_size_of_generated_map() {
        final List<Auto> autos = new ArrayList<>();
        autos.add(car_1);
        autos.add(car_2);
        assertEquals(2, autoService.groupByMake(autos).size());

        autos.add(car_1);
        autos.add(car_2);
        autos.add(car_3);
        assertEquals(3, autoService.groupByMake(autos).size());

        autos.add(car_1);
        autos.add(car_2);
        autos.add(car_3);
        autos.add(car_4);
        autos.add(car_5);
        assertEquals(3, autoService.groupByMake(autos).size());
    }

    Auto opel1 = new Auto("Opel", "Corsa",13000);
    Auto opel2 = new Auto("Opel", "Astra",15000);
    Auto opel3 = new Auto("Opel", "Insignia",27000);
    Auto opel4 = new Auto("Opel", "Zafira",20000);
    Auto mazda1 = new Auto("Mazda", "CX-5",30000);
    Auto mazda2 = new Auto("Mazda", "6",31000);
    Auto mazda3 = new Auto("Mazda", "3",20000);
    ArrayList<Auto> list = new ArrayList<>();


    @Test
    public void test_groupByMake_CorrectKeys() {
        Collections.addAll(list, opel1, opel2, opel3, opel4, mazda1, mazda2, mazda3);
        Map<String, List<Auto>> res = autoService.groupByMake(list);
        HashSet<String> resKeys = new HashSet<>();
        resKeys.add("Opel");
        resKeys.add("Mazda");
        assertEquals(resKeys, res.keySet());
    }

    @Test
    public void test_groupByMake_CorrectValues_opel() {
        Collections.addAll(list, opel1, opel2, opel3, opel4, mazda1, mazda2, mazda3);
        Map<String, List<Auto>> res = autoService.groupByMake(list);
        List<Auto> expValues = new ArrayList<>();
        Collections.addAll(expValues, opel1, opel2, opel3, opel4);
        assertEquals(expValues, res.get("Opel"));
    }

    @Test
    public void test_groupByMake_CorrectValues_mazda() {
        Collections.addAll(list, opel1, opel2, opel3, opel4, mazda1, mazda2, mazda3);
        Map<String, List<Auto>> res = autoService.groupByMake(list);
        List<Auto> expValues = new ArrayList<>();
        Collections.addAll(expValues, mazda1, mazda2, mazda3);
        assertEquals(expValues, res.get("Mazda"));
    }


}