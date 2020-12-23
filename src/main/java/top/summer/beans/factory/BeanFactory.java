package top.summer.beans.factory;

/**
 * @Author: Panson
 */
public interface BeanFactory {
    BeanDefinition getBeanDefinition(String petstore);

    Object getBean(String beanId);
}
