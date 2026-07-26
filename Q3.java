 import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students (n): ");
        int n = scanner.nextInt();

        double[][] marks = new double[n + 1][4];
        boolean[] studentExists = new boolean[n + 1];

        while (true) {
            System.out.println("\nCommands:");
            System.out.println("add [studentID]");
            System.out.println("update [studentID] [subjectID]");
            System.out.println("average_s [subjectID]");
            System.out.println("average [studentID]");
            System.out.println("total [studentID]");
            System.out.println("grades");
            System.out.println("exit");
            System.out.print("Enter command: ");

            String command = scanner.next();

            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            if (command.equalsIgnoreCase("add")) {
                int studentID = scanner.nextInt();
                if (studentID < 1 || studentID > n) {
                    System.out.println("Invalid student ID.");
                    continue;
                }
                System.out.print("Enter marks for Mathematics, Chemistry, and Physics: ");
                marks[studentID][1] = scanner.nextDouble();
                marks[studentID][2] = scanner.nextDouble();
                marks[studentID][3] = scanner.nextDouble();
                studentExists[studentID] = true;
                System.out.println("Marks added successfully.");
            } else if (command.equalsIgnoreCase("update")) {
                int studentID = scanner.nextInt();
                int subjectID = scanner.nextInt();
                if (studentID < 1 || studentID > n || !studentExists[studentID]) {
                    System.out.println("Invalid student ID or marks not added yet.");
                    continue;
                }
                if (subjectID < 1 || subjectID > 3) {
                    System.out.println("Invalid subject ID. Use 1 for Math, 2 for Chemistry, 3 for Physics.");
                    continue;
                }
                System.out.print("Enter new mark: ");
                marks[studentID][subjectID] = scanner.nextDouble();
                System.out.println("Mark updated successfully.");
            } else if (command.equalsIgnoreCase("average_s")) {
                int subjectID = scanner.nextInt();
                if (subjectID < 1 || subjectID > 3) {
                    System.out.println("Invalid subject ID.");
                    continue;
                }
                double sum = 0;
                int count = 0;
                for (int i = 1; i <= n; i++) {
                    if (studentExists[i]) {
                        sum += marks[i][subjectID];
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("No student records found.");
                } else {
                    System.out.println("Average mark for subject " + subjectID + ": " + (sum / count));
                }
            } else if (command.equalsIgnoreCase("average")) {
                int studentID = scanner.nextInt();
                if (studentID < 1 || studentID > n || !studentExists[studentID]) {
                    System.out.println("Invalid student ID or marks not added yet.");
                    continue;
                }
                double total = marks[studentID][1] + marks[studentID][2] + marks[studentID][3];
                System.out.println("Average mark for student " + studentID + ": " + (total / 3.0));
            } else if (command.equalsIgnoreCase("total")) {
                int studentID = scanner.nextInt();
                if (studentID < 1 || studentID > n || !studentExists[studentID]) {
                    System.out.println("Invalid student ID or marks not added yet.");
                    continue;
                }
                double total = marks[studentID][1] + marks[studentID][2] + marks[studentID][3];
                System.out.println("Total mark for student " + studentID + ": " + total);
            } else if (command.equalsIgnoreCase("grades")) {
                System.out.println("\n");
                System.out.printf("%-12s | %-15s | %-15s | %-15s\n", "Student ID", "Mathematics", "Chemistry", "Physics");
                System.out.println(" ");
                
                for (int i = 1; i <= n; i++) {
                    if (studentExists[i]) {
                        System.out.printf("%-12d", i);
                        for (int j = 1; j <= 3; j++) {
                            double score = marks[i][j];
                            String grade;
                            if (score >= 90) {
                                grade = "Grade A";
                            } else if (score >= 80) {
                                grade = "Grade B";
                            } else if (score >= 70) {
                                grade = "Grade C";
                            } else if (score >= 60) {
                                grade = "Grade D";
                            } else {
                                grade = "Fail";
                            }
                            System.out.printf(" | %-15s", grade);
                        }
                        System.out.println();
                    }
                }
                System.out.println(" ");
            } else {
                System.out.println("Unknown command.");
            }
        }

        scanner.close();
    }
}