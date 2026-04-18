package lk.autocare.vehicle_service_system.domain.repositories;

import lk.autocare.vehicle_service_system.domain.models.Vehicle;

import java.util.Optional;

public interface VehicleRepository {

    //vehicle find by id
    Optional<Vehicle> findById(Long vehicleId);
}
