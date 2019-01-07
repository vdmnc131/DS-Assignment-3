
import java.io.*;
import java.lang.Integer;
class Entry2
{
    public int key;//This denotes the key of the entry stored at the node
    public Maxheap value;
    public String value2;
    public String value3;
    //This denotes the value of the entry stored at the node
    // public int max=0;
    
    public Entry2(int k, Maxheap v,String s,String w){
        key = k;
        value = v;
        value2=s;
        value3=w;
    }
}
public class MaxOfMaxheap
{
   final int MAX_OF_MAX_HEAP_SIZE = 1000;//This indicates the maximum size the heap can grow into.
    public Entry2[] A;//This is the array of references to entries
    public int size;//This is the number of current entries in the heap
    public MaxOfMaxheap()
    {
        size = 0;
        A = new Entry2[MAX_OF_MAX_HEAP_SIZE+1];
  }
 
  public void swapVals(int p, int q )
  {
  Maxheap temp1;
  String temp3;
   temp1 = A[p].value;
   temp3=A[p].value2;
        int temp2 = A[p].key;
        A[p].key = A[q].key;
        A[p].value2= A[q].value2;
        A[q].value2=temp3;
        A[p].value = A[q].value;
        A[q].key = temp2;
        A[q].value = temp1;
    String temp4=A[p].value3;
    A[p].value3= A[q].value3;
    A[q].value3=temp4;
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
    public

   
    
    
    public void insert(int k,Maxheap v ,String s, String w)
    {
        Entry2 E = new Entry2(k,v,s,w);
        A[++size] = E;
        upHeapBubble(size);
    }
    
      public int  returnIndex(String v)
    {
        int i=1;
        boolean loop= true;
        while(i<=size && loop)
        {
            if(A[i].value2.equals(v))
            {
                loop=false;
                // System.out.println(i);
            }
            i++;

        }if(loop) // loop=true
        i=0;
        return(i-1);
      
    }
    
  
    
    public void printTop3InAll()
    { 
    if(size!=0)
      { 
      if(A[1].key!=0){
      System.out.println(A[1].value.getParticipant(1).participantID+ " , " + A[1].value.getParticipant(1).participantName + " , " + A[1].value.getParticipant(1).universityName+","+A[1].value2+" , "+ A[1].value3+" , " + A[1].key);
      
          }
      else return;
      if(size==1)
        {
        int max2=A[1].value.returnSecondMax();
         // System.out.println(max2);
        if(max2!=0)
        {
         if(A[1].value.getValue(max2)!=0)
        
      System.out.println(A[1].value.getParticipant(max2).participantID+ " , " + A[1].value.getParticipant(max2).participantName + " , " + A[1].value.getParticipant(max2).universityName+","+A[1].value2+" , "+ A[1].value3+" , " + A[1].value.getValue(max2));
      else return;
        }
      else return;
        int max3=A[1].value.returnThirdMax();
        if(max3!=0)
        {
         if(A[1].value.getValue(max3)!=0)
        
      System.out.println(A[1].value.getParticipant(max3).participantID+ " , " + A[1].value.getParticipant(max3).participantName + " , " + A[1].value.getParticipant(max3).universityName+","+A[1].value2+" , "+ A[1].value3+" , " +A[1].value.getValue(max3) );
        else return;
        }
      else return;


        }
        
         if(size>=2)
         {      
         
                int I,J,K,L,M,u,x,y;
                M=0;u=0;x=0;y=0;L=0;I=0;K=0;J=0;
                Participant IP= new Participant();
                Participant MP= new Participant();
                Participant LP= new Participant();
                 Participant JP= new Participant();
                  Participant KP= new Participant();
                  
               
                 int max=2;
                int max2=2; 
                 int j=0;
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
                      
                    }
                for(int i=2;i<j;i++)
                {   
                    if(i+1!=max)
                    {
                    if(A[max2].key<A[i+1].key)
                    max2=i+1;
                    }
                }
                  
                     J= A[max].value.getValue(1);
                   JP=A[max].value.getParticipant(1);
                   if(max2<size)
                   {
                   K=A[max2].value.getValue(1);
                   KP=A[max2].value.getParticipant(1);
                 }
                
              if(A[1].value.getSize()==2)
              { I =A[1].value.getValue(2);
                 IP =A[1].value.getParticipant(2);
                    
                  if(I>=J)
                    { if(I>0)
                        System.out.println(IP.participantID+" , "+IP.participantName+" , "+IP.universityName+" , "+A[1].value2+" , "+A[1].value3+" , "+I);
                        if(J>0)
                    System.out.println(JP.participantID+" , "+JP.participantName+" , "+JP.universityName+" , "+A[max].value2+" , "+A[max].value3+" , "+J);

                    }
                  else
                    { if(J>0)
                       System.out.println(JP.participantID+" , "+JP.participantName+" , "+JP.universityName+" , "+A[max].value2+" , "+A[max].value3+" , "+J);
                      if(A[max].value.getSize()==1)
                      {
                        if(K>=I)
                        { if(K>0)
                          System.out.println(KP.participantID+" , "+KP.participantName+" , "+KP.universityName+" , "+A[max2].value2+" , "+A[max2].value3+" , "+K);
                        }
                         else
                         { if(I>0)
                          System.out.println(IP.participantID+" , "+IP.participantName+" , "+IP.universityName+" , "+A[1].value2+" , "+A[1].value3+" , "+I);
                        }
                      }
                      if(A[max].value.getSize()>=2)
                      {    
                      
                          u=A[max].value.returnSecondMax();
                            if(u>0){
                           L= A[max].value.getValue(u);
                           LP=A[max].value.getParticipant(u);
                         }
                          if(I>=L)
                          {
                            if(I>=K)
                             {  if(I>0)
                             System.out.println(IP.participantID+" , "+IP.participantName+" , "+IP.universityName+" , "+A[1].value2+" , "+A[1].value3+" , "+I);
                           }
                            else
                            { if(K>0)
                              System.out.println(KP.participantID+" , "+KP.participantName+" , "+KP.universityName+" , "+A[max2].value2+" , "+A[max2].value3+" , "+K);
                            }
                          }
                          else
                          {
                            if(L>=K)
                             {  if(L>0)
                              System.out.println(LP.participantID+" , "+LP.participantName+" , "+LP.universityName+" , "+A[max].value2+" , "+A[max].value3+" , "+L);
                            }
                            else
                              { if(K>0)
                             System.out.println(KP.participantID+" , "+KP.participantName+" , "+KP.universityName+" , "+A[max2].value2+" , "+A[max2].value3+" , "+K);
                            }
                          }

                      }


                    }
              }
                  if(A[1].value.getSize()==1)
              {      if(J>0)  
                    System.out.println(JP.participantID+" , "+JP.participantName+" , "+JP.universityName+" , "+A[max].value2+" , "+A[max].value3+" , "+J);
                    if(A[max].value.getSize()>=2)
                      {   
                         u=A[max].value.returnSecondMax();
                         if(u>0){
                           L= A[max].value.getValue(u);
                           LP=A[max].value.getParticipant(u);
                         }
                           if(L>=K) 
                            { if(L>0)
                              System.out.println(LP.participantID+" , "+LP.participantName+" , "+LP.universityName+" , "+A[max].value2+" , "+A[max].value3+" , "+L);
                            }
                           else
                           {if(K>0) 
                            System.out.println(KP.participantID+" , "+KP.participantName+" , "+KP.universityName+" , "+A[max2].value2+" , "+A[max2].value3+" , "+K);
                          }

                      }
                      else { if(K>0)
                        System.out.println(KP.participantID+" , "+KP.participantName+" , "+KP.universityName+" , "+A[max2].value2+" , "+A[max2].value3+" , "+K);
                          }

              }
                  if(A[1].value.getSize()>2)
              {         
                      x=A[1].value.returnSecondMax();
                      if(x>0)
                      {
                           I= A[1].value.getValue(x);
                           IP=A[1].value.getParticipant(x);
                      }
                       y=A[1].value.returnThirdMax();
                       if(y>0)
                       {
                           M= A[1].value.getValue(y);
                           MP=A[1].value.getParticipant(y);
                         }
                        if(A[max].value.getSize()>=2)
                        {
                           u=A[max].value.returnSecondMax();
                         if(u>0){
                           L= A[max].value.getValue(u);
                           LP=A[max].value.getParticipant(u);
                         }

                           if(I>=J)
                           { if(I>0)
                            System.out.println(IP.participantID+" , "+IP.participantName+" , "+IP.universityName+" , "+A[1].value2+" , "+A[1].value3+" , "+I);
                            if(M>=J)
                            {
                               if(M>0)
                              System.out.println(MP.participantID+" , "+MP.participantName+" , "+MP.universityName+" , "+A[1].value2+" , "+A[1].value3+" , "+M);
                            }
                            else{
                                 if(J>0)
                                System.out.println(JP.participantID+" , "+JP.participantName+" , "+JP.universityName+" , "+A[max].value2+" , "+A[max].value3+" , "+J);
                              }
                           }
                           else
                           {
                             if(J>0)
                            System.out.println(JP.participantID+" , "+JP.participantName+" , "+JP.universityName+" , "+A[max].value2+" , "+A[max].value3+" , "+J);
                             if(I>=L)
                                {
                                  if(I>=K)
                                  {
                                   if(I>0)
                                  System.out.println(IP.participantID+" , "+IP.participantName+" , "+IP.universityName+" , "+A[1].value2+" , "+A[1].value3+" , "+I);
                                  }
                                  else
                                  { if(K>0)
                                  System.out.println(KP.participantID+" , "+KP.participantName+" , "+KP.universityName+" , "+A[max2].value2+" , "+A[max2].value3+" , "+K);
                                  }
                                }
                            else
                              {
                                if(L>=K)
                                {
                               if(L>0)
                              System.out.println(LP.participantID+" , "+LP.participantName+" , "+LP.universityName+" , "+A[max].value2+" , "+A[max].value3+" , "+L);
                            }
                                  else
                                  {
                                   if(K>0)
                                  System.out.println(KP.participantID+" , "+KP.participantName+" , "+KP.universityName+" , "+A[max2].value2+" , "+A[max2].value3+" , "+K);
                                  }
                              }

                           }
                        }
                        if(A[max].value.getSize()==1)
                        {
                          if(I>=J)
                          {
                              if(I>0)
                             System.out.println(IP.participantID+" , "+IP.participantName+" , "+IP.universityName+" , "+A[1].value2+" , "+A[1].value3+" , "+I);
                             if(J>=M)
                             {
                               if(J>0)
                              System.out.println(JP.participantID+" , "+JP.participantName+" , "+JP.universityName+" , "+A[max].value2+" , "+A[max].value3+" , "+J);
                            }
                             else  
                              {
                                 if(M>0)
                                System.out.println(MP.participantID+" , "+MP.participantName+" , "+MP.universityName+" , "+A[1].value2+" , "+A[1].value3+" , "+M);
                              }
                          }
                          else
                          { if(J>0)
                         System.out.println(JP.participantID+" , "+JP.participantName+" , "+JP.universityName+" , "+A[max].value2+" , "+A[max].value3+" , "+J);
                            if(K>I)
                            { if(K>0)
                            System.out.println(KP.participantID+" , "+KP.participantName+" , "+KP.universityName+" , "+A[max2].value2+" , "+A[max2].value3+" , "+K);
                          }
                          else  
                            {
                               if(I>0)
                              System.out.println(IP.participantID+" , "+IP.participantName+" , "+IP.universityName+" , "+A[1].value2+" , "+A[1].value3+" , "+I);
                            }
                            
                          }






                        }
                              
              }

                


                


         

        }

      }
    }
}

   
    








