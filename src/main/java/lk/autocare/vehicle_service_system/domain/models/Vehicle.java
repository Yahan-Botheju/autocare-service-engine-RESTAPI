package lk.autocare.vehicle_service_system.domain.models;

import lk.autocare.vehicle_service_system.GlobalExceptionHandler.ServiceAlreadyCompletedException;
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
    private VehicleServiceStatus vehicleServiceStatus;

    //add customer id fields, get value to mapper
    private Long customerId;

    //customer object (stack overflow)
    //private Customer customer;

    //create helper method that affect all CRUD of vehicle
    public void updateNextServiceDate(){
        if(this.lastServiceDate != null){
            this.nextServiceDate = this.lastServiceDate.plusMonths(6);
        }
    }

    //create helper method to set to vehicle service status to PENDING when vehicle create
    public void setDefaultVehicleServiceStatus(){
        if(this.vehicleServiceStatus == null){
            this.setVehicleServiceStatus(VehicleServiceStatus.PENDING);
        }
    }

    //check vehicle service status is PENDING,then throw an error
    public void disableVehicleUpdate(){
        if(this.vehicleServiceStatus == VehicleServiceStatus.COMPLETED){
            throw new ServiceAlreadyCompletedException("Service is already completed, unable to update vehicle");
        }
    }
}
