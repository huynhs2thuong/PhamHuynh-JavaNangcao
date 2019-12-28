package io;

import java.io.*;

public class NoSerialization {

    public static void main(String[] args) throws IOException {

        Student student = new Student("A", 20, "TP HCM");

       // student.save("E:\\Javanangcao\\MultiThread\\file.txt");

        student.load("E:\\Javanangcao\\MultiThread\\file.txt");

        System.out.println(student);
    }
}

class Student {

    private String mName;
    private int mAge;
    private String mAddress;

    public Student(String name, int age, String address) {
        mName = name;
        mAge = age;
        mAddress = address;
    }

    public void save(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        DataOutputStream dos = new DataOutputStream(fos);
        int length = mName.getBytes("UTF-8").length;
        dos.writeInt(length);
        dos.writeInt(4);
        int length1 = mAddress.getBytes("UTF-8").length;
        dos.writeInt(length1);

        dos.write(mName.getBytes("UTF-8"));
        dos.writeInt(mAge);
        dos.write(mAddress.getBytes("UTF-8"));

        fos.close();
    }

    public void load(String filename) throws IOException {

        FileInputStream fis = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(fis);

        int lengthOfName = dis.readInt();
        int lengthOfAge = dis.readInt();
        int lengthOfAddress = dis.readInt();

        byte[] buffer = new byte[Math.max(lengthOfName, lengthOfAddress)];
        dis.read(buffer, 0, lengthOfName);
        mName = new String(buffer, 0, lengthOfName, "UTF-8");

        mAge = dis.readInt();

        dis.read(buffer, 0, lengthOfAddress);
        mAddress = new String(buffer, 0, lengthOfAddress, "UTF-8");

        fis.close();
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