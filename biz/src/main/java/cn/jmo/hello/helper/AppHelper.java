package cn.jmo.hello.helper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

public class AppHelper implements ApplicationContextAware{

    private static final Log logger = LogFactory.getLog(AppHelper.class);

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext appCtxIn) {
        applicationContext = appCtxIn;
    }

    /**
     * 根据beanId返回Spring管理的Bean实例对象.
     */
    public static Object getBean(String beanId) {
        Object service = null;

        if (applicationContext != null) {
            try {
                if (beanId.indexOf(".") >= -1) {
                    beanId = beanId.substring(beanId.lastIndexOf(".") + 1, beanId.length());
                }
                beanId = StringUtils.uncapitalize(beanId);
                if (logger.isDebugEnabled()) {
                    logger.debug("Finding bean=" + beanId);
                }
                service = applicationContext.getBean(beanId);
            } catch (NoSuchBeanDefinitionException ex) {
                ex.printStackTrace();
            } catch (BeansException ex) {
                ex.printStackTrace();
            }

        }
        return service;
    }
}
