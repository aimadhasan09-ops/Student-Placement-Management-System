import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHelper input = new InputHelper(scanner);

        if (!login(input)) {
            scanner.close();
            return;
        }

        PlacementManager manager = new PlacementManager(input);

        int choice;

        do {
            showMenu();
            choice = input.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    manager.registerStudent();
                    break;

                case 2:
                    manager.viewStudentDetails();
                    break;

                case 3:
                    manager.updateStudentInformation();
                    break;

                case 4:
                    manager.registerCompany();
                    break;

                case 5:
                    manager.viewCompanyDetails();
                    break;

                case 6:
                    manager.addPlacementDrive();
                    break;

                case 7:
                    manager.viewAvailableJobs();
                    break;

                case 8:
                    manager.applyForJob();
                    break;

                case 9:
                    manager.manageInterviewDetails();
                    break;

                case 10:
                    manager.recordPlacementResult();
                    break;

                case 11:
                    manager.searchStudentRecord();
                    break;

                case 12:
                    manager.generatePlacementReport();
                    break;

                case 13:
                    System.out.println("\nThank you for using the system. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select a number from 1 to 13.");
            }

        } while (choice != 13);

        scanner.close();
    }

    public static boolean login(InputHelper input) {
        Admin admin = new Admin("admin", "1234");

        System.out.println("========================================");
        System.out.println("   STUDENT PLACEMENT MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("              ADMIN LOGIN");
        System.out.println("========================================");

        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.println("\nLogin Attempt " + attempt + "/3");

            String username = input.readText("Enter username: ");
            String password = input.readText("Enter password: ");

            if (admin.checkLogin(username, password)) {
                System.out.println("\nLogin successful! Welcome Admin 🎉");
                return true;
            }

            System.out.println("Invalid username or password.");
        }

        System.out.println("\nYou used all 3 login attempts.");
        System.out.println("Application closed. 😞");

        return false;
    }

    public static void showMenu() {
        System.out.println("\n========================================");
        System.out.println("   STUDENT PLACEMENT MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Register Student");
        System.out.println("2. View Student Details");
        System.out.println("3. Update Student Information");
        System.out.println("4. Register Company");
        System.out.println("5. View Company Details");
        System.out.println("6. Add Placement Drive");
        System.out.println("7. View Available Jobs");
        System.out.println("8. Apply for a Job");
        System.out.println("9. Manage Interview Details");
        System.out.println("10. Record Placement Result");
        System.out.println("11. Search Student Record");
        System.out.println("12. Generate Placement Report");
        System.out.println("13. Exit");
        System.out.println("========================================");
    }
}