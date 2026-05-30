import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {

    public static void main(String[] args) {

        try {

            // Load Class Dynamically
            Class<?> cls = Class.forName("Student");

            System.out.println("Class Name: " + cls.getName());

            // Get All Declared Methods
            Method[] methods = cls.getDeclaredMethods();

            System.out.println("\nMethods in Class:");

            for (Method method : methods) {

                // Print Method Name
                System.out.println("\nMethod Name: "
                        + method.getName());

                // Print Return Type
                System.out.println("Return Type: "
                        + method.getReturnType());

                // Print Parameters
                Parameter[] params = method.getParameters();

                System.out.println("Parameters:");

                for (Parameter p : params) {

                    System.out.println(
                            p.getType().getSimpleName()
                    );
                }
            }

            // Create Object Dynamically
            Object obj = cls.getDeclaredConstructor().newInstance();

            // Get Specific Method
            Method m = cls.getMethod(
                    "display",
                    String.class,
                    int.class
            );

            // Invoke Method Dynamically
            System.out.println("\nInvoking display() Method:\n");

            m.invoke(obj, "Rahul", 21);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}