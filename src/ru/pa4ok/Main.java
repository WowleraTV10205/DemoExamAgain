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
        - public void sortBooksByPages(boolean reverse)
            сортирует books, если reverse == false, то от меньшего к большему
            если reverse == true - наоборот
        - public void sortBooksByTitle()
            сортирует книги по алфавиту (название)
        - public void shuffle()
            рандомно размешивает коллекции

        Author
        - String name

        Book
        - String title
        - Author author
        - int pages
     */

    public static void main(String[] args)
    {
        List<TestClass> list = new ArrayList<>();

        for(int i=0; i<10; i++) {
            list.add(new TestClass());
        }

        System.out.println(list);

        /*
            есть 2 варианта сортировки
            первый - мы передаем коллекцию и компаратор
            подходит в ситуациях, когда есть много разных вариантов сортировки
            второй - мы передаем только коллекцию
            но класс хранящийся в коллекции обязан реализовывать интерфейс Comparable
            подходит, когда коллеция с опр. типом всегда сортируется одинаково
         */

        /*Collections.sort(list, new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                //-1 o1 < o2
                //0 o1 == o2
                //1 o1 > o2
                return Integer.compare(o1.getI(), o2.getI());
            }
        });*/

        //тоже самое что и сверху
        //Collections.sort(list, (o1, o2) -> Integer.compare(o1.getI(), o2.getI()));

        //опять тоже самое
        //Collections.sort(list, Comparator.comparingInt(TestClass::getI));

        Collections.sort(list);
        System.out.println(list);

        //рандомно размешивает коллекцию
        Collections.shuffle(list);
        System.out.println(list);

        //строки сравниваются через интерфейс Comparable
        //через вызов метода compareTo у 1 из строк
        /*Collections.sort(list, new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                String s1 = "efgegfreg";
                String s2 = "jytkjytu";
                return s1.compareTo(s2);
            }
        });*/
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
