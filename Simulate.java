// import java.util.*;
import java.io.*;
import java.lang.Integer;





public class Simulate{
	
	
	static String file = "query.txt";
	static real B;
	public static void main(String args[]){
				 B = new real();
			
	
		BufferedReader br = null;
		FileReader fr = null;
		
		try{
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
				String curr = new String(sCurrentLine);
				String [] keys = sCurrentLine.replaceAll(",","").split(" ");
				if(keys[0].equals("ADD")){
					if(keys[1].equals("PARTICIPANT")){
						String [] keys2 = sCurrentLine.split(", ");
						 B.ADD_PARTICIPANT(keys[2], keys2[1], keys2[2]);

					}
					else if(keys[1].equals("EVENT")){
						String [] keys2 = sCurrentLine.split(", ");
						B.ADD_EVENT(keys[2], keys2[1], keys2[2]);
					}
					else{
						try{B.ADD(keys[1], keys[2]);}
						catch(Exception e){e.printStackTrace();}
					}
				}
				else if(keys[0].equals("UPDATE")){
					int l=0;
					l=Integer.parseInt(keys[4]);
					try{B.UPDATE_SCORE(keys[2], keys[3],l );}
					catch(Exception e){e.printStackTrace();}
					// System.out.println(Integer.parseInt(keys[4]));
				}
				else if(keys[0].equals("DELETE")){
					if(keys[1].equals("PARTICIPANT")){
						try{B.DELETE_PARTICIPANT(keys[2]);}
						catch(Exception e){e.printStackTrace();}
					}
					else if(keys[2].equals("PARTICIPANT")){
						try{B.DELETE_EVENT_PARTICIPANT(keys[3], keys[4]);}
						catch(Exception e){e.printStackTrace();}
					}
					else{
						try{B.CANCEL_EVENT(keys[2]);}
						catch(Exception e){e.printStackTrace();}
					}
				}
				else if(keys[0].equals("TOP3")){
					if(keys.length == 1){
						B.TOP3();
					}
					else{
						try{B.TOP3_IN_EVENT(keys[3]);}
						catch(Exception e){e.printStackTrace();}
					}
				}
			}
		} catch(IOException e){
			System.out.println("Exception");
		}
	}

	
}