package store.repository;

import store.dto.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
            // 일반 상품이 없는 경우 "재고 없음" 상품 추가
            checkAndAddMissingProducts(productList);
            // 이름별 정렬
//            productList.sort(Comparator.comparing(Product::getName).thenComparing(Product::getPromotion, Comparator.nullsFirst(String::compareTo)));
        } catch (IOException e) {
            System.out.println("Error reading markdown file: " + e.getMessage());
        }

        return productList;
    }

    private void checkAndAddMissingProducts(List<Product> productList) {
        List<Product> checkList = new ArrayList<>();

        for (Product product : productList){
            if(!Objects.equals(product.getPromotion(), "null")){
                checkList.add(product);
//                System.out.println("Null 아닌거 확인:  "+product);
            }
        }
        Product tmpProduct;
        for (int i = 0; i < productList.size()-1; i++){
            tmpProduct = productList.get(i);
            if(tmpProduct.getName().equals(productList.get(i+1).getName())){
                checkList.remove(tmpProduct);
//                System.out.println("지워질 항목 : " + tmpProduct);
            }
        }
//        System.out.println("체크리스트에 담긴 항목은: " + checkList);
        for (Product product : checkList) {
            productList.add(new Product(product.getName(), product.getPrice(), 0, "null"));
        }
    }






//    private void skipColumnName(BufferedReader reader) {
//        reader.readLine();
//    }

}
