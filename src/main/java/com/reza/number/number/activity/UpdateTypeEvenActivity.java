package com.reza.number.number.activity;

import com.reza.number.number.constant.WorkflowConstants;
import com.reza.number.number.entity.Number;
import com.reza.number.number.repository.NumberRepository;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@ConfigurationProperties
public class UpdateTypeEvenActivity implements JavaDelegate {

    @Autowired
    private NumberRepository numberRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception{
        Long numberId = (Long) delegateExecution.getVariable(WorkflowConstants.NUMBER_ID_VARIABLE_KEY);
        System.out.printf("UpdateTypeOddActivity PROCESS process: %s\n", numberId);

        String result = (String) delegateExecution.getVariable(WorkflowConstants.WORKFLOW_CHOOSE_TYPE_PASS);

        Optional<Number> number = numberRepository.findById(numberId);

        numberRepository.save(Number.builder().id(numberId).number(number.get().getNumber()).type(result).status(number.get().getStatus()).build());
        System.out.printf("UpdateTypeOddActivity DONE process: %s\n", numberId);


    }

}
