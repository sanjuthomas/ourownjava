package com.ourownjava.corejava.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ourownjava.com
 *
 */
public class Invoker {

	public static Object invoke(String className, 
			String methodName, Object... params) throws Exception{
		
		final List<Class<?> > paramTypes = new ArrayList<Class<?> >(params.length);
		final List<Object> paramInstances = new ArrayList<Object>(params.length);
		
		for(Object param : params){			
			paramTypes.add(param.getClass());
			paramInstances.add(param);
		}
		
		final Object object = Class.forName(className).newInstance();
		final Method method = object.getClass().getMethod(methodName, 
				(Class[]) paramTypes.toArray(new Class[paramTypes.size()]));
		return method.invoke(object, paramInstances.toArray());				
	}
}