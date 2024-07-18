import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz_App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] questions = {
                "1. What is the default value of byte variable?\nA) 0\nB) 0.0\nC) null\nD) not defined",
                "2. Which of the below are reserved keyword in Java?\nA) array\nB) go\nC) null\nD) int",
                "3. What is the correct way to declare a variable to store an integer value in Java?\nA) int num = 10;\nB) Integer num = 10;\nC) num integer = 10;\nD) Integer num;",
                "4. Which of the following is not a primitive data type in Java?\nA) int\nB) float\nC) boolean\nD) String",
                "5. What is the default value of a boolean variable in Java?\nA) true\nB) false\nC) null\nD) 0",
                "6. What is the result of 10 % 3 in Java?\nA) 3\nB) 1\nC) 0\nD) 2",
                "7. Which of the following loops will execute the code block at least once?\nA) for loop\nB) while loop\nC) do-while loop\nD) if-else statement",
                "8. Which of the following is used to read input from the user in Java?\nA) System.in.read()\nB) BufferedReader\nC) Scanner\nD) InputReader",
                "9. What is the correct way to declare a method that does not return any value in Java?\nA) void method()\nB) int method()\nC) method void()\nD) int void method()",
                "10. Which keyword is used to define a constant in Java?\nA) final\nB) const\nC) static\nD) constant"
        };
        char[] ans = {'A', 'D', 'A', 'D', 'B', 'B', 'C', 'C', 'A', 'A'};
        
        int score = 0;
        char[] userans = new char[questions.length];
        System.out.println("Type the letter corresponding to your answer.");
        System.out.println("You have 30 seconds for each question.");
        
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            final boolean[] timeUp = {false};
            
            Timer questimer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("Time's up!");
                    timeUp[0] = true;
                    questimer.cancel();
                }
            };
            questimer.schedule(task, 30000);
            
            while (!timeUp[0]) {
                try {
                    if (sc.hasNextLine()) {
                        String input = sc.nextLine().toUpperCase();
                        if (input.length() == 1 && "ABCD".indexOf(input.charAt(0)) != -1) {
                            userans[i] = input.charAt(0);
                            if (userans[i] == ans[i]) {
                                System.out.println("Correct!");
                                score++;
                            } else {
                                System.out.println("Wrong. The correct answer is: " + ans[i]);
                            }
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter A, B, C, or D.");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Exception occurred: " + e.getMessage());
                }
            }
            questimer.cancel();
        }
        
        System.out.println("Here are your answers:");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Your answer: " + userans[i]);
        }
        
        System.out.println("Your total score is " + score + " point" + (score != 1 ? "s" : "") + " out of 10");
        
        sc.close();
    }
}
