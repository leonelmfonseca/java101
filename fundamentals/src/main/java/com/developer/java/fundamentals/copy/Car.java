package com.developer.java.fundamentals.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements MemoryAddress{
    String model;
    Engine engine;

    protected static Car deepCopy(Car car){
        return  new Car(car.model, Engine.deepCopy(car.getEngine()));
    }
    
    @Override
    public String toString() {
    return "Car [model="
        + model
        + ", engine="
        + engine.toString()
        + "]";
    }
    
    public String memoryAddress() {
        return "Memory Address: " + this.getMemoryAddress();
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hash(this.model, this.engine);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        
        if(!(obj instanceof Car car)){
            return false;
        }
        return Objects.equals(this.model, car.model) && Objects.equals(this.engine, car.engine);
    }
}
