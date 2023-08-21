package com.alibaba.boot.nacos.actuate.autoconfigure;

import com.alibaba.boot.nacos.discovery.actuate.autoconfigure.NacosDiscoveryHealthIndicatorAutoConfiguration;
import com.alibaba.boot.nacos.discovery.actuate.health.NacosDiscoveryHealthIndicator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {NacosDiscoveryHealthIndicatorAutoConfiguration.class})
public class NacosDiscoveryHealthIndicatorAutoConfigurationTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void testNacosConfigHealthIndicatorBean() {
        Assert.assertNotNull(context.getBean(NacosDiscoveryHealthIndicator.class));
    }
}
