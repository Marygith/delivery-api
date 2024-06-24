package ru.labs.delivery_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.labs.delivery_api.dto.DeliveryMenRequestDto;
import ru.labs.delivery_api.dto.DeliveryMenResponseDto;
import ru.labs.delivery_api.dto.DeliveryRequestDto;
import ru.labs.delivery_api.dto.DeliveryResponseDto;
import ru.labs.delivery_api.service.DeliveryService;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;


    @PostMapping("/deliverymen")
    public DeliveryMenResponseDto getDeliverymen(@RequestBody DeliveryMenRequestDto request) {
        return new DeliveryMenResponseDto(deliveryService.getDeliverymen(request));
    }

    @PostMapping("/deliveries")
    public DeliveryResponseDto getDeliveries(@RequestBody DeliveryRequestDto request) {
        return new DeliveryResponseDto(deliveryService.getDeliveries(request));
    }
}
