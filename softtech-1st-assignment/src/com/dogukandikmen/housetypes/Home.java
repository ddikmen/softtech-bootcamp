package com.dogukandikmen.housetypes;

import com.dogukandikmen.propertyService.propertyService;

public class Home extends HouseType{

    public Home(){
        setPrice(50);
        setSquareMeter(100);
        setLivingRoomCount(1);
        setRoomCount(2);
        propertyService.homes.add(this);
    }

}
