package com.app.model;

public class UserDetails {
	
	private String name;
    private String dept;
    private Long salary;
    
    public UserDetails() {
		super();
	}

	public UserDetails(String name, String dept, Long salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

	@Override
	public String toString() {
		return "UserDetails [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
    

}
