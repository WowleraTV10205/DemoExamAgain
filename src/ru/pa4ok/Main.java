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
        //int float double boolean long char //0, false, ''
        //Integer Float Double Boolean Long Character //null

        /*List<TestClass> list = new ArrayList<>();

        list.add(new TestClass());
        list.add(new TestClass());
        list.add(new TestClass());
        list.add(new TestClass());
        TestClass test = new TestClass();
        list.add(test);
        //System.out.println(list);

        list.remove(2); //удаление по индексу
        list.remove(test); //удаление по объекту*/

        //int size = list.size();
        //list.clear();
        //boolean isEmpty = list.isEmpty();
        //boolean contains = list.contains(test);

        //System.out.println(list);

        /*for(TestClass t : list)
        {
            t.setI(t.getI() + 100);
        }*/

        /*for(int i=0; i<list.size(); i++)
        {
            TestClass t = list.get(i);
            t.setI(t.getI() + 100);
        }*/

        //3 способа удаления элементов из списка при его переборе

        //1 способ, развернуть цикл
        /*for(int i=list.size()-1; i>=0; i--)
        {
            TestClass t = list.get(i);
            if(i == 1) {
                list.remove(1);
            }
        }*/

        //2 временная коллекция для удаления
        /*List<TestClass> toRemove = new ArrayList<>();
        for(TestClass t : list) {
            if(t.getI() > 500) {
                toRemove.add(t);
            }
        }
        list.removeAll(toRemove);*/

        //3 removeIf
        //list.removeIf(testClass -> testClass.getI() > 500);

        //System.out.println(list);


        //абсолютно такой же список, но
        //не могут храниться повторяющиеся элементы
        Set<TestClass> set = new HashSet<>();

        TestClass t = new TestClass(55);

        set.add(new TestClass(55));
        set.add(new TestClass(55));
        set.add(new TestClass(55));


        /*set.add(t);
        set.add(t);
        set.add(t);*/


        set.add(new TestClass());
        set.add(new TestClass());
        set.add(new TestClass());
        set.add(new TestClass());

        System.out.println(set);
    }
}

class TestClass
{
    private int i;

    public TestClass(int i) {
        this.i = i;
    }

    public TestClass() {
        this(new Random().nextInt(1000));
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