class TypeCastingExample
{
    public static void main(String[] args)
    {
        // Double to Int

        double num1 = 45.89;

        int convertedInt = (int) num1;

        System.out.println("Double Value: " + num1);

        System.out.println("After Casting to Int: " + convertedInt);


        // Int to Double

        int num2 = 100;

        double convertedDouble = (double) num2;

        System.out.println("Integer Value: " + num2);

        System.out.println("After Casting to Double: " + convertedDouble);
    }
}