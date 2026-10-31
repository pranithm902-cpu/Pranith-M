import java.util.ArrayList;

public class AuctionService {
    private ArrayList<Item> items;
    private ArrayList<User> users;
    private int nextBidId;
    private String platformName;
    private double commissionRate;
    private int closedAuctions;

    public AuctionService(String platformName, double commissionRate) {
        this.platformName = platformName;
        this.commissionRate = commissionRate;
        this.items = new ArrayList<>();
        this.users = new ArrayList<>();
        this.nextBidId = 1;
        this.closedAuctions = 0;
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getName());
    }

    public void listItem(Item item) {
        items.add(item);
        System.out.println("Item listed successfully!");
    }

    // Method overloading: default maximum bid equals the submitted bid.
    public void placeBid(Item item, User bidder, double amount) {
        placeBid(item, bidder, amount, amount);
    }

    public void placeBid(Item item, User bidder, double amount, double maxAutoBid) {
        if (!item.isActive()) {
            System.out.println("Auction is closed.");
            return;
        }

        Bid highest = item.getHighestBid();
        double minimum = (highest == null) ? item.getBasePrice() : highest.getAmount();

        if (amount <= minimum || maxAutoBid < amount) {
            System.out.println("Invalid bid amount.");
            return;
        }

        Bid bid = new Bid(nextBidId++, item.getItemId(), bidder, amount);
        item.addBid(bid);
        System.out.println("Bid placed successfully!");
        bid.display();
    }

    public void closeAuction(Item item) {
        if (!item.isActive()) {
            System.out.println("Auction already closed.");
            return;
        }
        item.closeAuction();
        closedAuctions++;
        System.out.println("Auction closed for: " + item.getTitle());
    }

    public User winner(Item item) {
        Bid highest = item.getHighestBid();
        if (highest == null) {
            System.out.println("No bids received.");
            return null;
        }
        return highest.getBidder();
    }

    public void generateInvoice(Item item) {
        if (item.isActive()) {
            System.out.println("Close the auction first.");
            return;
        }

        Bid highest = item.getHighestBid();
        if (highest == null) {
            System.out.println("No invoice. No bids received.");
            return;
        }

        User seller = item.getSeller();
        double fee = seller.calculateFee(highest.getAmount());
        double total = highest.getAmount() + fee;

        System.out.println("\\n========== INVOICE ==========");
        System.out.println("Platform: " + platformName);
        System.out.println("Item: " + item.getTitle());
        System.out.println("Winner: " + highest.getBidder().getName());
        System.out.println("Winning Bid: Rs." + highest.getAmount());
        System.out.println("Seller Fee: Rs." + fee);
        System.out.println("Total Amount: Rs." + total);
        System.out.println("=============================");
    }

    public void listItems() {
        System.out.println("\\n--- ITEM LIST ---");
        for (Item item : items) {
            item.display();
        }
    }

    public void showReport() {
        System.out.println("\\n--- AUCTION REPORT ---");
        System.out.println("Platform: " + platformName);
        System.out.println("Registered Users: " + users.size());
        System.out.println("Total Items: " + items.size());
        System.out.println("Closed Auctions: " + closedAuctions);
        System.out.println("Commission Rate: " + commissionRate * 100 + "%");
    }
}
