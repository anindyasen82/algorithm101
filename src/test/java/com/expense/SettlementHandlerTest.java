package com.expense;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SettlementHandlerTest {

    SettlementHandler handler;

    @Before
    public void init() {
        handler = new SettlementHandler();
    }

    @Test
    public void handleOneSettlement() throws Exception {
        Expense expenseHirak = new Expense("Hirak Raja", 10);
        Expense expenseMaganlal = new Expense("Maganlal Meghraj", 13);
        Expense expenseMandar = new Expense("Mandar Bose", 7);
        Expense expenseHalla = new Expense("Halla Raja", 10);

        List<Expense> expenses = new LinkedList<>();
        expenses.add(expenseHirak);
        expenses.add(expenseMaganlal);
        expenses.add(expenseMandar);
        expenses.add(expenseHalla);

        List<Settlement> settlements = handler.handle(expenses);

        assertEquals(1, settlements.size());

        assertEquals("Mandar Bose", settlements.get(0).getFromFullName());
        assertEquals("Maganlal Meghraj", settlements.get(0).getToFullName());
        assertEquals(3, settlements.get(0).getAmount(), 0);

    }

    @Test
    public void handleTwoEqualSettlement() throws Exception {
        Expense expenseHirak = new Expense("Hirak Raja", 13);
        Expense expenseMaganlal = new Expense("Maganlal Meghraj", 13);
        Expense expenseMandar = new Expense("Mandar Bose", 7);
        Expense expenseHalla = new Expense("Halla Raja", 7);

        List<Expense> expenses = new LinkedList<>();
        expenses.add(expenseHirak);
        expenses.add(expenseMaganlal);
        expenses.add(expenseMandar);
        expenses.add(expenseHalla);

        List<Settlement> settlements = handler.handle(expenses);

        assertEquals(2, settlements.size());

        assertEquals("Mandar Bose", settlements.get(0).getFromFullName());
        assertEquals("Hirak Raja", settlements.get(0).getToFullName());
        assertEquals(3, settlements.get(0).getAmount(), 0);

        assertEquals("Halla Raja", settlements.get(1).getFromFullName());
        assertEquals("Maganlal Meghraj", settlements.get(1).getToFullName());
        assertEquals(3, settlements.get(1).getAmount(), 0);

    }

    @Test
    public void handleTwoUnEqualSettlementInOrder() throws Exception {
        Expense expenseHirak = new Expense("Hirak Raja", 12);
        Expense expenseMaganlal = new Expense("Maganlal Meghraj", 13);
        Expense expenseMandar = new Expense("Mandar Bose", 8);
        Expense expenseHalla = new Expense("Halla Raja", 7);

        List<Expense> expenses = new LinkedList<>();
        expenses.add(expenseHirak);
        expenses.add(expenseMaganlal);
        expenses.add(expenseMandar);
        expenses.add(expenseHalla);

        List<Settlement> settlements = handler.handle(expenses);

        assertEquals(2, settlements.size());

        assertEquals("Mandar Bose", settlements.get(0).getFromFullName());
        assertEquals("Hirak Raja", settlements.get(0).getToFullName());
        assertEquals(2, settlements.get(0).getAmount(), 0);

        assertEquals("Halla Raja", settlements.get(1).getFromFullName());
        assertEquals("Maganlal Meghraj", settlements.get(1).getToFullName());
        assertEquals(3, settlements.get(1).getAmount(), 0);

    }

    @Test
    public void handleTwoUnEqualSettlementNotInOrder() throws Exception {
        Expense expenseHirak = new Expense("Hirak Raja", 12);
        Expense expenseMaganlal = new Expense("Maganlal Meghraj", 13);
        Expense expenseMandar = new Expense("Mandar Bose", 7);
        Expense expenseHalla = new Expense("Halla Raja", 8);

        List<Expense> expenses = new LinkedList<>();
        expenses.add(expenseHirak);
        expenses.add(expenseMaganlal);
        expenses.add(expenseMandar);
        expenses.add(expenseHalla);

        List<Settlement> settlements = handler.handle(expenses);

        assertEquals(3, settlements.size());

        assertEquals("Mandar Bose", settlements.get(0).getFromFullName());
        assertEquals("Hirak Raja", settlements.get(0).getToFullName());
        assertEquals(2, settlements.get(0).getAmount(), 0);

        assertEquals("Mandar Bose", settlements.get(1).getFromFullName());
        assertEquals("Maganlal Meghraj", settlements.get(1).getToFullName());
        assertEquals(1, settlements.get(1).getAmount(), 0);

        assertEquals("Halla Raja", settlements.get(2).getFromFullName());
        assertEquals("Maganlal Meghraj", settlements.get(2).getToFullName());
        assertEquals(2, settlements.get(2).getAmount(), 0);

    }

    @Test
    public void handleOneZeroExpenseAmount() throws Exception {
        Expense expenseHirak = new Expense("Hirak Raja", 12);
        Expense expenseMaganlal = new Expense("Maganlal Meghraj", 13);
        Expense expenseMandar = new Expense("Mandar Bose", 7);
        Expense expenseHalla = new Expense("Halla Raja", 0);

        List<Expense> expenses = new LinkedList<>();
        expenses.add(expenseHirak);
        expenses.add(expenseMaganlal);
        expenses.add(expenseMandar);
        expenses.add(expenseHalla);

        List<Settlement> settlements = handler.handle(expenses);

        assertEquals(3, settlements.size());

        assertEquals("Mandar Bose", settlements.get(0).getFromFullName());
        assertEquals("Hirak Raja", settlements.get(0).getToFullName());
        assertEquals(1, settlements.get(0).getAmount(), 0);

        assertEquals("Halla Raja", settlements.get(1).getFromFullName());
        assertEquals("Hirak Raja", settlements.get(1).getToFullName());
        assertEquals(3, settlements.get(1).getAmount(), 0);

        assertEquals("Halla Raja", settlements.get(2).getFromFullName());
        assertEquals("Maganlal Meghraj", settlements.get(2).getToFullName());
        assertEquals(5, settlements.get(2).getAmount(), 0);

    }

    @Test
    public void handleThreeZeroExpenseAmount() throws Exception {
        Expense expenseHirak = new Expense("Hirak Raja", 12);
        Expense expenseMaganlal = new Expense("Maganlal Meghraj", 0);
        Expense expenseMandar = new Expense("Mandar Bose", 0);
        Expense expenseHalla = new Expense("Halla Raja", 0);

        List<Expense> expenses = new LinkedList<>();
        expenses.add(expenseHirak);
        expenses.add(expenseMaganlal);
        expenses.add(expenseMandar);
        expenses.add(expenseHalla);

        List<Settlement> settlements = handler.handle(expenses);

        assertEquals(3, settlements.size());

        assertEquals("Maganlal Meghraj", settlements.get(0).getFromFullName());
        assertEquals("Hirak Raja", settlements.get(0).getToFullName());
        assertEquals(3, settlements.get(0).getAmount(), 0);

        assertEquals("Mandar Bose", settlements.get(1).getFromFullName());
        assertEquals("Hirak Raja", settlements.get(1).getToFullName());
        assertEquals(3, settlements.get(1).getAmount(), 0);

        assertEquals("Halla Raja", settlements.get(2).getFromFullName());
        assertEquals("Hirak Raja", settlements.get(2).getToFullName());
        assertEquals(3, settlements.get(2).getAmount(), 0);

    }

    @Test
    public void handleOneExpense() throws Exception {
        Expense expenseHirak = new Expense("Hirak Raja", 10);

        List<Expense> expenses = new LinkedList<>();
        expenses.add(expenseHirak);

        List<Settlement> settlements = handler.handle(expenses);

        assertEquals(0, settlements.size());

    }

    @Test
    public void handleEmptyExpense() throws Exception {
        List<Expense> expenses = new LinkedList<>();

        List<Settlement> settlements = handler.handle(expenses);

        assertEquals(0, settlements.size());

    }

    @Test
    public void handleNullExpense() throws Exception {
        List<Settlement> settlements = handler.handle(null);

        assertEquals(0, settlements.size());

    }


}
