package xmu.mystore.goodsmgt.hqchou.model;

import java.io.Serializable;

/**
 * Created by sher on 31/3/2017.
 */

public class Goods implements Serializable {

    public static final long serialVersionUID = 131420;

    private Long id;
    private String name;
    private String serialCode;
    private Double weight;
    private Integer stockNumber;
    private Integer preSaleNumber;
    private Integer storeId;
    private Double midUserPrice;
    private Double marketPrice;
    private Double realPrice;
    private Integer redeemPoint;
    private Integer categoryId;
    private Integer brandId;
    private Long standId;
    private String addTime;
    private String lastModifiedTime;
    private String description;
    private String imagePath;
    private Boolean isDividable;
    private String defaultExpress;

    public Goods() {
    }

    public Goods(String name, String serialCode, Double weight, Integer stockNumber, Integer preSaleNumber, Integer storeId, Double midUserPrice, Double marketPrice, Double realPrice, Integer redeemPoint, Integer categoryId, Integer brandId, Long standId, String addTime, String lastModifiedTime, String description, String imagePath, Boolean isDividable, String defaultExpress) {
        this.name = name;
        this.serialCode = serialCode;
        this.weight = weight;
        this.stockNumber = stockNumber;
        this.preSaleNumber = preSaleNumber;
        this.storeId = storeId;
        this.midUserPrice = midUserPrice;
        this.marketPrice = marketPrice;
        this.realPrice = realPrice;
        this.redeemPoint = redeemPoint;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.standId = standId;
        this.addTime = addTime;
        this.lastModifiedTime = lastModifiedTime;
        this.description = description;
        this.imagePath = imagePath;
        this.isDividable = isDividable;
        this.defaultExpress = defaultExpress;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
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

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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

    public Integer getRedeemPoint() {
        return redeemPoint;
    }

    public void setRedeemPoint(Integer redeemPoint) {
        this.redeemPoint = redeemPoint;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Long getStandId() {
        return standId;
    }

    public void setStandId(Long standId) {
        this.standId = standId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Boolean getDividable() {
        return isDividable;
    }

    public void setDividable(Boolean dividable) {
        isDividable = dividable;
    }

    public String getDefaultExpress() {
        return defaultExpress;
    }

    public void setDefaultExpress(String defaultExpress) {
        this.defaultExpress = defaultExpress;
    }
}
