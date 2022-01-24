package week14.day01;

import java.util.ArrayList;
import java.util.List;


public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }
}
