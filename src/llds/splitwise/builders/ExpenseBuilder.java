package llds.splitwise.builders;
import llds.splitwise.entities.Expense;
import llds.splitwise.entities.ExpenseSplit;
import llds.splitwise.enums.ExpenseType;

import java.util.ArrayList;
import java.util.List;

public class ExpenseBuilder {
    List<ExpenseSplit> expenseSplits;
    Double amount;
    String expenseInfo;
    ExpenseType expenseType;

    public ExpenseBuilder addAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public ExpenseBuilder addExpenseInfo(String expenseInfo) {
        this.expenseInfo = expenseInfo;
        return this;
    }

    public ExpenseBuilder addExpenseSpits(ExpenseSplit expenseSplit) {
        if (expenseSplits == null)
            expenseSplits = new ArrayList<>();

        expenseSplits.add(expenseSplit);
        return this;
    }

    public ExpenseBuilder setExenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
        return this;
    }
    public Expense build() {
        if (Expense.validateExpenseDetails(expenseInfo, amount, expenseSplits ,expenseType))
            return new Expense(expenseInfo, amount, expenseSplits, expenseType);
        return null;
    }

}
