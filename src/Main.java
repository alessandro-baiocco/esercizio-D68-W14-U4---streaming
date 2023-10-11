import market.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {


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


        System.out.println("*******************esercizio1***********************");
        Predicate<Product> isABook = Product -> Objects.equals(Product.getCategory(), "book");
        Predicate<Product> moreThanHundred = Product -> Product.getPrice() > 100;
        catalogo.stream().filter(isABook.and(moreThanHundred)).forEach(product -> System.out.println(product.toString()));


        System.out.println("*******************esercizio2***********************");

        Predicate<Product> isForChildren = Product -> Objects.equals(Product.getCategory(), "baby");

        for (Product product : catalogo) {
            if (isForChildren.test(product)) System.out.println(product);
        }


    }

}