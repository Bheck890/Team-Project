package userInput;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Project> Project = new ArrayList<Project>();
	
	//file Output Example
	
	//projectName,priority,startDate,deliveryDate,Members[Array]
	public static void main(String[] args) {
		
		gatherProjectDetails(); //User Inputs data
		Writer(); //Writes to text File
	}
	
	public static void gatherProjectDetails() 
	{	
		
	}
	
	public static void Writer()
	{
		try {
			//projectName,priority,startDate,deliveryDate,Members[Array]
			PrintWriter fw = new PrintWriter(new FileOutputStream("Projects.txt",true));
			
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
			System.out.println("Error 404 File not found"); //LOL
		}
	}
	
	
}
