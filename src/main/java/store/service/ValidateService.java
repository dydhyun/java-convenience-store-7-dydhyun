package store.service;

import camp.nextstep.edu.missionutils.Console;
import store.dto.Product;
import store.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ValidateService {

    private final InputView inputView;
    private final String userOrder;

    public ValidateService(InputView inputView) {
        this.inputView = inputView;
        this.userOrder = Console.readLine();
    }

    // 유효성 검사 메서드
    private boolean validateUserOrderFormat() {
        String[] items = userOrder.split(",");

        for (String item : items) {
            // 상품명과 수량이 올바른 형식인지 검사
            if (!isValidQuantityFormat(item) || !isValidProductName(deleteBracket(item.split("-")[0]))) {
                System.out.println("검사 실패. 형식이 올바르지 않습니다.");
                return false;
            }
        }
        System.out.println("검사 성공");
        return true;
    }

    // 수량 형식 확인
    private boolean isValidQuantityFormat(String userOrder) {
        return userOrder.matches("^\\[[가-힣]+-\\d+\\]$");
    }

    // 상품명이 유효한지 확인
    private boolean isValidProductName(String orderName) {
        List<Product> productList = inputView.getProductList();
        return productList.stream().anyMatch(product -> product.getName().trim().equals(orderName));
    }

    // 대괄호 제거 메서드
    private String deleteBracket(String input) {
        return input.replaceAll("[\\[\\]]", "");
    }

    // 유효성 검사 후 주문을 가져오는 메서드
    public List<Product> getUserOrder() {
        if (!validateUserOrderFormat()) {  // 유효성 검사 후에만 getUserOrder를 진행
            System.out.println("유효하지 않은 주문 형식입니다.");
            return new ArrayList<>();  // 빈 리스트 반환
        }

        String[] items = userOrder.split(",");
        List<Product> userOrderList = new ArrayList<>();

        for (String item : items) {
            String cleanedItem = deleteBracket(item);
            String[] parts = cleanedItem.split("-");  // [상품명, 수량]으로 분리
            String productName = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            inputView.getProductList().stream()
                    .filter(product -> product.getName().equals(productName))
                    .findFirst()
                    .ifPresent(product -> userOrderList.add(new Product(product.getName(), product.getPrice(), quantity, product.getPromotion())));
        }

        return userOrderList;
    }
}
