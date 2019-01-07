import java.io.*;
import java.lang.Integer;
class Entry
{
    public int key;//This denotes the key of the entry stored at the node
    public Participant value;//This denotes the value of the entry stored at the node
    // public int max=0;
    
    public Entry(int k, Participant v){
        key = k;
        value = v;
    }
}
public class Maxheap
{
	 final int MAX_HEAP_SIZE = 600000;//This indicates the maximum size the heap can grow into.
    public Entry[] A;//This is the array of references to entries
    public int size;//This is the number of current entries in the heap
    public Maxheap()
    {
        size = 0;
        A = new Entry[MAX_HEAP_SIZE+1];
	}
	  public void swapVals(int p, int q)
	{
        Participant temp1 = A[p].value;
        int temp2 = A[p].key;
        A[p].key = A[q].key;
        A[p].value = A[q].value;
        A[q].key = temp2;
        A[q].value = temp1;
	 }
     public int maxValue()
     {
         if(size==0)
            {
               
                return(0);
            }
        return(A[1].key);
    	
    }

    public void upHeapBubble(int i)
    {
    	if(i>=2)
        {
    	if(A[(i/2)].key>=A[i].key )return;
        else{
            swapVals(i,(i/2));
            upHeapBubble(i/2);
        	}
        }
	}
	 
    public void downHeapBubble(int i)
    {   
        
            int max; 
            // System.out.println(size);
            //   System.out.println(i);

    	   if(2*i>size)
    		return;
    else{
            if((2*i+1)>size)
            {
                if(A[i].key<A[2*i].key)
                {
                    swapVals(i,2*i);
                    return;
                }
            }
            else
            {
            if(A[i].key>=A[i*2+1].key && A[i].key>=A[2*i].key)
                return;
    	
    	   if(A[2*i].key>=A[2*i+1].key)
    	       {
    		      max=2*i;
    	       }
    	   else{
    		       max=2*i+1;
    	       }    

    	if(A[i].key<A[max].key)
    	   {
    		 swapVals(i,max);
    		 downHeapBubble(max);
    	   }
    	   else
    	       {
    		return;
    	       }
            }
     }
        
    }
    
    public void insert(int k, Participant v)
    {
        Entry E = new Entry(k, v);
        A[++size] = E;
        upHeapBubble(size);
       
    }
    public void deleteNode(Participant v)
    {
        int i;
        i=returnIndex(v);
         // System.out.println(i);
        A[i].key = A[size].key; A[i].value = A[size].value;
        // System.out.println( A[i].key);
        size--;
        // System.out.println(i);
        downHeapBubble(i);
        
        
    }
    public void modifyKeyOfNode(int k ,Participant v)
    {
        int i;
        i=returnIndex(v);
         // System.out.println(k);
        A[i].key=k;

        A[i].value=v;
        if(i==1)
        {
            downHeapBubble(i);
            return;
        }
       else
       {
                if(2*i+1>size && 2*i>size)
                    {
                    upHeapBubble(i);
                    return;
                    }
                else
                {
                    if(2*i+1>size && 2*i==size)
                    {
                        if(A[i].key<A[2*i].key)
                            {
                            downHeapBubble(i);
                            return;
                            }
                        if(A[i/2].key<A[i].key)
                            {
                            upHeapBubble(i);
                            return;
                            }
                    }
                    else
                    {
            
                if(A[i/2].key>=A[i].key && A[i].key>=A[2*i].key && A[i].key>=A[2*i+1].key)
                    return;
                else
                {
                    if(A[i].key>A[i/2].key)
                        upHeapBubble(i);
                    if(A[i].key<A[2*i+1].key || A[i].key<A[2*i].key)
                        downHeapBubble(i);
                }
                }
            }
        }

            
        
        
    }
    public void printTop3()
    {   
        int max=2;
        int max2=2; 
        int j=0;
        // System.out.println(size);
        if(size!=0)
        {
            if(A[1].key!=0)
        System.out.println(A[1].value.participantID + " , " + A[1].value.participantName+ " , " + A[1].value.universityName +" , " + A[1].key);

        else
        {
            // System.out.println("All are Zero");
            return;
        }
        if(size==2)
            if(A[2].key!=0)
         System.out.println(A[2].value.participantID + " , " + A[2].value.participantName+ " , " + A[2].value.universityName +" , " + A[2].key);
        if(size>2)
            {
                j=size;
                if(size>7) 
                {
                    j=7;

                }
                for(int i=2;i<j;i++)
                {
                    if(A[max].key<A[i+1].key)
                    max=i+1;
                }
                if(A[max].key!=0)
                System.out.println(A[max].value.participantID + " , " + A[max].value.participantName+ " , " + A[max].value.universityName +" , " + A[max].key);
                if(max==2)
                    {
                        max2=3;
                        // System.out.println("G");
                    }
                for(int i=2;i<j;i++)
                {   
                    if(i+1!=max)
                    {
                    if(A[max2].key<A[i+1].key)
                    max2=i+1;
                    }
                }
                // System.out.println(max2);
                if(A[max2].key!=0)
                System.out.println(A[max2].value.participantID + " , " + A[max2].value.participantName+ " , " + A[max2].value.universityName +" , " + A[max2].key);

            }
            // for(int i=1;i<=size;i++)
            // {
            //     System.out.println(A[i].key);
            // }
        }
        // else
        // {
        //     System.out.println("No Element");
        // }
        
    }
   
    public int  returnIndex(Participant v)
    {
        int i=1;
        boolean loop= true;
        while(i<=size && loop)
        {
            if(A[i].value.equals(v))
            {
                loop=false;
                // System.out.println(i);
            }
            i++;

        }if(loop) // loop=true
        i=0;
        return(i-1);
    }
    public int returnSecondMax()
    {   int j=0;
        int max=2;
         if(size==2)
         {
            if(A[2].key!=0)
         return(2);
        }
        if(size>2)
            {
                j=size;
                if(size>7) 
                {
                    j=7;

                }
                for(int i=2;i<j;i++)
                {
                    if(A[max].key<A[i+1].key)
                    max=i+1;
                }
                if(A[max].key!=0)
                return(max);
        }
        return(0);
    }
    public int returnThirdMax()
    {   int max=2;
        int max2=2; 
        int j=0;
        if(size>2)
        {
            j=size;
                if(size>7) 
                {
                    j=7;

                }
                for(int i=2;i<j;i++)
                {
                    if(A[max].key<A[i+1].key)
                    max=i+1;
                }
               
                if(max==2)
                    {
                        max2=3;
                        // System.out.println("G");
                    }
                for(int i=2;i<j;i++)
                {   
                    if(i+1!=max)
                    {
                    if(A[max2].key<A[i+1].key)
                    max2=i+1;
                    }
                }
                // System.out.println(max2);
                if(A[max2].key!=0)
                return(max2);
        }
        return(0);
    }





    public Participant getParticipant(int k)
        {
            return(A[k].value);
        }
    public int getValue(int k)
        {
            return(A[k].key);
        }
    public int getSize()
        {
            return(size);
        }




    














    }