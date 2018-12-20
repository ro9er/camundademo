package com.roger.camunda.adapter.transaction;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @author: Yuanqing Luo
 * @date: 2018/12/14
 **/
@Component
public class CancelAdapter implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("enter cancel");
        System.out.println("time now:" + System.currentTimeMillis());
    }
}
