package Task2.Cars;

import java.util.ArrayList;
import java.util.HashMap;

public class CarsUtils {

    public static ArrayList<Car> detectCars(String rawCarsString){

        ArrayList<Car> carList=new ArrayList<>();
        for(String rawCarString:rawCarsString.split(", ")){
            carList.add(new Car(rawCarString));
        }
        return carList;

    }

    public static HashMap<String, ArrayList<String>> GroupCar(ArrayList<Car> cars){

        HashMap<String,ArrayList<String>> carsMap = new HashMap<>();

        for(Car car:cars){

            if(carsMap.containsKey(car.getType())){
                carsMap.get(car.getType()).add(car.getModel());
            } else{
                ArrayList<String> list = new ArrayList<>();
                list.add(car.getModel());
                carsMap.put(car.getType(),list);
            }

        }

        return carsMap;
    }
}
