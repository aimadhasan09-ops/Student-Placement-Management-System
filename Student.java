public class Student {

    private int studentId;
    private String name;
    private String email;
    private String department;
    private double cgpa;
    private String placementStatus;
    private String placedCompany;

    public Student(int studentId, String name, String email,
                   String department, double cgpa) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.cgpa = cgpa;
        this.placementStatus = "Not Placed";
        this.placedCompany = "Not Available";
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getPlacementStatus() {
        return placementStatus;
    }

    public String getPlacedCompany() {
        return placedCompany;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setPlacementStatus(String placementStatus) {
        this.placementStatus = placementStatus;
    }

    public void setPlacedCompany(String placedCompany) {
        this.placedCompany = placedCompany;
    }

    public void displayStudent() {
        System.out.println("----------------------------------------");
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Placement Status: " + placementStatus);
        System.out.println("Placed Company: " + placedCompany);
    }
}