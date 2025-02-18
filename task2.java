package CodeSoft;
// Task 2- STUDENT GRADE CALCULATOR

import java.util.Scanner;

// Input: Take marks obtained (out of 100) in each subject.
// Calculate Total Marks: Sum up the marks obtained in all subjects.
// Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
// average percentage.
// Grade Calculation: Assign grades based on the average percentage achieved.
// Display Results: Show the total marks, average percentage, and the corresponding grade to the user
public class task2 {

    static int subjects;
    static int marks[];

    int TotalMarks() {
        int sum = 0;
        for (int x : marks) {
            sum += x;
        }
        return sum;
    }

    int AverageMarks() {
        return TotalMarks() / subjects;
    }

    String Grades() {
        int avg = AverageMarks();
        if (avg >= 95 && avg <= 100) {
            return "A+";
        } else if (avg >= 90 && avg < 95) {
            return "A";
        } else if (avg >= 85 && avg < 90) {
            return "B+";
        } else if (avg >= 80 && avg < 85) {
            return "B";
        } else if (avg >= 75 && avg < 80) {
            return "C+";
        } else if (avg >= 70 && avg < 75) {
            return "C";
        } else if (avg >= 60 && avg < 70) {
            return "D+";
        } else if (avg >= 50 && avg < 60) {
            return "D";
        } else {
            return "E";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total num of subjects : ");
        subjects = sc.nextInt();

        marks = new int[subjects];

        System.out.print("Enter your marks for all the subjects (out of 100) : ");
        for (int i = 0; i < subjects; i++) {
            marks[i] = sc.nextInt();
        }

        task2 t = new task2();
        System.out.println(t.Grades());
    }
}
