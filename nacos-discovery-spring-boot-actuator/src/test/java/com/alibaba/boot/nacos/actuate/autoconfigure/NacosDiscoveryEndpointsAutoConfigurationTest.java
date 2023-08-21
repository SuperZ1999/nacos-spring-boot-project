package com.alibaba.boot.nacos.actuate.autoconfigure;

import com.alibaba.boot.nacos.discovery.actuate.autoconfigure.NacosDiscoveryEndpointsAutoConfiguration;
import com.alibaba.boot.nacos.discovery.actuate.endpoint.NacosDiscoveryEndpoint;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {NacosDiscoveryEndpointsAutoConfiguration.class})
@TestPropertySource(properties = {
        "management.endpoints.web.exposure.include=nacos-discovery"
})
public class NacosDiscoveryEndpointsAutoConfigurationTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void testNacosDiscoveryEndpointBean() {
        Assert.assertNotNull(context.getBean(NacosDiscoveryEndpoint.class));
    }
}
