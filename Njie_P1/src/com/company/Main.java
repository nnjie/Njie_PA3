package com.company;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Main {

        public static void printCorrect()
        {
            Random rand = new SecureRandom();
            int rightMsgNumber = 1 + rand.nextInt(4);

            switch (rightMsgNumber)
            {
                case 1: System.out.println("Very Good!");
                    break;
                case 2: System.out.println("Excellent!");
                    break;
                case 3: System.out.println("Nice Work!");
                    break;
                case 4: System.out.println("Keep up the good work!");
                    break;
            }
        }

        public static void printIncorrect()
        {
            Random rand = new SecureRandom();
            int wrongMsgNumber = 1 + rand.nextInt(4);

            switch (wrongMsgNumber)
            {
                case 1: System.out.println("No. Please try again.");
                    break;
                case 2: System.out.println("Wrong. Try once more.");
                    break;
                case 3: System.out.println("Don't give up!");
                    break;
                case 4: System.out.println("No. Keep trying");
            }
        }

        public static void Helper() {

            boolean newStudent = true;

            System.out.println("=================================================================");

            while (newStudent) {

                int stopper = 10;
                int level, levelRange =1,type =1;
                int number1=0, number2=0;
                int correctCounter = 0, incorrectCounter = 0;
                double correctAnswer=0.00, answer = 0.00;
                boolean gotIt = false;
                double percentage;
                Random rand = new SecureRandom();
                Scanner scan = new Scanner(System.in);

                System.out.println("=================================================================");
                System.out.println(" Welcome to the  Math Helper");
                System.out.println("=================================================================");
                System.out.print("Please enter the level (1,2,3 or 4): ");
                level = scan.nextInt();
                System.out.println("Pick the type of arithmetic :");
                System.out.println("1 - Addition ");
                System.out.println("2 - Subtraction ");
                System.out.println("3 - multiplication ");
                System.out.println("4 - Division ");
                System.out.println("5 - Mixture ");
                System.out.print("Your pick: ");
                type = scan.nextInt();
                while (stopper != 0) {

                    if(level ==1) {
                        levelRange =1;
                        number1 = levelRange + rand.nextInt(8);
                        number2 = levelRange + rand.nextInt(8);
                    }

                    if(level ==2) {
                        levelRange =10;
                        number1 = levelRange + rand.nextInt(89);
                        number2 = levelRange + rand.nextInt(89);
                    }
                    if(level ==3) {
                        levelRange =100;
                        number1 = levelRange + rand.nextInt(899);
                        number2 = levelRange + rand.nextInt(899);
                    }

                    if(level ==4) {
                        levelRange =1000;
                        number1 = levelRange + rand.nextInt(8999);
                        number2 = levelRange + rand.nextInt(8999);
                    }

                    gotIt = false;

                    while (gotIt != true && stopper != 0) {

                        if(type ==5)
                        {
                            correctAnswer = mixtureProblem(type, number1,number2);
                        }
                        else
                        {
                            correctAnswer = arithmeticProblem(type, number1,number2);
                        }

                        // getting the student answer
                        answer = scan.nextInt();

                        if (answer == correctAnswer) {
                            printCorrect();
                            System.out.println("================================");
                            gotIt = true;
                            correctCounter++;
                        } else {
                            printIncorrect();
                            incorrectCounter++;
                            System.out.println("================================");
                        }
                        stopper--;
                    }
                }
                // calculating Percentage
                percentage = 100 * correctCounter / 10;
                if (percentage < 75) {
                    System.out.println("\nPlease ask your instructor for extra help.\n");
                } else {
                    System.out.println("Congratulations, you are ready to go to the next level!\n");
                }
                // Reset the program for another student
            }
        }

        private static double arithmeticProblem(int type, int num1, int num2)
        {
            int result =0;
            switch (type)
            {
                case 1:
                {
                    System.out.println("How much is " + num1 + " plus " + num2 + " ?");
                    result =  num1+ num2;
                    break;
                }
                case 2:
                {
                    System.out.println("How much is " + num1 + " minus " + num2 + " ?");
                    result = num1 - num2;
                    break;
                }
                case 3:
                {
                    System.out.println("How much is " + num1 + " times " + num2 + " ?");
                    result =  num1 * num2;
                    break;
                }
                case 4:
                {
                    System.out.println("How much is " + num1 + " divides " + num2 + " ?");
                    result =  num1 / num2;
                    break;
                }
            }

            return result;
        }

        private static double mixtureProblem(int type, int num1, int num2)
        {
            Random rand = new SecureRandom();
            // pick a number from 1 to 4 for the random type of arithmetic
            type = 1 + rand.nextInt(4);

            return arithmeticProblem(type,num1,num2);
        }

        public static void main(String[] args)  {
            Helper();
        }


}


