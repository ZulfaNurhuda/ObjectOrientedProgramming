import java.util.Scanner;

public class ClinicDriver {
    public static void main(String[] args) {
        PatientQueue queue = new PatientQueue();
        PatientHistory history = new PatientHistory();
        PriorityRegistry priority = new PriorityRegistry();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Clinic System ===");
            System.out.println("1. Add Patient to Queue");
            System.out.println("2. Serve Next Patient");
            System.out.println("3. View Next Patient");
            System.out.println("4. Add Patient to Priority List");
            System.out.println("5. Remove Patient from Priority List");
            System.out.println("6. Show Queue");
            System.out.println("7. Show History");
            System.out.println("8. Show Priority List");
            System.out.println("9. Sort & Display History by Name");
            System.out.println("10. Search Patient in History");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Critical (true/false): ");
                    boolean critical = sc.nextBoolean();
                    sc.nextLine();
                    queue.addPatient(new Patient(name, age, critical));
                    System.out.println("Patient added to queue.");
                    break;

                case 2:
                    Patient served = queue.serveNext();
                    if (served != null) {
                        System.out.println("Serving patient: " + served);
                        history.addRecord(served);
                    } else {
                        System.out.println("No patient in queue.");
                    }
                    break;

                case 3:
                    Patient next = queue.peekNext();
                    if (next != null)
                        System.out.println("Next patient: " + next);
                    else
                        System.out.println("Queue is empty.");
                    break;

                case 4:
                    System.out.print("Enter name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter age: ");
                    int page = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Critical (true/false): ");
                    boolean pcrit = sc.nextBoolean();
                    sc.nextLine();
                    priority.addPriority(new Patient(pname, page, pcrit));
                    System.out.println("Patient added to priority list.");
                    break;

                case 5:
                    System.out.print("Enter name to remove: ");
                    String rname = sc.nextLine();
                    if (priority.removePriority(rname))
                        System.out.println("Patient removed from priority list.");
                    else
                        System.out.println("Patient not found.");
                    break;

                case 6:
                    queue.displayQueue();
                    break;

                case 7:
                    history.displayHistory();
                    break;

                case 8:
                    priority.displayPriorityList();
                    break;

                case 9:
                    history.sortByName();
                    System.out.println("History sorted by name:");
                    history.displayHistory();
                    break;

                case 10:
                    System.out.print("Enter name to search: ");
                    String sname = sc.nextLine();
                    Patient found = history.searchByName(sname);
                    if (found != null)
                        System.out.println("Found: " + found);
                    else
                        System.out.println("Patient not found in history.");
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}