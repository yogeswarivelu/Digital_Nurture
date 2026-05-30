import java.util.concurrent.*;
import java.util.*;

public class CallableDemo {

    public static void main(String[] args) {

        // Create Fixed Thread Pool
        ExecutorService executor =
                Executors.newFixedThreadPool(5);

        List<Future<Integer>> futures =
                new ArrayList<>();

        // Submit Callable Tasks
        for (int i = 1; i <= 10; i++) {

            int number = i;

            Callable<Integer> task = () -> {

                // Simulate computation
                int result = number * number;

                System.out.println(
                        "Processing: " + number
                );

                Thread.sleep(500);

                return result;
            };

            Future<Integer> future =
                    executor.submit(task);

            futures.add(future);
        }

        // Collect Results
        for (Future<Integer> future : futures) {

            try {

                Integer result = future.get();

                System.out.println(
                        "Result: " + result
                );

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Shutdown Executor
        executor.shutdown();

        System.out.println("All tasks completed.");
    }
}