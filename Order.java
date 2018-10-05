
public class Order implements Comparable<Order>{
int startTimeInt;
String id;
Coordinates c;
double stamp;
boolean flag;

public Order(String time,String id,String c)
{
	this.startTimeInt=getTimeInSeconds(time);
	this.id=id;
	this.c=new Coordinates(c);
	this.stamp=this.startTimeInt+this.c.getD();
	if(getTimeInSeconds(time)<21600)
		flag=true;
	else 
		flag=false;
		
}
	@Override
	public int compareTo(Order o) {
		if(this.stamp<o.stamp)
			return -1;
		else if(this.stamp==o.stamp)
			return 0;
		else 
			return 1;
	}	
	//Method to help with writing the time in
	//efficient way.
	public  String putTimeinString(int timeInSeconds)
	{
	    int hours = timeInSeconds / 3600;
	    int secondsLeft = timeInSeconds - hours * 3600;
	    int minutes = secondsLeft / 60;
	    int seconds = secondsLeft - minutes * 60;

	    String formattedTime = "";
	    if (hours < 10)
	        formattedTime += "0";
	    formattedTime += hours + ":";

	    if (minutes < 10)
	        formattedTime += "0";
	    formattedTime += minutes + ":";

	    if (seconds < 10)
	        formattedTime += "0";
	    formattedTime += seconds ;

	    return formattedTime;
	}
	public  int getTimeInSeconds(String s) {
		String[] splitted = s.split(":");
		int hours = Integer.parseInt(splitted[0]);
		int minutes = Integer.parseInt(splitted[1]);
		int seconds = Integer.parseInt(splitted[2]);
		int ret = (hours * 3600) + (minutes * 60) + (seconds);
		return ret;
	}
	public String toString()
	{
		int t=this.startTimeInt;
		String ret=this.id+" "+this.c.cordinates+" "+this.putTimeinString(t);
		return ret;
	}
}
