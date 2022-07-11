package com.reza.number.number.activity;

import com.reza.number.number.constant.WorkflowConstants;
import com.reza.number.number.service.NumberService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@ConfigurationProperties
public class UpdateTypeEvenActivity implements JavaDelegate {

    @Autowired
    private NumberService numberService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception{
        UUID numberId = (UUID) delegateExecution.getVariable(WorkflowConstants.NUMBER_ID_VARIABLE_KEY);
        System.out.printf("UpdateTypeOddActivity PROCESS process: %s\n", numberId);

        String result = (String) delegateExecution.getVariable(WorkflowConstants.WORKFLOW_CHOOSE_TYPE_PASS);

        numberService.updateTypeNumber(result, numberId);

        System.out.printf("UpdateTypeOddActivity DONE process: %s\n", numberId);


    }

}
