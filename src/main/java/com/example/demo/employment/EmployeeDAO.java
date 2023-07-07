package com.example.demo.employment;

public class EmployeeDAO {
    private static Employess list = new Employess();

    static {
    list.getEmployeeList().add(
            new Employee(
                    1,
                    "Prem",
                    "Tiwari",
                    "chapradreams@gmail.com"));

    list.getEmployeeList().add(
            new Employee(
                    2,
                    "Vikash",
                    "Kumar",
                    "abc@gmail.com"));

    list.getEmployeeList().add(
            new Employee(
                    3,
                    "Ritesh",
                    "Ojha",
                    "asdjf@gmail.com"));
    }
    public Employess getAllEmployess (){
        return list;
    }
    public  void  addEmployee(Employee employee){
        list.getEmployeeList().add(employee);
    }


}
