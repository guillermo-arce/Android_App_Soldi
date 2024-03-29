package com.project.soldiapp.data_handling;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.project.soldiapp.auxiliar.DayExpense;
import com.project.soldiapp.auxiliar.Expense;
import com.project.soldiapp.auxiliar.Expense_Payment;
import com.project.soldiapp.auxiliar.Expense_Type;
import com.project.soldiapp.auxiliar.MonthDate;
import com.project.soldiapp.auxiliar.MonthExpense;

import java.util.List;

public class ExpenseViewModel extends AndroidViewModel {
    private ExpenseRepository repository;


    public ExpenseViewModel(@NonNull Application application){
        super(application);
        repository = new ExpenseRepository(application);
    }

    public void insert(Expense expense){
        repository.insert(expense);
    }

    public List<Expense> getAllExpenses(){
        return getAllExpenses();
    }

    public List<Expense_Type> getSumTypeExpenses(int month, int year){
        return repository.getSumTypeExpenses(month,year);
    }

    public List<Expense_Type> getSumTypeExpenses( int year){
        return repository.getSumTypeExpenses(year);
    }

    public List<Expense_Payment> getSumPaymentExpenses(int year){
        return repository.getSumPaymentExpenses(year);
    }

    public List<Expense_Payment> getSumPaymentExpenses(int month, int year){
        return repository.getSumPaymentExpenses(month,year);
    }


    public List<MonthDate> getMonthsRegistered(){
        return repository.getMonthsRegistered();
    }
    public List<Integer> getYearsRegistered(){
        return repository.getYearsRegistered();
    }

    public List<DayExpense> getDayExpenses(int month,int year){
        return repository.getDayExpenses(month,year);
    }
    public List<MonthExpense> getMonthExpenses(int month){
        return repository.getMonthExpenses(month);
    }

    public void delete(int month, int year){
        repository.delete(month,year);
    }

    public void deleteAll(){
        repository.deleteAll();
    }


}
