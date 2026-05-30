import java.util.List;
import java.util.stream.Collectors;

// Record Definition

record Person(String name, int age)
{
}

class RecordsExample
{
    public static void main(String[] args)
    {
        // Create record instances

        Person p1 =
        new Person("Ravi",22);

        Person p2 =
        new Person("Priya",17);

        Person p3 =
        new Person("Arun",25);

        // Print records

        System.out.println(p1);

        System.out.println(p2);

        System.out.println(p3);

        // Store in List

        List<Person> people =
        List.of(p1,p2,p3);

        // Stream filtering

        List<Person> adults =
        people.stream()
              .filter(
              person -> person.age() >= 18)
              .collect(
              Collectors.toList());

        System.out.println(
        "\nAdults:");

        adults.forEach(
        System.out::println);
    }
}