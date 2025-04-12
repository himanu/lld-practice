package llds.splitwise.entities;

import llds.splitwise.enums.ExpenseType;

import java.util.List;

public class Expense {
    List<ExpenseSplit> expenseSplits;
    Double amount;
    String expenseInfo;
    ExpenseType expenseType;
    String ownerId;


    public Expense(String expenseInfo, Double amount, List<ExpenseSplit> expenseSplits, ExpenseType expenseType) {
        this.expenseInfo = expenseInfo;
        this.amount = amount;
        this.expenseSplits = expenseSplits;
        this.expenseType = expenseType;
    }

    public static boolean validateExpenseDetails(String expenseInfo, Double amount, List<ExpenseSplit> expenseSplits, ExpenseType expenseType) {
        //
        return true;
    }

    public void updateExpense(Expense newExpense) {
        if (validateExpenseDetails(newExpense.expenseInfo, newExpense.amount, newExpense.expenseSplits, newExpense.expenseType)) {
            this.expenseInfo = newExpense.expenseInfo;
            this.expenseType = newExpense.expenseType;
            this.amount = newExpense.amount;
            this.expenseSplits = newExpense.expenseSplits;
        }
    }

}
