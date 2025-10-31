import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class FinanceManager {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t) { 
      transactions.add(t); 
    }
    public void removeTransaction(int index) { 
      if(index>=0 && index<transactions.size()) 
        transactions.remove(index); 
    }
    public void listTransactions() { 
      for (Transaction t : transactions) {
        System.out.println(t);
      } 
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for(Transaction t : transactions){
            writer.write(t.getDate() + "," + t.getType() + "," + t.getCategory() + "," + t.getAmount() + "," + t.getDescription() + "\n");
        }
        writer.close();
    }

    public void loadFromFile(String filename) throws IOException {
        transactions.clear();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while((line=reader.readLine())!=null){
            String[] parts = line.split(",");
            Transaction t = new Transaction(parts[1], parts[2], Double.parseDouble(parts[3]), LocalDate.parse(parts[0]), parts[4]);
            transactions.add(t);
        }
        reader.close();
    }

    public void reportByCategory(){
        Map<String, Double> summary = new HashMap<>();
        for(Transaction t: transactions){
            summary.put(t.getCategory(), summary.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
        }
        System.out.println("Expenses/Income by Category:");
        summary.forEach((k,v)->System.out.println(k + ": $" + v));
    }
}
