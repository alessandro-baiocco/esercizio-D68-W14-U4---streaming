import market.Customer;
import market.Order;
import market.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        LocalDate primoFeb = LocalDate.parse("2023-01-02", DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        LocalDate primoApr = LocalDate.parse("2023-01-04", DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        LocalDate date = LocalDate.parse("2023-21-03", DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        LocalDate date1 = LocalDate.parse("2023-18-02", DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        LocalDate date2 = LocalDate.parse("2023-05-01", DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        LocalDate date3 = LocalDate.parse("2023-07-08", DateTimeFormatter.ofPattern("yyyy-dd-MM"));


        List<Product> catalogo = new ArrayList<>();
        Product prodotto = new Product("libro0", "book", 4.99);
        catalogo.add(new Product("libro1", "book", 152.45));
        catalogo.add(new Product("libro2", "book", 50.32));
        catalogo.add(new Product("libro3", "book", 120.99));
        catalogo.add(new Product("libro4", "book", 200.99));
        catalogo.add(new Product("coso0", "baby", 4.99));
        catalogo.add(new Product("coso1", "baby", 152.45));
        catalogo.add(new Product("coso2", "baby", 50.32));
        catalogo.add(new Product("coso3", "baby", 120.99));
        catalogo.add(new Product("coso4", "baby", 200.99));
        catalogo.add(new Product("boh0", "boys", 4.99));
        catalogo.add(new Product("boh1", "boys", 152.45));
        catalogo.add(new Product("boh2", "boys", 50.32));
        catalogo.add(new Product("boh3", "boys", 120.99));
        catalogo.add(new Product("boh4", "boys", 200.99));

        List<Product> cart = new ArrayList<>();

        cart.add(catalogo.get(0));
        cart.add(catalogo.get(3));

        List<Customer> clienti = new ArrayList<>();
        clienti.add(new Customer("coso", 2));
        clienti.add(new Customer("pinko", 1));
        clienti.add(new Customer("pallino", 2));
        clienti.add(new Customer("francescano", 3));


        List<Order> ordini = new ArrayList<>();
        ordini.add(new Order(date1, date, cart, clienti.get(3)));
        ordini.add(new Order(date2, date3, cart, clienti.get(1)));
        ordini.add(new Order(date3, date2, cart, clienti.get(2)));
        ordini.add(new Order(date1, date, cart, clienti.get(3)));
        ordini.add(new Order(date, date2, cart, clienti.get(0)));


        System.out.println("*******************esercizio1***********************");
        Predicate<Product> isABook = Product -> Objects.equals(Product.getCategory(), "book");
        Predicate<Product> moreThanHundred = Product -> Product.getPrice() > 100;
        catalogo.stream().filter(isABook.and(moreThanHundred)).forEach(product -> System.out.println(product.toString()));


        System.out.println("*******************esercizio2***********************");

        Predicate<Product> isForChildren = Product -> Objects.equals(Product.getCategory(), "baby");

        for (Product product : catalogo) {
            if (isForChildren.test(product)) System.out.println(product);
        }

        System.out.println("*******************esercizio3***********************");

        Predicate<Product> forBoys = Product -> Objects.equals(Product.getCategory(), "boys");

        catalogo.stream().filter(forBoys).forEach(Product -> {
            System.out.println("0% off : " + Product);
            Product.setPrice((Product.getPrice() / 100) * 90);
            System.out.println("10% off : " + Product);
        });


        System.out.println("*******************esercizio4***********************");

        Predicate<Order> isRightDate = Order -> Order.getOrderDate().isAfter(primoFeb) && Order.getOrderDate().isBefore(primoApr);
        Predicate<Order> rightTier = Order -> Order.getCustTier(Order.getCustomer()) == 2;

        ordini.stream().filter(isRightDate.and(rightTier)).forEach(order -> System.out.println(order.toString()));


    }
}