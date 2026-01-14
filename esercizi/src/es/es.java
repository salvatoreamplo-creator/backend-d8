package es;

public class es {
    List<Product> result1 = products.stream()
            .filter(p -> p.getCategory().equals("Books"))
            .filter(p -> p.getPrice() > 100)
            .toList();
    List<Order> result2 = orders.stream()
            .filter(o -> o.getProducts().stream()
                    .anyMatch(p -> p.getCategory().equals("Baby")))
            .toList();
    List<Product> result3 = products.stream()
            .filter(p -> p.getCategory().equals("Boys"))
            .map(p -> new Product(
                    p.getId(),
                    p.getName(),
                    p.getCategory(),
                    p.getPrice() * 0.9
            ))
            .toList();

    List<Product> result4 = orders.stream()
            .filter(o -> o.getCustomer().getTier() == 2)
            .filter(o -> !o.getOrderDate().isBefore(LocalDate.of(2021, 2, 1)))
            .filter(o -> !o.getOrderDate().isAfter(LocalDate.of(2021, 4, 1)))
            .flatMap(o -> o.getProducts().stream())
            .toList();

}
