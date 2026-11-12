
import java.util.*;

class Emp{
    int id;
    String name;
    String dep;
    double salary;
    Emp(int id,String name,String dep,double salary){
        this.id = id;
        this.name = name;
        this.dep = dep;
        this.salary = salary;
    }
    public int getid(){
        return id;
    }
    public String getname(){
        return name;
    }
    public String getdep(){
        return dep;
    }
    public double getsalary(){
        return salary;
    }
    
    @Override 
    public String toString (){
        return "ID :"+ id+ ", Name : "+ name+", Department : "+dep + " salary : "+salary;
    }
} 
class Main {
    public static void main(String[] args) {
        ArrayList<Emp>emp = new ArrayList<>();
        
        emp.add(new Emp(101, "A","DEV",90000));
        emp.add(new Emp(102, "B","Testing",70000));
        emp.add(new Emp(103, "C","Backend",50000));

        System.out.println("All Records");
        emp.stream()
            .forEach(System.out::println);
        
        System.out.println("Salary greater than 60k");
        emp.stream()
            .filter(e->e.getsalary() > 60000)
            .forEach(System.out::println);  
        
        System.out.println("Sorted by Salary");
        emp.stream()
            .sorted((e1,e2) -> Double.compare(e1.getsalary(),e2.getsalary()))
            .forEach(System.out::println);
        System.out.println("Sorted by Name");

        emp.stream()
            .sorted((e1, e2) -> e1.getname().compareTo(e2.getname()))
            .forEach(System.out::println);
            
    }
}