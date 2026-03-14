package com.example.config_service.client;

import feign.FeignException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.example.common.Exceptions.ServiceUnavailableException;
import com.example.common.models.Cars;

@Component // 1. Register as a Spring Bean
public class CarrentalsClientFallbackFactory implements FallbackFactory<CarrentalsClient> { 
    private static final Logger logger = LoggerFactory.getLogger(CarrentalsClientFallbackFactory.class);

    @Override
    public CarrentalsClient create(Throwable cause) {
        logger.error("cars service fallback triggered. Reason: {}", cause.getMessage());

        return new CarrentalsClient() {
            @Override
            public List<Cars> getCars() {
                if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
                    logger.warn("cars not found (404). Returning empty list.");
                    return List.of(); 
                }
                
                throw new ServiceUnavailableException("Failed to fetch passengers from carrental-service", cause);
            }
        };
    }
}
