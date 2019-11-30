package io;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class ReadLocalFile {
    public static void main(String[] args) throws IOException {
     /*   String str = read("C:\\Users\\DELL\\Documents\\file.txt");
        System.out.println(str);
        System.out.println("----------------------------------------");
        String str1 = readUTF8("C:\\Users\\DELL\\Documents\\file.txt");
        System.out.println(str1);
        System.out.println("----------------------------------------");
        String str2 = readUTF8("C:\\Users\\DELL\\Documents\\file.txt");
        System.out.println(covertToString(str2));
        System.out.println("----------------------------------------");
        String str3 = readByLine("C:\\Users\\DELL\\Documents\\file.txt");
        System.out.println(str3);
        System.out.println("----------------------------------------");
        String str4 = readUFT8ByLine("C:\\Users\\DELL\\Documents\\file.txt");
        System.out.println(str4);*/
        /*System.out.println("----------------------------------------");
        String str5 = readBuffer("C:\\Users\\DELL\\Documents\\file.txt");
        System.out.println(str5);*/
        System.out.println("----------------------------------------");
      /*  String str6 = readOnlineResource("https://github.com/nam-long/learning-java/blob/master/resources/cadao.txt");
        System.out.println(str6);*/
        ////////////////////////////////////////////////////////
        /*String s = "Welcome to java.";
        byte b[] = s.getBytes();
        SaveFile("C:\\Users\\DELL\\Documents\\file.txt",b);*/

       /* downloadImage("https://upload.wikimedia.org/wikipedia/commons/7/73/Lion_waiting_in_Namibia.jpg",
                new File("C:\\\\Users\\\\DELL\\\\Documents\\\\image.jpg").getAbsolutePath());*/
       /* String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/7/73/Lion_waiting_in_Namibia.jpg";
        String destinationFile = "image.jpg";

        saveImage(imageUrl, destinationFile);*/
       String s = "https://github.com/nam-long/learning-java/blob/master/resources/cadao.txt";
       String t = "file.txt";
       dowloadReadSource(s,t);
    }

    public static String read(String filename) throws IOException{
        String str ="";
        InputStream is = new FileInputStream(filename);
        int c;
     while ((c = is.read())!=-1){
         str+=(char) c;
     }
     is.close();
     return str;
    }
    public static String covertToString(String value) {
        try {
            String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static String readUTF8(String filename) throws IOException{
        String str ="";
        Reader is = new FileReader(filename);
        int c;
        while ((c = is.read())!=-1){
            str+=(char) c;
        }
        is.close();
        return str;
    }
    public static String readByLine(String filename) throws IOException{
        String str = "";
        InputStream is = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(is);
        String line;
        while ((line = dis.readLine()) != null){
            str += line +"\n";
        }
        is.close();
        return str;
    }
    public static String readUFT8ByLine(String filename) throws IOException{
        String str = "";
        FileReader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null){
            str += line +"\n";
            /*for(int i = 1;i<line.length();i++){

                str += i+line +"\n";
            }*/
        }
        reader.close();
        return str;
    }
    public static String readBuffer(String filename) throws IOException {
        String str ="";
        byte[] buffer =new byte[10];
        InputStream is = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int count;
        while ((count = bis.read(buffer))!=-1){
            baos.write(buffer,0,count);
        }
        str = new String(baos.toByteArray());
        is.close();
        baos.close();
        return str;
    }
    public static String readOnlineResource(String strURL) throws IOException {
        String str = null;
        URL url = new URL(strURL);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[100];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            str = new String(baos.toByteArray());
            is.close();
            baos.close();

        }
        return str;
    }
    public static void SaveFile(String fileName, byte[] data) throws IOException {
       FileOutputStream Fos = new FileOutputStream(fileName);
       Fos.write(data);
       Fos.close();
    }
   /* public static void saveImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();
        FileOutputStream fos = new FileOutputStream("C://borrowed_image.jpg");
        fos.write(response);
        fos.close();
    }

    public static void downloadImage(String sourceUrl, String targetDirectory) throws  IOException {
        URL imageUrl = new URL(sourceUrl);
        try (InputStream imageReader = new BufferedInputStream(
                imageUrl.openStream());
             OutputStream imageWriter = new BufferedOutputStream(
                     new FileOutputStream(targetDirectory + File.separator
                             + FilenameUtils.getName(sourceUrl)));)
        {
            int readByte;

            while ((readByte = imageReader.read()) != -1)
            {
                imageWriter.write(readByte);
            }
        }
    }*/
    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }

    public static void dowloadReadSource(String strUrl,String filename) throws IOException{
        String str = null;
        URL url = new URL(strUrl);
        InputStream is = url.openStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        FileOutputStream fos = new FileOutputStream(filename);
        byte[] buffer = new byte[100];
        int count;
        while ((count = bis.read(buffer)) !=-1){
            fos.write(buffer,0,count);
        }
        is.close();
        fos.close();
    }

}