package kitm;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String name, double num)
    {
        this.name = name;
        transactions.add(num);
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Double> getTransactions()
    {
        return transactions;
    }

    public void addTransaction(double num)
    {
        transactions.add(num);
    }
}
