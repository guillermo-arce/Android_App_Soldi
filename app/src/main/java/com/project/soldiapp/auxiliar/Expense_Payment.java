package com.project.soldiapp.auxiliar;

import androidx.room.Ignore;

public class Expense_Payment {

    private double expense;

    private boolean paymentWithCash;

    //private Date date;

    public Expense_Payment() {
    }

    @Ignore
    public Expense_Payment(double expense, boolean paymentWithCash) {
        this.expense = expense;
        this.paymentWithCash = paymentWithCash;
    }

    public double getExpense() {
        return expense;
    }


    public boolean isPaymentWithCash() {
        return paymentWithCash;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public void setPaymentWithCash(boolean paymentWithCash) {
        this.paymentWithCash = paymentWithCash;
    }

}
