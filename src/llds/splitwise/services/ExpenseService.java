package llds.splitwise.services;
import llds.splitwise.entities.Expense;
import java.util.HashMap;
import java.util.Map;

public class ExpenseService {
    Map<Integer, Expense> expenses;
    Integer expenseCounter = 1;
    public ExpenseService() {
        expenses = new HashMap<>();
    }


    public void addExpense(Expense expense) {
        expenses.put(expenseCounter, expense);
        expenseCounter += 1;
    }

    public void updateExpense(Integer id, Expense newExpense) {
        expenses.get(id).updateExpense(newExpense);
    }
}
