package store.dto;

public class Product {
    private String name;
    private int price;
    private int quantity;
    private String promotion;

    public Product(String name, int price, int quantity, String promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }


    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getPromotion() { return promotion; }

    @Override
    public String toString(){
        if (quantity == 0){
            return "- " + name + " " + price + "원 재고 없음";
        }
        if (promotion.equals("null")) {
            return "- " + name + " " + price + "원 " + quantity + "개";
        }
        return "- " + name + " " + price + "원 " + quantity + "개 " + promotion;
    }

}
