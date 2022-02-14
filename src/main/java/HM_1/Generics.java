package HM_1;
/*1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        2. Написать метод, который преобразует массив в ArrayList;
        3. Большая задача:
        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
        g. Не забываем про метод добавления фрукта в коробку.*/

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Generics {
    public static void main(String[] args) {

        //№1
        Object [] arr1 = new Object[]{1, 2, 3, 4, 5, 6};
        reverseElements(arr1,3,2);
        System.out.println(Arrays.toString(arr1));

        //№2
        Object [] arr2 =new Object[]{1, "2", 3, '4', 5, 6};
        arrayToList(arr2);
        Arrays.stream(arr2).forEach(System.out::println);

        //№3
        Apple apple = new Apple();
        Orange orange = new Orange();
        BoxWithFruit boxWithFruit = new BoxWithFruit();
        BoxWithFruit boxWithFruit2 = new BoxWithFruit();
        boxWithFruit.putFruit(apple);
        boxWithFruit.putFruit(apple);
        boxWithFruit.putFruit(apple);
        boxWithFruit.getWeight(apple);
        boxWithFruit2.pourOverTheFruit(boxWithFruit);








    }

    protected static Object [] reverseElements (Object [] array, int firstIndexElement, int secondIndexElement){ //№1
       Object oneVal = array[firstIndexElement];
       array[firstIndexElement] = array[secondIndexElement];
       array[secondIndexElement] = oneVal;
     return array;
 }

    protected static <T> ArrayList<T> arrayToList(T[] array) { //№2
        return new ArrayList<>(Arrays.asList(array));
    }
}
