class MethodOverloading
{
    // Two integers

    static int add(int a, int b)
    {
        return a + b;
    }

    // Two doubles

    static double add(double a, double b)
    {
        return a + b;
    }

    // Three integers

    static int add(int a, int b, int c)
    {
        return a + b + c;
    }

    public static void main(String[] args)
    {
        System.out.println(
        "Two Integers: "
        + add(10,20));

        System.out.println(
        "Two Doubles: "
        + add(10.5,20.7));

        System.out.println(
        "Three Integers: "
        + add(10,20,30));
    }
}