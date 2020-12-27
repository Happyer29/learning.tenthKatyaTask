package ru.vsu.cs.yagodintsevNikitaAndreevich;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        List<Map<String, String>> apartmentsList = new ArrayList<>();
        /* Список (иными словами массив){
        *   [0] (это номер внутри списка) = Map (Ключ = значение){
        *       String = String,
        *       String = String,
        *       String = String
        *   },
        *   [1] = Map{
        *       "district"      = "название района",
        *       "roomNum"       = "количество комнат",
        *       "square"        = "общая площадь",
        *       "squareKitchen" = "площадь кухни",
        *       "price"         = "цена",
        *   },
        *   [2] = Map{
        *       ....
        *   },
        *   [3] = Map{
        *       ....
        *   }
        * }
        */

        apartmentsList.add(createApartmentMap("район1", "2", "120", "20", "100"));
        apartmentsList.add(createApartmentMap("район1", "2", "100", "10", "90"));
        apartmentsList.add(createApartmentMap("район1", "3", "130", "30", "120"));
        apartmentsList.add(createApartmentMap("район1", "3", "150", "30", "150"));
        apartmentsList.add(createApartmentMap("район1", "4", "200", "30", "500"));
        apartmentsList.add(createApartmentMap("район2", "2", "90", "20", "70"));

        for (Map<String, String> val:apartmentsList) {
            if(val.get("district") == "район1"){
                System.out.println(val.get("price"));
            }
        }
    }

    private static Map<String, String> createApartmentMap(String district, String roomNum, String square, String squareKitchen, String price){
        Map<String, String> apartment;
        apartment = new HashMap<>();
        apartment.put("district", district);
        apartment.put("roomNum", roomNum);
        apartment.put("square", square);
        apartment.put("squareKitchen", squareKitchen);
        apartment.put("price", price);
        return apartment;
    }
}
