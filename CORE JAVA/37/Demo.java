public class Demo {

    public int add(int a, int b) {

        return a + b;
    }

    public static void main(String[] args) {

        Demo d = new Demo();

        int result = d.add(10, 20);

        System.out.println("Sum = " + result);
    }
}