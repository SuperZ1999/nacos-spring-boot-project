package com.alibaba.boot.nacos.actuate.autoconfigure;

import com.alibaba.boot.nacos.actuate.endpoint.NacosConfigEndpoint;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {NacosConfigEndpointAutoConfiguration.class})
@TestPropertySource(properties = {
        "management.endpoints.web.exposure.include=nacos-config"
})
public class NacosConfigEndpointAutoConfigurationTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void testNacosConfigEndpointBean() {
        Assert.assertNotNull(context.getBean(NacosConfigEndpoint.class));
    }
}
