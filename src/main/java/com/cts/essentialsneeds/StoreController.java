package com.cts.essentialsneeds;

import com.cts.essentialsneeds.model.Item;
import com.cts.essentialsneeds.model.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/storeCon")
public class StoreController {

    @RequestMapping(value = "/displayStores" , method = RequestMethod.GET)
    public List<Store> displayStores(@RequestParam(value = "needType", required = true)String keyword, @RequestParam(value = "location", required = true)String location, Model model)
            throws IOException {

        List<Store> storeList = getStoreData();
        List<Store> storeListBykey = storeList.stream().filter(s-> s.getStoreType().equals(keyword)).collect(Collectors.toList());

        if(!StringUtils.isEmpty(location) && storeListBykey.size()>0) {
            List<Store> storeListBylocation = storeListBykey.stream().filter(s -> s.getStoreLocation().equals(location)).collect(Collectors.toList());
            model.addAttribute("storeList", storeListBylocation);
            return storeListBylocation;
        }
        else if (storeListBykey.size()>0){
            model.addAttribute("storeList", storeListBykey);
            return storeListBykey;
        }else {
            model.addAttribute("storeList", new ArrayList<>());
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "/displayItems" , method = RequestMethod.GET)
    public List<Item> displayItems(@RequestParam(value = "id", required = true)int id, @RequestParam(value = "type", required = true)String type, Model model)
            throws IOException {

        Store store = new Store();
        List<Store> storeList = getStoreData();

        for(Store s : storeList){
            if(id == s.getStoreId()){
                store = s;
                break;
            }
        }

        if(type.equals(store.getStoreType())) {
            model.addAttribute("items", store.getItems());
        }
        if(store != null) {
            return store.getItems();
        }else {
            return new ArrayList<Item>();
        }

    }

    private List<Store> getStoreData(){
        List<Store> stores = new ArrayList<>();
        List<Item> items = new ArrayList<>();

        items.add(new Item("paracetamol", "₹ 10", "10 Nos"));
        items.add(new Item("vicks", "₹ 5", "20 Nos"));
        stores.add(new Store(1l,"Bangalore","Medicines","Medical Store", "Manyata", 123456789l,items, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Medplus_logo.jpg/220px-Medplus_logo.jpg"));

        items = new ArrayList<>();
        items.add(new Item("sinarest", "₹ 15","10 Nos"));
        items.add(new Item("zyncet", "₹ 25","10 Nos"));
        stores.add(new Store(2l,"Chennai","Medicines","General Medical Store","Mahatma gandhi road", 987654321l,items, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Medplus_logo.jpg/220px-Medplus_logo.jpg"));

        items = new ArrayList<>();
        items.add(new Item("potato", "₹ 50", "1 KG"));
        items.add(new Item("tomato", "₹ 30", "2 KG"));
        stores.add(new Store(3l,"Bangalore","Vegetables","Green vegetable","Manyata", 123456789l,items, "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=50,w=290,h=280/app/images/category/cms_images/icon/icon_cat_1487_v_3_500_1580063978.jpg"));

        items = new ArrayList<>();
        items.add(new Item("tomato", "₹ 25","3 KG"));
        items.add(new Item("cabbage", "₹ 25","1 KG"));
        stores.add(new Store(4l,"Chennai","Vegetables","All Vegetable","Mahatma gandhi road", 987654321l,items, "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=50,w=290,h=280/app/images/category/cms_images/icon/icon_cat_1487_v_3_500_1580063978.jpg"));

        items = new ArrayList<>();
        items.add(new Item("oil", "₹ 200", "1 KG"));
        items.add(new Item("rice", "₹ 60", "2 KG"));
        stores.add(new Store(5l,"Bangalore","Grocery","General store","Manyata", 123456789l,items, "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=50,w=290,h=280/app/images/category/cms_images/icon/icon_cat_18_v_3_500_1584355882.jpg"));

        items = new ArrayList<>();
        items.add(new Item("wheat floor", "₹ 50", "5 KG"));
        items.add(new Item("ghee", "₹ 500","1 KG"));
        stores.add(new Store(6l,"Chennai","Grocery","Capital store","Mahatma gandhi road", 987654321l,items, "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=50,w=290,h=280/app/images/category/cms_images/icon/icon_cat_18_v_3_500_1584355882.jpg"));

        items = new ArrayList<>();
        items.add(new Item("grapes", "₹ 100", "1 KG"));
        items.add(new Item("orange", "₹ 80", "2 KG"));
        stores.add(new Store(7l,"Bangalore","Fruits","Palamuthir Solai","Manyata", 123456789l,items, "https://www.bigbasket.com/media/customPage/355c27b8-a44f-4900-a390-8e82c69b8021/6f7d5511-eb2f-4631-a10f-be4e15d82910/dddde6ba-4399-4675-96c7-c5d210e5128e/T1_All_Fresh-Fruits_DT_1_480x360_25thMar.jpg"));

        items = new ArrayList<>();
        items.add(new Item("apple", "₹ 200", "2 KG"));
        items.add(new Item("orange", "₹ 70","1 KG"));
        stores.add(new Store(8l,"Chennai","Fruits","Capital store","Mahatma gandhi road", 987654321l,items,"https://www.bigbasket.com/media/customPage/355c27b8-a44f-4900-a390-8e82c69b8021/6f7d5511-eb2f-4631-a10f-be4e15d82910/dddde6ba-4399-4675-96c7-c5d210e5128e/T1_All_Fresh-Fruits_DT_1_480x360_25thMar.jpg"));
        return stores;

    }


}
