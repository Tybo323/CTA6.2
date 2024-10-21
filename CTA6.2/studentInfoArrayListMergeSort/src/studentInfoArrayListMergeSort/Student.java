package studentInfoArrayListMergeSort;

public class Student {
	int rollnum;
	String name;
	String address;
	
	public Student(int rollnum, String name, String address) {
        this.rollnum = rollnum;
        this.name = name;
        this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [Roll Number= " + rollnum + ", Name= " + name + ", Address= " + address + "]";
	}
}

	