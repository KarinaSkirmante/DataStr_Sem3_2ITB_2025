package model;

public class Patient implements Comparable<Patient>{
	
	private String name;
	private String surname;
	private int priority;
	
	//TODO uztaisīt set funkcijās pārbaudes
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public Patient() {
		setName("Test");
		setSurname("Pacients");
		setPriority(3);
	}
	
	public Patient(String inputName, String inputSurname, int inputPriority)
	{
		setName(inputName);
		setSurname(inputSurname);
		setPriority(inputPriority);
	}
	
	public String toString() {
		return name + " " + surname + " (" + priority+ ")";
		
	}
	@Override
	public int compareTo(Patient arg0) {
		if(priority > arg0.priority)
		{
			return 1;
		}
		else if (priority < arg0.priority)
		{
			return -1;
		}
		else //abi ir vienādi
		{
			return 0;
		}
	}

}
