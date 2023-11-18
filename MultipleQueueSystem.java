import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

class MultipleQueueSystem {
    List<Queue<Patient>> queues;
    ServicePoint[] servicePoints;
    Random random;
    List<Patient> servedPatients = new ArrayList<>();

    public MultipleQueueSystem(int queueCount, int servicePointCount) {
        queues = new ArrayList<>();
        for (int i = 0; i < queueCount; i++) {
            queues.add(new LinkedList<>());
        }

        servicePoints = new ServicePoint[servicePointCount];
        for (int i = 0; i < servicePointCount; i++) {
            servicePoints[i] = new ServicePoint(i + 1);
        }
    }

    public void enqueuePatient(int queueIndex, Patient patient) {
        queues.get(queueIndex).add(patient);
        System.out.println("Patient " + patient.id + " enqueued to Queue " + queueIndex +
                " (Arrival Time: " + patient.arrivalTime + " seconds)");
    }

    public void simulateService() {
        int timeElapsed = 0;
        int maxSimulationDuration = 10000; // Set a maximum simulation duration in iterations

        while (timeElapsed < maxSimulationDuration) {
            boolean allQueuesEmpty = true;

            for (int i = 0; i < servicePoints.length; i++) {
                if (!queues.get(i).isEmpty()) {
                    allQueuesEmpty = false;
                    Patient patient = queues.get(i).poll();
                    servicePoints[i].servePatient(patient);
                    servedPatients.add(patient);
                }
            }

            if (allQueuesEmpty) {
                System.out.println("Simulation ended: All queues are empty.");
                break;
            }

            try {
                Thread.sleep(1000); // Simulating time passing in milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            timeElapsed++;
        }
    }

    public String printStatistics() {
        StringBuilder statistics = new StringBuilder();
        double totalWaitingTime = 0;
        double totalServingTime = 0;

        for (Patient patient : servedPatients) {
            totalWaitingTime += patient.waitingTime;
            totalServingTime += patient.serviceTime;
            statistics.append("Patient ").append(patient.id)
                    .append(" - Waiting Time: ").append(patient.waitingTime).append(" seconds, ")
                    .append("Serving Time: ").append(patient.serviceTime).append(" seconds")
                    .append(System.lineSeparator());
        }

        double totalSystemTime = totalWaitingTime + totalServingTime;
        double averageWaitingTime = totalWaitingTime / servedPatients.size();
        double averageServingTime = totalServingTime / servedPatients.size();

        statistics.append("Total System Time: ").append(totalSystemTime).append(" seconds").append(System.lineSeparator());
        statistics.append("Average Waiting Time: ").append(averageWaitingTime).append(" seconds").append(System.lineSeparator());
        statistics.append("Average Serving Time: ").append(averageServingTime).append(" seconds").append(System.lineSeparator());

        return statistics.toString();
    }
}
