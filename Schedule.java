package scheduler;

import java.util.ArrayList;
import scheduler.domain.Class;
import scheduler.domain.Department;
public class Schedule
{
	private int classNo;
	private ArrayList<Class> classes;
	private Data data;
	private int noOfConflicts=0;
	private double fitness=-1;
	private boolean isFitnessChanged=true;
	public Data getData()
	{
		return data;
	}
	public Schedule(Data data)
	{
		this.data=data;
		classes=new ArrayList<Class>(data.getNoOfClasses());
	}
	public Schedule initialize()
	{
		new ArrayList<Department>(data.getDepartment()).forEach(dept->
		{
			dept.getCourses().forEach(course->
			{
				Class class1=new Class(classNo++,dept,course);
				
				// Setting up the meeting time
				
				class1.setMeetingTime(data.getMeetingTime().get((int)(data.getMeetingTime().size()*Math.random())));
				
				// Setting up the rooms info
				
				class1.setRooms(data.getRooms().get((int)(data.getRooms().size()*Math.random())));
				
				//  Setting up the Instructors info
				
				class1.setInstructors(course.getInstructors().get((int)(course.getInstructors().size()*Math.random())));
				classes.add(class1);
			});
		});
		return this;
	}
	public int getNoOfConflicts()
	{
		return noOfConflicts;
	}
	public ArrayList<Class> getClasses()
	{
		isFitnessChanged=true;
		return classes;
	}
	public double getFitness()
	{
		if(isFitnessChanged==true)
		{
			fitness=calculateFitness();
			isFitnessChanged=false;
		}
		return fitness;
	}
	private double calculateFitness()
	{
		noOfConflicts=0;
		classes.forEach(x->
		{
			if(x.getRooms().getSeatingCapacity()<x.getCourses().getMaxNoOfStudents())
				noOfConflicts++;
			classes.stream().filter(y->classes.indexOf(y)>=classes.indexOf(x)).forEach(y->
			{
				// Calculating different types of conflicts
				
				if(x.getMeetingTime()==y.getMeetingTime() && x.getId()!=y.getId())
				{
					if(x.getRooms()==y.getRooms())
						noOfConflicts++;
					if(x.getInstructors()==y.getInstructors())
						noOfConflicts++;
				}
			});
		});
		return(1/((double)(noOfConflicts+1)));
	}
	public String toString()
	{
		String returnValue=new String();
		for(int x=0;x<classes.size();x++)
		{
			returnValue+=classes.get(x)+",";
		}
		returnValue+=classes.get(classes.size()-1);
		return returnValue;
	}
}
