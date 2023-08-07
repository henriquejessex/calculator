package com.pluralsight.calculator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            performCalculation();
        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        } else if (args.length == 3) {
            handleCommandLine(args);
        }else {
            System.out.println("Please provide an operation code and 2 numeric values.");
        }
    }
    private static void performCalculation() {

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100d, 50d);
        equations[1] = new MathEquation('a', 25d, 92d);
        equations[2] = new MathEquation('s', 225d, 17d);
        equations[3] = new MathEquation('m', 11d, 3d);

        for (MathEquation equation: equations) {
            equation.execute();
            System.out.println(equation);
        }
        System.out.println("Average result = " + MathEquation.getAverageResult());

        //useOverloads();
    }
    static void useOverloads(){
        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation equationOverload = new MathEquation('d');
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;

        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Overload result with doubles: " + equationOverload.getResult());

        equationOverload.execute(19, 2);
        System.out.println("Overload result with int: " + equationOverload.getResult());
    }
    static void executeInteractively(){
        System.out.println("Enter an operation and two numbers.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }
    private static void performOperation(String[] parts) {
        char input = inputFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        double results = execute(input, leftVal, rightVal);
        displayResults(input, leftVal, rightVal, results);
    }
    private static void displayResults(char input, double leftVal, double rightVal, double results) {
        char symbol = symbolFromInput(input);
        StringBuilder builder = new StringBuilder(20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(results);
        String output = builder.toString();
        System.out.println(output);

    }

    private static char symbolFromInput(char input){
        char[] inputs = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for (int index = 0; index < inputs.length; index++){
            if (input == inputs[index]){
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }


    private static void handleCommandLine(String[] args) {
        char input = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(input, leftVal, rightVal);
        System.out.println(result);
    }

    static double execute(char input, double leftVal, double rightVal){
        double result;
        switch (input){
            case 'a':
                result = leftVal + rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ?  leftVal / rightVal : 0.0d;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            default:
                System.out.println("invalid input " + input);
                result = 0;
                break;
        }
        return result;
    }
    static  char inputFromString(String operationName){ //pega a primeira letra do input e transforma em char
        char input = operationName.charAt(0);
        return input;
    }

    static double valueFromWord(String word){
        String[] numberWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        double value = 0d;
        for (int index = 0; index < numberWords.length; index++){
            if (word.equals(numberWords[index])){
                value = index;
                break;
            }
        }
        return value;
    }





}