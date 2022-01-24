package week14.day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    public long countOrderNumbersByStatus(String status) {
        return orders.stream()
                .filter(o -> o.getStatus().equals(status))
                .count();
    }

    public List<Order> getOrdersBetweenDates(LocalDate start, LocalDate end) {
        return orders.stream()
                .filter(o -> o.getOrderDate().isAfter(start) && o.getOrderDate().isBefore(end))
                .collect(Collectors.toList());
    }

    public boolean isLessThan(int minOrders) {
        return orders.stream()
                .anyMatch(o -> o.getProducts().size() < minOrders);
    }

    public Order mostProductsInOrder() {
        return orders.stream()
                .max(Comparator.comparingInt(o -> o.getProducts().size()))
                .orElseThrow(() -> new IllegalStateException("List is empty!"));
    }

    public List<Order> getOrdersMatchCategory(String category) {
        return orders.stream()
                .filter(o -> o.getProducts()
                        .stream()
                        .anyMatch(p->p.getCategory().equals(category)))
                .collect(Collectors.toList());
    }
}
