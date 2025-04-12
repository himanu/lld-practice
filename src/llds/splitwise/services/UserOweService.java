package llds.splitwise.services;

import llds.splitwise.entities.ExpenseSplit;
import llds.splitwise.entities.UserLevelOwe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserOweService {
    Map<String, Map<String, Double>> owes = new HashMap<>();
    Map<String, Map<String, Double>> owed = new HashMap<>();

    void processSplits(List<ExpenseSplit> splits, String payer) {
        for(ExpenseSplit split: splits) {
            String userId = split.getUserId();
            boolean isPayer = split.isPayer();
            double amount = split.getAmount();

            if (!isPayer) {
                owes.get(payer).put(userId, owes.get(payer).get(userId) + amount);

                owed.get(userId).put(payer, owed.get(userId).get(payer) + amount);
            }
        }
    }

    void getOwes(String userId) {
        Map<String, Double> owe = owes.get(userId);
        for(Map.Entry<String, Double> entry: owe.entrySet()) {
            String ower = entry.getKey();
            Double amount = entry.getValue();
            Double owedAmount = owed.get(ower).get(userId);

            amount -= owedAmount;

            if (amount > 0) {
                System.out.println("Ower: " + ower + " amount: " + amount);
            }
        }
    }
    /*



    B A 30
    C A 30
    A B 50

    payer_id otheruser_id amount
    A       B       30
    B       A       50
    A       C       30


    // Find money owed by A
    A owes B 50 - B owes A 30

    self join table
    t1 where payer_id=A

    t2 where other_user_id = A

    left join
    t1.otheruser_id = t2.payer_id





A
    Inse lena h
    B: 30
    C: 30

    Inko Dena h
    B: 50


B
    Inse Lena h
    A: 50

    Inko dena h
    A: 30



C
    Inko Dena h
    A: 30




    pay karni h
    A: {
        B: 20
    }

    kisese recieve karni h
    A: {
        C: 30,

    }

    A -> {
        B: 30
        C: 30

    }




    1 pays 90rs equal share
    2 Pays bill in which 1 needs to pay 50
        salary
        { 1: {
                2: 30,
                3: 30
            },

            2: {
                1: 50
            }
        }

         debit
         {
            2: {
                1: 30
            },
            3: {
                1: 30
            },
            1: {
                2: 50
            }

         }

         A B 30 50

        Is it right to add a new boolean field in the split, to identifier payer



     */
}
