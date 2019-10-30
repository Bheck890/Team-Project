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
	
	//2hr to code 1 year to debug
	
	public static void main(String[] args) {
		ReadProjectInfo(); //Read the Projects Text file and Input the data into an Array Object. 
		AnalyzeMembers(); //Reads the Project File and keeps track of the Members and what Projects they are parts of. 
		WriteMemberStatistics(); //Writes the Members to Member text File
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
				
				
				//Debug(text File)
				/*
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
			//Gather Needed Project Data to Evaluate
			String[] Names = Projects.get(i).getNames();
			String ProjectName = Projects.get(i).getProjectName();
			
			//STEP 2 
			// Analyze the List of names in the Projects
			for(int j = 0; j < Names.length ; j++)
			{
				//STEP 3  Compare each Name to the MemberArray NAMES if they exist or not
				int matchNum = 0;
				boolean matching = false;
				for(int k = 0; k < Members.size();k++)
					if(Members.get(k).getName().equals(Names[j]))
					{
						matching = true;
						matchNum = k;
					}
				
				if(matching)
					Members.get(matchNum).addProject(ProjectName);
				else
					Members.add(new Member(Names[j], ProjectName));
			}
		}
		//DEBUG (Members Data)
		/*
		for(int k = 0; k < Members.size();k++)
		{
			System.out.println(Members.get(k));
		}
		*/
	}
	
	public static void WriteMemberStatistics()
	{
		try {
			PrintWriter fw = new PrintWriter(new FileOutputStream("Members.txt"));
			for(int i = 0; i < Members.size(); i++)
			{	
				fw.print(Members.get(i).getName() + ";");
				fw.print(Members.get(i).getProjectList().get(0));
				for(int j = 1; j < Members.get(i).getProjectList().size(); j++)
					{
						fw.print("," + Members.get(i).getProjectList().get(j));
					}
				fw.println();
			}
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error 404: No permissions to write file");
		}
	}
	
}
