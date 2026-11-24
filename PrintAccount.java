/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.print_account;

/**
 *
 * @author arobo_cpe113
 */
public class PrintAccount {

    private String studentName;
    private int credits;

    public PrintAccount(String studentName, int credits) {
        this.studentName = studentName;
        if (credits < 0) {
            this.credits = 0;
        } else {
            this.credits = credits;
        }
    }

    public boolean addCredits(int amount) {
        if (amount > 0) {
            this.credits += amount;
            return true;
        }
        return false;
    }

    public boolean printPages(int pages) {
        if (pages > 0 && this.credits >= pages) {
            this.credits -= pages;
            return true;
        }
        return false;
    }

    public int getCredits() {
        return this.credits;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public static void main(String[] args) {

        PrintAccount mia = new PrintAccount("Mia", 10);
        PrintAccount luis = new PrintAccount("Luis", -4);
        System.out.println("Mia: " + mia.getCredits() + ", Luis: " + luis.getCredits());

        boolean ikaduha = mia.printPages(4);
        System.out.println(ikaduha + "; Mia: " + mia.getCredits());

        boolean ikatulo = mia.printPages(7);
        System.out.println(ikatulo + "; Mia: " + mia.getCredits());

        boolean ikaupat = mia.addCredits(-3);
        System.out.println(ikaupat + "; Mia: " + mia.getCredits());

        boolean ikalima = mia.addCredits(4);
        System.out.println(ikalima + "; Mia: " + mia.getCredits() + ", Luis: " + luis.getCredits());
    }

}
// Prompt used: "Don't write the method for me. What conditions should I check before deducting printing credits?"

// Accepted or rejected: Accepted checking that pages is greater than 0 and current credits are at least equal to 
//pages before subtracting; rejected using Scanner input since the handout specifies fixed test inputs.

// How I checked it: Ran Main with Mia (10 credits) and Luis (-4 credits) through all five test steps and 
//verified each boolean return and credit balance matched the expected output.