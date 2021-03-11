package ru.pa4ok;

import java.util.*;

public class Main
{
    /*
        ALT + INSERT - автогенерация (алт. пр. кнопка мышки -> generate)
        ALT + ENTER - вызов меню с возможными решениями ошибки
     */

    public static void main(String[] args)
    {
        List<TestClass> list = new ArrayList<>();

        for(int i=0; i<10; i++) {
            list.add(new TestClass());
        }

        System.out.println(list);

        //вариант 1, не требует ничего дополнительного
        /*Collections.sort(list, new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                //-1 o1 < 02
                //0 o1 == o2
                //1 o1 > o2
                return Integer.compare(o1.getI(), o2.getI());
            }
        });

        //одинаковый код с тем что выше
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.getI(), o2.getI()));

        //опять одинаковый
        Collections.sort(list, Comparator.comparingInt(TestClass::getI));*/

        //вариант 2
        //класс, который хранится в колекции
        //должен реализовавывать интерфейс Comparable
        Collections.sort(list);

        /*
            2 метода
            1 более подходит если у вас много различных правил для сортировки
            2 подходит если колекция с выбранным типом всегда сортируется одинаково
         */

        System.out.println(list);
    }
}

class TestClass implements Comparable<TestClass>
{
    private int i;

    public TestClass(int i) {
        this.i = i;
    }

    public TestClass() {
        this(new Random().nextInt(1000));
    }

    @Override
    public int compareTo(TestClass o) {
        return Integer.compare(this.i, o.getI());
    }

    /*

        Так как мы не можем сравнить сложные объекты через ==
        нам нужно сравнивать их через equals
        для ваших классов вы можете через ALT + INSERT
        сгенерировать готовые методы для сравнения с учетом полей

     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestClass testClass = (TestClass) o;
        return i == testClass.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

    //

    @Override
    public String toString() {
        return "TestClass{" +
                "i=" + i +
                '}';
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}