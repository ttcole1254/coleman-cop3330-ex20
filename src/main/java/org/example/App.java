package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 20 Solution
 *  Copyright 2021 Tyler Coleman
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the order amount? ");
        double orderAmount = in.nextDouble();
        in.nextLine();
        System.out.println("What state do you live in? ");
        String state = in.nextLine();
        System.out.println("What county do you live in? ");
        String county = in.nextLine();
        double taxRate = 0;
        if (Objects.equals(state, "Wisconsin")|(Objects.equals(state, "wisconsin"))|(Objects.equals(state, "WI"))){
            taxRate = 0.05;
            if (Objects.equals(county, "Eau Claire")|(Objects.equals(county, "eau claire"))){
                taxRate = taxRate + 0.005;
            }
            if (Objects.equals(county, "Dunn")|(Objects.equals(county, "dunn"))){
                taxRate = taxRate + 0.004;
            }
        }
        if (Objects.equals(state, "Illinois")|(Objects.equals(state, "illinois"))|(Objects.equals(state, "IL"))){
            taxRate = 0.08;
        }
        double tax = orderAmount * taxRate;
        double total = orderAmount + tax;
        BigDecimal result = new BigDecimal(total).setScale(3, RoundingMode.HALF_UP);
        NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("The tax is $%.02f.\nThe total is %s.", tax, usdCostFormat.format(result.doubleValue()));
    }
}
