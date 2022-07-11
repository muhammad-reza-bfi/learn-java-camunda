package com.reza.number.number.service;

import com.reza.number.number.dto.number.request.NumberRequest;
import com.reza.number.number.dto.number.response.NumberResponse;

import java.util.List;
import java.util.UUID;

public interface NumberService {
    NumberResponse createNumber(NumberRequest request);

    List<NumberResponse> getNumbers();

    NumberResponse updateNumber(NumberRequest request, UUID id);

    NumberResponse deleteNumber(UUID id);

    NumberResponse getNumber(UUID id);

    NumberResponse updateTypeNumber(String typeNumber, UUID id);

}
