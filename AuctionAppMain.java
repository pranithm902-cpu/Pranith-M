public class AuctionAppMain {
    public static void main(String[] args) {
        AuctionService service = new AuctionService("Online Auction", 0.05);

        VerifiedSeller seller = new VerifiedSeller(
                101, "Arun", "arun@gmail.com", 4.8, 10, 0.03);
        User buyer1 = new User(102, "Kumar", "kumar@gmail.com", 4.5, "Buyer");
        User buyer2 = new User(103, "Ravi", "ravi@gmail.com", 4.6, "Buyer");

        service.registerUser(seller);
        service.registerUser(buyer1);
        service.registerUser(buyer2);

        // Polymorphism: parent reference refers to a child-class object.
        User sellerReference = seller;
        sellerReference.display();

        Item laptop = new Item(201, "Laptop", "Dell Laptop, 16GB RAM",
                30000, seller);
        service.listItem(laptop);
        service.listItems();

        service.placeBid(laptop, buyer1, 32000);
        service.placeBid(laptop, buyer2, 35000, 40000);

        User winner = service.winner(laptop);
        if (winner != null) {
            System.out.println("\\nAuction Winner: " + winner.getName());
        }

        service.closeAuction(laptop);
        service.generateInvoice(laptop);
        service.showReport();
    }
}
