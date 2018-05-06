package com.expense;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SettlementHandler {

    public List<Settlement> handle(List<Expense> expenses) {
        List<Settlement> settlements = new LinkedList<>();

        double expenseAmountPerPerson = calculateExpenseAmountPerPerson(expenses);

        List<Expense> receivables = expenses.stream().filter(expense -> expense.getTotalAmountSpent() > expenseAmountPerPerson).collect(Collectors.toList());
        List<Expense> payables = expenses.stream().filter(expense -> expense.getTotalAmountSpent() < expenseAmountPerPerson).collect(Collectors.toList());

        for (int receivableIndex = 0, payableIndex = 0; payableIndex < payables.size();) {
            Expense receivable = receivables.get(receivableIndex);
            double amountToBeReceived = receivable.getTotalAmountSpent() - expenseAmountPerPerson;
            while (amountToBeReceived > 0) {
                Expense payable = payables.get(payableIndex);
                double amountToBePaid = expenseAmountPerPerson - payable.getTotalAmountSpent();
                Settlement settlement = new Settlement();
                settlement.setFromFullName(payable.getFullName());
                settlement.setToFullName(receivable.getFullName());
                if(amountToBeReceived > amountToBePaid) {
                    settlement.setAmount(amountToBePaid);
                    amountToBeReceived -= amountToBePaid;
                    payableIndex++;
                } else if(amountToBeReceived < amountToBePaid) {
                    settlement.setAmount(amountToBeReceived);
                    payable.setTotalAmountSpent(payable.getTotalAmountSpent() + amountToBeReceived);
                    amountToBeReceived = 0;
                    receivableIndex++;
                } else if(amountToBeReceived == amountToBePaid) {
                    settlement.setAmount(amountToBeReceived);
                    amountToBeReceived = 0;
                    payableIndex++;
                    receivableIndex++;
                }

                settlements.add(settlement);
            }
        }

        return settlements;
    }

    private double calculateExpenseAmountPerPerson(List<Expense> expenses) {
        double totalExpenseAmount = expenses.stream().mapToDouble(expense -> expense.getTotalAmountSpent()).sum();
        return totalExpenseAmount/expenses.size();
    }
}
