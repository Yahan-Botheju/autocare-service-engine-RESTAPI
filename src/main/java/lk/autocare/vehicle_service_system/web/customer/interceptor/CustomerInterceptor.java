package lk.autocare.vehicle_service_system.web.customer.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CustomerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler
    ) throws Exception {

        String uri = request.getRequestURI();
        String requestMethod = request.getMethod();
        String role = request.getHeader("role");

        //only admin can view all the vehicles
        if("GET".equalsIgnoreCase(requestMethod) && uri.startsWith("/api/v1/autocare/customers/all")) {
            if(role == null || !role.trim().equalsIgnoreCase("ADMIN")){
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Only ADMIN can view all the customers..!!");

                return false;
            }
        }

        //only admin can delete customer
        if("DELETE".equalsIgnoreCase(requestMethod) && uri.startsWith("/api/v1/autocare/customers/")) {
            if(role == null || !role.trim().equalsIgnoreCase("ADMIN")){
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Only ADMIN can delete customer..!!");

                return false;
            }
        }

        return true;
    }
}
