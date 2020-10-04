package buildInList;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class BuildInListOperations 
{

	public static void main(String[] args) 
	{
		
		ArrayList<String> StudentsOfBSSE10Batch = new ArrayList<String>();
		
		
		
		StudentsOfBSSE10Batch.add("Dip");
		StudentsOfBSSE10Batch.add("redowan");
		StudentsOfBSSE10Batch.add("Yasin");
		StudentsOfBSSE10Batch.add("Sakib");
		StudentsOfBSSE10Batch.add("jahid");
		
		System.out.println("Size if the array: " + StudentsOfBSSE10Batch.size());
		
		StudentsOfBSSE10Batch.add("4,Shamma");
		
		System.out.println("Size if the array: " + StudentsOfBSSE10Batch.size());
		
		
		if(StudentsOfBSSE10Batch.isEmpty())
			System.out.println("Array is empty");
		
		if(StudentsOfBSSE10Batch.contains("Jahid"))
			System.out.println("Contains");
		
		System.out.println("Index of Jhaid is: " +StudentsOfBSSE10Batch.indexOf("Jahid"));
		
		
		System.out.println("Index 4 has : " +StudentsOfBSSE10Batch.get(4));
		
		StudentsOfBSSE10Batch.set(0, "Jahid");
		
		StudentsOfBSSE10Batch.remove(0);
		
		StudentsOfBSSE10Batch.remove("redowan");
		
		StudentsOfBSSE10Batch.clear();
		
		
		

	}

}
