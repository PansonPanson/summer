package top.summer.test.v1;

import org.junit.Assert;
import org.junit.Test;
import top.summer.beans.factory.BeanFactory;
import top.summer.beans.factory.support.DefaultBeanFactory;
import top.summer.service.v1.PetStoreServcie;

/**
 * @Author: Panson
 */
public class BeanFactoryTest {

    /**
     * 测试获取 bean
     */
    @Test
    public void testGetBean() {
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition beanDefinition = factory.getBeanDefinition("petstore");

        Assert.assertEquals("top.summer.PetStoreService", beanDefinition.getBeanClassName());

        PetStoreServcie petStoreServcie = (PetStoreServcie) factory.getBean("petStore");

        Assert.assertNotNull(petStoreServcie);
    }
}
