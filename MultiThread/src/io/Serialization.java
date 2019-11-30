package io;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Studentone student = new  Studentone("A", 20, "TP HCM");
         student.save("E:\\Javanangcao\\MultiThread\\file.txt");
        System.out.println(student);
    }
}
class Studentone implements Serializable{

    private String mName;
    private int mAge;
    private String mAddress;

    public Studentone(String name, int age, String address) {
        mName = name;
        mAge = age;
        mAddress = address;
    }

    public void save(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       oos.writeObject(this);

        fos.close();
    }

    public Student load(String filename) throws IOException, ClassNotFoundException {
        Student student;
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        student=(Student) ois.readObject();
        fis.close();
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mName='" + mName + '\'' +
                ", mAge=" + mAge +
                ", mAddress='" + mAddress + '\'' +
                '}';
    }
}
