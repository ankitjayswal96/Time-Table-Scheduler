package scheduler.domain;

import java.util.ArrayList;
import scheduler.domain.Course;
public class Department 
{
	private String name;
	private ArrayList<Course> courses;
	public Department(String name,ArrayList<Course> courses)
	{
		this.name=name;
		this.courses=courses;
	}
	public String getName()
	{
		return name;
	}
	public ArrayList<Course> getCourses()
	{
		return courses;
	}
	// A String method that returns the department name
	public String toString()
	{
		return name;
	}
	
}
