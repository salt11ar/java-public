package edu.examples;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author stomasini 05/06/2012
 * @
 *
 */
@Documented
@interface ClassPreamble
{
	String author();

	String date();

	int currentRevision() default 1;

	String lastModified() default "N/A";

	String lastModifiedBy() default "N/A";

	// Note use of array
	String[] reviewers();
	
	 
}

/**
 * 
 * @author stomasini 05/06/2012
 *  To make annotation information available at runtime, the annotation type itself must be annotated with this
 */
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationForRuntime {

   // Elements that give information
   // for runtime processing
   
}


/**
 * 
 * @author stomasini 05/06/2012
 * @
 *
 */
@ClassPreamble (
	   author = "John Doe",
	   date = "3/17/2002",
	   currentRevision = 6,
	   lastModified = "4/12/2004",
	   lastModifiedBy = "Jane Doe",
	   // Note array notation
	   reviewers = {"Alice", "Bob", "Cindy"}
)
public class AnnotationsExamples
{

	@Deprecated
	public void methodToBeOverriden(){
		
	}
	
	
	@ClassPreamble (
		   author = "John Doe",
		   date = "3/17/2002",
		   currentRevision = 6,
		   lastModified = "4/12/2004",
		   lastModifiedBy = "Jane Doe",
		   // Note array notation
		   reviewers = {"Alice", "Bob", "Cindy"}
	)
	public class AnnotationChild extends AnnotationsExamples{
	
		@Override
		public void methodToBeOverriden(){
			
		}	
	}	
	
	
}




