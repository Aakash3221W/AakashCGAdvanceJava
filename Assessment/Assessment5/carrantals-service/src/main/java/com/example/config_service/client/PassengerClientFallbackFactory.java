package com.example.config_service.client;

import feign.FeignException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.example.common.Exceptions.ServiceUnavailableException;
import com.example.common.models.User;

@Component // 1. Register as a Spring Bean
public class PassengerClientFallbackFactory implements FallbackFactory<PassengerClient> { 
    private static final Logger logger = LoggerFactory.getLogger(PassengerClientFallbackFactory.class);

    @Override
    public PassengerClient create(Throwable cause) {
        logger.error("Passenger service fallback triggered. Reason: {}", cause.getMessage());

        return new PassengerClient() {
            @Override
            public List<User> getPassengers() {
                if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
                    logger.warn("Passengers not found (404). Returning empty list.");
                    return List.of(); 
                }
                
                throw new ServiceUnavailableException("Failed to fetch passengers from passenger-service", cause);
            }
        };
    }
}