package com.cts.essentialsneeds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.StringUtils;

import java.util.List;

public class Store {

    private Long storeId;
    private String storeLocation;
    private String storeType;
    private String storeName;
    private String address;
    private Long mobileNumber;
    private String img;
    @JsonIgnore
    private List<Item> items;

    public Store() {
    }

    public Store(Long storeId, String storeLocation,String storeType,  String storeName, String address, Long mobileNumber, List<Item> items, String img) {
        this.storeId = storeId;
        this.storeLocation = storeLocation;
        this.storeType = storeType;
        this.storeName = storeName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.items = items;
        this.img = img;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
