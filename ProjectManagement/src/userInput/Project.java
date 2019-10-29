package userInput;



public class Project {
	
	//Optional if you want to create it.
	enum Members {
		
	}
	
	//Elements Needed. 
	//projectName,priority,startDate,deliveryDate,Names[Array]
	private String projectName,startDate,deliveryDate;
	private int priority; 
    private String[] Names;
	
    public Project(String projectName, String priority, String startDate, String deliveryDate, String[] Names) {
    	setProjectName(projectName);
    	setPriority(priority);
    	setStartDate(startDate);
    	setDeliveryDate(deliveryDate);
    	setNames(Names);
    }
    
    //Methods
    public String toString()
	{
		System.out.println("\n\nProjectName: " + getProjectName());
		System.out.println("Start Date: " + getStartDate());
		System.out.println("DeliveryDate: " + getDeliveryDate());
		System.out.println("Priority: " + getPriority());
		System.out.println("Members: ");
		for(int i = 0 ; i < getNames().length ; i++)
			System.out.println(" - " + Names[i]);
		return " ";
	}
    
    //Return
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
	public String[] getNames() {
		return Names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(String[] names) {
		Names = names;
	}


	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}


	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		if(priority.equalsIgnoreCase("Low"))
			this.priority = 1;
		else if (priority.equalsIgnoreCase("Medium"))
			this.priority = 2;
		else if(priority.equalsIgnoreCase("High"))
			this.priority = 3;
		else
			this.priority = 0;
	}
	
	
	
	
}
