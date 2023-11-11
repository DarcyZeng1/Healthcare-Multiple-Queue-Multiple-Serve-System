import java.util.Random;

class Patient {
    int id;
    double serviceTime;
    double meanServiceTime = 20;
    double stdServiceTime = 5;
    Random random = new Random();

    public Patient(int id) {
        this.id = id;
        this.serviceTime = Math.max(0, meanServiceTime + random.nextGaussian() * stdServiceTime);
    }
}