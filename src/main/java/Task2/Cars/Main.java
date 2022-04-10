package Task2.Cars;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String rawString = "Лада седан, Лада хэтчбек, Мерседес седан, Бмв кроссовер, " +
                           "Форд хэтчбек, Пежо кроссовер, Тойота седан ";

        ArrayList<Car> carList = CarsUtils.detectCars(rawString);
        HashMap<String, ArrayList<String>> grouped = CarsUtils.GroupCar(carList);
        System.out.println(grouped);

    }
}
