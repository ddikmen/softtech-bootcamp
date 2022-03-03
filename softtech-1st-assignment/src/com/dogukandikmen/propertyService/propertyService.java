package com.dogukandikmen.propertyService;

import com.dogukandikmen.housetypes.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class propertyService {

    public static List<Home> homes = new ArrayList<>();
    public static List<Villa> villas= new ArrayList<>();
    public static List<SummerHouse> summerHouses= new ArrayList<>();

    public static int getTotalPriceOfHomes(){
        int totalPrice = 0;
        for(Home home : homes){
            totalPrice += home.getPrice();
        }
        return totalPrice;
    }

    public static int getTotalPriceOfSummerHouses(){
        int totalPrice = 0;
        for(SummerHouse summerHouse : summerHouses){
            totalPrice += summerHouse.getPrice();
        }
        return totalPrice;
    }

    public static int getTotalPriceOfVillas(){
        int totalPrice = 0;
        for(Villa villa: villas){
            totalPrice += villa.getPrice();
        }
        return totalPrice;
    }

    public static int getTotalPriceOfAllHouses(){
        int totalPrice = 0;
        for(Home home : homes){
            totalPrice += home.getPrice();
        }
        for(Villa villa: villas){
            totalPrice += villa.getPrice();
        }
        for(SummerHouse summerHouse : summerHouses){
            totalPrice += summerHouse.getPrice();
        }
        return totalPrice;
    }

    public static float getAvgAreaOfHomes(){
        BigDecimal avgArea;
        BigDecimal sum = new BigDecimal(0);
        BigDecimal sampleCount = new BigDecimal(homes.size());
        for(Home home : homes){
            sum = sum.add(BigDecimal.valueOf(home.getSquareMeter()));
        }
        avgArea = sum.divide(sampleCount);
        return avgArea.floatValue();
    }

    public static float getAvgAreaOfVillas(){
        BigDecimal avgArea;
        BigDecimal sum = new BigDecimal(0);
        BigDecimal sampleCount = new BigDecimal(villas.size());
        for(Villa villa : villas){
            sum = sum.add(BigDecimal.valueOf(villa.getSquareMeter()));
        }
        avgArea = sum.divide(sampleCount);
        return avgArea.floatValue();
    }

    public static float getAvgAreaOfSummerHouses(){
        BigDecimal avgArea;
        BigDecimal sum = new BigDecimal(0);
        BigDecimal sampleCount = new BigDecimal(summerHouses.size());
        for(SummerHouse summerHouse : summerHouses){
            sum = sum.add(BigDecimal.valueOf(summerHouse.getSquareMeter()));
        }
        avgArea = sum.divide(sampleCount);
        return avgArea.floatValue();
    }

    public static float getAvgAreaOfAllHouses(){
        BigDecimal avgArea;
        BigDecimal sum = new BigDecimal(0);
        int temp = homes.size() + villas.size() + summerHouses.size();
        BigDecimal sampleCount = new BigDecimal(temp);
        for(Home home : homes){
            sum = sum.add(BigDecimal.valueOf(home.getSquareMeter()));
        }
        for(Villa villa : villas){
            sum = sum.add(BigDecimal.valueOf(villa.getSquareMeter()));
        }
        for(SummerHouse summerHouse : summerHouses){
            sum = sum.add(BigDecimal.valueOf(summerHouse.getSquareMeter()));
        }
        avgArea = sum.divide(sampleCount, 2, RoundingMode.HALF_UP);
        return avgArea.floatValue();
    }

    public static List<HouseType> getByRoomAndLivingRoomCount(int roomCount, int livingRoomCount){
        List<HouseType> resultList = new ArrayList<>();
        for(Home home : homes){
            if(isRoomCountMatch(home,roomCount) && isLivingRoomCountMatch(home,livingRoomCount))
                resultList.add(home);
        }
        for(Villa villa : villas){
            if(isRoomCountMatch(villa,roomCount) && isLivingRoomCountMatch(villa,livingRoomCount))
                resultList.add(villa);
        }
        for(SummerHouse summerHouse : summerHouses){
            if(isRoomCountMatch(summerHouse,roomCount) && isLivingRoomCountMatch(summerHouse,livingRoomCount))
                resultList.add(summerHouse);
        }
        return resultList;
    }

    public static void utilityPrint(){
        System.out.println("Total of home prices: " + getTotalPriceOfHomes());
        System.out.println("Total of villa prices: " + getTotalPriceOfVillas());
        System.out.println("Total of summerhouse prices: " + getTotalPriceOfSummerHouses());
        System.out.println("Total price of all housings: " + getTotalPriceOfAllHouses());
        System.out.println("Average area of homes: " + getAvgAreaOfHomes());
        System.out.println("Average area of villas: " + getAvgAreaOfVillas());
        System.out.println("Average area of summerhouses: " + getAvgAreaOfSummerHouses());
        System.out.println("Average area of all housings: " + getAvgAreaOfAllHouses());
        System.out.println("Total ");

    }

    private static boolean isRoomCountMatch(HouseType source, int roomCount){
        return source.getRoomCount() == roomCount;
    }

    private static boolean isLivingRoomCountMatch(HouseType source, int livingRoomCount){
        return source.getLivingRoomCount() == livingRoomCount;
    }

}
