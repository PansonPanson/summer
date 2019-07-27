package com.summer.beans.factory.support;

import com.summer.beans.factory.BeanFactory;
import com.summer.beans.BeanDefinition;

/**
 * @author: panxing
 * @date: 2019年07月26日 19:56
 */
public class DefaulBeanFactory implements BeanFactory {
	public DefaulBeanFactory(String configFile) {

	}

	@Override
	public BeanDefinition getBeanDefinition(String petstore) {
		return null;
	}

	@Override
	public PetStoreService getBean(String petStore) {
		return null;
	}
}
