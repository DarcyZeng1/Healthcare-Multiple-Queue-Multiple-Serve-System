class ServicePoint {
    private int id;

    public ServicePoint(int id) {
        this.id = id;
    }

    public void servePatient(Patient patient) {
        patient.startTime = System.currentTimeMillis() / 1000.0; // Record start time in seconds
        // Simulate serving the patient
        String time = String.format("%.3f", patient.serviceTime);
        System.out.println("Service Point " + id + " serving Patient " + patient.id +
                " (Service Time: " + time + " seconds)");
        try {
            Thread.sleep((long)(patient.serviceTime * 1000)); // Simulating service time in seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        patient.endTime = System.currentTimeMillis() / 1000.0; // Record end time in seconds
        patient.waitingTime = patient.startTime - patient.arrivalTime;
        System.out.println("Service Point " + id + " finished serving Patient " + patient.id);
    }
}
