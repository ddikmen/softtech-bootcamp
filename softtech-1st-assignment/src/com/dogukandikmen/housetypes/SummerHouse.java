package com.dogukandikmen.housetypes;

import com.dogukandikmen.propertyService.propertyService;

public class SummerHouse extends HouseType{

    public SummerHouse(){
        setPrice(100);
        setSquareMeter(200);
        setLivingRoomCount(1);
        setRoomCount(3);
        propertyService.summerHouses.add(this);
    }

}
