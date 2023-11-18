import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int queueCount = 3;
        int servicePointCount = 3;

        MultipleQueueSystem system = new MultipleQueueSystem(queueCount, servicePointCount);

        // Example: Enqueue 10 patients to different queues
        double arrivalTime = 0;
        for (int i = 1; i <= 10; i++) {
            int queueIndex = new Random().nextInt(queueCount);
            Patient patient = new Patient(i, arrivalTime);
            arrivalTime += patient.serviceTime; // Adjust arrival time based on service time
            system.enqueuePatient(queueIndex, patient);
        }

        // Start the simulation
        system.simulateService();

        // Calculate and print statistics
        String output = system.printStatistics();

        writeTheFile("output.csv", output);

        System.out.println("Simulation Complete");
    }

    private static void writeTheFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("The output written to" + filename);

            System.out.println("Output:\n" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
