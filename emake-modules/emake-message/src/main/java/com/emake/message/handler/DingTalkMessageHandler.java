package com.emake.message.handler;

import com.alibaba.fastjson.JSONObject;
import com.emake.common.utils.httpclient.HttpContacter;
import com.emake.common.utils.httpclient.HttpFeedback;
import com.emake.message.config.DingTalkPropertiesConfig;
import com.emake.message.template.DingTalkMsgTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送钉钉消息逻辑
 */
@Slf4j
@Component
public class DingTalkMessageHandler {
    @Autowired
    private DingTalkPropertiesConfig dingTalkPropertiesConfig;

    /**
     * 业务处理
     *
     * @param text 消息
     */
    public boolean process(String text) {
        String webhook = dingTalkPropertiesConfig.getWebhook();
        if (StringUtils.isBlank(webhook)) {
            log.error("钉钉配置错误，webhook为空");
            return false;
        }

        DingTalkMsgTemplate dingTalkMsgTemplate = new DingTalkMsgTemplate();
        dingTalkMsgTemplate.setMsgtype("text");
        DingTalkMsgTemplate.TextBean textBean = new DingTalkMsgTemplate.TextBean();
        textBean.setContent(text);
        dingTalkMsgTemplate.setText(textBean);
        HttpFeedback result = null;
        try {
            result = HttpContacter.p().doPost(webhook,JSONObject.toJSONString(dingTalkMsgTemplate));
        } catch (Exception e) {
            log.error("钉钉发送异常:{}", e.getMessage());
        }
        log.info("钉钉提醒成功,报文响应:{}", result.getReceiptStr());
        return true;
    }

}
