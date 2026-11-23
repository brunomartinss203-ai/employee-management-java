package service;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
   private List<Employee> employees = new ArrayList<>();

    public boolean addEmployee(Employee employee){
        if (employee != null) {
            String nome = employee.getName();
            String role = employee.getRole();
            double baseSalary = employee.getBaseSalary();
            if (nome!= null &&
                    !nome.isBlank()&&
                     role != null &&  !role.isBlank()
                     && baseSalary > 0) {
                employees.add(employee);
                return true;
            }
        }
        return false;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee findById(int id){
        for(Employee emp: employees){
            if (id == emp.getId()){
                return emp;
            }
        }
        return null;
    }

    public boolean removeEmployee(int id){
        Employee idl = findById(id);
        if(idl != null) {
            employees.remove(idl);
            return true;
        }
        return false;
    }

    public boolean increaseEmployeeSalary(int id,double percentage){
        Employee func = findById(id);
        if (func != null && percentage >0) {
            func.increaseSalary(percentage);
            return  true;
            }
        return false;
    }

    public double calculatePayroll(){
        double total = 0;
        for (Employee func : employees){
            total += func.getBaseSalary();
        }
        return  total;
    }

}
