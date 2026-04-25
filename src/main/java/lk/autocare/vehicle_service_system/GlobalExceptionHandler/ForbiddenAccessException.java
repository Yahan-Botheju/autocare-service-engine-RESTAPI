package lk.autocare.vehicle_service_system.GlobalExceptionHandler;

public class ForbiddenAccessExceptioN extends RuntimeException {
  public ForbiddenAccessExceptioN(String message) {
    super(message);
  }
}
