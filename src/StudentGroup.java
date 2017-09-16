import java.util.*;
import java.text.*;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	//ArrayList<Student> studentsList = new ArrayList<Student>();

	public void modifyingStudentsArray(Student[] tempStudents, int length){
		this.students = new Student[length];
		for(int i=0; i<students.length; i++){
			this.students[i] = tempStudents[i];
		}
	}

	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {		
		// Add your implementation here	
		if(students == null)
			throw new IllegalArgumentException();	
		else{			
			for(int i=0; i<students.length; i++){
				this.students[i] = students[i];
			}
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length){
			throw new IllegalArgumentException("");
		}
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student == null || index<0 || index>=students.length){
			throw new IllegalArgumentException("");
		}
		else{
			this.students[index] = student;
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException("");
		}
		else{
			Student tempStudents[] = new Student[students.length+1];
			int j = 1;
			for(int i=0; i<students.length; i++){
				tempStudents[j++] = this.students[i];			
			}
			tempStudents[0] = student;
			modifyingStudentsArray(tempStudents, students.length+1);
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException("");
		}
		else{
			Student tempStudents[] = new Student[students.length+1];
			int j = 0;
			for(int i=0; i<students.length; i++){
				tempStudents[j++] = this.students[i];			
			}
			tempStudents[students.length] = student;
			modifyingStudentsArray(tempStudents, students.length+1);
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student == null || index<0 || index>=students.length){
			throw new IllegalArgumentException("");
		}
		else{
			Student tempStudents[] = new Student[students.length+1];
			int j = 0;
			for(int i=0; i<students.length; i++){
				if(i == index){
					j = j+1;
					tempStudents[j++] = this.students[i];
				}
				else{
					tempStudents[j++] = this.students[i];
				}
			}
			tempStudents[index] = student;
			modifyingStudentsArray(tempStudents, students.length+1);
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length){
			throw new IllegalArgumentException("");
		}
		else{
			Student tempStudents[] = new Student[students.length+1];
			int j = 0;
			for(int i=0; i<students.length; i++){
				if(i != index){
					tempStudents[j++] = this.students[i];
				}
				else{
					continue;
				}
			}
			modifyingStudentsArray(tempStudents, students.length-1);
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException("");
		}
		else{
			int index = 0, i = 0;
			for(i=0; i<students.length; i++){
				if(students[i].getId() == student.getId() && 
				   students[i].getFullName() == student.getFullName() && 
				   students[i].getBirthDate() == student.getBirthDate() &&
				   students[i].getAvgMark() == student.getAvgMark()){
					index = i;
					break;
				}
			}
			if(i == students.length){
				throw new IllegalArgumentException("Student not exist");		
			}
			else{
				remove(index);
			}
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length){
			throw new IllegalArgumentException("");
		}
		else{
			Student tempStudents[] = new Student[students.length+1];
			int j = 0;
			for(int i=0; i<=index; i++){
				tempStudents[j++] = this.students[i];
			}
			modifyingStudentsArray(tempStudents, j);
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException("");
		}
		else{
			int index = 0, i = 0;
			for(i=0; i<students.length; i++){
				if(students[i].getId() == student.getId() && 
				   students[i].getFullName() == student.getFullName() && 
				   students[i].getBirthDate() == student.getBirthDate() &&
				   students[i].getAvgMark() == student.getAvgMark()){
					index = i;
					break;
				}
			}
			removeFromIndex(index);
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length){
			throw new IllegalArgumentException("");
		}
		else{
			Student tempStudents[] = new Student[students.length+1];
			int j = 0;
			for(int i=index; i<students.length; i++){
				tempStudents[j++] = this.students[i];
			}
			modifyingStudentsArray(tempStudents, j);
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException("");
		}
		else{
			int index = 0, i = 0;
			for(i=0; i<students.length; i++){
				if(students[i].getId() == student.getId() && 
				   students[i].getFullName() == student.getFullName() && 
				   students[i].getBirthDate() == student.getBirthDate() &&
				   students[i].getAvgMark() == student.getAvgMark()){
					index = i;
					break;
				}
			}
			removeToIndex(index);
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0; i<students.length-1; i++){
			for(int j=0; j<students.length-1-i; j++){
				if(this.students[j].compareTo(this.students[j+1]) > 0){
					Student temp = this.students[j];
					this.students[j] = this.students[j+1];
					this.students[j+1] = temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null){
			throw new IllegalArgumentException("");
		}
		else{
			Student tempStudents[] = new Student[students.length];
			int j = 0;
			for(int i=0; i<students.length; i++){
				if(this.students[i].getBirthDate().before(date) || 
					this.students[i].getBirthDate().equals(date)){
					tempStudents[j++] = this.students[i];
				}
			}
			if(j != 0)
				return tempStudents;
		}
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate == null || lastDate == null){
			throw new IllegalArgumentException("");
		}
		else{
			Student tempStudents[] = new Student[students.length];
			int j = 0;
			for(int i=0; i<students.length; i++){
				if((this.students[i].getBirthDate().after(firstDate) || this.students[i].getBirthDate().equals(firstDate)) && 
				   (this.students[i].getBirthDate().before(lastDate) || this.students[i].getBirthDate().equals(lastDate))){
					tempStudents[j++] = this.students[i];
				}
			}
			if(j != 0)
				return tempStudents;
		}
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		int age = 0;
		if(indexOfStudent < 0 || indexOfStudent >= students.length){
			throw new IllegalArgumentException("");
		}
		else{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = new Date();
			String currentDate = dateFormat.format(date);
			StringTokenizer stToken = new StringTokenizer(currentDate,"-");
			int currentYear = Integer.parseInt(stToken.nextToken());
			int currentMonth = Integer.parseInt(stToken.nextToken());
			int currentDay = Integer.parseInt(stToken.nextToken());
			
			Date studentBirthDate = this.students[indexOfStudent].getBirthDate();
			String BirthDate = dateFormat.format(studentBirthDate);
			StringTokenizer stToken2 = new StringTokenizer(BirthDate,"-");
			int birthYear = Integer.parseInt(stToken2.nextToken());
			int birthMonth = Integer.parseInt(stToken2.nextToken());
			int birthDay = Integer.parseInt(stToken2.nextToken());

			if(birthYear < currentYear){
				age = currentYear-birthYear;
				if (birthMonth > currentMonth) {
			        age--;
			    } 
			    else if (birthMonth == currentMonth) {
			        if (birthDay > currentDay) {
			            age--;
			        }
			    }
			}
		}
		return age;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		Student tempStudents[] = new Student[students.length];
		int j = 0;
		for(int i=0; i<students.length; i++){
			if(getCurrentAgeByDate(i) == age){
				tempStudents[j++] = this.students[i];
			}
		}
		if(j != 0)
			return tempStudents;
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double maxAvgMark = 0;
		for(int i=0; i<students.length; i++){
			if(maxAvgMark < this.students[i].getAvgMark()){
				maxAvgMark = this.students[i].getAvgMark();
			}
		}
		Student tempStudents[] = new Student[students.length];
		int j = 0;
		for(int i=0; i<students.length; i++){
			if(this.students[i].getAvgMark() == maxAvgMark){
				tempStudents[j++] = this.students[i];
			}
		}
		if(j != 0)
			return tempStudents;
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException("");
		}
		else{
			int index = -1;
			for(int i=0; i<students.length; i++){
				if(this.students[i].getId() == student.getId() && 
				   this.students[i].getFullName() == student.getFullName() && 
				   this.students[i].getBirthDate() == student.getBirthDate() &&
				   this.students[i].getAvgMark() == student.getAvgMark()){
					index = i;
					break;
				}
			}
			if(index>=0 && index<students.length - 1){
				return this.students[index+1];
			}
		}
		return null;
	}
}
