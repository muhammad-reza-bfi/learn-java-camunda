package com.reza.number.number.activity;

import com.reza.number.number.constant.AppConstants;
import com.reza.number.number.constant.WorkflowConstants;
import com.reza.number.number.entity.Number;
import com.reza.number.number.exception.BusinessErrorException;
import com.reza.number.number.repository.NumberRepository;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UpdateStatusActivity implements JavaDelegate {

    @Autowired
    private NumberRepository numberRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        UUID numberId = (UUID) delegateExecution.getVariable(WorkflowConstants.NUMBER_ID_VARIABLE_KEY);
        System.out.printf("ChooseStatusActivity PROCESS: %s\n", numberId);

        Number currentNumber = numberRepository.findById(numberId).orElseThrow(() -> new BusinessErrorException(AppConstants.NUMBER_NOT_FOUND_MESSAGE));

        numberRepository.save(Number.builder().id(numberId).number(currentNumber.getNumber()).type(currentNumber.getType()).status("SUCCESS").build());

        System.out.printf("ChooseStatusActivity DONE: %s\n", numberId);
    }
}
