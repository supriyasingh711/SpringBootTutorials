package com.luv2code.springboot.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.antlr.v4.runtime.atn.EmptyPredictionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //quick and dirty: inject employee dao

private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public  EmployeeRestController(EmployeeService theEmployeeService,ObjectMapper theObjectMapper){
        employeeService=theEmployeeService;
        objectMapper=theObjectMapper;
    }

    //expose "/employees" and return the list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }


    //addd mapping for get /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("No such Employee of given id");

        }
        return theEmployee;
    }
    //add mapping for post /emloyee --add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also just in case they pass id in json ... set id to 0
        //this is to force a save of new item..instead of update
        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }
    //add mapping for PUT /employees -update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }
    //add mapping for patch /employees/{employeeId} - patch employee ... partial update
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,@RequestBody Map<String,Object> patchPayLoad){
        Employee tempEmployee=employeeService.findById(employeeId);
        //throw exception if we couldn't find a employee
        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found -"+employeeId);

        }
        //throw exception if request body contains id key
        if(patchPayLoad.containsKey("id")){
            throw new RuntimeException("Employee id is not allowed in request body-"+employeeId);
        }
        Employee patchedEmployee=apply(patchPayLoad,tempEmployee);
        Employee dbEmployee=employeeService.save(patchedEmployee);
        return  dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayLoad, Employee tempEmployee) {
        //convert employee object to json object
        ObjectNode employeeNode=objectMapper.convertValue(tempEmployee,ObjectNode.class);
        //convert patched payload map to a json object node
        ObjectNode patchNode=objectMapper.convertValue(patchPayLoad,ObjectNode.class);
        //merge the patch updates into the employee node
        employeeNode.setAll(patchNode);
        return  objectMapper.convertValue(employeeNode,Employee.class);
    }
    //add mapping for delete /employee/{employeeId}
    @DeleteMapping("/employees/{employeeId}")
    private String deleteById(@PathVariable int employeeId){
        Employee temp=employeeService.findById(employeeId);
        if(temp==null){
            throw new RuntimeException("Employee id not found -"+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee id -"+employeeId;
    }

}
