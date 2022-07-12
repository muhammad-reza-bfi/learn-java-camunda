package com.reza.number.number.activity;

import com.reza.number.number.repository.NumberRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ChooseTypeActivityTest {

    @InjectMocks
    private ChooseTypeActivity chooseTypeActivity;

    @Mock
    private NumberRepository numberRepository;

    @Mock
    private DelegateExecution delegateExecution;




}
