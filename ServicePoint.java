class ServicePoint {
    private int id;

    public ServicePoint(int id) {
        this.id = id;
    }

    public void servePatient(Patient patient) {
        // Simulate serving the patient
        System.out.println("Service Point " + id + " serving Patient " + patient.id +
                " (Service Time: " + patient.serviceTime + " units)");
        try {
            Thread.sleep(patient.serviceTime * 1000); // Simulating service time in seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Service Point " + id + " finished serving Patient " + patient.id);
    }
}