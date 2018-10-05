import java.io.*;
import java.util.PriorityQueue;
class Operation 
{
	
	
   public static void main(String args[]) throws UnsupportedEncodingException, FileNotFoundException, IOException

   {
	    aDay sunnyDay=new aDay();
      try{
    	  int count=0;
    	  int score=0;
    	  boolean flag=true;
    	 
		FileInputStream fstream = new FileInputStream("input");
		DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		
		
		
		while ((strLine = br.readLine()) != null) 	{
		String[] s=strLine.split(" ");
	
		String id=s[0];
		String location=s[1];
		String time=s[2];
		Order ord=new Order(time,id,location);
		count++;
		
		sunnyDay.Add(ord);

		
		}
		
		for(int i=0;i<count;i++)
			sunnyDay.remove();

		for(int i=0;i<count;i++) {
			 flag=!sunnyDay.delivered.get(i).DayisOver;
			System.out.println(sunnyDay.delivered.get(i));
			//If the period is sub 90 minutes for
			//the delivery.
		if(sunnyDay.delivered.get(i).waitPeriod<5400)
			score++;
		else if(sunnyDay.delivered.get(i).waitPeriod>12600)
			score--;
		}
		System.out.println("The NPS Score is "+score);
		
		
		in.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
  

         
	}
}