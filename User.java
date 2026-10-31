public class User {
    private int userId;
    private String name;
    private String email;
    private double rating;
    private String role;

    public User(int userId, String name, String email, double rating, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.role = role;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getRating() { return rating; }
    public String getRole() { return role; }

    public double calculateFee(double amount) {
        return amount * 0.05;
    }

    public void display() {
        System.out.println("User: " + name + " | Role: " + role);
    }
}
