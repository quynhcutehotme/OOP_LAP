package OOP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.lang.Comparable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Project {
    public String projectID;
    public Date startDate;
    public Date endDate;
    public ArrayList<Employee> listOfEmployee;

    public Project(String projectID, Date startDate,Date endDate){
        this.projectID = projectID;
        this.startDate= startDate;
        this.endDate = endDate;
        this.listOfEmployee = new ArrayList<>();
    }

    public int estimateBudget(){
        long timeSecond = this.endDate.getTime() - this.startDate.getTime();
        long timeDay = TimeUnit.MILLISECONDS.toDays(timeSecond)+1;
        int total = 0;

        for (Employee e : listOfEmployee) {
            total += e.getSalaryPerHour() * 8 * timeDay;
        }
        return total;
    }

    @Override
    public String toString() {
        List<Employee> sortedList = new ArrayList<>(listOfEmployee);
        Collections.sort(sortedList);
        StringBuilder sb = new StringBuilder("List of employees in project (sorted by rank):\n");
        for (Employee e : sortedList) {
            sb.append(e.toString()).append("\n");}
        return sb.toString();
}}

class Employee implements Comparable<Employee> {
    private String employeeId;
    private String employeeName;
    private Integer salaryPerHour;
    private Integer noOfLeavingDay;
    private Integer noOfTravelDay;


    public Employee(String employeeId, String employeeName, Integer salaryPerHour, Integer noOfLeavingDay, Integer noOfTravelDay) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salaryPerHour = salaryPerHour;
        this.noOfLeavingDay = noOfLeavingDay;
        this.noOfTravelDay = noOfTravelDay;
    }

    public int getSalaryPerHour(){
        return this.salaryPerHour;
    }


    public Integer calculateWeeklySalary() {
        return salaryPerHour * 8 * (5 - noOfLeavingDay + noOfTravelDay / 2);
    }

    @Override
    public int compareTo(Employee obj) {
        int travelDayCompare = Integer.compare(obj.noOfTravelDay, this.noOfTravelDay);
        if (travelDayCompare != 0) {
            return travelDayCompare;
        } else {
            return Integer.compare(this.noOfLeavingDay, obj.noOfLeavingDay);
        }
    }


    @Override
    public String toString() {

        return String.format("[Name:%s - Salary Per Hour:%d - Weekly Salary:%d]",
                this.employeeName,
                this.salaryPerHour,
                this.calculateWeeklySalary());
    }}


class testProject {
    public static void main(String[] args) {
        Employee emp1 = new Employee("E01", "An", 20, 1, 4);
        Employee emp2 = new Employee("E02", "Binh", 25, 2, 4);
        Employee emp3 = new Employee("E03", "Cuong", 15, 0, 6);
        Employee emp4 = new Employee("E04", "Dung", 30, 0, 2);

        Project project;

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            project = new Project("P12", formatter.parse("17/06/2006"),formatter.parse("26/07/2006") );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }



        project.listOfEmployee.add(emp1);
        project.listOfEmployee.add(emp2);
        project.listOfEmployee.add(emp3);
        project.listOfEmployee.add(emp4);

        System.out.println(project.toString());
        System.out.println("The budget of project: "+project.estimateBudget());

    }

}





