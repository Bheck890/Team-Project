package userInput;

import java.util.ArrayList;

public class Member {

	//Variables
	private String Name;
	private ArrayList<String> ProjectList = new ArrayList<String>();
	
	public Member(String Name, String firstProject)
	{
		setName(Name);
		addProject(firstProject);
	}
	
	public void addProject(String name) {
		//ProjectList.add(name); //testing
		ProjectList.add(new String(name)); //Default
	}
	
	public String toString()
	{
		System.out.println("\n\nName: " + getName());
		System.out.println("Projects: ");
		for(int i = 0 ; i < ProjectList.size() ; i++)
			System.out.println(" - " + ProjectList.get(i));
		return " ";
	}
	
	//Return
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the projects
	 */
	public ArrayList<String> getProjects() {
		return ProjectList;
	}
	/**
	 * @param projects the projects to set
	 */
	public void setProjects(ArrayList<String> projects) {
		ProjectList = projects;
	}
	
}
