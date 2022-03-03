package com.dogukandikmen.main;

import com.dogukandikmen.housetypes.Home;
import com.dogukandikmen.housetypes.HouseType;
import com.dogukandikmen.housetypes.SummerHouse;
import com.dogukandikmen.housetypes.Villa;
import com.dogukandikmen.propertyService.propertyService;

public class Main {
    public static void main(String[] args) {
        HouseType home1 = new Home();
        HouseType home2 = new Home();
        HouseType home3 = new Home();

        HouseType villa1 = new Villa();
        HouseType villa2 = new Villa();
        HouseType villa3 = new Villa();

        HouseType summerHouse1 = new SummerHouse();
        HouseType summerHouse2 = new SummerHouse();
        HouseType summerHouse3 = new SummerHouse();

        propertyService.utilityPrint();

    }
}
