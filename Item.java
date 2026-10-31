import java.util.ArrayList;

public class Item {
    private int itemId;
    private String title;
    private String description;
    private double basePrice;
    private User seller;
    private boolean active;
    private ArrayList<Bid> bids;

    public Item(int itemId, String title, String description,
                double basePrice, User seller) {
        this.itemId = itemId;
        this.title = title;
        this.description = description;
        this.basePrice = basePrice;
        this.seller = seller;
        this.active = true;
        this.bids = new ArrayList<>();
    }

    public void addBid(Bid bid) { bids.add(bid); }

    public Bid getHighestBid() {
        Bid highest = null;
        for (Bid bid : bids) {
            if (highest == null || bid.getAmount() > highest.getAmount()) {
                highest = bid;
            }
        }
        return highest;
    }

    public void closeAuction() { active = false; }

    public void display() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Base Price: Rs." + basePrice);
        System.out.println("Seller: " + seller.getName());
        System.out.println("Status: " + (active ? "ACTIVE" : "CLOSED"));
    }

    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public double getBasePrice() { return basePrice; }
    public User getSeller() { return seller; }
    public boolean isActive() { return active; }
    public ArrayList<Bid> getBids() { return new ArrayList<>(bids); }
}
