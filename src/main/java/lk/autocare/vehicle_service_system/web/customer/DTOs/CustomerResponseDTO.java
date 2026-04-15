package lk.autocare.vehicle_service_system.web.customer.DTOs;

import lk.autocare.vehicle_service_system.web.vehicle.DTOs.VehicleShortInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private Long customerId;
    private String customerName;
    private String customerPhone;
    private String customerEmail;

    //get values from vehicleShortInfoDTO
    private List<VehicleShortInfoDTO> vehicles;
}
