package lk.autocare.vehicle_service_system.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private Long vehicleId;
    private String vehicleNumber;
    private String vehicleModel;
    //enum
    private VehicleFuelType vehicleFuelType;
    private LocalDate lastServiceDate;
    private LocalDate nextServiceDate;
    private int mileage;

    //add customer id fields, get value to mapper
    private Long customerId;

    //customer object
    //private Customer customer;

    //create helper method that affect all CRUD of vehicle
    public void updateNextServiceDate(){
        if(this.lastServiceDate != null){
            this.nextServiceDate = this.lastServiceDate.plusMonths(6);
        }
    }
}
