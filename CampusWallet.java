/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.campuswallet;

/**
 *
 * @author arobo_cpe113
 */
public class CampusWallet {

    private String owner;
    private int balance;

    public CampusWallet(String owner, int balance) {
        this.owner = owner;
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public CampusWallet(String owner) {
        this(owner, 0);
    }

    public boolean deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public boolean transferTo(CampusWallet recipient, int amount) {
        if (recipient == null || recipient == this) {
            return false;
        }
        if (amount <= 0 || this.balance < amount) {
            return false;
        }

        this.balance -= amount;
        recipient.balance += amount;
        return true;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getOwner() {
        return this.owner;
    }

    public static void main(String[] args) {
        CampusWallet aly = new CampusWallet("Aly", 100);
        CampusWallet ben = new CampusWallet("Ben");
        System.out.println("Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean ikaduha = aly.transferTo(ben, 35);
        System.out.println(ikaduha + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean ikatulo = aly.transferTo(ben, 70);
        System.out.println(ikatulo + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean ikaupat = aly.transferTo(aly, 10);
        System.out.println(ikaupat + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean ikalima = ben.deposit(15);
        System.out.println(ikalima + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean ikaunom = aly.transferTo(ben, 65);
        System.out.println(ikaunom + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean ikapito = ben.transferTo(aly, 0);
        System.out.println(ikapito + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean ikawalo = ben.transferTo(null, 10);
        System.out.println(ikawalo + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());
    }

}
