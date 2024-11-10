package store.dto;

import java.time.LocalDateTime;

public class Promotion {
    private PromotionType promotionType;
    private int buy;
    private int get;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionName(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getGet() {
        return get;
    }

    public void setGet(int get) {
        this.get = get;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
