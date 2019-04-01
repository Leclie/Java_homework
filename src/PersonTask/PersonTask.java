package PersonTask;


// написать генератор списка объектов класса Person
// Сортировать объекты Person по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании

import java.io.IOException;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

class Person {
    String name;
    int age;
    int salary;
    String company;

    public Person(String name, int age, int salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                salary == person.salary &&
                Objects.equals(name, person.name) &&
                Objects.equals(company, person.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, company);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                '}';
    }
}
class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class PersonCompanyComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}

class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class PersonSalaryomparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}






public class PersonTask {
    public static void main(String[] args){
        // 1 сортировка
        Comparator<Person> personComparator = new PersonNameComparator();
        TreeSet<Person> personTreeSet = new TreeSet<>(personComparator);

        personTreeSet.add(new Person("Jack", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet.add(new Person("Bob", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet.add(new Person("Josh", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet.add(new Person("Kris", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet.add(new Person("Anger", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));

        for (Person p: personTreeSet) {
            System.out.println(p);
        }

        // 2 сортировка
        Comparator<Person> personComparator2 = new PersonNameComparator()
                .thenComparing(new PersonSalaryomparator());
        TreeSet<Person> personTreeSet2 = new TreeSet<>(personComparator2);

        personTreeSet2.add(new Person("Jack", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet2.add(new Person("Bob", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet2.add(new Person("Josh", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet2.add(new Person("Kris", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet2.add(new Person("Anger", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        System.out.println();
        for (Person p: personTreeSet2) {
            System.out.println(p);
        }

        // 3 сортировка
        Comparator<Person> personComparator3 = new PersonNameComparator()
                .thenComparing(new PersonSalaryomparator())
                .thenComparing(new PersonAgeComparator())
                .thenComparing(new PersonCompanyComparator());
        TreeSet<Person> personTreeSet3 = new TreeSet<>(personComparator3);

        personTreeSet3.add(new Person("Jack", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet3.add(new Person("Bob", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet3.add(new Person("Josh", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet3.add(new Person("Kris", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        personTreeSet3.add(new Person("Anger", (int)(Math.random()*50+10), (int)(Math.random()*5000+1000), "Epam"));
        System.out.println();
        for (Person p: personTreeSet3) {
            System.out.println(p);
        }
    }
}
