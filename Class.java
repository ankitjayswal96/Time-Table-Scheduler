package scheduler.domain;
import scheduler.domain.Instructor;
import scheduler.domain.Course;
import scheduler.domain.Department;
import scheduler.domain.MeetingTime;
import scheduler.domain.Room;
public class Class
{
	private int id;
	private Instructor instructors;
	private Course courses;
	private Department dept;
	private MeetingTime time;
	private Room rooms;
	public Class(int id,Department dept,Course courses)
	{
		this.id=id;
		this.courses=courses;
		this.dept=dept;
	}
	public void setInstructors(Instructor instructors)
	{
		this.instructors=instructors;
	}
	public void setMeetingTime(MeetingTime time)
	{
		this.time=time;
	}
	public void setRooms(Room rooms)
	{
		this.rooms=rooms;
	}
	public int getId()
	{
		return id;
	}
	public Instructor getInstructors()
	{
		return instructors;
	}
	public Course getCourses()
	{
		return courses;
	}
	public Department getDepartment()
	{
		return dept;
	}
	public MeetingTime getMeetingTime()
	{
		return time;
	}
	public Room getRooms()
	{
		return rooms;
	}
	// A string method to return the class
	public String toString()
	{
		return("["+dept.getName()+","+courses.getNo()+","+rooms.getRoomNumber()+","+instructors.getId()+","+time.getId()+"]");
	}
}
