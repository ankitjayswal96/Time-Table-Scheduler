package scheduler;

import java.util.ArrayList;
import java.util.Arrays;

import scheduler.domain.Course;
import scheduler.domain.Department;
import scheduler.domain.Instructor;
import scheduler.domain.MeetingTime;
import scheduler.domain.Room;

public class Data 
{
	private ArrayList<Instructor> instructors;
	private ArrayList<Course> courses;
	private ArrayList<Department> dept;
	private ArrayList<MeetingTime> time;
	private ArrayList<Room> rooms;
	private int noOfClasses;
	public Data()
	{
		initialize();
	}
	private Data initialize()
	{
		// Data input for Room
		
		Room room1=new Room("R-103",25);
		Room room2=new Room("R-203",35);
		Room room3=new Room("R-303",45);
		rooms=new ArrayList<Room>(Arrays.asList(room1,room2,room3/*,room4,room5*/));
		
		// Data input for MeetingTime
		
		MeetingTime time1=new MeetingTime("MT-1","09:00-10:00");
		MeetingTime time2=new MeetingTime("MT-2","10:00-11:00");
		MeetingTime time3=new MeetingTime("MT-3","09:00-10:00");
		MeetingTime time4=new MeetingTime("MT-4","11:00-12:00");
		time=new ArrayList<MeetingTime>(Arrays.asList(time1,time2,time3,time4/*,time5*/));
		
		//Data input for Instructor
		
		Instructor ins1=new Instructor("INS-1","Saritha");
		Instructor ins2=new Instructor("INS-2","Ayesha");
		Instructor ins3=new Instructor("INS-3","Anand");
		Instructor ins4=new Instructor("INS-4","Saloni");
		instructors=new ArrayList<Instructor>(Arrays.asList(ins1,ins2,ins3,ins4/*,ins5*/));
		
		//Data input for Course
		
		Course course1=new Course("C-1","Data Structures     ",25,new ArrayList<Instructor>(Arrays.asList(ins1,ins2)));
		Course course2=new Course("C-2","OOMD                ",35,new ArrayList<Instructor>(Arrays.asList(ins1,ins2,ins3)));
		Course course3=new Course("C-3","Software Engineering",25,new ArrayList<Instructor>(Arrays.asList(ins1,ins2)));
		Course course4=new Course("C-4","Web Technologies    ",30,new ArrayList<Instructor>(Arrays.asList(ins3,ins4)));
		Course course5=new Course("C-5","Soft Computing      ",35,new ArrayList<Instructor>(Arrays.asList(ins4)));
		courses=new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5));
		
		//Data input for Department
		
		Department dept1=new Department("ISE",new ArrayList<Course>(Arrays.asList(course1,course3)));
		Department dept2=new Department("ISE",new ArrayList<Course>(Arrays.asList(course2,course4,course5)));
		Department dept3=new Department("CSE",new ArrayList<Course>(Arrays.asList(course4,course5)));
		dept=new ArrayList<Department>(Arrays.asList(dept1,dept2,dept3));
		
		// Calculating total no of classes
		
		dept.forEach(x->noOfClasses+=x.getCourses().size());
		return this;
		
	}
	public ArrayList<Instructor> getInstructors()
	{
		return instructors;
	}
	public ArrayList<Course> getCourses()
	{
		return courses;
	}
	public ArrayList<Department> getDepartment()
	{
		return dept;
	}
	public ArrayList<MeetingTime> getMeetingTime()
	{
		return time;
	}
	public ArrayList<Room> getRooms()
	{
		return rooms;
	}
	public int getNoOfClasses()
	{
		return noOfClasses;
	}
}
