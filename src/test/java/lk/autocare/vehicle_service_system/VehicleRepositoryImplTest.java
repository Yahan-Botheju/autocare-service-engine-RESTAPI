package lk.autocare.vehicle_service_system;

import lk.autocare.vehicle_service_system.domain.models.Vehicle;
import lk.autocare.vehicle_service_system.infrastructure.vehicle.persistence.VehicleRepositoryImpl;
import lk.autocare.vehicle_service_system.infrastructure.vehicle.persistence.entity.VehicleEntity;
import lk.autocare.vehicle_service_system.infrastructure.vehicle.persistence.jpa.JpaVehicleRepository;
import lk.autocare.vehicle_service_system.infrastructure.vehicle.persistence.mapper.VehiclePersistenceMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleRepositoryImplTest {

    @Mock
    private JpaVehicleRepository jpaVehicleRepository;

    @Mock
    private VehiclePersistenceMapper vehiclePersistenceMapper;

    @InjectMocks
    private VehicleRepositoryImpl vehicleRepositoryImpl;

    @Test
    void shouldFindById(){
        Long vehicleId = 1L;
        VehicleEntity dummyVehicleEntity = new VehicleEntity();
        Vehicle dummyVehicleDomain = new Vehicle();

        when(jpaVehicleRepository.findById(vehicleId)).thenReturn(Optional.of(dummyVehicleEntity));

        when(vehiclePersistenceMapper.toDomainModel(dummyVehicleEntity)).thenReturn(dummyVehicleDomain);

        Optional<Vehicle> result = vehicleRepositoryImpl.findById(vehicleId);

        assertTrue(result.isPresent());
        assertEquals(dummyVehicleDomain, result.get());

    }

    @Test
    void shouldDeleteVehicle(){
        Long vehicleId = 1L;
        VehicleEntity dummyVehicleEntity = new VehicleEntity();

        when(jpaVehicleRepository.findById(vehicleId)).thenReturn(Optional.of(dummyVehicleEntity));

        vehicleRepositoryImpl.deleteVehicle(vehicleId);

        verify(jpaVehicleRepository,times(1)).deleteById(vehicleId);
    }
}


