import java.io.*;
import java.util.ArrayList;

public class File {

    private static  final String path="D:\\codegym\\modul2\\test\\contact.txt";
    public ArrayList<Contact> readFromFile() throws IOException {
        ArrayList<Contact> list = new ArrayList<>();
        java.io.File file=new java.io.File(path);
        FileReader fileReader = null;
        BufferedReader br = null;
        String line=null;
        String[] contactInfor;
        try {
            if (file==null){
                throw new FileNotFoundException();
            }
            fileReader=new FileReader(file);
            br=new BufferedReader(fileReader);
            while ((line=br.readLine())!=null){
                contactInfor=line.split(",");
                Contact contact=new Contact(contactInfor[0],contactInfor[1],contactInfor[2],contactInfor[3],contactInfor[4],contactInfor[5],contactInfor[6]);
                list.add(contact);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fileReader.close();
            br.close();
        }
        return list;
    }



    public void writeToFile(ArrayList<Contact> arrayList) throws IOException {
        java.io.File file=new java.io.File(path);
        FileWriter fileWriter=null;
        BufferedWriter bw=null;
        try {
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            fileWriter=new FileWriter(file);
            bw=new BufferedWriter(fileWriter);
            String content=null;
            for (Contact contact:arrayList){
                String number=contact.getNumber();
                String group=contact.getGroup();
                String name=contact.getName();
                String gender=contact.getGender();
                String address=contact.getAddress();
                String dateOfBirth=contact.getDateOfBirth();
                String email=contact.getEmail();
                content=number+","+group+","+name+","+gender+","+address+","+dateOfBirth+","+email;
                bw.write(content);
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileWriter.close();
            bw.close();
        }
    }

}
