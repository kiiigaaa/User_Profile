package test;

public class customerProfile {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String telNo;
	private String gender;
	private String userName;
	private String paswword;
	
	public customerProfile(int id, String firstName, String lastName, String address, String email, String telNo,
			String gender, String userName, String paswword) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.telNo = telNo;
		this.gender = gender;
		this.userName = userName;
		this.paswword = paswword;
	}

	public int getId() {
		return id;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public String getAddress() {
		return address;
	}

	
	public String getEmail() {
		return email;
	}

	
	public String getTelNo() {
		return telNo;
	}

	public String getGender() {
		return gender;
	}

	public String getUserName() {
		return userName;
	}

	public String getPaswword() {
		return paswword;
	}


}
