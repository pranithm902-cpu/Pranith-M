import java.time.LocalDateTime;

public class Bid {
    private int bidId;
    private int itemId;
    private User bidder;
    private double amount;
    private String time;
    private String status;

    public Bid(int bidId, int itemId, User bidder, double amount) {
        this.bidId = bidId;
        this.itemId = itemId;
        this.bidder = bidder;
        this.amount = amount;
        this.time = LocalDateTime.now().toString();
        this.status = "PLACED";
    }

    public int getBidId() { return bidId; }
    public int getItemId() { return itemId; }
    public User getBidder() { return bidder; }
    public double getAmount() { return amount; }
    public String getTime() { return time; }
    public void updateStatus(String status) { this.status = status; }
    public String getStatus() { return status; }

    public void display() {
        System.out.println("Bid ID: " + bidId + " | Bidder: " + bidder.getName()
                + " | Amount: Rs." + amount + " | Status: " + status);
    }
}
