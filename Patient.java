import java.util.Random;

class Patient {
    int id;
    int serviceTime;

    public Patient(int id) {
        this.id = id;
        this.serviceTime = new Random().nextInt(5) + 1; // Random service time (1 to 5 units)
    }
}