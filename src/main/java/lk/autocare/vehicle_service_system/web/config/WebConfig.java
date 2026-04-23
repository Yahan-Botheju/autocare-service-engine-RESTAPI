package lk.autocare.vehicle_service_system.web.config;

import lk.autocare.vehicle_service_system.web.customer.interceptor.CustomerRoleBaseInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    //inject role base interceptor
    private final CustomerRoleBaseInterceptor customerRoleBaseInterceptor;


}
