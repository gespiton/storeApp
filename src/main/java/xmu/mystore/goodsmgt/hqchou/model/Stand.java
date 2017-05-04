package xmu.mystore.goodsmgt.hqchou.model;

import java.io.Serializable;

/**
 * Created by sher on 4/5/2017.
 */
public class Stand implements Serializable {
    public static final long serialVersionUID = 131421;

    private Long id;
    private Long goodsID;
    private Double midUserPrice;
    private Double marketPrice;
    private Double realPrice;
    private String onMarketTime;
    private String offMarketTime;
    private Long preSaleCount;
    private Goods goods;
    public Stand() {
    }

    public Stand(Long goodsID, Double midUserPrice, Double marketPrice, Double realPrice, String onMarketTime,
                 String offMarketTime, Long preSaleNumber) {
        this.goodsID = goodsID;
        this.midUserPrice = midUserPrice;
        this.marketPrice = marketPrice;
        this.realPrice = realPrice;
        this.offMarketTime = offMarketTime;
        this.preSaleCount = preSaleNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Long goodsID) {
        this.goodsID = goodsID;
    }

    public Double getMidUserPrice() {
        return midUserPrice;
    }

    public void setMidUserPrice(Double midUserPrice) {
        this.midUserPrice = midUserPrice;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public String getOffMarketTime() {
        return offMarketTime;
    }

    public void setOffMarketTime(String offMarketTime) {
        this.offMarketTime = offMarketTime;
    }

    public String getOnMarketTime() {
        return onMarketTime;
    }

    public void setOnMarketTime(String onMarketTime) {
        this.onMarketTime = onMarketTime;
    }

    public Long getPreSaleCount() {
        return preSaleCount;
    }

    public void setPreSaleCount(Long preSaleCount) {
        this.preSaleCount = preSaleCount;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
