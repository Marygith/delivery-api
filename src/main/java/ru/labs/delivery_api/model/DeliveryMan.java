package ru.labs.delivery_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryMan {
    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    private String name;
}
