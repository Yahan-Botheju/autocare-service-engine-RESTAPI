package lk.autocare.vehicle_service_system.web.vehicle.webMappers;

import lk.autocare.vehicle_service_system.domain.models.Vehicle;
import lk.autocare.vehicle_service_system.domain.models.VehicleUpdateResult;
import lk.autocare.vehicle_service_system.web.vehicle.DTOs.VehicleRequestDTO;
import lk.autocare.vehicle_service_system.web.vehicle.DTOs.VehicleResponseDTO;
import lk.autocare.vehicle_service_system.web.vehicle.DTOs.VehicleShortInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleWebMapper {

    //vehicle model to vehicleShortIntoDTO
    VehicleShortInfoDTO toVehicleShortInfoDTO(Vehicle vehicle);

    //domain model to responseDTO
    VehicleResponseDTO toResponseDTO(Vehicle vehicle);

    //requestDTO to domain model
    Vehicle toDomainModel(VehicleRequestDTO vehicleRequestDTO);

    //create custom mapper for map both customer and vehicle models
    default VehicleResponseDTO customResponseDTO(VehicleUpdateResult vehicleUpdateResult){

        //get both models as response
        VehicleResponseDTO toResponseDTO = toResponseDTO(vehicleUpdateResult.getVehicle());

        //attach customer ID and name to response dto
        toResponseDTO.setCustomerId(vehicleUpdateResult.getCustomer().getCustomerId());
        toResponseDTO.setCustomerName(vehicleUpdateResult.getCustomer().getCustomerName());

        //return response
        return toResponseDTO;
    }
}
