package store.repository;

import store.dto.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MdRepository {

    public List<Product> loadProducts() {

        List<Product> productList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/products.md"));
            String str;

            reader.readLine();

            while ((str = reader.readLine()) != null) {
                String[] itemData = str.split(",");
                String name = itemData[0].trim();
                int price = Integer.parseInt(itemData[1].trim());
                int quantity = Integer.parseInt(itemData[2].trim());
                String promotion = itemData[3].trim();

                Product product = new Product(name, price, quantity, promotion);
                productList.add(product);
            }
        } catch (IOException e) {
            System.out.println("Error reading markdown file: " + e.getMessage());
        }

        return productList;
    }

//    private void skipColumnName(BufferedReader reader) {
//        reader.readLine();
//    }

}
