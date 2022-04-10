package Task2.Cars;

import java.util.Objects;

public class Car {

    private String type, model;

    public Car(String model, String type) {
        this.type = type;
        this.model = model;
    }

    public Car(String rawCarString) {
        String[] splittedRaw = rawCarString.split(" ");
        this.model = splittedRaw[0];
        this.type = splittedRaw[1];
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return type.equals(car.type) &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, model);
    }
}
