package kitm;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Customer> getCustomers()
    {
        return customers;
    }

    public boolean newCustomer(String name, double transaction)
    {
        if (findCustomer(name) == null)
        {
            customers.add(new Customer(name, transaction));

            return true;
        }

        return false;
    }

    public boolean addCustomerTransaction(String name, double transaction)
    {
        Customer customer = findCustomer(name);

        if (customer != null)
        {
            customer.addTransaction(transaction);
            return true;

        }

        return false;
    }

    private Customer findCustomer(String name)
    {
        for (Customer i : customers)
        {
            if (i.getName().equals(name))
            {
                return i;
            }
        }

        return null;
    }
}
