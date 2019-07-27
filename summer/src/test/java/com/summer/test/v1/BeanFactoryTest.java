package com.summer.test.v1;

import com.summer.beans.BeanDefinition;
import com.summer.beans.factory.BeanFactory;
import com.summer.beans.factory.support.DefaulBeanFactory;
import com.summer.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author: panxing
 * @date: 2019年07月26日 19:19
 */
public class BeanFactoryTest {

	@Test
	public void testGetBean() {
		BeanFactory factory = new DefaulBeanFactory("petstore-v1.xml");
		BeanDefinition bd = factory.getBeanDefinition("petstore");

		Assert.assertEquals("com.summer.service.v1.PetStoreService", bd.getBeanClassName());

		PetStoreService petStoreService = (PetStoreService)factory.getBean("petStore");

		Assert.assertNotNull(petStoreService);
	}
}
