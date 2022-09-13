/**
 * 
 */
package edu.examples;

import java.applet.Applet;
import java.beans.Beans;
import java.io.IOException;

/**
 * @author stomasini 12/06/2012
 *
 */
@SuppressWarnings("removal")	
public class JavaBeansExample extends Applet
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		MyBean mybean; //= new MyBean( );
		//
				
		try
		{
			mybean = (MyBean) Beans.instantiate(ClassLoader.getSystemClassLoader( )  , "edu.examples.MyBean" );
			mybean.setName( "My bean" );
			// from JavaBeans spec : You should never use Java casts to access different type views of a Java bean.
			
//			Programmers must note that:
//				� they should never use Java �instanceof� or Java casts to navigate between different type
//				views of a bean.
//				� they should not assume that the result object of a beans.getInstanceOf call is the same
//				object as the input object.
//				� they should not assume that the result object of a beans.getInstanceOf call supports the
//				same properties, events, or methods supported by the original type view.
			//
			
			//validate if the instanceof is of component before get type view
			//if (Beans.isInstanceOf(x, java.awt.Component.class)) {
			java.awt.Component typeViewForComponent = (java.awt.Component)
							Beans.getInstanceOf(mybean, java.awt.Component.class);
			
			if(Beans.isInstanceOf( typeViewForComponent, edu.examples.MyBean.class )){
				System.out.println("bean is edu.examples.MyBean.class");

			}

			if(Beans.isInstanceOf( typeViewForComponent, java.awt.Component.class )){
				System.out.println("bean is java.awt.Component.class");

			}
			
			System.out.println("typeViewForComponent is type view of "+ typeViewForComponent.getClass( ).toString( ));

			System.in.read( );
			
			
		}
		catch (ClassNotFoundException | IOException e)
		{
			e.printStackTrace();
		}
		
	
		
	}
	
}
