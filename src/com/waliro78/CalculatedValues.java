package com.waliro78;


import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by User on 20-Jul-20.
 */

public class CalculatedValues {
    private byte percent =100;
    private byte monthInAYears =12;
    private float calMonthlyInterest;
    private float numberOfMonths;
    private double principal;
    private double mortgage;
    private float annualInterest =0f;
    float period =0f;

    Scanner input = new Scanner(System.in);

    public void inputPrincipal() {

        //creating infinite loop
        while (true) {
            System.out.print("Principal :");
            try {
                double principal = input.nextDouble();
                this.principal = principal;
            } catch (InputMismatchException exception) {
                System.out.println("Enter a Number NOT Text");

                //this is to clear the buffer of any input
                input.nextLine();
                continue;
            }
            if (principal >= 1000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a Number 1000 and 1000000");
        }
    }

    public double getPrincipal() {
        return this.principal;
    }

    public void calculateMonthlyInterest(){
        float inputAnnualRate =0f;
        while(true) {
            System.out.print("Enter Annual Interest Rate :");
            try{
                inputAnnualRate = input.nextFloat();
                this.calMonthlyInterest = inputAnnualRate / percent / monthInAYears;
            }
            catch (InputMismatchException exception){
                System.out.println("Enter a number NOT Text");
                input.nextLine();
            }

            if(inputAnnualRate>=5 && inputAnnualRate<=20){

                break;
            }
            System.out.println("Enter a number Greater 5% and Less than 20% NOT Text");
            continue;
        }
    }
    public float getCalMonthlyInterest() {
        return calMonthlyInterest;
    }
    public void calNumberOfMonths(){
        while(true) {
            try{
                System.out.print("Period :");
                period = input.nextFloat();
                numberOfMonths = period * monthInAYears;
            }
            catch (InputMismatchException exception){
                System.out.println("Enter a Number NOT a Text");
                input.nextLine();
            }
            if(period >=1 && period <= 30){
               break;
            }
            System.out.println("Enter a Period between 1 and 30");
            continue;
        }
    }
    public float getNumberOfMonths(){
        return numberOfMonths;
    }
    public double monthltyMortgage(){
        double mortgage = getPrincipal()*getCalMonthlyInterest()*Math.pow(1+getCalMonthlyInterest(),getNumberOfMonths())/(Math.pow(1+getCalMonthlyInterest(),getNumberOfMonths())-1);
        String formattedMortgage = (Double.toString(mortgage));
        return this.mortgage = Double.parseDouble(formattedMortgage);
    }

    public double getMortgage() {
        return mortgage;
    }
}