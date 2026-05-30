class Car
{
    // Attributes

    String make;
    String model;
    int year;

    // Method

    void displayDetails()
    {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println();
    }

    public static void main(String[] args)
    {
        // Object 1

        Car car1 = new Car();

        car1.make = "Toyota";
        car1.model = "Corolla";
        car1.year = 2020;

        // Object 2

        Car car2 = new Car();

        car2.make = "Honda";
        car2.model = "Civic";
        car2.year = 2022;

        // Method Call

        car1.displayDetails();

        car2.displayDetails();
    }
}