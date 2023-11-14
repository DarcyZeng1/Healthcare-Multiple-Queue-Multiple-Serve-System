import java.util.Random;

class Patient {
    int id;
    double serviceTime;
    double arrivalTime;
    double startTime;
    double endTime;
    double waitingTime;
    double meanServiceTime = 20;
    double stdServiceTime = 5;
    Random random = new Random();

    public Patient(int id, double arrivalTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = Math.max(0, meanServiceTime + random.nextGaussian() * stdServiceTime);
    }
}
