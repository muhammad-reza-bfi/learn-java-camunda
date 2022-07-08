package com.reza.number.number.dto.number.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NumberResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("number")
    private Long number;

    @JsonProperty("status")
    private String status;

    @JsonProperty("type")
    private String type;
}




