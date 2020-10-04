package buildInList;

import java.util.Arrays;

public class JahidsArrayList 
{

	private int n=0,total=60;
	private String student[];
	
	public JahidsArrayList ()
	{
		
		
		student = new String[total];
		
		
		
	}
	
	
	
	public int size()
	{
		return n-1;
	}
	
	
	public boolean isEmpty()
	{
		if(n>=1) return true;
		else	return false;
		
		
	}
	public int search(String s) 
	{
		
		for(int i=0;i<n;i++)
		{
			if(s.equals(student[i])) return i;
		}
		return -1;
	}
	
	public  boolean add(String s) 
	{
		
		student[n]=s;
		n++;
		return true;
	}
	
	public void add (int index,String s)
	{
		if(index == n) student[n++]=s;
		
		else if(index < n) {
			
			for(int j=n-1;j>=index;j--) {
				
				student[j+1]=student[j];
			}
			
			student[index]=s;
			n++;
		}
		
		else System.out.println("Invalid rslt!!!");
	}
	
	
	public void clear()
    {
      n=0;   
    } 
	
	public void remove(String s) {
		
		int i=search(s);
		
		if(i==-1) {
			
			System.out.println("Name Not found!!!");
			return;
		}
		
		else {
			
			for(int j=i;j<n-1;j++) {
				
				student[j]=student[j+1];
			}
			
			student[--n]=null;
			
		}
		
	}
	
	
	public int indexOf(String s)
    {
        for(int i=0; i<n; i++)
        {
            if(student[i]==s) return i;
        }
        return -1;
    }
	
	
	public void remove(int index) {
		
		if(index>=n) {
			
			System.out.println("Invalid input!!!");
		}
		
		else if(index<n) {
			for(int j=index;j<n-1;j++) {
				
				student[j]=student[j+1];
			}
			
			student[--n]=null;
			
		}
		
	}
	
	
	
	
	 public boolean contains(String s)
	    {
	        
	        for(int i=0; i<n; i++)
	        {
	            if(student[i]==s) return true;
	        }
	        return false;
	    }
	
	
	

	@Override
	public String toString() {
		return "MyList [student=" + Arrays.toString(student) + "]";
	}
	
	
	
}
