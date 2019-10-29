package userInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Project> Projects = new ArrayList<Project>();
	static ArrayList<Member> Members = new ArrayList<Member>();
	static String[] DataInput;
	
	//file Output Example
	
	//projectName,priority,startDate,deliveryDate,Members[Array]
	public static void main(String[] args) {
		
		ReadProjectInfo(); //Read the Projects Text file and Input the data into an Array Object. 
		//Project Output;
		//AnalyzeMembers(); //sets the last array of the input into array of members; 
		//WriteMemberStatistics(); //Writes to Member text File
	}
	
	public static void ReadProjectInfo()
	{
		//projectName,priority,startDate,deliveryDate,Members[Array]
		
		try {
			Scanner input = new Scanner(new File("Projects.txt"));
			while(input.hasNextLine())
			{
				//Template Project Values
				String //I have to initialize each one for the ArrayList
				name = " ",
				priority = " ",
				startDate = " ",
				deliveryDate = " ";
				
				
				//semicolon Separated Values CSV File
				DataInput = input.nextLine().split(";");
				for(int i = 0; i <DataInput.length; i++)
				{
					//System.out.print(i + ": " + DataInput[i] + " "); //Debug
					if(i == 0)
						name = DataInput[i];
					else if(i == 1)
						priority = DataInput[i];
					else if(i == 2)
						startDate = DataInput[i];
					else if(i == 3)
						deliveryDate = DataInput[i];
					//else if(i == 4)
						//Turn Names into an Array Object to analyze later
						 
					
				}
				//System.out.println(); //Debug
				
				Projects.add(new Project(name,priority,startDate,deliveryDate));
				//System.out.println(Projects.get(Projects.size()-1));  //Debug
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error 404: No permissions to read file");
		}
	}
	
	public static void AnalyzeMembers(String Names)
	{
		
	}
	
	public static void WriteMemberStatistics()
	{
		try {
			
			PrintWriter fw = new PrintWriter(new FileOutputStream("Members.txt",true));
			
			fw.println("ProjectName" + "," + "Priority" + "," + "StartDate" + ", ....."); //Project Elements each Separated by a , 
			
			int Members = 3; //Probably going to need an array of members but also a system for each of the members.
			for(int i = 0; i < Members; i++)
			{
				fw.println("," + "Member1");
			}
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error 404: No permissions to write file");
		}
	}
	
	
}
