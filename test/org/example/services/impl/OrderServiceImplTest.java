package org.example.services.impl;

import jdk.jshell.execution.Util;
import org.example.mapping.dtos.OrderDto;
import org.example.mapping.dtos.ProductDto;
import org.example.services.ProductService;
import org.example.services.impl.OrderServiceImpl;
import org.example.services.impl.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

class OrderServiceImplTest {

    @Test
    void filterBabyProducts() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<OrderDto> expected = Utils.getUserListSimulated();
        List<OrderDto> result = orderService.filterBabyProducts();
        assertEquals(expected , size(), "La función no se esta desarrollando correctamente");
    }

    @Test
    void calculateGlobalPromedium() {
    }
}