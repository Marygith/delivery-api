package ru.labs.delivery_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.labs.delivery_api.model.DeliveryMan;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeliveryMenResponseDto {
    private List<DeliveryMan> deliveryMen;
}
