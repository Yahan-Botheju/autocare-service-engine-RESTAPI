package lk.autocare.vehicle_service_system.usecase.customer;

import lk.autocare.vehicle_service_system.domain.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerUseCaseImpl implements  CustomerUseCase {

    //inject customer domain repo as initiating bean config
    private final CustomerRepository customerRepository;
}
