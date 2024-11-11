package store.service;

import store.dto.Product;
import store.dto.PromotionType;
import store.view.InputView;

import java.util.List;

public class ConvenienceStoreService {
    private PromotionType promotionType;

    public ConvenienceStoreService(InputView inputView, List<Product> userOrderList) {
//        promotionApply(userOrderList);
        System.out.println("inputView 에서 호출한 pl" + inputView.getProductList());
        System.out.println("convenienceStoreService : userOrderList : " + userOrderList);

    }

    private boolean isPromotion(List<Product> userOrderList){
        for (int i = 0; i <userOrderList.size(); i++){
            userOrderList.get(i);
        }
        // userOrderList 를 순회하며 i 번째 에 프로모션이 있는지 확인하고 저장하기

        return false;
    }

    private void promotionApply(){
//        2+1 적용되면 메서드 호출
        if (isTowGetOne()) {
            buyTwoGetOnePromotion();
            System.out.println("2+1");
            return;
        }
//        1+1 적용되면 메서드 호출
        if (isOneGetOne()){
            buyOneGetOnePromotion();
            System.out.println("1+1");
            return;
        }
//        프로모션 적용안되면 메서드 호출
        applyNoPromotion();
        System.out.println("noPromotions");
    }

    private boolean isTowGetOne(){
        return false;
    }
    // 프로모션타입에 따른 2+1 메서드
    public void buyTwoGetOnePromotion() {

    }

    private boolean isOneGetOne(){
        return true;
    }
    // 프로모션타입에 따른 1+1 메서드
    public void buyOneGetOnePromotion() {

    }

    // 프로모션 적용 안될시 호출할 메서드
    public void applyNoPromotion() {

    }

    // 맴버십 할인 받을지 메서드 : 프로모션 미적용 금액의 30%를 프로모션 적용 후 남은금액에서 할인하기. 최대 8000원 한도
    public void membershipDiscount() {

    }

    // 전체에서 차감하는 메서드
    public void calculateFinalAmount() {

    }

    // 영수증 출력하는 메서드 는 OutputView 의 역할


}
