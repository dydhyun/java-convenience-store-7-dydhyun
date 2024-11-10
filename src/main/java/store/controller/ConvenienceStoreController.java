package store.controller;

import store.dto.Product;
import store.service.ConvenienceStoreService;
import store.service.ValidateService;
import store.view.InputView;

import java.util.List;

public class ConvenienceStoreController {

    public void enterStore() {
        InputView inputView = new InputView();
        ValidateService validateService = new ValidateService(inputView);
        List<Product> userOrderList = validateService.getUserOrder();
        System.out.println(userOrderList);
        ConvenienceStoreService convenienceStoreService = new ConvenienceStoreService(inputView, userOrderList);

    }

}
