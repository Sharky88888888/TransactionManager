import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FinanceManager fm = new FinanceManager();

        try { fm.loadFromFile("data/finance_data.csv"); } catch(Exception e){System.out.println("No previous data found."); }

        boolean running = true;
        while(running){
            System.out.println("\nOptions: add, remove, list, report, save, exit");
            System.out.print("Choose: ");
            String cmd = sc.nextLine().toLowerCase();
            switch(cmd){
                case "add":
                    System.out.print("Type (income/expense): "); String type = sc.nextLine();
                    System.out.print("Category: "); String cat = sc.nextLine();
                    System.out.print("Amount: "); double amt = Double.parseDouble(sc.nextLine());
                    System.out.print("Description: "); String desc = sc.nextLine();
                    fm.addTransaction(new Transaction(type, cat, amt, LocalDate.now(), desc));
                    break;
                case "remove":
                    System.out.print("Index to remove: "); int idx = Integer.parseInt(sc.nextLine());
                    fm.removeTransaction(idx);
                    break;
                case "list":
                    fm.listTransactions();
                    break;
                case "report":
                    fm.reportByCategory();
                    break;
                case "save":
                    fm.saveToFile("data/finance_data.csv");
                    System.out.println("Data saved.");
                    break;
                case "exit":
                    running=false;
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
        sc.close();
    }
}
