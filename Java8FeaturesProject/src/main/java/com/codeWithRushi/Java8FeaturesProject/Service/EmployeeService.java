package com.codeWithRushi.Java8FeaturesProject.Service;

import com.codeWithRushi.Java8FeaturesProject.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = List.of(

            new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020),
            new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015),
            new Employee(3, "efg", 32, 115, "M", "HR", "Chennai", 2014),
            new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2010),
            new Employee(5, "ijk", 22, 160, "F", "IT", "Noida", 2013),
            new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017),
            new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016),
            new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015),
            new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010)
    );

//    Group the Employees by city.
    public Map<String, List<Employee>> getGroupEmployeeByCity(){
        Map<String, List<Employee>> GroupEmployeeByCity = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity));
        return GroupEmployeeByCity;
    }


//    Group the Employees by age.
    public Map<Integer, List<Employee>> getGroupEmployeeByAge(){
        Map<Integer, List<Employee>> GroupEmployeeByAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge))   ;
        return GroupEmployeeByAge;
    }


//    Find the count of male and female employees present in the organization
    public Map<String, Long> getNoOfMaleAndFemaleEmployees(){
        Map<String, Long> NoOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        return NoOfMaleAndFemaleEmployees;
    }


//    Print the names of all departments in the organization.
    public List<String> allDepartmentName(){
        List<String> allDepartmentName = employeeList.stream().map(employee -> employee.getDeptName()).distinct().collect(Collectors.toList());
        return allDepartmentName;
    }


//    Print employee details whose age is greater than 28.
    public List<Employee> getAllEmployeeGreaterThan28(){
        List<Employee> allEmployeeGreaterThan28 = employeeList.stream().filter(employee -> employee.getAge() > 28).collect(Collectors.toList());
        return allEmployeeGreaterThan28;
    }


//    Find maximum age of employee.
    public Optional<Employee> maxAgeEmp(){
        Optional<Employee> maxAgeEmp = employeeList.stream().max(Comparator.comparing(Employee::getAge));
        return maxAgeEmp;
    }


//    Print Average age of Male and Female Employees.
    public Map<String,Double> getAvgOfMale_Female(){
        Map<String, Double> avgOfMale_Female = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        return avgOfMale_Female;
    }

//    Print the number of employees in each department.
    public Map<String, Long> getNoOfEmployeeByDept(){
        Map<String, Long> countByEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        return countByEmp;

        // printing Map
//        for(Map.Entry<String, Long> entry : countByDept.entrySet())
//        {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
    }


//        Find oldest employee.
    public Optional<Employee> getOldestEmployee(){
        Optional<Employee> max = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        return max;
    }


//      Find youngest female employee.
    public Optional<Employee> getYoungestEmployee(){
        Optional<Employee> min = employeeList.stream().filter(emp -> emp.getGender() == "F").min(Comparator.comparingInt(Employee::getAge));
        return min;
    }


//    Find employees whose age is greater than 30 and less than 30.
    public Map<Boolean, List<Employee>> getAgeGreaterThan30_LessThan30(){
      return employeeList.stream().collect(Collectors.partitioningBy(e -> Boolean.parseBoolean(e.getAge() > 30 ? "Employees greater than 30 years" : "Employees less than or equal to 30 years")));

//        Set<Map.Entry<Boolean, List<Employee>>> empSet = partitionEmployeesByAge.entrySet();
//
//        for (Map.Entry<Boolean, List<Employee>> entry : empSet) {
//            if (Boolean.TRUE.equals(entry.getKey())) {
//                System.out.println("Employees greater than 30 years ::" + entry.getValue());
//            } else {
//                System.out.println("Employees less than 30 years ::" + entry.getValue());
//            }
//        }
    }



//    Find the department name which has the highest number of employees.


    public Map.Entry<String, Long> getDeptNameHighestEmployees() {
        Map.Entry<String, Long> maxNoOfEmployeesInDept  = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        return maxNoOfEmployeesInDept;
    }


//    Find if there any employees from HR Department.

    public List<Employee> getEmployeeFromHRDept() {

        List<Employee> employeeFromHRDept = employeeList.stream().filter(employee -> employee.getDeptName().equalsIgnoreCase("HR")).collect(Collectors.toList());
        return employeeFromHRDept;
    }


//    Find the department names that these employees work for, where the number of employees in the department is over 3.

    public List<Map.Entry<String, Long>> getEmployeeListOver3Employee() {
        List<Map.Entry<String, Long>> employeeListOver3Employee = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().filter(emp -> emp.getValue() > 3).collect(Collectors.toList());
//         forEach(System.out::println);
        return employeeListOver3Employee;

    }

//    Find distinct department names that employees work for.

    public List<String> getDeptNameByDistinct() {
        List<String> deptNameByDistinct = employeeList.stream().map(Employee::getDeptName).distinct().collect(Collectors.toList());
        return deptNameByDistinct;
    }

//    Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
    public List<Employee> getCitySpecificEmpSortByName(){
        List<Employee> citySpecificEmpSortByName = employeeList.stream().filter(employee -> employee.getCity().equalsIgnoreCase("Chennai"))
                .sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        return citySpecificEmpSortByName;
    }


//    No of employees in the organisation.

    public long getAllEmployeeList() {
        long totalEmpCount = employeeList.stream().count();
        return totalEmpCount;
    }


//    Find employee count in every department
//    Find the department which has the highest number of employees.
    public Optional<Map.Entry<String, Long>> getEmployeeListByDeptCount() {
        Optional<Map.Entry<String, Long>> employeeListByDeptCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());
        return employeeListByDeptCount;
    }



//    Sorting a Stream by age and name fields.

    public List<Employee> getSortedByAgeAndName() {
        Comparator<Employee> comparator1 = Comparator.comparing(Employee::getAge);
        Comparator<Employee> comparator2 = Comparator.comparing(Employee::getName);
        List<Employee> sortedByAgeAndName = employeeList.stream().sorted(comparator1.thenComparing(comparator2)).collect(Collectors.toList());
        return sortedByAgeAndName;
    }


//    Highest experienced employees in the organization.

    public List<Employee> getHighestExperienceEmployee() {
//        Optional<Employee> highestExperienceEmployee = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
        int maxExperience = employeeList.stream()
                .mapToInt(Employee::getYearOfJoining)
                .min()
                .orElse(0);

        // Finding the employees with the highest years of experience and the same date of joining
        return employeeList.stream()
                .filter(employee -> employee.getYearOfJoining() == maxExperience)
                .collect(Collectors.groupingBy(Employee::getYearOfJoining
                ))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElse(List.of());
    }


//    . Print average salary of the organization

    public OptionalDouble getAverageOfSalary() {
        OptionalDouble average = employeeList.stream().mapToDouble(Employee::getSalary).average();
        return average;
    }

//    total salary of the organization
    public double getTotalSalary() {
        double totalSalary = employeeList.stream().mapToDouble(Employee::getSalary).sum();
        return totalSalary;
    }

//    Print Average salary of each department.

    public Map<String, Double> getAverageSalaryEachDept() {
        Map<String, Double> averageSalaryEachDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));
        return averageSalaryEachDept;
//        Set<Map.Entry<String, Double>> entrySet = avgSalary.entrySet();
//        for(Map.Entry<String, Double> entry : entrySet){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
    }

//    Find Highest salary in the organisation.

    public List<Employee> getHighestSalary() {
        double highestSalary = employeeList.stream().mapToDouble(Employee::getSalary).max().orElse(0);
        return employeeList.stream().filter(employee -> employee.getSalary() == highestSalary).collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry:: getKey))
                .map(Map.Entry:: getValue)
                .orElse(List.of());
    }

    public Optional<Employee> getSecondHighestSalary() {
        Optional<Employee> secondHighestSalary = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).distinct().skip(1).findFirst();
        return secondHighestSalary;
    }
}

