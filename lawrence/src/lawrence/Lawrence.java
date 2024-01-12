/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lawrence;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Lawrence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of respondents: ");
        int numberOfRespondents = input.nextInt();
           
        System.out.print("Number of questions: ");
        int numberOfQuestions = input.nextInt();
        
        // Questions array
        double[] questionArray = new double[numberOfQuestions];
        
        for(int i = 0; i < numberOfQuestions; i++) {
            System.out.println("Question #" + (i+1));
            double choiceScore = 0;
            double choiceWeightedMean = 0;
            
            for(int j = 1; j <= 5 && choiceScore < numberOfRespondents; j++) {
                System.out.print("\tChoice #:" + j + " ");
                double choice = input.nextDouble();
                choiceScore += choice;
                choiceWeightedMean += choice*j;
            }
            
            System.out.println("Question 1 sum:"+ choiceWeightedMean);
            System.out.println("");
            System.out.println("I VALUE PUTANGINAMO "+i);
            questionArray[i] = choiceWeightedMean / numberOfRespondents;
        }
        // [1.5, 3]
        System.out.print("Array: "+ Arrays.toString(questionArray));
        
        // Get overall weighted mean
        double overallMean = 0;
        for(int i = 0; i < questionArray.length; i++) {
            overallMean += questionArray[i];
        }
        
        overallMean = overallMean / numberOfQuestions;
        
        // Get variance
        double variance = 0;
        for(int i = 0; i < questionArray.length; i++) {
            double data = questionArray[i] - overallMean;
            variance += Math.pow(data, 2);
            System.out.println("Variance: "+ variance);
        }
        
        // Get standard deviation
        double standardDeviation = Math.sqrt(variance/(numberOfQuestions-1));
        
        System.out.println("Standard deviation: "+ standardDeviation);
    } // End main
} // End class
