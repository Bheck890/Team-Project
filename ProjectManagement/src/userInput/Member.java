package userInput;

import java.util.ArrayList;

public class Member {

	//Variables
	private String Name;
	private ArrayList<String> Projects = new ArrayList<String>();
	
	
	
	
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
		return Projects;
	}
	/**
	 * @param projects the projects to set
	 */
	public void setProjects(ArrayList<String> projects) {
		Projects = projects;
	}
	
}
