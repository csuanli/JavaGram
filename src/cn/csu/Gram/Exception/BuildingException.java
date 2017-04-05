package cn.csu.Gram.Exception;

/**
 * @author Administrator
 *
 */
class CommonException extends Exception{
	public CommonException(){
		super();
	}
	public CommonException(String info){
		super(info);
	}
	public CommonException(String info,Throwable cause){
		super(info,cause);
	}
}

class ThrowException extends Throwable{
	public ThrowException(){
		super();
	}
	public ThrowException(String info){
		super(info);
	}
	public ThrowException(String info,Throwable cause){
		super(info,cause);
	}
}

public class BuildingException {
	public static void ThrowsComException() throws CommonException{
		throw new CommonException("继承Exception类的CommonException异常");
	}
	public static void ThrowsException() throws ThrowException{
		throw new ThrowException("继承Exception类的ThrowsException异常");
	}
	public static void main(String[] args) {
		try {
			ThrowsComException();
			
		} catch (CommonException e) {			
			e.printStackTrace();
		}finally{
			try {
				ThrowsException();		//捕获第二个异常
			} catch (ThrowException e) {
				e.printStackTrace();
			}
		}		
	}
}
