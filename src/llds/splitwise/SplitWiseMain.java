package llds.splitwise;

import llds.splitwise.builders.ExpenseBuilder;
import llds.splitwise.entities.Expense;
import llds.splitwise.entities.ExpenseSplit;
import llds.splitwise.enums.ExpenseType;
import llds.splitwise.services.ExpenseService;

/*
    I have put logic of expense creation and update in the main class
    because
        1. Expense object is created on frontend itself.
        2. New expense object is created on frontend itself.
 */
public class SplitWiseMain {
    public static void start() {
        ExpenseService expenseService = new ExpenseService();

        // create an expense
        Expense expense = new ExpenseBuilder()
                .addExpenseInfo("Juice")
                .addAmount(100.0)
                .addExpenseSpits(new ExpenseSplit("1", 50.0, true))
                .addExpenseSpits(new ExpenseSplit("2", 50.0, false))
                .setExenseType(ExpenseType.EXACT)
                .build();

        // add the expense
        expenseService.addExpense(expense);

        // modify the expense
//        expenseService.updateExpense(1, );

    }
}
