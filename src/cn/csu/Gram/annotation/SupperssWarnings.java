package cn.csu.Gram.annotation;

public class SupperssWarnings {
	@SuppressWarnings(value={"Deprecation"})
	public static void main(String[] args) {
		new Test().foo();
	}
}

class Test{
	@Deprecated
	public void foo(){
		System.out.println("Deprecated method!");
	}
}