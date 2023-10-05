package com.org.core.java.demo.multithreading.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelRestCall {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a ThreadPoolExecutor with a fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Create a list of Callable tasks
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(new RestApiTask("https://api.example.com/endpoint1"));
        tasks.add(new RestApiTask("https://api.example.com/endpoint2"));
        tasks.add(new RestApiTask("https://api.example.com/endpoint3"));

        // Invoke all tasks in parallel
        List<Future<String>> results = executor.invokeAll(tasks);

        // Process results or handle exceptions here

        // Shutdown the executor when done
        executor.shutdown();
    }
}

class RestApiTask implements Callable<String> {
    private final String apiUrl;

    public RestApiTask(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Override
    public String call() throws Exception {
        // Make the REST call and return the response
        // Implement your REST logic here
        return "Response from " + apiUrl;
    }
}
