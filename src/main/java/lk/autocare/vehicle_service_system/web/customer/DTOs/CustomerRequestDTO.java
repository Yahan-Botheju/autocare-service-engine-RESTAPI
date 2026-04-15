package lk.autocare.vehicle_service_system.web.customer.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {

    @NotBlank(message = "Full name required")
    private String customerName;
    @NotBlank(message = "Phone number is required")
    private String customerPhone;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String customerEmail;
}
