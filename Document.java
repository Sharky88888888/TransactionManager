import java.time.LocalDate;

public class Transaction {
    private String type;
    private String category;
    private double amount;
    private LocalDate date;
    private String description;

    public Transaction(String type, String category, double amount, LocalDate date, String description) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getType() { 
        return type; 
    }
    
    public String getCategory() {
        return category; 
    }
    
    public double getAmount() {
        return amount; 
    }
    
    public LocalDate getDate() {
        return date; 
    }
    
    public String getDescription() {
        return description; 
    }

    @Override
    public String toString() {
        return date + " | " + type + " | " + category + " | $" + amount + " | " + description;
    }
}
