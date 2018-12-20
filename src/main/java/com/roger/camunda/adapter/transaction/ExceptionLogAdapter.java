package com.roger.camunda.adapter.transaction;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @author: Yuanqing Luo
 * @date: 2018/12/14
 **/
@Component
public class ExceptionLogAdapter implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {}
}
