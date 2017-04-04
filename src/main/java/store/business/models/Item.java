package store.business.models;

import java.io.Serializable;

/**
 * Created by sher on 31/3/2017.
 */

public class Item implements Serializable {

    public static final long serialVersionUID = 131420;

    private Long id;
    private String name;
    private Long serialCode;
    private Double weight;
    private Integer stockNumber;
    private Integer preSaleNumber;
    private String shop;
    private Double introducedPrice;
    private Double marketPrice;
    private Double bankPrice;
    private Integer exchangeCredit;
    private String categoryName;
    private String brandName;
    private String onMarketTime;
    private String outMarketTime;
    private String addedTime;
    private String lastModifiedTime;
    private String description;
    private String imageNumber;
    private Boolean isDividable;

    public Item() {
    }

    public Item(Long id, String name, Long serialCode, Double weight, Integer stockNumber, Integer preSaleNumber, String shop, Double introducedPrice, Double marketPrice, Double bankPrice, Integer exchangeCredit, String categoryName, String brandName, String onMarketTime, String outMarketTime, String addedTime, String lastModifiedTime, String description, String imageNumber, Boolean isDividable) {
        this.id = id;
        this.name = name;
        this.serialCode = serialCode;
        this.weight = weight;
        this.stockNumber = stockNumber;
        this.preSaleNumber = preSaleNumber;
        this.shop = shop;
        this.introducedPrice = introducedPrice;
        this.marketPrice = marketPrice;
        this.bankPrice = bankPrice;
        this.exchangeCredit = exchangeCredit;
        this.categoryName = categoryName;
        this.brandName = brandName;
        this.onMarketTime = onMarketTime;
        this.outMarketTime = outMarketTime;
        this.addedTime = addedTime;
        this.lastModifiedTime = lastModifiedTime;
        this.description = description;
        this.imageNumber = imageNumber;
        this.isDividable = isDividable;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    public Long getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(long serialCode) {
        this.serialCode = serialCode;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Integer getPreSaleNumber() {
        return preSaleNumber;
    }

    public void setPreSaleNumber(Integer preSaleNumber) {
        this.preSaleNumber = preSaleNumber;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public Double getIntroducedPrice() {
        return introducedPrice;
    }

    public void setIntroducedPrice(Double introducedPrice) {
        this.introducedPrice = introducedPrice;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getBankPrice() {
        return bankPrice;
    }

    public void setBankPrice(Double bankPrice) {
        this.bankPrice = bankPrice;
    }

    public Integer getExchangeCredit() {
        return exchangeCredit;
    }

    public void setExchangeCredit(Integer exchangeCredit) {
        this.exchangeCredit = exchangeCredit;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getOnMarketTime() {
        return onMarketTime;
    }

    public void setOnMarketTime(String onMarketTime) {
        this.onMarketTime = onMarketTime;
    }

    public String getOutMarketTime() {
        return outMarketTime;
    }

    public void setOutMarketTime(String outMarketTime) {
        this.outMarketTime = outMarketTime;
    }

    public String getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(String addedTime) {
        this.addedTime = addedTime;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(String imageNumber) {
        this.imageNumber = imageNumber;
    }

    public Boolean getDividable() {
        return isDividable;
    }

    public void setDividable(Boolean dividable) {
        isDividable = dividable;
    }
}
