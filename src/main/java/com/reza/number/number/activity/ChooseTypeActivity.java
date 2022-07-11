package com.reza.number.number.activity;

import com.reza.number.number.constant.WorkflowConstants;
import com.reza.number.number.repository.NumberRepository;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChooseTypeActivity implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long numberId = (Long) delegateExecution.getVariable(WorkflowConstants.NUMBER_ID_VARIABLE_KEY);
        System.out.println(numberId);

        delegateExecution.setVariable(WorkflowConstants.WORKFLOW_CHOOSE_TYPE_PASS, true);
    }
}
