package com.reza.number.number.service;

import com.reza.number.number.dto.number.request.NumberRequest;
import com.reza.number.number.dto.number.response.NumberResponse;

import java.util.List;

public interface NumberService {
    NumberResponse createNumber(NumberRequest request);

    List<NumberResponse> getNumbers();

    NumberResponse updateNumber(NumberRequest request, Long id);

    NumberResponse deleteNumber(Long id);

    NumberResponse getNumber(Long id);
}
