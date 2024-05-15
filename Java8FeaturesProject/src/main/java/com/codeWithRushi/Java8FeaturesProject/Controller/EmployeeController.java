package com.codeWithRushi.Java8FeaturesProject.Controller;

import com.codeWithRushi.Java8FeaturesProject.Service.EmployeeService;
import com.codeWithRushi.Java8FeaturesProject.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/GroupEmployeeByCity")
    public Map<String, List<Employee>> getGroupEmployeeByCity(){

        return employeeService.getGroupEmployeeByCity();
    }

    @GetMapping("/GroupEmployeeByAge")
    public Map<Integer, List<Employee>> getGroupEmployeeByAge(){

        return employeeService.getGroupEmployeeByAge();
    }

    @GetMapping("/NoOfMaleAndFemaleEmployees")
    public Map<String, Long> getNoOfMaleAndFemaleEmployees(){
        return employeeService.getNoOfMaleAndFemaleEmployees();
    }


    @GetMapping("/allDepartmentList")
    public List<String> getAllDepartmentName(){
        return employeeService.allDepartmentName();
    }

    @GetMapping("/allEmployeeGreaterThan28")
    public List<Employee> getAllEmployeeGreaterThan28(){
        return employeeService.getAllEmployeeGreaterThan28();
    }

    @GetMapping("/maxAgeEmp")
    public Optional<Employee> getMaxAgeEmp(){
        return employeeService.maxAgeEmp();
    }

    @GetMapping("/avgOfMale_Female")
    public Map<String,Double> getAvgOfMale_Female(){
        return employeeService.getAvgOfMale_Female();
    }

    @GetMapping("/noOfEmployeeByDept")
    public Map<String, Long> getNoOfEmployeeByDept(){
        return employeeService.getNoOfEmployeeByDept();
    }

    @GetMapping("/oldestEmployee")
    public Optional<Employee> getOldestEmployee(){
        return employeeService.getOldestEmployee();
    }

    @GetMapping("/youngestEmployee")
    public Optional<Employee> getYoungestEmployee(){
        return employeeService.getYoungestEmployee();
    }

    @GetMapping("/ageGreaterThan30_LessThan30")
    public Map<Boolean, List<Employee>> getAgeGreaterThan30_LessThan30(){
        return employeeService.getAgeGreaterThan30_LessThan30();
    }

    @GetMapping("/deptNameHighestEmployees")
    public Map.Entry<String, Long> getDeptNameHighestEmployees() {
        return employeeService.getDeptNameHighestEmployees();
    }

    @GetMapping("/employeeFromHRDept")
    public List<Employee> getEmployeeFromHRDept() {
        return employeeService.getEmployeeFromHRDept();
    }

    @GetMapping("/employeeListOver3Employee")
    public List<Map.Entry<String, Long>> getEmployeeListOver3Employee() {
        return employeeService.getEmployeeListOver3Employee();
    }

    @GetMapping("/deptNameByDistinct")
    public List<String> getDeptNameByDistinct() {
        return employeeService.getDeptNameByDistinct();
    }

    @GetMapping("/citySpecificEmpSortByName")
    public List<Employee> getCitySpecificEmpSortByName(){
        return employeeService.getCitySpecificEmpSortByName();
    }

    @GetMapping("/allEmployeeList")
    public long getAllEmployeeList() {
        return employeeService.getAllEmployeeList();
    }

    @GetMapping("/employeeListByDeptCount")
    public Optional<Map.Entry<String, Long>> getEmployeeListByDeptCount() {
        return employeeService.getEmployeeListByDeptCount();
    }

    @GetMapping("/sortedByAgeAndName")
    public List<Employee> getSortedByAgeAndName() {
        return employeeService.getSortedByAgeAndName();
    }

    @GetMapping("/highestExperienceEmployee")
    public List<Employee> getHighestExperienceEmployee() {
        return employeeService.getHighestExperienceEmployee();
    }

    @GetMapping("/averageOfSalary")
    public OptionalDouble getAverageOfSalary() {
        return employeeService.getAverageOfSalary();
    }

    @GetMapping("/totalSalary")
    public double getTotalSalary() {
        return employeeService.getTotalSalary();
    }

    @GetMapping("/averageSalaryEachDept")
    public Map<String, Double> getAverageSalaryEachDept() {
        return employeeService.getAverageSalaryEachDept();
    }

    @GetMapping("/highestSalary")
    public List<Employee> getHighestSalary() {
        return employeeService.getHighestSalary();
    }

    @GetMapping("/secondHighestSalary")
    public Optional<Employee> getSecondHighestSalary() {
        return employeeService.getSecondHighestSalary();
    }
}
