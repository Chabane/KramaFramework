package org.kramaframework.introspection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.kramaframework.exception.KramaReflectionIllegalArgumentException;
import org.kramaframework.exception.KramaReflectionIllegalClassException;
import org.kramaframework.exception.KramaReflectionIllegalMethodSignatureException;
import org.kramaframework.exception.KramaViewClassNotFoundException;

/**
 * This class is dealing to convert a string information format to 
 * java instance class. It also invoke a method of class. 
 * @author chabane
 * @version 1.0
 */
public class TReflection {

	/**
	 * This method allows to obtains a object from TMethod object and
	 * parameter's
	 * 
	 * @param tMethod
	 * @param paramValue
	 * @return a value of method return 
	 * @throws KramaReflectionIllegalClassException 
	 * @throws KramaReflectionIllegalMethodSignatureException 
	 * @throws KramaReflectionIllegalArgumentException 
	 */
	public static Object getResult(TMethod tMethod, Object[] paramValue) throws KramaReflectionIllegalClassException, KramaReflectionIllegalMethodSignatureException, KramaReflectionIllegalArgumentException {

		Object result = null;
		try {
			// Get the Class object associated with the name of class
			Class className = Class.forName(tMethod.get_class());
			// Creates a new instance of the class represented by this name of Class object.
			Object classInstance = className.newInstance();
			// Get all types of parameters
			List paramsList = tMethod.get_params();
			// We store a instances of type in table of class
			Class[] parameterTypes = null;
			
			// If any parameter, we recuperate a types
			if (paramValue != null && paramValue.length > 0) {
				parameterTypes = new Class[paramsList.size()];
				for (int i = 0; i < paramsList.size(); i++) {
					Class typeParam = Class.forName(paramsList.get(i).toString());
					parameterTypes[i] = typeParam;
				}
			}
			/*
			 *  Returns an Method objects reflecting all the methods 
			 *  declared by the class
			 */
			Method methodeName = classInstance.getClass().getDeclaredMethod(
					tMethod.get_method(), parameterTypes);
			
			// Return a value of method
			result = methodeName.invoke(classInstance, (Object[]) paramValue);

		} catch (ClassNotFoundException e) {
			throw new KramaReflectionIllegalClassException(tMethod.get_class()+" not exist", e);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			throw new KramaReflectionIllegalMethodSignatureException(
					tMethod.get_method()+" not exist in "+tMethod.get_class(), e);
		} catch (IllegalArgumentException e) {
			throw new KramaReflectionIllegalArgumentException("All or some arguments were" +
					" not found into method "+tMethod.get_method()+
					" from "+tMethod.get_class(), e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Get an instance of class view from name of view
	 * 
	 * @param view
	 * @return Instance of view
	 * @throws KramaViewClassNotFoundException 
	 */
	public static Object getView(String view) throws KramaViewClassNotFoundException {
		Object result = null;
		try {
			// Get the Class object associated with the name of class
			Class className = Class.forName(view);
			// Creates a new instance of the class represented by this name of Class object.
			result = className.newInstance();

		} catch (ClassNotFoundException e) {
			throw new KramaViewClassNotFoundException(view+" not exist !");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
}
