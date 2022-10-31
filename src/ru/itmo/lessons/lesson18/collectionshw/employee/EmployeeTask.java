package ru.itmo.lessons.lesson18.collectionshw.employee;

import java.util.Comparator;
import java.util.List;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.employeeGenerator(50);

        // TODO 1: отсортировать список по имени
        // TODO 2: отсортировать список по имени и зп
        // TODO 3: отсортировать список по имени, зарплате, возрасту и компании
        Comparator<Employee> byName = new NameComparator();
        Comparator<Employee> byAge = new AgeComparator();
        Comparator<Employee> bySalary = new SalaryComparator();
        Comparator<Employee> byCompany = new CompanyComparator();

        employeeList.sort(byName); // имени
        employeeList.forEach(employee -> System.out.println(employee.getName()));

        employeeList.sort(byName.thenComparing(bySalary));// имени и зарплате
        employeeList.forEach(employee -> System.out.println(employee.getName() + " " + employee.getSalary()));

        // имени, зарплате, возрасту и компании
        employeeList.sort(byName.thenComparing(bySalary).thenComparing(byAge).thenComparing(byCompany));
        employeeList.forEach(System.out::println);

        employeeList.sort(AppComparators.BY_NAME.thenComparing(AppComparators.BY_AGE));

    }
}

class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class AgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAge() - o2.getAge();
    }
}

class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
    }
}

class CompanyComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}