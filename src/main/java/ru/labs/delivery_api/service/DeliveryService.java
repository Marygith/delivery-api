package ru.labs.delivery_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.labs.delivery_api.dto.DeliveryMenRequestDto;
import ru.labs.delivery_api.dto.DeliveryRequestDto;
import ru.labs.delivery_api.model.Delivery;
import ru.labs.delivery_api.model.DeliveryMan;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    @Value("${files.deliveries}")
    private String deliveriesFilePath;
    @Value("${files.deliverymen}")
    private String deliverymenFilePath;

    private final FileParseServce fileParseServce;

    public List<Delivery> getDeliveries(DeliveryRequestDto request) {

        try {
            var deliveries = fileParseServce.readDeliveries(deliveriesFilePath);
            return filterDeliveries(deliveries, request);
        } catch (IOException e) {
            throw new RuntimeException("Didn't manage to read deliveries file, " + e);
        }
    }

    public List<DeliveryMan> getDeliverymen(DeliveryMenRequestDto request) {

        try {
            var deliverymen =  fileParseServce.readDeliveryMen(deliverymenFilePath);
            return filterDeliverymen(deliverymen, request);
        } catch (IOException e) {
            throw new RuntimeException("Didn't manage to read deliverymen file, " + e);
        }
    }

    public List<Delivery> filterDeliveries(List<Delivery> deliveries, DeliveryRequestDto request) {
        List<Delivery> filteredDeliveries;

        if (request.getEarliestDateTime() != null) {
            filteredDeliveries = deliveries.stream()
                    .filter(delivery -> delivery.getDeliveryTime().isAfter(request.getEarliestDateTime()))
                    .limit(request.getRowsAmount())
                    .collect(Collectors.toList());
        } else {
            int start = request.getFirstRowNum();
            int end = Math.min(start + request.getRowsAmount(), deliveries.size());
            filteredDeliveries = deliveries.subList(start, end);
        }

        return filteredDeliveries;
    }

    public List<DeliveryMan> filterDeliverymen(List<DeliveryMan> deliveryMen, DeliveryMenRequestDto request) {
        List<DeliveryMan> filteredDeliveries;

        int start = request.getFirstRowNum();
        int end = Math.min(start + request.getRowsAmount(), deliveryMen.size());
        filteredDeliveries = deliveryMen.subList(start, end);

        return filteredDeliveries;
    }
}
