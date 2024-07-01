import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String name;
    private double amount;
    private String category;

    public Expense(String name, double amount, String category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                '}';
    }
}

public class ExpenseTracker {
    private List<Expense> expenses;
    private Scanner scanner;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addExpense() {
        System.out.print("Enter expense name: ");
        String name = scanner.nextLine();

        System.out.print("Enter expense amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();

        Expense expense = new Expense(name, amount, category);
        expenses.add(expense);

        System.out.println("Expense added successfully.");
    }

    public void viewExpenses() {
        System.out.println("Expense List:");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    tracker.addExpense();
                    break;
                case 2:
                    tracker.viewExpenses();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
