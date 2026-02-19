package com.demo.testingPrac;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private PaymentGateway paymentGateway;

    static Stream<Arguments> provideOrders() {
        return Stream.of(
            Arguments.of(new Order(100), true),
            Arguments.of(new Order(-50), false),
            Arguments.of(new Order(0), false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideOrders")
    public void testProcessOrder(Order order, boolean expected) {
        OrderService orderService = new OrderService(paymentGateway);
        when(paymentGateway.processPayment(anyDouble())).thenReturn(expected);
        boolean result = orderService.processOrder(order);
        assertEquals(expected, result);
    }
}
