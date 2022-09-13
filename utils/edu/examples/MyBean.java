/**
 * 
 */
package edu.examples;

import java.awt.Component;

/**
 * @author stomasini 12/06/2012
 *
 */
public class MyBean extends Component
{

	private String name;
	private String thisIsPrivate = "esto es privado!!";
	/**
	 * @return the thisIsPrivate
	 */
	private String getThisIsPrivate()
	{
		return thisIsPrivate;
	}
	/**
	 * @param thisIsPrivate the thisIsPrivate to set
	 */
	private void setThisIsPrivate(String thisIsPrivate)
	{
		this.thisIsPrivate = thisIsPrivate;
	}
	/**
	 * 
	 */
	public MyBean()
	{
		setThisIsPrivate("fromconstructor");
		getThisIsPrivate();
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
}
