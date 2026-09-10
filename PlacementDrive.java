public class PlacementDrive {

    private int driveId;
    private int companyId;
    private String jobRole;
    private double packageAmount;
    private double minimumCgpa;
    private String driveDate;

    public PlacementDrive(int driveId, int companyId,
                          String jobRole, double packageAmount,
                          double minimumCgpa, String driveDate) {
        this.driveId = driveId;
        this.companyId = companyId;
        this.jobRole = jobRole;
        this.packageAmount = packageAmount;
        this.minimumCgpa = minimumCgpa;
        this.driveDate = driveDate;
    }

    public int getDriveId() {
        return driveId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public double getPackageAmount() {
        return packageAmount;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    public String getDriveDate() {
        return driveDate;
    }

    public void displayDrive(String companyName) {
        System.out.println("----------------------------------------");
        System.out.println("Drive ID: " + driveId);
        System.out.println("Company Name: " + companyName);
        System.out.println("Job Role: " + jobRole);
        System.out.println("Package: " + packageAmount + " LPA");
        System.out.println("Minimum CGPA: " + minimumCgpa);
        System.out.println("Drive Date: " + driveDate);
    }
}