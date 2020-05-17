
public class Employee{
	private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String address;
    private String email;
    private String location;
    

    public Employee(String firstName, String middleName, String lastName, int age, String address, String email,
			String location) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.email = email;
		this.location = location;
	}

	public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private int age;
        private String address;
        private String email;
        private String location;
        
        public Builder(){}
        
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
			this.age = age;
			return this;
		}
        
		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setLocation(String location) {
			this.location = location;
			return this;
		}

		public Employee build() {
            return new Employee(firstName, middleName, lastName, age, address, email, location);
        }
		
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", age="
				+ age + ", address=" + address + ", email=" + email + ", location=" + location + "]";
	}
	
}
