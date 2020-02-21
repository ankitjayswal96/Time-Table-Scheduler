package scheduler.domain;

import java.util.ArrayList;
import scheduler.domain.Instructor;
public class Course 
{
	private String no;
	private String name;
	private int maxNoOfStudents;
	private ArrayList<Instructor> instructors;
	public Course(String no,String name,int maxNoOfStudents,ArrayList<Instructor> instructors)
	{
		this.no=no;
		this.name=name;
		this.maxNoOfStudents=maxNoOfStudents;
		this.instructors=instructors;
	}
	public String getNo()
	{
		return no;
	}
	public String getName()
	{
		return name;
	}
	public int getMaxNoOfStudents()
	{
		return maxNoOfStudents;
	}
	public ArrayList<Instructor> getInstructors()
	{
		return instructors;
	}
	// A String method that returns the name of the instructor
	public String toString()
	{
		return name;
	}
}
