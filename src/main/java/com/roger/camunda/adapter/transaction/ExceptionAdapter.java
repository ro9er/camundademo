package com.roger.camunda.adapter.transaction;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.bpmn.helper.CompensationUtil;
import org.springframework.stereotype.Component;

/**
 * @author: Yuanqing Luo
 * @date: 2018/11/15
 **/
@Component
public class ExceptionAdapter implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("enter Exception, rollback");
        throw new Exception("throw new Exception");
    }
}
