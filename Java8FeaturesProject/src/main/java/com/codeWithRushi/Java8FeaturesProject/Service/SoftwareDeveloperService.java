package com.codeWithRushi.Java8FeaturesProject.Service;

import com.codeWithRushi.Java8FeaturesProject.entity.SoftwareDeveloper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SoftwareDeveloperService {

     private final List<SoftwareDeveloper> softwareDevelopers = List.of(
            new SoftwareDeveloper("Rico", "Riddle", 21, 122.2, List.of("Java", "Spring"), "M"),
            new SoftwareDeveloper("Jeremiah", "Bonilla", 34, 127.2, List.of("Ruby", "Go", "Docker"), "M"),
            new SoftwareDeveloper("Kamal", "Waller", 32, 129.2, List.of("AWS", "Azure", "Spring"), "M"),
            new SoftwareDeveloper("Mariya", "Kent", 45, 120.2, List.of("Hibernate", "Java", "Kotlin", "K8s"), "F"),
            new SoftwareDeveloper("Ali", "Bouali", 18, 123.2, List.of("C", ".NET", "Angular"), "M"),
            new SoftwareDeveloper("Miriam", "Merrill", 39, 125.2, List.of("Angular", "Javascript", "Typescript"), "F"),
            new SoftwareDeveloper("Djamal", "Francis", 56, 125.2, List.of("Marketing", "Design"), "M"),
            new SoftwareDeveloper("Briony", "Finch", 27, 126.2, List.of("Docker", "GitHub Actions", "GitLab CI"), "M"),
            new SoftwareDeveloper("Joanna", "Maddox", 56, 128.2, List.of("Management", "Team building"), "F")
    );

     public Map<String, Long> countDeveloperPerGerder(){
         return softwareDevelopers.stream().collect(Collectors.groupingBy(SoftwareDeveloper::getGender,Collectors.counting()));
     }

     public List<SoftwareDeveloper> getAllByGender(String gender){
         List<SoftwareDeveloper> allEmpListByGender = softwareDevelopers.stream().filter(emp -> gender.equals(emp.getGender())).collect(Collectors.toList());
         return allEmpListByGender;
     }

     public List<SoftwareDeveloper> increasedAllSalariesBy_10_Percent(){
         List<SoftwareDeveloper> increasedAllSalariesBy_10_Percent = softwareDevelopers.stream().map(dev ->
                 new SoftwareDeveloper(
                         dev.getFirstname(),
                         dev.getLastname(),
                         dev.getAge(),
                         dev.getSalary() * 1.10,
                         dev.getSkills(),
                         dev.getGender())).collect(Collectors.toList());
         return increasedAllSalariesBy_10_Percent;
     }

     public List<SoftwareDeveloper> sortingByAge(){
         List<SoftwareDeveloper> sortingByAgeList = softwareDevelopers.stream()
                 .sorted(Comparator.comparing(SoftwareDeveloper::getAge)).collect(Collectors.toList());
         return sortingByAgeList;
     }

    public List<SoftwareDeveloper> sortingByAgeDesc(){
        List<SoftwareDeveloper> sortingByAgeListDesc = softwareDevelopers.stream()
                .sorted((d1,d2) -> d2.getAge() - d1.getAge()).collect(Collectors.toList());
        return sortingByAgeListDesc;
    }

    public List<SoftwareDeveloper> sortingBySalaryDesc(){
        List<SoftwareDeveloper> sortingBySalaryDesc = softwareDevelopers.stream()
                .sorted((d1,d2) -> (int) (d2.getSalary() - d1.getSalary())).collect(Collectors.toList());
        return sortingBySalaryDesc;
    }

    public List<String> listUniqueSkillsAndUpperCase(){
        List<String> uniqueSkillWithUpperCase = softwareDevelopers.stream().map(SoftwareDeveloper::getSkills).flatMap(List::stream).
                map(String::toUpperCase).distinct().sorted().collect(Collectors.toList());
        return uniqueSkillWithUpperCase;
    }

    public List<SoftwareDeveloper> findAllDevsEarningMoreThan(double salary){
        List<SoftwareDeveloper> allDevsEarningMoreThan = softwareDevelopers.stream().filter(dev -> dev.getSalary() >= salary).collect(Collectors.toList());
        return allDevsEarningMoreThan;
    }

    public List<String> findAnyDev_whereNameStartsWith(String namePortion){
        List<String> nameStartsWith = softwareDevelopers.stream().filter(dev -> dev.getFirstname().startsWith(namePortion)).map(SoftwareDeveloper::getFirstname).collect(Collectors.toList());
        return nameStartsWith;
    }

    public List<SoftwareDeveloper> findFirst_2_DevelopersStartingFromPosition_3(){
        List<SoftwareDeveloper> findFirst_2_DevelopersStartingFromPosition_3 = softwareDevelopers.stream().skip(3).limit(2).collect(Collectors.toList());
        return findFirst_2_DevelopersStartingFromPosition_3;
    }

    public List<SoftwareDeveloper> displayFirst_3_developers() {
        List<SoftwareDeveloper> displayFirst_3_developers = softwareDevelopers.stream().limit(3).collect(Collectors.toList());
        return displayFirst_3_developers;
    }

    public Optional<SoftwareDeveloper> displayOldestDeveloper(){
        Optional<SoftwareDeveloper> max = softwareDevelopers.stream().max(Comparator.comparing(SoftwareDeveloper::getAge));
        return max;
    }
    public Optional<SoftwareDeveloper> displayYoungestDeveloper(){
        Optional<SoftwareDeveloper> min = softwareDevelopers.stream().min(Comparator.comparing(SoftwareDeveloper::getAge));
        return min;
    }

    public Double displayTotalSalaries() {
        var totalSalaries = softwareDevelopers
                .stream()
                .map(SoftwareDeveloper::getSalary)
                .reduce(0.0, Double::sum);
        return totalSalaries;
    }
}
