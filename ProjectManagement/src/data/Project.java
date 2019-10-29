package data;

import java.util.ArrayList;

public class Project {
	
	enum Members {
		
	}
	
	//projectName,priority,startDate,deliveryDate,Names[Array]
	private String projectName,priority,startDate,deliveryDate;
    private ArrayList<String> Names = new ArrayList<String>();
	
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the deliveryDate
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the names
	 */
	public ArrayList<String> getNames() {
		return Names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(ArrayList<String> names) {
		Names = names;
	}
	
	
}
