import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int queueCount = 3;
        int servicePointCount = 3;

        MultipleQueueSystem system = new MultipleQueueSystem(queueCount, servicePointCount);

        // Example: Enqueue 10 patients to different queues
        for (int i = 1; i <= 10; i++) {
            int queueIndex = new Random().nextInt(queueCount);
            Patient patient = new Patient(i);
            system.enqueuePatient(queueIndex, patient);
        }

        // Start the simulation
        system.simulateService();

        System.out.println("Simulation Complete");
    }
}