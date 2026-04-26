package lk.autocare.vehicle_service_system;

import lk.autocare.vehicle_service_system.infrastructure.vehicle.persistence.VehicleRepositoryImpl;
import lk.autocare.vehicle_service_system.infrastructure.vehicle.persistence.jpa.JpaVehicleRepository;
import lk.autocare.vehicle_service_system.infrastructure.vehicle.persistence.mapper.VehiclePersistenceMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VehicleRepositoryImplTest {

    @Mock
    private JpaVehicleRepository jpaVehicleRepository;

    @Mock
    private VehiclePersistenceMapper vehiclePersistenceMapper;

    @InjectMocks
    private VehicleRepositoryImpl vehicleRepositoryImpl;

}


