package cn.csu.Reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * Java 的反射机制原理
 */
public class TestReflect {

	public Object getProperty(Object obj) throws Exception{	//获得参数对象的属性
		Class<?> classType=obj.getClass();					//获得对象的类型
		System.out.println("Class:"+classType.getName());	
		/*
		 * 在反射动态机制中有两种方法，一个针对无变量的构造方法，一个针对带参数的
		 * 构造方法，，如果想调用带参数的构造方法，就比较的麻烦，不能直接调用Class类中的newInstance（）
		 * 而是调用Constructor类中newInstance（）方法，首先准备一个Class[]作为Constructor的参数类型。 
		 * 然后调用该Class对象的getConstructor（）方法获得一个专属的Constructor的对象，最后再准备一个 
		 * Object[]作为Constructor对象昂的newInstance（）方法的实参。
		 * 
		 * 通过默认构造方法去创建一个新的对象，getConstructor的视其参数决定调用哪个构造方法
		 * 
		 */
		Object objectCopy=classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
		Field fields[]=classType.getDeclaredFields();				//获得对象的所有属性
		// System.out.println(fields.length);
		
		for(int i=0;i<fields.length;i++){
			Field field=fields[i];
			String fieldName=field.getName();
			String firstLetter=fieldName.substring(0, 1).toUpperCase();	//将字段的第一个字母大写
			
			//获得属性对应的getXXX()方法的名字
			//"hamburger".substring(4, 8) returns "urge"  ----substring()用法
			String getMethodName="get"+firstLetter+fieldName.substring(1);
			//获得属性对应的setXXX()方法的名字
			String setMethodName="set"+firstLetter+fieldName.substring(1);
			
//			System.out.println(getMethodName+"  and  "+setMethodName);
			
			//获得和属性对应的getXXX()方法，无参数
			Method getMethod=classType.getMethod(getMethodName, new Class[]{});
			//获得和属性对应的setXXX()方法,有参数
			Method setMethod=classType.getMethod(setMethodName, new Class[]{field.getType()});
			Object value=getMethod.invoke(obj, new Object[]{});
			System.out.println(fieldName+":"+value);
			//调用拷贝对象的setXXX方法
			setMethod.invoke(objectCopy, new Object[]{value});
		}
		return objectCopy;
	}
	
	/*
	 * 利用反射机制动态创建数组
	 */
	public void getArrayProperty() throws ClassNotFoundException{
		Class<?> classType=Class.forName("java.lang.String");
		Object array=Array.newInstance(classType, 10);	//指定数组的类型和大小
		Array.set(array, 5, "Helloworld");				//把索引位置为5的元素设置为Helloworld
		String s=(String)Array.get(array, 5);
		System.out.println(s);
	}
	
	/*
	 * 获得参数对象的属性值
	 */
	public Object getPrivatePropertyValue(Object obj,String propertyName) throws Exception{
		Class cls=obj.getClass();
		Field field=cls.getDeclaredField(propertyName);
		field.setAccessible(true);
		Object retvalue=field.get(obj);
		return retvalue;
	}
	
	/*
	 * 调用指定对象owner的methodName方法,传入的参数为args
	 */
	public Object invokMethod(Object owner,String methodName,Object[] args)throws Exception{
		Class cls=owner.getClass();
		int j=args.length;
		Class[] argclass=new Class[j];		//参数数组
		for(int i=0;i<j;i++){				//设置方法的各参数类型
			argclass[i]=args[i].getClass();
		}
		Method method=cls.getMethod(methodName, argclass);
		return method.invoke(owner, args);
	}
	
	//相加的方法	
	public int add(int num1,int num2){
		return num1+num2;
	}
	
	//输出方法
	public String echo(String info){
		return "echo:"+info;
	}
	
	public void invodeMethod() throws Exception{
		Class<?> classType=TestReflect.class;
		Object invokeTester=classType.newInstance();
		
		//获得add方法的参数，"add"为方法的名字，Class中式参数的类型
		Method addMethod=classType.getMethod("add", new Class[]{
			int.class,int.class
		});
		
		//调用该方法
		Object result =addMethod.invoke(invokeTester, new Object[]{
			new Integer(100),new Integer(200)
		});
		System.out.println((Integer)result);
		
		//获得echo的参数，"echo"方法的名字，Class的参数为参数类型
		Method echoMethod=classType.getMethod("echo", new Class[]{
				String.class
		});
		
		//调用该方法
		result =echoMethod.invoke(invokeTester, new Object[]{"Hello"});
		System.out.println((String)result);
	}
	
	
	public static void main(String[] args) {		
		try {
			TestReflect tr=new TestReflect();
			//初始化Customer对象
			Customer c=new Customer("lian",23);
			c.setId(new Integer(1));
			
			System.out.println("--------------1.取得参数对象中的全部属性---------");
			Customer cu=(Customer)tr.getProperty(c);
			System.out.println("用户信息：编号--"+cu.getId()+
							   ",名称--"+cu.getName()+
							   ",年龄--"+cu.getAge());
			
			System.out.println("--------------2.获得反射数组的信息---------------");
			tr.getArrayProperty();
			
			
			System.out.println("--------------3.获取参数对象的属性值--------------");
			String userName=(String)tr.getPrivatePropertyValue(c, "name");
			System.out.println("用户名称："+userName);
			
			System.out.println("--------------4.执行某对象的方法------------------");
			tr.invokMethod(c, "showInfo", new Object[]{"2000"});
			
			System.out.println("---------------5.调用本类的方法-------------------");
			tr.invodeMethod();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}

class Customer{
	private int id;
	private String name;
	private int age;
	public Customer(){		
	}
	public Customer(String name,int age){
		this.name=name;
		this.age=age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void showInfo(String salary){
		System.out.println("薪水:"+salary+"RMB");
	}
}