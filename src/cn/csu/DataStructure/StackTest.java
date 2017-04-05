/**
 * 
 */
package cn.csu.DataStructure;

/**
 * 栈的数组实现
 * @author Lenovo
 *
 */
public class StackTest {

	public static void main(String[] args) {
		StackArray sa=new StackArray(10);
		sa.push(1);
		sa.push(2);
		sa.push(3);
		System.out.println(sa.pop());
		sa.push(4);
		while(!sa.isEmpty()){
			System.out.println(sa.pop());
		}
	}
}

class StackArray {
	
	private Object [] theArray;
	private int topOfStack;
	private static final int DEFAULT_CAPACITY = 10;//栈的数组默认大小
	
	public StackArray(){
		this(DEFAULT_CAPACITY);
	}
	
	public StackArray(int capacity){
		theArray = new Object[capacity];
		topOfStack = -1;
	}
	
	public boolean isEmpty(){
		return topOfStack==-1;
	}
	
	public boolean isFull(){
		return topOfStack==theArray.length-1;
	}
	
	public void push(Object x){//入栈操作
		if(isFull())
			throw new RuntimeException("栈满");
		theArray[++topOfStack] = x;
	}
	
	public Object peek(){//查看栈顶元素
		if(isEmpty())
			return null;
		return theArray[topOfStack];
	}
	
	public Object pop(){//弹出栈的顶元素
		if(isEmpty())
			return null;
		Object topItem = theArray[topOfStack];
		theArray[topOfStack--]=null;
		return topItem;
	}
}
