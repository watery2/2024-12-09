package kitm;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank(String name)
    {
        this.name = name;
    }

    public boolean addBranch(String name)
    {
        if (findBranch(name) == null)
        {
            branches.add(new Branch(name));

            return true;
        }

        return false;
    }

    public boolean addCustomer(String nameOfBranch, String nameOfCustomer, double transaction)
    {
        Branch branch = findBranch(nameOfBranch);

        if (branch != null)
        {
            return branch.newCustomer(nameOfCustomer, transaction);
        }

        return false;
    }

    public boolean addCustomerTransaction(String nameOfBranch, String nameOfCustomer, double transaction)
    {
        Branch branch = findBranch(nameOfBranch);

        if (branch != null)
        {
            return branch.addCustomerTransaction(nameOfCustomer, transaction);
        }

        return false;
    }


    private Branch findBranch(String name)
    {
        for (Branch i : branches)
        {
            if (i.getName().equals(name))
            {
                return i;
            }
        }

        return null;
    }

    public boolean listCustomers(String name, boolean print)
    {
        Branch branch = findBranch(name);

        if (branch != null)
        {
            if (print) {
                System.out.println("Customer details for branch " + name);

                ArrayList<Customer> customers = branch.getCustomers();

                int nr = 1;

                for (Customer i : customers) {
                    System.out.println("Customer: " + i.getName() + "[" + nr + "]");
                    System.out.println("Transactions");

                    ArrayList<Double> transactions = i.getTransactions();

                    int tNr = 1;

                    for (Double j : transactions) {
                        System.out.println("[" + tNr + "] Amount " + j);

                        tNr++;
                    }

                    nr++;
                }
            }
            else
            {
                System.out.println("Customer details for branch " + name);

                ArrayList<Customer> customers = branch.getCustomers();

                int nr = 1;

                for (Customer i : customers) {
                    System.out.println("Customer: " + i.getName() + "[" + nr + "]");

                    nr++;
                }
            }

            return true;
        }

        return false;
    }
}
