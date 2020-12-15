import java.io.IOException;
import java.io.*;
import java.util.ArrayList;

public class Service {
    private String path="dataBase/contacts.csv";
    private  ArrayList<Object> dataList=new ArrayList<>();
    private static ArrayList<Object> tempDataList=new ArrayList<>();
    private DisplayMenu displayMenu=new DisplayMenu();
    private CheckCondition checkCondition= new CheckCondition();


    public Service(){}
    static {
        Service service=new Service();
        try {
            service.readFile(tempDataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayFile() throws IOException {
        dataList= new ArrayList<>();
        readFile(dataList);
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
        System.out.println("");
        displayMenu.displayString("Information contact new");
        displayMenu.displayString(inforPersonNew.toString());
        displayMenu.displayString("Do you want save contact: Y (Y: Yes)");
        
        tempDataList.add(inforPersonNew);
        System.out.println("Success add infomation");
    }
    public void updateInfo() throws IOException{
        String numberTelephone=checkCondition.inputDataString("Nhập số điện thoại");

    }
    private void readFile(ArrayList<Object> list) throws IOException {
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
            list.add(inforPerson);
        }
        bufferedReader.close();
        fileReader.close();
    }
    public void readFile() throws IOException {
        readFile(dataList);
    }
    public void writeFile() throws IOException{
        FileWriter fileWriter=new FileWriter(new File(path));
        fileWriter.append("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email");
        fileWriter.append("\n");
        for (Object obj: tempDataList){
            InforPerson inforPerson=(InforPerson) obj;
            fileWriter.append(inforPerson.getNumberTelephone());
            fileWriter.append(",");
            fileWriter.append(inforPerson.getGroup());
            fileWriter.append(",");
            fileWriter.append(inforPerson.getFullName());
            fileWriter.append(",");
            fileWriter.append(inforPerson.getGender());
            fileWriter.append(",");
            fileWriter.append(inforPerson.getBirthDay());
            fileWriter.append(",");
            fileWriter.append(inforPerson.getAddress());
            fileWriter.append(",");
            fileWriter.append(inforPerson.getEmail());
            fileWriter.append("\n");
        }

        fileWriter.close();
    }

}
