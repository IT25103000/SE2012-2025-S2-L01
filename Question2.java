import java.util.Scanner;

// Question 2 - Student Marks Program
// Subjects: 1 = Maths, 2 = Chemistry, 3 = Physics
public class Question2 {

    static int n;
    static int[][] marks;
    static boolean[] added;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        n = Integer.parseInt(sc.nextLine().trim());

        marks = new int[n + 1][4];
        added = new boolean[n + 1];

        boolean running = true;
        while (running) {
            System.out.println("\nMENU");
            System.out.println("1. Add student marks");
            System.out.println("2. Update student mark");
            System.out.println("3. Average for a subject");
            System.out.println("4. Average for a student");
            System.out.println("5. Total for a student");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            String choice = sc.nextLine().trim();

            switch (choice) {

                case "1": // add
                    System.out.print("Enter student ID (1-" + n + "): ");
                    int addId = Integer.parseInt(sc.nextLine().trim());
                    if (addId < 1 || addId > n) {
                        System.out.println("That student ID doesn't exist.");
                        break;
                    }
                    System.out.print("Maths mark: ");
                    marks[addId][1] = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Chemistry mark: ");
                    marks[addId][2] = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Physics mark: ");
                    marks[addId][3] = Integer.parseInt(sc.nextLine().trim());
                    added[addId] = true;
                    System.out.println("Saved marks for student " + addId);
                    break;

                case "2": // update
                    System.out.print("Enter student ID (1-" + n + "): ");
                    int upId = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter subject (1=Maths, 2=Chemistry, 3=Physics): ");
                    int upSubject = Integer.parseInt(sc.nextLine().trim());
                    if (upId < 1 || upId > n || upSubject < 1 || upSubject > 3) {
                        System.out.println("Invalid student or subject ID.");
                        break;
                    }
                    System.out.print("New mark: ");
                    marks[upId][upSubject] = Integer.parseInt(sc.nextLine().trim());
                    System.out.println("Updated.");
                    break;

                case "3": // average for a subject
                    System.out.print("Enter subject (1=Maths, 2=Chemistry, 3=Physics): ");
                    int subj = Integer.parseInt(sc.nextLine().trim());
                    if (subj < 1 || subj > 3) {
                        System.out.println("Invalid subject ID.");
                        break;
                    }
                    int subjTotal = 0, subjCount = 0;
                    for (int id = 1; id <= n; id++) {
                        if (added[id]) {
                            subjTotal += marks[id][subj];
                            subjCount++;
                        }
                    }
                    if (subjCount == 0) {
                        System.out.println("No marks entered yet.");
                    } else {
                        System.out.println("Average for subject " + subj + " = " + (subjTotal / (double) subjCount));
                    }
                    break;

                case "4": // average for a student
                    System.out.print("Enter student ID (1-" + n + "): ");
                    int avgId = Integer.parseInt(sc.nextLine().trim());
                    if (avgId < 1 || avgId > n || !added[avgId]) {
                        System.out.println("No marks for this student yet.");
                        break;
                    }
                    int avgTotal = marks[avgId][1] + marks[avgId][2] + marks[avgId][3];
                    System.out.println("Average for student " + avgId + " = " + (avgTotal / 3.0));
                    break;

                case "5": // total for a student
                    System.out.print("Enter student ID (1-" + n + "): ");
                    int totId = Integer.parseInt(sc.nextLine().trim());
                    if (totId < 1 || totId > n || !added[totId]) {
                        System.out.println("No marks for this student yet.");
                        break;
                    }
                    int totTotal = marks[totId][1] + marks[totId][2] + marks[totId][3];
                    System.out.println("Total for student " + totId + " = " + totTotal);
                    break;

                case "6": // exit
                    System.out.println("Finish");
                    running = false;
                    break;

                default:
                    System.out.println("Please choose a number from 1 to 6.");
            }
        }

        sc.close();
    }
}