package com.alibaba.boot.nacos.util.editor;

import com.alibaba.boot.nacos.config.util.editor.NacosCustomBooleanEditor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: NacosCustomBooleanEditorTest
 * @Author: SuperZ1999
 * @Date: 2023/8/21
 */
public class NacosCustomBooleanEditorTest {
    @Test
    public void testAllowEmpty() {
        NacosCustomBooleanEditor booleanEditor = new NacosCustomBooleanEditor(true);
        booleanEditor.setValue("");
        Assert.assertEquals(booleanEditor.getAsText(), "false");

        booleanEditor.setValue("true");
        Assert.assertEquals(booleanEditor.getAsText(), "true");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotAllowEmpty() {
        NacosCustomBooleanEditor booleanEditor = new NacosCustomBooleanEditor(false);
        booleanEditor.setValue("true");
        Assert.assertEquals(booleanEditor.getAsText(), "true");

        booleanEditor.setValue("");
    }

    @Test
    public void testCustomBooleanString() {
        NacosCustomBooleanEditor booleanEditor = new NacosCustomBooleanEditor("TRUE", "FALSE", true);
        booleanEditor.setValue("");
        Assert.assertEquals(booleanEditor.getAsText(), "FALSE");

        booleanEditor.setValue("TRUE");
        Assert.assertEquals(booleanEditor.getAsText(), "TRUE");

        booleanEditor.setValue("false");
        Assert.assertEquals(booleanEditor.getAsText(), "FALSE");
    }
}
