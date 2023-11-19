package com.example.Assignments;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Students {
    private final HashMap<Integer, String> names = new HashMap<>();
    private final HashMap<Integer, LinkedList<Integer>> marks = new HashMap<>();
    private final Scanner scan = new Scanner(System.in);

    public void fill() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the id and the name: ");
            int id = scan.nextInt();
            scan.nextLine();
            String name = scan.nextLine();

            names.put(id, name);
            marks.put(id, new LinkedList<>());
        }
    }

    public void scanMarks() {
        while (true) {
            System.out.println("0.Exit");
            System.out.println("1.Add mark");
            int proceed = scan.nextInt();
            if (proceed == 0)
                break;
            System.out.println("Enter the student's ID:");
            int id = scan.nextInt();
            if (!marks.containsKey(id)) {
                System.out.println("Invalid id");
                continue;
            }
            System.out.println("Enter the mark:");
            int mark = scan.nextInt();

            LinkedList<Integer> list = marks.get(id);
            list.add(mark);
        }
    }

    public void printNamesAndAverages() {
        for (int i : names.keySet()) {
            System.out.print(names.get(i) + "'s average: ");
            if (marks.get(i).isEmpty()) {
                System.out.println("Does not have marks yet");
                continue;
            }
            System.out.printf("%.2f\n", calculateAverage(marks.get(i)));
        }
    }

    private double calculateAverage(LinkedList<Integer> list) {
        int sum = 0;
        for (int d : list) {
            sum += d;
        }

        return (double)(sum) / list.size();
    }

    public static void main(String[] args) {
        Students students = new Students();
        students.fill();
        students.scanMarks();
        students.printNamesAndAverages();
    }
}
