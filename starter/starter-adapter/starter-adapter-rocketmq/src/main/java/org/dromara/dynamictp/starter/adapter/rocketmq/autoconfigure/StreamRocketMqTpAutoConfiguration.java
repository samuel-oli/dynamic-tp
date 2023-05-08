package org.dromara.dynamictp.starter.adapter.rocketmq.autoconfigure;

import org.dromara.dynamictp.adapter.rocketmq.StreamRocketMqDtpAdapter;
import org.dromara.dynamictp.core.spring.DtpBaseBeanConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * StreamRocketMqTpAutoConfiguration related
 *
 * @author zhanjb
 * @since 1.1.0
 */
@Configuration
@ConditionalOnProperty(prefix = "spring.cloud.stream.rocketmq.binder", value = {"name-server"})
@ConditionalOnBean({DtpBaseBeanConfiguration.class})
@AutoConfigureAfter({DtpBaseBeanConfiguration.class})
@SuppressWarnings("all")
public class StreamRocketMqTpAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public StreamRocketMqDtpAdapter rocketMqDtpHandler() {
        return new StreamRocketMqDtpAdapter();
    }
}