package web.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Car {
    private String brandName;
    private String modelCar;
    private int yearAuto;

    public Car(){};

    public Car(String brandName, String modelCar, int yearAuto) {
        this.brandName = brandName;
        this.modelCar = modelCar;
        this.yearAuto = yearAuto;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public int getYearAuto() {
        return yearAuto;
    }

    public void setYearAuto(int yearAuto) {
        this.yearAuto = yearAuto;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brandName='" + brandName + '\'' +
                ", modelCar='" + modelCar + '\'' +
                ", yearAuto=" + yearAuto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearAuto == car.yearAuto && Objects.equals(brandName, car.brandName) && Objects.equals(modelCar, car.modelCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, modelCar, yearAuto);
    }
}
