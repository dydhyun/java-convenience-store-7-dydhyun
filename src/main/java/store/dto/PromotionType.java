package store.dto;

public enum PromotionType {
    NONE("null"),
    CARBONATED("탄산2+1"),
    MD_RECOMMEND("MD추천상품"),
    FLASH_SALE("반짝할인");

    private final String description;

    PromotionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PromotionType fromString(String text) {
        for (PromotionType promotion : PromotionType.values()) {
            if (promotion.description.equalsIgnoreCase(text)) {
                return promotion;
            }
        }
        return NONE;  // 기본값을 설정
    }
}
