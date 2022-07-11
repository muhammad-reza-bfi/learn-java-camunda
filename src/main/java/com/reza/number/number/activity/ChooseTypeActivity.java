package com.reza.number.number.activity;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChooseTypeActivity implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws FlowException {

    }
}
