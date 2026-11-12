
import java.util.*;

class student{
    int id;
    String name;
    double marks;
    student(int id,String name,double marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    @Override 
    public String toString (){
        return "ID :"+ id+ ", Name : "+ name+", Marks : "+marks;
    }
} 
class Main {
    public static void main(String[] args) {
        ArrayList<student>studentlist = new ArrayList<>();
        HashMap<Integer,student>studentmap = new HashMap<>();
        student s1 = new student(101, "A",90);
        student s2 = new student(102, "B",91);
        student s3 = new student(103, "C",92);

        studentlist.add(s1);
        studentlist.add(s2);
        studentlist.add(s3);
        
        studentmap.put(s1.id, s1);
        studentmap.put(s2.id, s2);
        studentmap.put(s3.id, s3);

        int ch = 103;
        if(studentmap.containsKey(ch)){
            System.out.println("Record found");
            System.out.println(studentmap.get(ch));
        }
        else{
            System.out.println("Record Not found");
        }
        int ch1 = 102;
        if(studentmap.containsKey(ch1)){
            System.out.println("Record found");
            System.out.println(studentmap.get(ch1));
        }
        else{
            System.out.println("Record Not found");
        }

        int up1 = 103;
        if(studentmap.containsKey(up1)){
            student st = studentmap.get(up1);
            st.marks = 96;
            System.out.println("Update record");
            System.out.println(st);
        }
        else{
            System.out.println("Record not found");
        }
         int up2 = 102;
        if(studentmap.containsKey(up2)){
            student st = studentmap.get(up2);
            st.marks = 98;
            System.out.println("Update record");
            System.out.println(st);
        }
        else{
            System.out.println("Record not found");
        }

        System.out.println("All records");

        Iterator<student>iterator = studentlist.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
            
    }
}