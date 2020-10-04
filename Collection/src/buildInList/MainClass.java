package buildInList;

public class MainClass 
{

	public static void main(String[] args) 
	
	{
		
		
		JahidsArrayList ArrayListOfJahid = new JahidsArrayList();

		ArrayListOfJahid.add("Dip");
		ArrayListOfJahid.add("redowan");
		ArrayListOfJahid.add("Yasin");
		ArrayListOfJahid.add("Sakib");
		ArrayListOfJahid.add("jahid");
		
		System.out.println("Size if the array: " + ArrayListOfJahid.size());
		
		ArrayListOfJahid.add("4,Shamma");
		
		System.out.println("Size if the array: " + ArrayListOfJahid.size());
		
		
		if(ArrayListOfJahid.isEmpty())
			System.out.println("Array is empty");
		
		if(ArrayListOfJahid.contains("Jahid"))
			System.out.println("Contains");
		
		System.out.println("Index of Jhaid is: " +ArrayListOfJahid.indexOf("Jahid"));
		
		
		//System.out.println("Index 4 has : " +ArrayListOfJahid.get(4));
		
		//ArrayListOfJahid.set(0, "Jahid");
		
		ArrayListOfJahid.remove(0);
		
		ArrayListOfJahid.remove("redowan");
		
		ArrayListOfJahid.clear();
		

	}

}
