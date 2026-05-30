import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LambdaExpressions
{
    public static void main(String[] args)
    {
        List<String> names =
        new ArrayList<>();

        names.add("Banana");
        names.add("Apple");
        names.add("Orange");
        names.add("Mango");

        Collections.sort(
        names,
        (a,b) -> a.compareTo(b)
        );

        System.out.println(
        "Sorted List:");

        for(String name : names)
        {
            System.out.println(name);
        }
    }
}