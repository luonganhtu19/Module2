import java.io.IOException;
import java.io.*;
import java.util.ArrayList;

public class Service {
    private String path="dataBase/contacts.csv";
    private  ArrayList<Object> dataList=new ArrayList<>();
    private DisplayMenu displayMenu=new DisplayMenu();
    private CheckCondition checkCondition= new CheckCondition();


    public Service(){}


    public void displayFile() throws IOException {
        dataList= new ArrayList<>();
        readFile();
        for (Object obj:dataList){
            InforPerson inforPerson=(InforPerson) obj;
            System.out.println(inforPerson.toString());
        }
    }
    public void addNewContact() throws IOException{
         InforPerson inforPersonNew= new InforPerson();
        inforPersonNew.setNumberTelephone(checkCondition.inputDataString("Số điện thoại: "));
        inforPersonNew.setGroup(checkCondition.inputDataString("Nhóm danh bạ: "));
        inforPersonNew.setFullName(checkCondition.inputDataString("Họ và tên: "));
        inforPersonNew.setGender(checkCondition.inputDataString("Giới tính: "));
        inforPersonNew.setAddress(checkCondition.inputDataString("Địa chỉ: "));
        inforPersonNew.setBirthDay(checkCondition.inputDataString("Ngày sinh: "));
        inforPersonNew.setEmail(checkCondition.inputDataString("Email"));
        dataList.add(inforPersonNew);
        System.out.println("Success add infomation");
    }
    public void readFile() throws IOException {
        File file=new File(path);
        if (!file.exists()){
            System.out.println("File not found");
            return;
        }
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=null;
        while ((line=bufferedReader.readLine())!=null){
            String[] data= line.split(",");
            InforPerson inforPerson=new InforPerson();
            if (data[0].equals("Số điện thoại")) continue;
            inforPerson.setNumberTelephone(data[0]);
            inforPerson.setGroup(data[1]);
            inforPerson.setFullName(data[2]);
            inforPerson.setGender(data[3]);
            inforPerson.setAddress(data[4]);
            inforPerson.setBirthDay(data[5]);
            inforPerson.setEmail(data[6]);
            dataList.add(inforPerson);
        }
        bufferedReader.close();
        fileReader.close();
    }
    public void writeFile() throws IOException{
        FileWriter fileWriter=new FileWriter(new File(path));
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        for (Object obj: dataList){
            InforPerson inforPerson=(InforPerson) obj;
            fileWriter.append("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email");
            fileWriter.append(inforPerson.getNumberTelephone());
            fileWriter.append(inforPerson.getGroup());
            fileWriter.append(inforPerson.getFullName());
            fileWriter.append(inforPerson.getGender());
            fileWriter.append(inforPerson.getBirthDay());
            fileWriter.append(inforPerson.getAddress());
            fileWriter.append(inforPerson.getEmail());
        }
    }
}
