package com.waliro78;



public class CalculateMortgage {


    public static void main(String[] args) {
        CalculatedValues calculatedValues = new CalculatedValues();
        calculatedValues.inputPrincipal();
        calculatedValues.calculateMonthlyInterest();
        calculatedValues.calNumberOfMonths();
        double finalMortgage = calculatedValues.monthltyMortgage();
        System.out.println("Monthly Mortgage Pay Back :" + finalMortgage);
    }
}