package cn.csu.Collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Set无法拥有重复元素，内部set是内部排序的
 * @author Administrator
 */
public class SetOrder {

	public static void main(String[] args) {
		HashSet<Integer> hs=new HashSet<Integer>();
		hs.add(new Integer(1));
		hs.add(new Integer(5));
		hs.add(new Integer(3));
		hs.add(new Integer(2));
		
		Iterator<Integer> it=hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next());		//1 2 3 5
		}
	}

}
