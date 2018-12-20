package com.roger.camunda.adapter.transaction;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: Yuanqing Luo
 * @date: 2018/11/15
 **/
@Component
public class CompensationAdapter implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("enter compensation");
        System.out.println("time now:" + System.currentTimeMillis());
        Thread.sleep(300);
        System.out.println("exit compensation");
    }
}
