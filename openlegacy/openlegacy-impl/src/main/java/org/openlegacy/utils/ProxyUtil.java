package org.openlegacy.utils;

import net.sf.cglib.proxy.Enhancer;

import org.springframework.aop.TargetClassAware;
import org.springframework.aop.framework.Advised;

public class ProxyUtil {

	@SuppressWarnings("unchecked")
	public static <T> T getTargetObject(Object proxy, Class<T> targetClass) throws Exception {
		if (proxy instanceof Advised) {
			return (T)((Advised)proxy).getTargetSource().getTarget();
		}
		return (T)proxy;
	}

	public static Class<?> getObjectRealClass(Object object) {
		if (object instanceof TargetClassAware) {
			return ((TargetClassAware)object).getTargetClass();
		} else {
			return object.getClass();
		}
	}

	public static Class<?> getOriginalClass(Class<?> entityClass) {
		if (Enhancer.isEnhanced(entityClass)) {
			entityClass = entityClass.getSuperclass();
		}
		return entityClass;
	}
}
