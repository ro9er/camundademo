package com.roger.camunda.controller;

import org.camunda.bpm.engine.OptimisticLockingException;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yuanqing Luo
 * @date: 2018/11/15
 **/
@RequestMapping("trans")
@RestController
public class TransactionController {

    @Autowired
    private ProcessEngine camunda;

    @GetMapping("trigger")
    public String trigger(){
        try {
            ProcessInstanceWithVariables process =
                    camunda.getRuntimeService().createProcessInstanceByKey("transaction_v2")
                            .executeWithVariablesInReturn();

            return "trigger:" + process.getId();
        } catch (OptimisticLockingException ole){
            ole.printStackTrace();
            return "concurrent access error";
        } catch (Exception e){
            e.printStackTrace();
            return "exception happen";
        }
    }

    @GetMapping("start/{id}")
    public String start(@PathVariable("id")String id){
        try {
            System.out.println("id:" + id);
            MessageCorrelationResult result = camunda.getRuntimeService()
                    .createMessageCorrelation("START_MSG")
                    .processInstanceId(id)
                    .correlateWithResult();
            return "start";
        } catch (OptimisticLockingException ole){
            ole.printStackTrace();
            return "concurrent access error";
        } catch (Exception e){
            e.printStackTrace();
            return "exception happen";
        }
    }


    @GetMapping("continue/{id}")
    public String continueProcess(@PathVariable("id")String id){
        try {
            MessageCorrelationResult result = camunda.getRuntimeService()
                    .createMessageCorrelation("MSG_CONTINUE")
                    .processInstanceId(id)
                    .correlateWithResult();
            return "continue";
        } catch (OptimisticLockingException ole){
            ole.printStackTrace();
            return "concurrent access error";
        } catch (Exception e){
            e.printStackTrace();
            return "exception happen";
        }
    }



}
