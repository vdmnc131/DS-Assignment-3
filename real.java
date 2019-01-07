import java.io.*;
import java.lang.Integer;

class Event
{
	String eventID;
	String eventName;
	String eventDescription;
	Maxheap C1;
	public Event()
	{
		eventID="";
		eventName="";
		 eventDescription="";
		 C1= new Maxheap();
	}
		
}

class Participant
{
	String  participantID;
	String participantName;
	String universityName;
	public Participant()
	{
		participantID="";		
		participantName="";
		universityName="";

	}
	
}
public class real
{
	final int MAX_EVENT=1000;
	final int MAX_PARTICPANT=600000;
	public Event[] A1;
	public Participant[] B1;

	public int counter_event;
	public int counter_participant;
	public MaxOfMaxheap D1;
	public int l=0;
		
	

	// public dynamicArray B1 = new dynamicArray();
	public real()
	{
	counter_event=1;
	A1= new Event[MAX_EVENT+1];
	B1= new Participant[MAX_PARTICPANT+1];
	counter_participant=1;
	

	
	}
	public void ADD_EVENT(String A,String B ,String C)
	{		 
	
		A1[counter_event]= new Event();
		A1[counter_event].eventID=A;
		A1[counter_event].eventName=B;
		A1[counter_event].eventDescription=C;
		A1[counter_event].C1= new Maxheap();
		
		counter_event++;
		
	}
	public void ADD_PARTICIPANT(String A,String B, String C)
	{	
		 B1[counter_participant]= new Participant();
		B1[counter_participant].participantID=A;
		B1[counter_participant].participantName=B;
		B1[counter_participant].universityName=C;
		counter_participant++;


	}
	
	public void ADD(String A, String B)  throws Exception
		{	
			

			int i=returnIndexOfEvent(B);
			int j=returnIndexOfParticipant(A);
			
			 if(i>0 &&  j>0 )
			
			A1[i].C1.insert(0,B1[j]);
			else{
        System.out.println("ILLEGAL QUERY");
        throw new Exception();
             }


		}
	public void UPDATE_SCORE( String A, String B, int k) throws Exception
	{
			
			int i=returnIndexOfEvent(B);
			int j=returnIndexOfParticipant(A);
			
			 if(i>0 &&  j>0 )
			A1[i].C1.modifyKeyOfNode(k,B1[j]);
			else{
        System.out.println("ILLEGAL QUERY");
        throw new Exception();
             }
				

	}
	public void DELETE_EVENT_PARTICIPANT(String A ,String B) throws Exception
		{
			
			int i=returnIndexOfEvent(B);
			int j=returnIndexOfParticipant(A);
			 if(i>0 &&  j>0 )
			A1[i].C1.deleteNode(B1[j]);
				else{
        System.out.println("ILLEGAL QUERY");
        throw new Exception();
             }


		}
	public void DELETE_PARTICIPANT(String A) throws Exception
		{	int temp=0;
			int j=returnIndexOfParticipant(A);
			 if(j>0 )
			{
			for(int i=1;i<counter_event;i++)
				
			{
				temp=A1[i].C1.returnIndex(B1[j]);
				if(temp!=-1)
					A1[i].C1.deleteNode(B1[j]);
			}
			}
			else{
        System.out.println("ILLEGAL QUERY");
        throw new Exception();
             }

		}
	 public void CANCEL_EVENT(String B) throws Exception
	 {
	 	// System.out.println(counter_event);
	 	int i=returnIndexOfEvent(B);
	 	if(i>0)
	 {
	 	for(int j=i;j<counter_event-1;j++)
	 	{
	 		A1[j]=A1[j+1];
	 	}
	 	counter_event--;
	 }
	 else{
        System.out.println("ILLEGAL QUERY");
        throw new Exception();
             }
	 }
	public void TOP3_IN_EVENT(String B) throws Exception
	{	
		int i=returnIndexOfEvent(B);
		if(i>0)
		A1[i].C1.printTop3();
		else{
        System.out.println("ILLEGAL QUERY");
        throw new Exception();
             }
	}
	public void TOP3()
	{		
			 D1= new MaxOfMaxheap();
			                // yha par phle save karke bottom heap me bhejna
			for(int i=1;i<counter_event;i++)
			{
				int temp=0;
				temp=A1[i].C1.maxValue();

				if(temp!=0)
				{	
					// System.out.println(A1[i].eventName);
				D1.insert(temp,A1[i].C1,A1[i].eventID,A1[i].eventName);
				}
			}
					D1.printTop3InAll(); 

	}
	





	public int returnIndexOfEvent(String B )
	{
		boolean tempo=true;
		int i=1;
			while(i<counter_event && tempo)
			{
				if(B.equals(A1[i].eventID))
				
					tempo=false; 
					i++;
																			
			}
			if(tempo)
			{
				i=0;
			}
			return(i-1);
	}
	public int returnIndexOfParticipant(String A)
	{
		int j=1;
			boolean tempo=true;
			while(j<counter_participant && tempo)
			{
				if(A.equals(B1[j].participantID))
					tempo=false;
				j++;
			}
			if(tempo)
			{
				j=0;
			}
			return(j-1);
	}
}





