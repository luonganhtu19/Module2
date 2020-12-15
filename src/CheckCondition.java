import java.util.Scanner;

public class CheckCondition {
    CheckCondition(){}
    private Scanner input=new Scanner(System.in);
    public int checkInputInt(String mess){
        boolean check=true;
        int number=-1;
        while (check){
            try{
                System.out.println(mess);
                number= Integer.parseInt(input.nextLine());
                check=false;
            }catch (Exception e){
                System.out.println(" Please try again "+mess);
            }
        }
        return number;
    }

    public void inputStringEnter(String mess){
        boolean check=true;
        do {
            System.out.println(mess);
            String inputString=input.nextLine();
            if (inputString.equals("\n"));
        }while (check);
    }
    public String inputDataString(String mess){
        System.out.println(mess);
        String inputData=input.nextLine();
        return inputData;
    }
    public boolean inputStringYN(String mess){
            System.out.println(mess);
            String inputString=input.nextLine();
            if (inputString.equals("Y")) return true;
            else return false;
    }
}
