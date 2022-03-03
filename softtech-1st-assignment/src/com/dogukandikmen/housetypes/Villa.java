package com.dogukandikmen.housetypes;

import com.dogukandikmen.propertyService.propertyService;

public class Villa extends HouseType{

    public Villa(){
        setPrice(150);
        setSquareMeter(400);
        setLivingRoomCount(2);
        setRoomCount(5);
        propertyService.villas.add(this);
    }

}
