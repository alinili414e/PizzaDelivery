import java.util.ArrayList;
import java.util.PriorityQueue;
/*
 * Class that will represent the entire day of this drone.
 * The orders customers have placed are put in an priority queue 
 * that gives higher priority to Orders that were either placed
 * first ,take less time to finish or a mix of both.
 * For further details about how the orders are compared
 * refer to the comparetTo function of the Order class which has been 
 * Overridden.  
 * */
public class aDay {
	//The queue instance variable.
	PriorityQueue<Order> toDo;
//The represents a counter until the day is finished.
	double timeCount;
//The currTime will keep track of the time/	
	double currTime;
//Every time an order gets fulfilled we add to delivered
	ArrayList<Delivered> delivered;
//Assuming the order could not be satisfied we add what is left.
	ArrayList<Order> whatisLeft;
	public aDay()
	{
		toDo = new PriorityQueue<Order>();
		currTime=21600;
		timeCount=0;
		delivered=new ArrayList<Delivered>();
	}
	public void Add(Order o) {
		//This Stops it working after 16 hours has passed.
		if(o.startTimeInt+timeCount<57600) {
		toDo.add(o);
		
		}
		else 
			//If the time is past 10 PM add it to next day.
			whatisLeft.add(o);
	}

	public Order remove() {
		Order temp=toDo.remove();
		double finish;
		int start=temp.startTimeInt;
		String id=temp.id;
		double arrival=temp.startTimeInt;
	

		if(delivered.size()<1&&start<21600) {
			finish=currTime;
		}
		else if(delivered.size()<1&&start>21600)
		{
			finish=start;
		}
		else
		{
			
			double time1=delivered.get(delivered.size()-1).finishTimeInt;
			if(time1<arrival)
				finish=arrival+temp.c.getD();
			else
				finish=time1+temp.c.getD();
		
		} 
		timeCount=timeCount+temp.c.getD();
		
			
		Delivered justNow=new Delivered(start,id,finish);
		//Flag to check if the time is past 10 PM
		if(finish>79200) {
			justNow.DayisOver=true;
		}
		if(!justNow.DayisOver)
		delivered.add(justNow);
		else 
		{
			System.out.println("Sorry our service time is over");
		}
		
		return temp;
		
	}
}
