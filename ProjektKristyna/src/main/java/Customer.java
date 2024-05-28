import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private ArrayList<Order> orders;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.orders = new ArrayList<>();
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public void removeOrder (Order order){
        orders.remove(order);
    }

    public String getName() {
        return name;
    }
}
