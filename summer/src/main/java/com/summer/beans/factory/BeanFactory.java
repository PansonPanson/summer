package com.summer.beans.factory;
import com.summer.beans.

/**
 * @author: panxing
 * @date: 2019年07月26日 19:52
 */
public interface BeanFactory {

	BeanDefinition getBeanDefinition(String petstore);

	PetStoreService getBean(String petStore);
}
