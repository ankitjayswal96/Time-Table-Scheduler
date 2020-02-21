package scheduler;

import java.util.ArrayList;
import scheduler.domain.Class;
public class Tester 
{
	public static final int POPULATION_SIZE=9;
	public static final double MUTATION_RATE=0.1;
	public static final double CROSSOVER_RATE=0.9;
	public static final int TOURNAMENT_SELECTION_SIZE=3;
	public static final int NO_OF_SCHEDULES=1;
	private int classNo=1;
	private Data data;
	private int scheduleNo=0;
	private void printAvailableData()
	{
		System.out.println("Available Departments");
		data.getDepartment().forEach(x->System.out.println("Name:"+x.getName()+", Courses:"+x.getCourses()));
		System.out.println("\n Available Courses");
		data.getCourses().forEach(x->System.out.println("Course#:"+x.getNo()+", Name:"+x.getName()+", Max # of Students:"+x.getMaxNoOfStudents()+", Instructors:"+x.getInstructors()));
		System.out.println("\n Available Instructors");
		data.getInstructors().forEach(x->System.out.println("Id:"+x.getId()+", Name:"+x.getName()));
		System.out.println("\n Available Meeting Times");
		data.getMeetingTime().forEach(x->System.out.println("Id:"+x.getId()+", Meeting Time:"+x.getTime()));
		System.out.println("\n Available Seating Capacity");
		data.getRooms().forEach(x->System.out.println("Room#:"+x.getRoomNumber()+", Seating Capacity:"+x.getSeatingCapacity()));
		System.out.print("------------------------------------------------------------------------------");
		System.out.print("-------------------------------------------------------------------------------");
		System.out.print("-------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------");
	}
	private void printScheduleAsTable(Schedule schedule,int generationNo)
	{
		ArrayList<Class> classes=schedule.getClasses();
		System.out.print("------------------------------------------------------------------------------");
		System.out.print("-------------------------------------------------------------------------------");
		System.out.print("-------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.print("\n");
		System.out.print("          ---------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("         "+" | Class#        |     Department    |    Course(Course#,Max No of Students)    | Room(Seating Capacity) |   Instructor(Id)   | Meeting Time(Id)  |");
		System.out.print("          ---------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------");
		classes.forEach(x->
		{
			int majorIndex=data.getDepartment().indexOf(x.getDepartment());
			int courseIndex=data.getCourses().indexOf(x.getCourses());
			int roomIndex=data.getRooms().indexOf(x.getRooms());
			int instructorIndex=data.getInstructors().indexOf(x.getInstructors());
			int meetingTimeIndex=data.getMeetingTime().indexOf(x.getMeetingTime());
			//System.out.print("                           ");
			System.out.print("          | "+String.format("%1$02d",classNo)+"            |");
			System.out.print("      "+String.format("%1$4s",data.getDepartment().get(majorIndex).getName())+"         |");
			System.out.print("       "+String.format("%1$21s",data.getCourses().get(courseIndex).getName()+"("+data.getCourses().get(courseIndex).getNo()+","+x.getCourses().getMaxNoOfStudents()+")")+"       |");
			System.out.print("       "+String.format("%1$10s",data.getRooms().get(roomIndex).getRoomNumber()+"("+x.getRooms().getSeatingCapacity()+")")+"       |");
			System.out.print("  "+String.format("%1$15s",data.getInstructors().get(instructorIndex).getName()+"("+data.getInstructors().get(instructorIndex).getId()+")")+"   |");
			System.out.println(" "+data.getMeetingTime().get(meetingTimeIndex).getTime()+"("+data.getMeetingTime().get(meetingTimeIndex).getId()+")"+" |");
			System.out.print("          ---------------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------------------");
			classNo++;
		});
		if(schedule.getFitness()==1)
		{
			System.out.println();
			System.out.print("------------------------------------------------------------------------------");
			System.out.print("-------------------------------------------------------------------------------");
			System.out.print("-------------------------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println();
			System.out.println(">Solution Found in "+ (generationNo+1)+"th"+" generation");
			System.out.println();
			System.out.print("------------------------------------------------------------------------------");
			System.out.print("-------------------------------------------------------------------------------");
			System.out.print("-------------------------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------------------");
			
		}
	}
	public static void main(String args[])
	{
		Tester tester=new Tester();
		tester.data=new Data();
		int generationNo=0;
		tester.printAvailableData();
		System.out.println();
		System.out.println(">Generation#:"+ generationNo);
		System.out.println();
		System.out.print("------------------------------------------------------------------------------");
		System.out.print("-------------------------------------------------------------------------------");
		System.out.print("-------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println();
		System.out.print("Schedule# |             ");
		System.out.print("                                                      Classes[Department,Class,Room,Instructor,MeetingTime]            ");
		System.out.print("                       "+"\t"+"\t"+"\t"+"\t"+"\t"+"\t" +"\t"+"\t"+"   "+"| Fitness|Conflicts");
		System.out.println();
		System.out.print("------------------------------------------------------------------------------");
		System.out.print("-------------------------------------------------------------------------------");
		System.out.print("-------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------");
		GeneticAlgorithm ga=new GeneticAlgorithm(tester.data);
		Population population=new Population(Tester.POPULATION_SIZE,tester.data).sortByFitness();
		population.getSchedules().forEach(schedule->System.out.println("     "+tester.scheduleNo++ + "    |"+schedule+" | "+String.format("%.5f", schedule.getFitness())+"| "+schedule.getNoOfConflicts()));
		tester.printScheduleAsTable(population.getSchedules().get(0),generationNo);
		tester.classNo=1;
		while(population.getSchedules().get(0).getFitness()!=1.0)
		{
			System.out.println();
			System.out.print("------------------------------------------------------------------------------");
			System.out.print("-------------------------------------------------------------------------------");
			System.out.print("-------------------------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println();
			System.out.println(">Generation#:"+ ++generationNo);
			System.out.println();
			System.out.print("------------------------------------------------------------------------------");
			System.out.print("-------------------------------------------------------------------------------");
			System.out.print("-------------------------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println();
			System.out.print("Schedule# |             ");
			System.out.print("                                                      Classes[Department,Class,Room,Instructor,MeetingTime]            ");
			System.out.print("                       "+"\t"+"\t"+"\t"+"\t"+"\t"+"\t" +"\t"+"\t"+"   "+"| Fitness|Conflicts");
			System.out.println();
			System.out.print("------------------------------------------------------------------------------");
			System.out.print("-------------------------------------------------------------------------------");
			System.out.print("-------------------------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println();
			population=ga.evolve(population).sortByFitness();
			tester.scheduleNo=0;
			population.getSchedules().forEach(schedule->System.out.println("     "+tester.scheduleNo++ + "    |"+schedule+" | "+String.format("%.5f", schedule.getFitness())+"| "+schedule.getNoOfConflicts()));
			System.out.println();
			tester.printScheduleAsTable(population.getSchedules().get(0),generationNo);
			System.out.println();
			tester.classNo=1;
		}
	}
}
