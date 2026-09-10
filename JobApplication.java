public class JobApplication {

    private int applicationId;
    private int studentId;
    private int driveId;
    private String applicationStatus;

    public JobApplication(int applicationId, int studentId, int driveId) {
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.driveId = driveId;
        this.applicationStatus = "Applied";
    }

    public int getApplicationId() {
        return applicationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getDriveId() {
        return driveId;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public void displayApplication(String studentName, String companyName,
                                   String jobRole) {
        System.out.println("----------------------------------------");
        System.out.println("Application ID: " + applicationId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Company Name: " + companyName);
        System.out.println("Job Role: " + jobRole);
        System.out.println("Application Status: " + applicationStatus);
    }
}