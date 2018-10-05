
public class Delivered {
	int startTimeInt;
	String id;
	boolean DayisOver;
	double finishTimeInt;
	double waitPeriod;
	String finishTimeString;
	public Delivered(int start,String i,double finish)
	{
		finishTimeString=putTimeinString((int)finish);
		this.startTimeInt=start;
		this.id=i;
		this.finishTimeInt=finish;
		waitPeriod=finish-start;
		DayisOver=false;
	}
	
		public  String putTimeinString(int timeInSeconds)
		{
		    int hours = timeInSeconds / 3600;
		    int secondsLeft = timeInSeconds%3600;
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


	
	public String toString()
	{
		int n=(int)this.finishTimeInt;
		String s=this.finishTimeString;
		String id=this.id;
		String ret=id+" "+s;
		return ret;
	}
	

}
