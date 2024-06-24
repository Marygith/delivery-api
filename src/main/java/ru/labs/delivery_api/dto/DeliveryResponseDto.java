package ru.labs.delivery_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.labs.delivery_api.model.Delivery;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeliveryResponseDto {
    private List<Delivery> deliveries;

}
