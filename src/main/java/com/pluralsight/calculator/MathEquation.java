package com.pluralsight.calculator;

public class MathEquation {
    private double leftVal, rightVal, result;
    private char input;
    private static int numberOfCalculations;
    private static double sumOfResults;
    public MathEquation(){}// Constructor
    public MathEquation(char input){
        this.input = input;
    } // Constructor
    public MathEquation(char input, double leftVal, double rightVal){
        this(input);
        this.leftVal = leftVal;
        this.rightVal = rightVal;

    } // Constructor
    public void execute(){

        switch (input) {
            case 'a' -> result = leftVal + rightVal;
            case 'm' -> result = leftVal * rightVal;
            case 'd' -> result = rightVal != 0 ? leftVal / rightVal : 0.0d;
            case 's' -> result = leftVal - rightVal;
            default -> {
                System.out.println("invalid input " + input);
                result = 0;
            }

        }
        numberOfCalculations++;
        sumOfResults += result;
    }
    public void execute(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();
    }
    public void execute(int leftVal, int rightVal){
        this.rightVal = rightVal;
        this.leftVal = leftVal;
        execute();
        result = (int)result;
    }
    public String toString(){
        char symbol = symbolFromOpCode();
        StringBuilder builder = new StringBuilder(20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        return builder.toString();
    }
    public char symbolFromOpCode(){
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
    public static double getAverageResult(){
        return  sumOfResults / numberOfCalculations;
    }
    public double getLeftVal() {return leftVal; }
    public void setLeftVal(double leftVal){this.leftVal = leftVal; }
    public double getRightVal() {return rightVal; }
    public void setRightVal(double rightVal){this.rightVal = rightVal; }

    public double getResult() {
        return result;
    }
}
