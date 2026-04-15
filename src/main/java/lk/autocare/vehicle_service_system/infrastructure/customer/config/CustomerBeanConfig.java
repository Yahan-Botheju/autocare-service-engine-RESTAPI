package lk.autocare.vehicle_service_system.infrastructure.customer.config;

import lk.autocare.vehicle_service_system.domain.repositories.CustomerRepository;
import lk.autocare.vehicle_service_system.usecase.customer.CustomerUseCase;
import lk.autocare.vehicle_service_system.usecase.customer.CustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerBeanConfig {
    @Bean
    public CustomerUseCase customerUseCase(CustomerRepository customerRepository) {
        return new CustomerUseCaseImpl(customerRepository);
    }
}
