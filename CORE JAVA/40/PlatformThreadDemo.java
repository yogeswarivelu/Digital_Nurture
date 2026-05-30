public class PlatformThreadDemo {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= 100000; i++) {

            int threadNumber = i;

            Thread t = new Thread(() -> {

                System.out.println(
                        "Platform Thread: " + threadNumber
                );
            });

            t.start();
        }

        long endTime = System.currentTimeMillis();

        System.out.println(
                "\nTime Taken: "
                        + (endTime - startTime)
                        + " ms"
        );
    }
}