package io;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Studentone studentone = new  Studentone("A", 20, "TP HCM");
        studentone.save("E:\\Javanangcao\\MultiThread\\file.txt");
        Studentone student1 = studentone.load("E:\\Javanangcao\\MultiThread\\file.txt");

        System.out.println(student1);

        System.out.println(studentone);
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

    public Studentone load(String filename) throws IOException, ClassNotFoundException {
        Studentone student;

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        student = (Studentone) ois.readObject();
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
