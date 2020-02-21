package scheduler.domain;

public class Room 
{
	private String roomNo;
	private int capacity;
	public Room(String roomNo,int capacity)
	{
		this.roomNo=roomNo;
		this.capacity=capacity;
	}
	public String getRoomNumber()
	{
		return roomNo;
	}
	public int getSeatingCapacity()
	{
		return capacity;
	}
}
