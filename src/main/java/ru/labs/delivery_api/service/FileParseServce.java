package ru.labs.delivery_api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.labs.delivery_api.model.Delivery;
import ru.labs.delivery_api.model.DeliveryMan;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileParseServce {

    private final ObjectMapper objectMapper;

    public List<Delivery> readDeliveries(String filePath) throws IOException {
        List<Delivery> deliveries = objectMapper.readValue(new File(filePath), new TypeReference<List<Delivery>>(){});

        return deliveries;
    }

    public List<DeliveryMan> readDeliveryMen(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<List<DeliveryMan>>(){});
    }
}
