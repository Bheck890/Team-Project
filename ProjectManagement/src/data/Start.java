package data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Project> Project = new ArrayList<Project>();
	
	//file
	
	//projectName,priority,startDate,deliveryDate,Names[Array],
	public static void main(String[] args) {
		
	}
	
	public static void ArrayList()
	{	
		System.out.print("Enter number of variables into array: ");
		int number = scan.nextInt();
		
		scan.nextLine();
		for(int i = 0;i<number;i++)
		{
			System.out.print("data for var " + i);
			Project.add(new Project());
		}
	}
	
	public static void Writer(int var)
	{
		
		ArrayList();
		
		try {
			
			PrintWriter fw = new PrintWriter(new FileOutputStream("bin/out.txt"));
			
			fw.println("");
			
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Array Written to .dat file");
	}
}
