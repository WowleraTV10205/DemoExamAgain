package ru.pa4ok;

import java.util.*;

public class Main
{
    /*
        Library
        - String title
        - String address
        - List<Book> books
        - Set<Author> authors
        - public void addBook(Book book)
            добавить книгу в список
            если в authors еще не было такого автора
            то вывести в консоль информацию о нем
            и добавить его в authors
        - public List<Book> getAuthorBooks(Author author)
            метод должен вернуть список всех книг автора
        - public int deleteAuthorBooks(Author author)
            метод должен удалить все книги автора
            и самого автора из сета
            возвращаемое значение - колво удаленных книг

        Author
        - String name

        Book
        - String title
        - Author author
        - int pages
     */

    public static void main(String[] args)
    {
        //int float long double boolean char //0, false, ''
        //Integer Float Long Double Boolean Character //null

        /*List<TestClass> list = new ArrayList<>();

        list.add(new TestClass());
        list.add(new TestClass());
        list.add(new TestClass(55));
        list.add(new TestClass());
        list.add(new TestClass());


        System.out.println(list);*/

        //list.remove(1); //удаление по индексу
        //list.remove(new TestClass(55)); //удаление по объекту

        //TestClass t = list.get(4);
        //list.size();
        //list.clear();
        //list.isEmpty();
        //list.contains(new TestClass(55));

        //java 9+
        //List<String> l1 = List.of(...);

        //java 8
        //тут будет ошибка из-за того что Arrays.asList возвращает реализацию List без части методов
        //List<String> l1 = Arrays.asList("grrgerggr", "frfrerfeerfg");
        //l1.add("grtgregrgereg");
        //можно исправить обернув в ArrayList
        //List<String> l1 = new ArrayList<>(Arrays.asList("grrgerggr", "frfrerfeerfg"));
        //l1.add("grtgregrgereg");
        //System.out.println(l1);

        //System.out.println(list);

        /*ClassWithList1 classWithList1 = new ClassWithList1();
        classWithList1.list.add(new TestClass());

        ClassWithList4 classWithList4 = new ClassWithList4();
        ClassWithList4 ClassWithList4d1 = new ClassWithList4(new TestClass());
        ClassWithList4 ClassWithList4d2 = new ClassWithList4(new TestClass(), new TestClass(), new TestClass());*/

        //проблема удаления объектов из коллекции при ее переборе

        //ConcurrentModificationException
        /*for(TestClass t : list) {
            if(t.getI() > 500) {
                list.remove(t);
            }
        }*/

        //OutOfBoundsException + пропускаем элементы после удаления
        /*int size = list.size();
        for(int i=0; i<size; i++) {
            TestClass t = list.get(i);
            if(t.getI() > 500) {
                list.remove(i);
            }
        }*/

        //вариант 1, разворот цикла с конца в начало
        /*int size = list.size();
        for(int i=size-1; i>=0; i--) {
            TestClass t = list.get(i);
            if(t.getI() > 500) {
                list.remove(i);
            }
        }*/

        //вариант 2, временная коллекция
        /*List<TestClass> toRemove = new ArrayList<>();
        for(TestClass t : list) {
            if(t.getI() > 500) {
                toRemove.add(t);
            }
        }
        list.removeAll(toRemove);*/

        //вариант 3, прокаченный вариант 2
        //list.removeIf(testClass -> testClass.getI() > 500);

        //System.out.println(list);

        /*
            Set - коллекция похожая на List
            у нее нет части методов и она не хранит повторяющиеся объекты
            в сете не оригинальный порядок хранения элементов
         */

        Set<TestClass> set = new HashSet<>();
        set.add(new TestClass());
        set.add(new TestClass());
        set.add(new TestClass(55));
        set.add(new TestClass(55));
        set.add(new TestClass());
        set.add(new TestClass());
        System.out.println(set);

        for(TestClass t : set) {
            //...
        }

        boolean hasRemoved = set.remove(new TestClass(55));
        boolean hasAdded = set.add(new TestClass(55));

        List<TestClass> list = new ArrayList<>(set);
    }
}

class ClassWithList1
{
    public List<TestClass> list = new ArrayList<>();

    public ClassWithList1() {
    }
}

class ClassWithList2
{
    public List<TestClass> list;

    public ClassWithList2(List<TestClass> list) {
        this.list = list;
    }

    public ClassWithList2() {
        this(new ArrayList<>());
    }
}

class ClassWithList3
{
    public List<TestClass> list;

    public ClassWithList3(TestClass[] testClasses) {
        list = new ArrayList<>(Arrays.asList(testClasses));
    }
}

class ClassWithList4
{
    public List<TestClass> list;

    public ClassWithList4(TestClass... testClasses) {
        list = new ArrayList<>(Arrays.asList(testClasses));
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
