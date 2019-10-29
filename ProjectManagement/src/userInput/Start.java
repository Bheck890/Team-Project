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
		AnalyzeMembers(); //sets the last array of the input into array of members; 
		//WriteMemberStatistics(); //Writes to Member text File
	}
	
	public static void ReadProjectInfo()
	{
		//projectName,priority,startDate,deliveryDate,Members[Array]
		
		try {
			Scanner input = new Scanner(new File("Projects.txt"));
			while(input.hasNextLine())
			{
				//Template Project Values //I have to initialize each one for the ArrayList
				String name = " ", priority = " ", startDate = " ", deliveryDate = " ";
				String[] MemberNames = null;
				//semicolon Separated Values CSV File
				DataInput = input.nextLine().split(";");
				for(int i = 0; i <DataInput.length; i++)
				{
					if(i == 0)
						name = DataInput[i];
					else if(i == 1)
						priority = DataInput[i];
					else if(i == 2)
						startDate = DataInput[i];
					else if(i == 3)
						deliveryDate = DataInput[i];
					else if(i == 4)
						MemberNames = DataInput[i].split(",");
				}
				Projects.add(new Project(name,priority,startDate,deliveryDate,MemberNames));
				
				/*
				//Debug(text File)
				for(int i = 0; i <DataInput.length; i++)
				{
					System.out.print(i + ": " + DataInput[i] + " "); //Debug
				}
				System.out.println(); //Debug
				*/
				//System.out.println(Projects.get(Projects.size()-1));  //Debug(Projects Array) As it is Created
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error 404: No permissions to read file");
		}
	}
	
	public static void AnalyzeMembers()
	{
		//STEP 1
		//Go through each Project
		for(int i = 0; i < Projects.size() ; i++) // Check Each Project for members;
		{
			//Return Needed Project Data to Evaluate
			String[] Names = Projects.get(i).getNames();
			String ProjectName = Projects.get(i).getProjectName();
			
			
			//STEP 2 //ArrayList then Array
			
			
			// Analyze the List of members in the Projects
			for(int j = 0; j < Names.length ; j++)
			{
				if(Members.size() == 0)// Create a First Member so Members can be compared
				{
					Members.add(new Member(Names[0], ProjectName));
					System.out.println("1: " + Members.get(Members.size()-1));  //Debug(Members Array) As it is Created
				}
				System.out.println("j: " + j); //!!!!!!!!!!!!!!
				if(Members.size() >= 1)
				{
					//STEP 3
					//Check if name Is already in the Member array
					for(int k = 0; k < Members.size() ; k++)
					{
						System.out.println("k: " + k); //!!!!!!!!!!!!!!
						if((Members.get(k).getName().equals(Names[j]))) //If name all Ready matches a name that members Already have
						{
							Members.get(k).addProject(ProjectName);
							System.out.println("Project Added!: " + Members.get(Members.size()-1));  //Debug(Members Array) As it is Created
							k = Members.size();
						}	
						else 
						{
							Members.add(new Member(Names[j],ProjectName));  //else Create a new member and add it to the array
							System.out.println(Members.get(Members.size()-1));  //Debug(Members Array) As it is Created
							k = Members.size();
						}
					}
				}
			}
			
		}
		System.out.println(Members.size());
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
	
	//OLD DATA
	
	
	
	////////////////////////////
	/* V2
			//STEP 2 //ArrayList then Array
			if(Members.size() == 0)// Create a First Member so Members can be compared
			{
				Members.add(new Member(Names[0], ProjectName));
				System.out.println("1: " + Members.get(Members.size()-1));  //Debug(Members Array) As it is Created
			}
			
			// Analyze the List of members in the Projects
			for(int j = 0; j < Members.size() ; j++)
			{
				System.out.println(j); //!!!!!!!!!!!!!!
				if(Members.size() >= 1)
				{
					//STEP 3
					//Check if name Is already in the Member array
					for(int k = 0; k < Names.length ; k++)
					{
						System.out.println(k); //!!!!!!!!!!!!!!
						if((Members.get(j).getName().equals(Names[k]))) //If name all Ready matches a name that members Already have
						{
							Members.get(j).addProject(ProjectName);
							System.out.println("Project Added!: " + Members.get(Members.size()-1));  //Debug(Members Array) As it is Created
						}	
						else 
						{
							Members.add(new Member(Names[k],ProjectName));  //else Create a new member and add it to the array
							System.out.println(Members.get(Members.size()-1));  //Debug(Members Array) As it is Created
							j = Members.size();
						}
					}
				}
			}
	
	*/
	//////////////////////////////////////////////
	/* V1
	//STEP 2 //Array then ArrayList
	// Analyze the List of names in the Projects
	for(int j = 0; j < Names.length ; j++)
	{
		
		// Create a First Member so Members can be compared
		if(Members.size() == 0)
		{
			Members.add(new Member(Names[j], ProjectName));
			System.out.println("1: " + Members.get(Members.size()-1));  //Debug(Members Array) As it is Created
		}
		else if(Members.size() > 0)
		{
		
			//STEP 3
			//Check if name Is already in the Member array
			for(int k = 0; k < Members.size() ; k++)
			{
				if((Members.get(k).getName().equals(Names[j]))) //If name all Ready matches a name that members Already have
				{
					Members.get(k).addProject(ProjectName);
					System.out.println("Project Added!: " + Members.get(Members.size()-1));  //Debug(Members Array) As it is Created
				}	
				else 
				{
					Members.add(new Member(Names[j],ProjectName));  //else Create a new member and add it to the array
					System.out.println(Members.get(Members.size()-1));  //Debug(Members Array) As it is Created
					k = Members.size();
				}
			}
		}
			
		//}
		//catch(IndexOutOfBoundsException e)
		//{
			//Members.add(new Member(Names[j], ProjectName));
			//System.out.println("1: " + Members.get(Members.size()-1));  //Debug(Members Array) As it is Created
		//}
	}
	*/
	//////////////////////////////////////////
}
