package com.roger.camunda.adapter.transaction;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @author: Yuanqing Luo
 * @date: 2018/11/15
 **/
@Component
public class LongRunAdapter implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // sleep 20 seconds
        Thread.sleep(20_000);
    }
}
