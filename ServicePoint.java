class ServicePoint {
    private int id;

    public ServicePoint(int id) {
        this.id = id;
    }

    public void servePatient(Patient patient) {
        // Simulate serving the patient
        String time = String.format("%.3f", patient.serviceTime);
        System.out.println("Service Point " + id + " serving Patient " + patient.id +
                " (Service Time: %.3f" + time + " seconds)");
        try {
            Thread.sleep((long)(patient.serviceTime * 1000)); // Simulating service time in seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Service Point " + id + " finished serving Patient " + patient.id);
    }
}