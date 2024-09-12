import java.util.ArrayList;
import java.util.List;

public class UserHistory {
    private List<Order> orders;

    public UserHistory() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        if (orders.isEmpty()) {
            return "Історія замовлень порожня.";
        }
        StringBuilder sb = new StringBuilder("Історія замовлень:\n");
        for (Order order : orders) {
            sb.append(order).append("\n");
        }
        return sb.toString();
    }
}

