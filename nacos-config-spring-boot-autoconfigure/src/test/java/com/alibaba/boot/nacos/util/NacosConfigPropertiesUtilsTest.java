package com.alibaba.boot.nacos.util;

import com.alibaba.boot.nacos.config.autoconfigure.NacosConfigAutoConfiguration;
import com.alibaba.boot.nacos.config.properties.NacosConfigProperties;
import com.alibaba.boot.nacos.config.util.NacosConfigPropertiesUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { NacosConfigAutoConfiguration.class })
@TestPropertySource(properties = {
        "nacos.config.server-addr=8.8.8.8",
        "nacos.config.password=123456"
})
public class NacosConfigPropertiesUtilsTest {
    @Autowired
    private ConfigurableEnvironment environment;

    @Test
    public void testBuildNacosConfigProperties() {
        NacosConfigProperties properties = NacosConfigPropertiesUtils.buildNacosConfigProperties(environment);
        Assert.assertEquals(properties.getServerAddr(), "8.8.8.8");
        Assert.assertEquals(properties.getPassword(), "123456");
    }
}
