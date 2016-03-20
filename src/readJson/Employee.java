package readJson;

import java.util.ArrayList;

public class Employee {

	private String firstName, lastName;
	private int age;
	private Address address;
	private PhoneNumber numbers;

	public Employee(String firstName, String lastName, int age, Address address, PhoneNumber numbers) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.numbers = numbers;

	}

	public void setFirstname() {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName() {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setAge() {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAddress() {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setNumbers() {
		this.numbers = numbers;
	}

	public PhoneNumber getNumbers() {
		return numbers;
	}

	@Override
	public String toString() {
		return "Employee{\n" + "\tfirstName='" + firstName + '\'' + ", \n\tlastName='" + lastName + '\'' + ", age='" + age
				+ '\'' + ", \naddress=" + address + '}'  ;
	}

	class Address {
		private String streetAddress, city, state;
		private long postalCode;

		public void setStreetAddress() {
			this.streetAddress = streetAddress;
		}

		public String getStreetAddress() {
			return streetAddress;
		}

		public void setCity() {
			this.city = city;
		}

		public String getCity() {
			return city;
		}

		public void setState() {
			this.state = state;
		}

		public String getState() {
			return state;
		}

		public void setPostalCode() {
			this.postalCode = postalCode;
		}

		public long getPostalCode() {
			return postalCode;
		}

		@Override
		public String toString() {
			return " \nAddress{\n" + "streetAddress='" + streetAddress + '\'' + ", city='" + city + '\'' + ", state='"
					+ state + '\'' + ", postalCode='" + postalCode + '\'' +'}';
		}
	}

	class PhoneNumber {
		private String type, number;

		public void setType() {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public void setNumber() {
			this.number = number;
		}

		public String getNumber() {
			return number;
		}
		
		public String toString(){
			return "\nphoneNumbers\": [ " + "\n\t{" + "\"type\": " + type ;
		}
		
	}

}
