import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

class MultipleQueueSystem {
    List<Queue<Patient>> queues;
    ServicePoint[] servicePoints;
    Random random;

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
        System.out.println("Patient " + patient.id + " enqueued to Queue " + queueIndex);
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
    //doing distribution, but still testing
    public void simulatePatientArrivals(int queueIndex, double lambda, int maxArrivalTime) {
        int arrivalTime = 0;
        int patient_id = 1;
        while (arrivalTime < maxArrivalTime) {
            Patient patient = new Patient(patient_id);
            enqueuePatient(queueIndex, patient);
            try {
                Thread.sleep((long) (-Math.log(1 - random.nextDouble()) / lambda));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrivalTime += 1;
        }
    }
    
}