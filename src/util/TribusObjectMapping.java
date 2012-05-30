package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class TribusObjectMapping {

	private static Map<String,Class> typeMap = new HashMap<String,Class>();
	
	static{												
			typeMap.put("string",java.lang.String.class);					
			typeMap.put("date", java.util.Date.class);							
	}
	
	public static void main(String[] args) {
		try {
			Class myclass = Class.forName("model.User");
			Object o = myclass.newInstance();
			
			Field[] fs = myclass.getDeclaredFields();
			for (Field field : fs) {
				System.out.println(field.getName());
				
				Class c = field.getType();
				System.out.println(c.getName());
				if(c.getName() == "int"){
					
					String ini = field.getName();
					String n_ini = ini.substring(0,1).toUpperCase()+ini.substring(1);
					ini = null;
					
					myclass.getDeclaredMethod("set"+n_ini, Integer.TYPE).invoke(o,new Integer(1) );
				}else if(c.getName() == "java.lang.String"){
					
					String ini = field.getName();
					String n_ini = ini.substring(0,1).toUpperCase()+ini.substring(1);
					ini = null;
					Class ccc = Class.forName("java.lang.String");
					myclass.getDeclaredMethod("set"+n_ini, ccc).invoke(o,"String123" );
				}
				
				
			}
			
			User u = (model.User)o;
			System.out.println(u.getUserId());
			System.out.println(u.getUserPassword());
			
			
			System.out.println(Integer.TYPE);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public static Object convert(String className, HttpServletRequest request,
			HttpServletResponse response) {
		
		
		
		Class myclass = null;
		try {
			myclass = Class.forName("model.User");
			Object o = myclass.newInstance();
			
			Field[] fs = myclass.getDeclaredFields();
			for (Field field : fs) {				
				
				Class c = field.getType();
				
				String ini = field.getName();
				String n_ini = ini.substring(0,1).toUpperCase()+ini.substring(1);
				ini = null;
								
				String para_value = null;
				
				
				//<input name="username" value=""/>
				if(request.getParameter(ini)!=null && !"".equals(request.getParameter(ini))){
					para_value = request.getParameter(ini);
					
					
					if( "int".equals(c.getName())){														
						myclass.getDeclaredMethod("set"+n_ini, Integer.TYPE).invoke(o, Integer.parseInt(para_value));
					}else if("java.lang.String".equals(c.getName())){
						myclass.getDeclaredMethod("set"+n_ini, typeMap.get("string")).invoke(o,para_value);
					}else if("java.util.Date".equals(c.getName())){
						
					}				
				}				
			}
			
			
			return o; 


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
}
