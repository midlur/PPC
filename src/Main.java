import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File(System.getProperty("user.home") + "/Desktop/jj/employee.csv");
            ArrayList<Employee> employees = new ArrayList();

            Scanner scan = new Scanner(file);
            scan.useDelimiter(",");
            int i=0;
            while(scan.hasNext()){
                String name = scan.next();
                int salary = Integer.parseInt(scan.next());
                employees.add(new Employee(name,salary));
                i++;
            }

            employees.sort((Employee s1, Employee s2)->s1.getSalary()-s2.getSalary());
            Collections.reverse(employees);

            employees.forEach((s)->System.out.println(s));
            System.out.println("Employee with lowest salary is " + employees.get(10));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
