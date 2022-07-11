package com.reza.number.number.service.impl;

import com.reza.number.number.constant.WorkflowConstants;
import com.reza.number.number.dto.number.request.NumberRequest;
import com.reza.number.number.dto.number.response.NumberResponse;
import com.reza.number.number.entity.Number;
import com.reza.number.number.repository.NumberRepository;
import com.reza.number.number.service.NumberService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@Service
public class NumberServiceImpl implements NumberService {


    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private final NumberRepository numberRepository;

    public NumberServiceImpl(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @Override
    public NumberResponse createNumber(NumberRequest request) {
        Optional<Number> currentNumber =  numberRepository.findByNumber(request.getNumber());
        if (currentNumber.isPresent()){
            throw new RuntimeException("number already exist");
        }
        Number newNumber = numberRepository.save(Number.builder().number(request.getNumber()).status("PENDING").build());

        Map<String, Object> variables = new HashMap<>();
        variables.put(WorkflowConstants.NUMBER_ID_VARIABLE_KEY,newNumber.getId());

        ProcessInstance newProcess = runtimeService.startProcessInstanceByKey(WorkflowConstants.PRODUCT_TO_WORKFLOW_MAP.get(1L), variables);

        System.out.println(newProcess.getId());

        return NumberResponse.builder()
                .id(newNumber.getId())
                .number(newNumber
                        .getNumber())
                .type(newNumber
                        .getType())
                .status(newNumber
                        .getStatus())
                .build();
    }

    @Override
    public List<NumberResponse> getNumbers() {
        List<NumberResponse> listOfNumbers = new ArrayList<>();

        for (Number number : numberRepository.findAll()) {
            listOfNumbers.add(NumberResponse.builder()
                    .id(number.getId()).number(number.getNumber()).status(number.getStatus()).build());
        }
        return listOfNumbers;
    }

    @Override
    public NumberResponse updateNumber(NumberRequest request, Long id) {
        Optional<Number> currentNumber = numberRepository.findById(id);
        if (currentNumber.isEmpty()){
            throw new RuntimeException("number not exist");
        }
        Number newNumber = currentNumber.get();
        if (request.getNumber() != currentNumber.get().getNumber()) {
            newNumber = numberRepository.save(Number.builder().id(id)
                    .number(request.getNumber())
                    .status(newNumber.getStatus())
                    .type(newNumber.getType())
                    .build());
        }

        return NumberResponse.builder()
                .id(newNumber.getId())
                .number(newNumber
                        .getNumber())
                .status(newNumber
                        .getStatus())
                .build();
    }

    @Override
    public NumberResponse deleteNumber(Long id) {
        Optional<Number> currentNumber = numberRepository.findById(id);
        if (currentNumber.isEmpty()){
            throw new RuntimeException("number not exist");
        }
        numberRepository.deleteById(id);
        return NumberResponse.builder()
                .id(currentNumber.get().getId())
                .number(currentNumber.get().getNumber())
                .status(currentNumber.get().getStatus())
                .build();
    }

    @Override
    public NumberResponse getNumber(Long id) {
        Optional<Number> currentNumber = numberRepository.findById(id);
        if (currentNumber.isEmpty()){
            throw new RuntimeException("number not exist");
        }

        return NumberResponse.builder()
                .id(currentNumber.get().getId())
                .number(currentNumber.get().getNumber())
                .status(currentNumber.get().getStatus())
                .build();
    }

    @Override
    public NumberResponse updateTypeNumber(String typeNumber, Long id) {
        Optional<Number> currentNumber = numberRepository.findById(id);
        if (currentNumber.isEmpty()){
            throw new RuntimeException("number not exist");
        }
        Number newNumber = currentNumber.get();
        newNumber = numberRepository.save(Number.builder().id(id)
                    .number(newNumber.getNumber())
                    .status(newNumber.getStatus())
                    .type(typeNumber)
                    .build());

        return NumberResponse.builder()
                .id(newNumber.getId())
                .number(newNumber
                        .getNumber())
                .status(newNumber
                        .getStatus())
                .build();
    }
}
