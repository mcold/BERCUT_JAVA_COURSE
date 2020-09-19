/**
 * Создать класс Person с полями: name, surname, age.
 * Имплементировать интерфейс Comparable, используя поля surname, name
 * Добавить несколько объектов Person в List
 * Вывести
 * 1) неотсортированный список,
 * 2) список, отсортированный по name,
 * 3) список, отсортированный по surname,
 * 4) список, отсортированный по age
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Person implements Comparable<Person>{
    private String name;
    private String surname;
    private Integer age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Person(String name, String surname, Integer age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        int result = p.surname.compareTo(this.surname);
        if(result == 0){
            return p.name.compareTo(this.name);
        }else{
            return result;
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> pArr = new ArrayList<Person>(){
            {
                add(new Person("Jhon", "Snow", 17));
                add(new Person("Sam", "Tarly", 18));
                add(new Person("Tirion", "Lanister", 30));
                add(new Person("Arya", "Stark", 12));
                add(new Person("Walder", "Frey", 99));
                add(new Person("Tiwen", "Lanister", 55));
                add(new Person("Eddard", "Stark",45));
            }
        };

        //неотсортированный список
        System.out.println("Неотсортированный список");
        System.out.println("------------------------------");
        for(int i = 0; i < pArr.size(); i++){
            System.out.println(pArr.toArray()[i]);
        }
        System.out.println("------------------------------");
        System.out.println();

        // сортировка по имени
        System.out.println("Сортировка по имени");
        System.out.println("------------------------------");
        Comparator nameComparator = new PersonNameComparator();
        Collections.sort(pArr, nameComparator);
        for(int i = 0; i < pArr.size(); i++){
            System.out.println(pArr.toArray()[i]);
        }

        System.out.println("------------------------------");
        System.out.println();

        // сортировка по фамилии
        System.out.println("Сортировка по фамилии");
        System.out.println("------------------------------");
        Comparator surnameComparator = new PersonSurnameComparator();
        Collections.sort(pArr, surnameComparator);
        for(int i = 0; i < pArr.size(); i++){
            System.out.println(pArr.toArray()[i]);
        }
        System.out.println("------------------------------");
        System.out.println();

        // сортировка по возрасту
        System.out.println("Сортировка по возрасту");
        System.out.println("------------------------------");
        Comparator ageComparator = new PersonAgeComparator();
        Collections.sort(pArr, ageComparator);
        for(int i = 0; i < pArr.size(); i++){
            System.out.println(pArr.toArray()[i]);
        }
        System.out.println("------------------------------");
        System.out.println();

    }
}

class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class PersonSurnameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getSurname().compareTo(p2.getSurname());
    }
}


class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge().compareTo(p2.getAge());
    }
}
