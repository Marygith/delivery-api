package ru.labs.delivery_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Delivery {
    @JsonProperty("delivery_id")
    private String id;

    @JsonProperty("deliveryman_id")
    private String deliverymanId;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("order_date_created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime orderDateCreated;

    @JsonProperty("delivery_address")
    private String deliveryAddress;

    @JsonProperty("delivery_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime deliveryTime;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("tips")
    private Long tips;
}
