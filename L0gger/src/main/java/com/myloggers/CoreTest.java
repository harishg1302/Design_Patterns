package com.myloggers;

class A
{
	
}
class B extends A
{
	
}
class C extends B{
	
}

public class CoreTest {
	
	static void o(A a)
	{
		System.out.print("One");
	}
	
	/*static void o(B a)
	{
		System.out.print("Two");
	}*/
	
	static void o(Object a)
	{
		System.out.print("Three");
	}
	
	 public static void main(String str[])
	 {
		 C c=new C();
		 o(c);
	 }
	

}
