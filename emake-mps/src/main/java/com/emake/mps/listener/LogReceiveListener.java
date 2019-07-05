package com.emake.mps.listener;

import com.emake.mps.model.entity.SysLog;
import com.emake.mps.model.vo.LogVO;
import com.emake.mps.service.SysLogService;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
//@RabbitListener(queues = MqQueueConstant.LOG_QUEUE)
public class LogReceiveListener {
    private static final String KEY_USER = "user";

    @Resource
    private SysLogService sysLogService;

//    @RabbitHandler
    public void receive(LogVO logVo) {
        SysLog sysLog = logVo.getSysLog();
        MDC.put(KEY_USER, logVo.getUsername());
        sysLog.setCreateBy(logVo.getUsername());
        sysLogService.save(sysLog);
        MDC.remove(KEY_USER);
    }
}
