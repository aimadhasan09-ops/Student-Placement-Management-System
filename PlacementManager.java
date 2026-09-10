import java.util.ArrayList;

public class PlacementManager {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Company> companies = new ArrayList<>();
    private ArrayList<PlacementDrive> placementDrives = new ArrayList<>();
    private ArrayList<JobApplication> applications = new ArrayList<>();
    private ArrayList<Interview> interviews = new ArrayList<>();

    private InputHelper input;

    private int nextStudentId = 1;
    private int nextCompanyId = 1;
    private int nextDriveId = 1;
    private int nextApplicationId = 1;
    private int nextInterviewId = 1;

    public PlacementManager(InputHelper input) {
        this.input = input;
    }

    public void registerStudent() {
        System.out.println("\n--- Register Student ---");

        String name = input.readText("Enter student name: ");
        String email = input.readText("Enter student email: ");
        String department = input.readText("Enter department: ");
        double cgpa = input.readDouble("Enter CGPA: ");

        Student student = new Student(
                nextStudentId, name, email, department, cgpa
        );

        students.add(student);

        System.out.println("\nStudent registered successfully.");
        System.out.println("Student ID: " + nextStudentId);

        nextStudentId++;
    }

    public void viewStudentDetails() {
        System.out.println("\n--- Student Details ---");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }
    }

    public void updateStudentInformation() {
        System.out.println("\n--- Update Student Information ---");

        int studentId = input.readInt("Enter student ID: ");
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = input.readText("Enter new name: ");
        String email = input.readText("Enter new email: ");
        String department = input.readText("Enter new department: ");
        double cgpa = input.readDouble("Enter new CGPA: ");

        student.setName(name);
        student.setEmail(email);
        student.setDepartment(department);
        student.setCgpa(cgpa);

        System.out.println("Student information updated successfully.");
    }

    public void registerCompany() {
        System.out.println("\n--- Register Company ---");

        String companyName = input.readText("Enter company name: ");
        String location = input.readText("Enter company location: ");
        String contactEmail = input.readText("Enter company email: ");

        Company company = new Company(
                nextCompanyId, companyName, location, contactEmail
        );

        companies.add(company);

        System.out.println("\nCompany registered successfully.");
        System.out.println("Company ID: " + nextCompanyId);

        nextCompanyId++;
    }

    public void viewCompanyDetails() {
        System.out.println("\n--- Company Details ---");

        if (companies.isEmpty()) {
            System.out.println("No company records found.");
            return;
        }

        for (Company company : companies) {
            company.displayCompany();
        }
    }

    public void addPlacementDrive() {
        System.out.println("\n--- Add Placement Drive ---");

        if (companies.isEmpty()) {
            System.out.println("No company is registered.");
            System.out.println("Please use option 4 to register a company first.");
            return;
        }

        viewCompanyDetails();

        int companyId = input.readInt("Enter company ID for this drive: ");
        Company company = findCompanyById(companyId);

        if (company == null) {
            System.out.println("Company ID not found.");
            return;
        }

        String jobRole = input.readText("Enter job role: ");
        double packageAmount = input.readDouble("Enter package in LPA: ");
        double minimumCgpa = input.readDouble("Enter minimum CGPA required: ");
        String driveDate = input.readText("Enter drive date (DD-MM-YYYY): ");

        PlacementDrive drive = new PlacementDrive(
                nextDriveId,
                companyId,
                jobRole,
                packageAmount,
                minimumCgpa,
                driveDate
        );

        placementDrives.add(drive);

        System.out.println("\nPlacement drive added successfully.");
        System.out.println("Drive ID: " + nextDriveId);

        nextDriveId++;
    }

    public void viewAvailableJobs() {
        System.out.println("\n--- Available Jobs / Placement Drives ---");

        if (placementDrives.isEmpty()) {
            System.out.println("No placement drives available.");
            System.out.println("First register a company, then add a placement drive.");
            return;
        }

        for (PlacementDrive drive : placementDrives) {
            Company company = findCompanyById(drive.getCompanyId());

            if (company != null) {
                drive.displayDrive(company.getCompanyName());
            } else {
                System.out.println("Drive ID " + drive.getDriveId()
                        + " has an invalid company record.");
            }
        }
    }

    public void applyForJob() {
        System.out.println("\n--- Apply for a Job ---");

        if (students.isEmpty()) {
            System.out.println("No students registered. Register a student first.");
            return;
        }

        if (placementDrives.isEmpty()) {
            System.out.println("No placement drives available.");
            return;
        }

        int studentId = input.readInt("Enter student ID: ");
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("Student ID not found.");
            return;
        }

        viewAvailableJobs();

        int driveId = input.readInt("Enter placement drive ID: ");
        PlacementDrive drive = findDriveById(driveId);

        if (drive == null) {
            System.out.println("Placement drive ID not found.");
            return;
        }

        if (student.getCgpa() < drive.getMinimumCgpa()) {
            System.out.println("Student is not eligible for this placement drive.");
            System.out.println("Required CGPA: " + drive.getMinimumCgpa());
            System.out.println("Student CGPA: " + student.getCgpa());
            return;
        }

        if (hasAlreadyApplied(studentId, driveId)) {
            System.out.println("Student has already applied for this placement drive.");
            return;
        }

        JobApplication application = new JobApplication(
                nextApplicationId, studentId, driveId
        );

        applications.add(application);

        Company company = findCompanyById(drive.getCompanyId());
        String companyName = "Unknown Company";

        if (company != null) {
            companyName = company.getCompanyName();
        }

        System.out.println("\nApplication submitted successfully.");
        System.out.println(student.getName() + " applied for "
                + companyName + ".");
        System.out.println("Application ID: " + nextApplicationId);

        nextApplicationId++;
    }

    public void manageInterviewDetails() {
        System.out.println("\n--- Manage Interview Details ---");

        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            System.out.println("Use option 8 to apply for a job first.");
            return;
        }

        showApplications();

        int applicationId = input.readInt("Enter application ID: ");
        JobApplication application = findApplicationById(applicationId);

        if (application == null) {
            System.out.println("Application ID not found.");
            return;
        }

        String date = input.readText("Enter interview date (DD-MM-YYYY): ");
        String time = input.readText("Enter interview time: ");
        String round = input.readText("Enter interview round: ");

        Interview interview = new Interview(
                nextInterviewId,
                applicationId,
                date,
                time,
                round
        );

        interviews.add(interview);
        application.setApplicationStatus("Interview Scheduled");

        System.out.println("\nInterview scheduled successfully.");
        System.out.println("Interview ID: " + nextInterviewId);

        nextInterviewId++;
    }

    public void recordPlacementResult() {
        System.out.println("\n--- Record Placement Result ---");

        if (applications.isEmpty()) {
            System.out.println("No job applications found.");
            return;
        }

        showApplications();

        int applicationId = input.readInt("Enter application ID: ");
        JobApplication application = findApplicationById(applicationId);

        if (application == null) {
            System.out.println("Application ID not found.");
            return;
        }

        Student student = findStudentById(application.getStudentId());
        PlacementDrive drive = findDriveById(application.getDriveId());

        if (student == null || drive == null) {
            System.out.println("Student or placement drive record is missing.");
            return;
        }

        Company company = findCompanyById(drive.getCompanyId());

        if (company == null) {
            System.out.println("Company record is missing.");
            return;
        }

        String result = input.readText(
                "Enter result (Selected/Not Selected): "
        );

        if (result.equalsIgnoreCase("Selected")) {
            student.setPlacementStatus("Placed");
            student.setPlacedCompany(company.getCompanyName());
            application.setApplicationStatus("Selected");

            updateInterviewStatus(applicationId, "Selected");

            System.out.println("\nCongratulations " + student.getName() + "! 🎉");
            System.out.println("You are selected in " + company.getCompanyName() + ".");
            System.out.println("Application status updated successfully.");

        } else if (result.equalsIgnoreCase("Not Selected")) {
            application.setApplicationStatus("Not Selected");

            updateInterviewStatus(applicationId, "Not Selected");

            System.out.println("Result recorded: Not Selected.");
            System.out.println("Application status updated successfully.");

        } else {
            System.out.println("Invalid result.");
            System.out.println("Please enter only: Selected or Not Selected.");
        }
    }

    public void searchStudentRecord() {
        System.out.println("\n--- Search Student Record ---");

        int studentId = input.readInt("Enter student ID: ");
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.displayStudent();
    }

    public void generatePlacementReport() {
        System.out.println("\n--- Placement Report ---");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        int placedStudents = 0;

        for (Student student : students) {
            if (student.getPlacementStatus().equalsIgnoreCase("Placed")) {
                placedStudents++;
            }
        }

        System.out.println("----------------------------------------");
        System.out.println("Total Students: " + students.size());
        System.out.println("Total Companies: " + companies.size());
        System.out.println("Total Placement Drives: " + placementDrives.size());
        System.out.println("Total Job Applications: " + applications.size());
        System.out.println("Total Interviews: " + interviews.size());
        System.out.println("Placed Students: " + placedStudents);
        System.out.println("Not Placed Students: "
                + (students.size() - placedStudents));

        System.out.println("\n--- Placed Students ---");

        boolean foundPlacedStudent = false;

        for (Student student : students) {
            if (student.getPlacementStatus().equalsIgnoreCase("Placed")) {
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Name: " + student.getName());
                System.out.println("Company: " + student.getPlacedCompany());
                System.out.println("----------------------------------------");
                foundPlacedStudent = true;
            }
        }

        if (!foundPlacedStudent) {
            System.out.println("No students have been placed yet.");
        }
    }

    private void showApplications() {
        System.out.println("\n--- Job Applications ---");

        for (JobApplication application : applications) {
            Student student = findStudentById(application.getStudentId());
            PlacementDrive drive = findDriveById(application.getDriveId());

            if (student == null || drive == null) {
                continue;
            }

            Company company = findCompanyById(drive.getCompanyId());

            String studentName = student.getName();
            String companyName = "Unknown Company";
            String jobRole = drive.getJobRole();

            if (company != null) {
                companyName = company.getCompanyName();
            }

            application.displayApplication(studentName, companyName, jobRole);
        }
    }

    private void updateInterviewStatus(int applicationId, String status) {
        for (Interview interview : interviews) {
            if (interview.getApplicationId() == applicationId) {
                interview.setInterviewStatus(status);
            }
        }
    }

    private boolean hasAlreadyApplied(int studentId, int driveId) {
        for (JobApplication application : applications) {
            if (application.getStudentId() == studentId
                    && application.getDriveId() == driveId) {
                return true;
            }
        }

        return false;
    }

    private Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    private Company findCompanyById(int companyId) {
        for (Company company : companies) {
            if (company.getCompanyId() == companyId) {
                return company;
            }
        }

        return null;
    }

    private PlacementDrive findDriveById(int driveId) {
        for (PlacementDrive drive : placementDrives) {
            if (drive.getDriveId() == driveId) {
                return drive;
            }
        }

        return null;
    }

    private JobApplication findApplicationById(int applicationId) {
        for (JobApplication application : applications) {
            if (application.getApplicationId() == applicationId) {
                return application;
            }
        }

        return null;
    }
}