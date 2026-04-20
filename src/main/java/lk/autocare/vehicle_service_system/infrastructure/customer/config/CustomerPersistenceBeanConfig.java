package lk.autocare.vehicle_service_system.infrastructure.customer.config;

import lk.autocare.vehicle_service_system.domain.repositories.CustomerRepository;
import lk.autocare.vehicle_service_system.infrastructure.customer.persistence.CustomerRepositoryImpl;
import lk.autocare.vehicle_service_system.infrastructure.customer.persistence.jpa.JpaCustomerRepository;
import lk.autocare.vehicle_service_system.infrastructure.customer.persistence.mapper.CustomerPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CustomerPersistenceBeanConfig {
    @Bean
    CustomerRepository customerRepository(
            JpaCustomerRepository jpaCustomerRepository,
            CustomerPersistenceMapper customerPersistenceMapper
    ) {
        return new CustomerRepositoryImpl(jpaCustomerRepository, customerPersistenceMapper);
    }
}
