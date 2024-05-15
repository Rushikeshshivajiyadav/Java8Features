package com.codeWithRushi.Java8FeaturesProject.Controller;

import com.codeWithRushi.Java8FeaturesProject.Service.SoftwareDeveloperService;
import com.codeWithRushi.Java8FeaturesProject.entity.SoftwareDeveloper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SoftwareDeveloperController {

        private SoftwareDeveloperService softwareDeveloperService;

    public SoftwareDeveloperController(SoftwareDeveloperService softwareDeveloperService) {
        this.softwareDeveloperService = softwareDeveloperService;
    }

    @GetMapping("/countDevelopersPerGender")
    public Map<String, Long> getCountPerGender(){
        return softwareDeveloperService.countDeveloperPerGerder();
    }

    @GetMapping("/allEmpByGender/{gender}")
    public List<SoftwareDeveloper> getAllEmpByGender(@PathVariable String gender){
        return softwareDeveloperService.getAllByGender(gender);
    }

    @GetMapping("/increasedAllSalariesBy_10_Percent")
    public List<SoftwareDeveloper> getIncreasedAllSalariesBy_10_Percent(){
        return softwareDeveloperService.increasedAllSalariesBy_10_Percent();
    }

    @GetMapping("/sortingByAgeList")
    public List<SoftwareDeveloper> getSortingByAgeList(){
        return softwareDeveloperService.sortingByAge();
    }

    @GetMapping("/sortingByAgeListDesc")
    public List<SoftwareDeveloper> getsortingByAgeListDesc(){
        return softwareDeveloperService.sortingByAgeDesc();
    }

    @GetMapping("/sortingBySalaryDesc")
    public List<SoftwareDeveloper> getSortingBySalaryDesc(){
        return softwareDeveloperService.sortingBySalaryDesc();
    }

    @GetMapping("/listUniqueSkillsAndUpperCase")
    public List<String> getListUniqueSkillsAndUpperCase(){
        return softwareDeveloperService.listUniqueSkillsAndUpperCase();
    }

    @GetMapping("/allDevsEarningMoreThan/{salary}")
    public List<SoftwareDeveloper> findAllDevsEarningMoreThan(@PathVariable double salary){
        return softwareDeveloperService.findAllDevsEarningMoreThan(salary);
    }

    @GetMapping("/AnyDev_whereNameStartsWith/{firstname}")
    public List<String> findAnyDev_whereNameStartsWith(@PathVariable String firstname){
        return softwareDeveloperService.findAnyDev_whereNameStartsWith(firstname);
    }

    @GetMapping("/findFirst_2_DevelopersStartingFromPosition_3")
    public List<SoftwareDeveloper> findFirst_2_DevelopersStartingFromPosition_3(){
        return softwareDeveloperService.findFirst_2_DevelopersStartingFromPosition_3();
    }

    @GetMapping("/displayFirst_3_developer")
    public List<SoftwareDeveloper> displayFirst_3_developers(){
        return softwareDeveloperService.displayFirst_3_developers();
    }

    @GetMapping("/displayOldestDeveloper")
    public Optional<SoftwareDeveloper> displayOldestDeveloper(){
        return  softwareDeveloperService.displayOldestDeveloper();
    }

    @GetMapping("/displayYoungestDeveloper")
    public Optional<SoftwareDeveloper> displayYoungestDeveloper(){
        return  softwareDeveloperService.displayYoungestDeveloper();
    }

    @GetMapping("/displayTotalSalaries")
    public Double displayTotalSalaries() {
        var totalSalaries = softwareDeveloperService.displayTotalSalaries();
        return totalSalaries;
    }

}
