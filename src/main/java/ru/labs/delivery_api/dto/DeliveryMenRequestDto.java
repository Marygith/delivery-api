package ru.labs.delivery_api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeliveryMenRequestDto {

    private int rowsAmount;
    private int firstRowNum;
}
