package com.reza.number.number.activity;

import com.reza.number.number.constant.WorkflowConstants;
import com.reza.number.number.entity.Number;
import com.reza.number.number.repository.NumberRepository;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class UpdateStatusActivity implements JavaDelegate {

    @Autowired
    private NumberRepository numberRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long numberId = (Long) delegateExecution.getVariable(WorkflowConstants.NUMBER_ID_VARIABLE_KEY);
        System.out.printf("ChooseStatusActivity PROCESS: %s\n", numberId);

        String result;
        Optional<Number> currentNumber = numberRepository.findById(numberId);

        numberRepository.save(Number.builder().id(numberId).number(currentNumber.get().getNumber()).type(currentNumber.get().getType()).status("SUCCESS").build());


        System.out.printf("ChooseStatusActivity DONE: %s\n", numberId);
    }
}
