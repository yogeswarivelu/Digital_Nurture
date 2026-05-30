public class Hello {

    public String greet(String name) {

        return "Hello, " + name;
    }

    public static void main(String[] args) {

        Hello h = new Hello();

        System.out.println(h.greet("Rahul"));
    }
}