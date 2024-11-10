package store.view;

import store.dto.Product;
import store.repository.MdRepository;

import java.util.List;

public class InputView {
    private static final String startMessage = "안녕하세요. W편의점 입니다.\n현재 보유하고 있는 상품입니다.\n";
    private static final String guideMessage = "\n구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-2])";

    public InputView() {
        System.out.println(startMessage);
        List<Product> productList = getProductList();
        displayProductList(productList);
        System.out.println(guideMessage);
    }

    public List<Product> getProductList() {
        MdRepository mdReadService = new MdRepository();
        return mdReadService.loadProducts();
    }

    private void displayProductList(List<Product> productList) {
        productList.forEach(product -> System.out.println(product.toString()));
    }



}