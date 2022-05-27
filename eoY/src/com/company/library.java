package com.company;

import java.io.IOException;

import java.util.Arrays;

import java.util.Scanner;

public class library
{
    public static void print(String A)
    {
        System.out.print(A);
    }

    public static void println(String B)
    {
        System.out.println(B);
    }

    public static void networkTest() throws InterruptedException, IOException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your URL");
        String C = scan.next();
        Process process = java.lang.Runtime.getRuntime().exec("ping " + C);
        int x = process.waitFor();
        if (x == 0)
        {
            System.out.println("Connection Successful, "
                    + "Output was " + x);
        } else
        {
            System.out.println("Internet Not Connected, "
                    + "Output was " + x);
        }
    }


    public static void bubbleSort(int []arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[i] > arr[i=1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static int binarySearch(int[] list, int target){
        int min = 0;
        int max = list.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (list[mid] < target) {
                min = mid + 1;
            } else if (list[mid] > target) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -(min + 1);
    }

    public static int range(int[] list) {
        int max = list[0];
        int min = max;
        for (int i = 1; i < list.length; i++) {
            if (list[i] < min) {
                min = list[i];
            }
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max - min;
    }
    public static void startCalc(){
        String x = "x";
        Scanner sc;
        while(!x.equals("quit"))
        {
            sc = new Scanner(System.in);
            System.out.println("What is your expression?");
            String expression = sc.nextLine();
            expression = expression.toLowerCase();
            x = calculate(expression);
            System.out.println(x);
        }
    }
    public static String calculate(String s){
        // you add code here to take a String as a parameter, and return a String with the result
        String result;
        Scanner sc = new Scanner(s);
        String a = s.toLowerCase();
        if (a.equals("quit"))
        {
            return "quit";
        }
        if(numberOfTokens(s) == 2)
        {
            result = oneOperand(sc.nextLine());
        }
        else if (numberOfTokens(s) == 3)
        {
            result = twoOperand(sc.nextLine());
        }
        else if (numberOfTokens(s) == 5)
        {
            result = threeOperand(sc.nextLine());
        }
        else {
            return "ERROR";
        }
        // you'll probably call other methods (that you write) here to do work,
        // like deciding if it's a 2-part or 3-part expression, or calculating the result of a
        // 2-part expression or a 3-part expression
        return result;
    }
    public static int numberOfTokens(String s)
    {
        //sends tokens through scanner
        Scanner sc = new Scanner(s);
        //no. of tokens
        int numberOfT = 0;
        //while statement for tokens
        while(sc.hasNext())
        {
            //current number of tokens
            numberOfT++;
            //scanner next
            sc.next();
        }
        //return number of tokens
        return numberOfT;
    }
    //One operand Function statement: Example Sin 90
    public static String oneOperand(String s) {
        Scanner sc = new Scanner(s);
        String x;
        double c;
        try{
            x = sc.next();
            c = sc.nextDouble();
        }
        catch (Exception e)
        {
            return "ERROR";
        }
        // catches errors in parsing through the scanner and returns "ERROR" if any.
        double result = -1;

        if(x.equals("s"))
        {
            result = Math.sin(c);
            //calculates the sin value of the operand you put in if you type "s"before the operand
        }
        else if(x.equals("c"))
        {
            result = Math.cos(c);
            //calculates the cos value of the operand you put in if you type "c"before the operand
        }
        else if(x.equals("t"))
        {
            result = Math.tan(c);
            //calculates the tan value of the operand you put in if you type "t" before the operand
        }
        else if(x.equals("|"))
        {
            result = Math.abs(c);
            //calculates the absolute value of the operand you put in if you type "|" before the operand
        }
        else if(x.equals("v"))
        {
            result = Math.sqrt(c);
            //calculates the sqrt value of the operand you put in if you type "v" before the operand
        }
        else if(x.equals("~"))
        {
            result = Math.round(c);
            //rounds the value of the operand you put in if you type "~" before the operand
        }
        else
        {
            return "ERROR";
        }
        return String.valueOf(result);
    }
    //Two operand Function statement: Example: 3 x 2
    public static String twoOperand(String s) {
        double c;
        String x;
        double g;
        Scanner sc = new Scanner(s);
        try {
            c = sc.nextDouble();
            x = sc.next();
            g = sc.nextDouble();
        }
        catch (Exception e)
        {
            return "ERROR";
        }
        // catches errors in parsing through the scanner and returns "ERROR" if any.
        double result = -1;
        if(x.equals("+"))
        {
            result = c + g;
            //adds 2 operands that you input if you put the "+" symbol in between the 2 numbers and then saves the result in the variable "result"
        }
        else if(x.equals("-"))
        {
            result = c - g;
            //subtracts 2 operands that you input if you put the "-" symbol in between the 2 numbers and then saves the result in the variable "result"
        }
        else if(x.equals("*"))
        {
            result = c * g;
            //multiplies 2 operands that you input if you put the "*" symbol in between the 2 numbers and then saves the result in the variable "result"
        }
        else if(x.equals("/"))
        {
            result = c / g;
            //divides 2 operands that you input if you put the "/" symbol in between the 2 numbers and then saves the result in the variable "result"
        }
        else if(x.equals("%"))
        {
            result = c % g;
            //calculates the remainder of c / g if you put the "%" symbol in between the 2 numbers and then saves the result in the variable "result"
        }
        else if(x.equals("^"))
        {
            result = Math.pow(c, g);
            //puts the operand "c" to the power of "g" if you put the "^" symbol in between the 2 numbers and then saves the result in the variable "result"
        }
        else {
            return "ERROR";
            //returns an error statement if none of the conditions are met
        }
        return String.valueOf(result);
    }
    //Two operand Function statement: Example: 3 x 2 + 5
    public static String threeOperand(String s) {
        Scanner sc = new Scanner(s);
        double c;
        String x;
        double g;
        String a;
        double b;
        try{
            c = sc.nextDouble();
            x = sc.next();
            g = sc.nextDouble();
            a = sc.next();
            b = sc.nextDouble();
        }
        catch (Exception e)
        {
            return "ERROR";
        }
        // catches errors in parsing through the scanner and returns "ERROR" any.
        double result = -1;
        if(x.equals("+"))
        {
            result = c + g;
            //uses 3 operands that you input if you put the "+" symbol in between one of the numbers and then saves the result in the variable "result"
        }
        else if(x.equals("-"))
        {
            result = c - g;
            //uses 3 operands that you input if you put the "-" symbol in between one of the numbers and then saves the result in the variable "result"
        }
        else if(x.equals("*"))
        {
            result = c * g;
            //uses 3 operands that you input if you put the "*" symbol in between one of the numbers and then saves the result in the variable "result"
        }
        else if(x.equals("/"))
        {
            result = c / g;
            //uses 3 operands that you input if you put the "/" symbol in between one of the numbers and then saves the result in the variable "result"
        }
        else if(x.equals("%"))
        {
            result = c % g;
            //uses 3 operands that you input if you put the "%" symbol in between one of the numbers and then saves the result in the variable "result"
        }
        else if(x.equals("^"))
        {
            result = Math.pow(c, g);
            //uses 3 operands that you input if you put the "^" symbol in between one of the numbers and then saves the result in the variable "result"
        }
        else
        {
            return "ERROR";
            //returns an error if none of the conditions are met
        }
        if(a.equals("+"))
        {
            result += b;
        }
        else if(a.equals("-"))
        {
            result -= b;
        }
        else if(a.equals("*"))
        {
            result *= b;
        }
        else if(a.equals("/"))
        {
            result /= b;
        }
        else if(a.equals("%"))
        {
            result %= b;
        }
        else if(a.equals("^"))
        {
            result = Math.pow(result, b);
        }
        else {
            return "ERROR";
        }
        return String.valueOf(result);
    }
    public static void arrayCopier(int[] array, int[] array1)
    {
        int i = 0;
        for (int x : array)
        {
            array1[i] = x;
            i++;
        }
    }
    public static void array(int[] array, int[] array1)
    {
        int i = 0;
        for (int x : array)
        {
            array1[i] = x;
            i++;
        }
    }
}
