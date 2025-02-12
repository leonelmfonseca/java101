package com.developer.java.fundamentals.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engine implements MemoryAddress{
    private String name;
    private Integer horsepower;
    private Integer torque;
    
    public static Engine deepCopy(Engine engine) {
        return new Engine(engine.name, engine.getHorsepower(), engine.getTorque());
    }
    
    @Override
    public String toString() {
        return "Engine [name=" + name + ", horsepower=" + horsepower + ", torque=" + torque + "]";
    }
    
    public String memoryAddress() {
        return "Memory Address: " + this.getMemoryAddress();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.horsepower, this.torque);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        
        Engine engine = (Engine) obj;
        return Objects.equals(this.name, engine.name) && Objects.equals(this.horsepower, engine.horsepower) && Objects.equals(this.torque
                , engine.torque);
    }
}
