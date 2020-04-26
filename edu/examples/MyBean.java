/**
 * 
 */
package edu.examples;

import java.awt.Component;
import java.io.Serializable;

/**
 * @author stomasini 12/06/2012
 *
 */
public class MyBean extends Component implements Serializable
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
		// TODO Auto-generated constructor stub
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
