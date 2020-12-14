import java.io.IOException;

public class Program {
    private static DisplayMenu displayMenu = new DisplayMenu();
    private static CheckCondition checkCondition = new CheckCondition();
    private static Service service=new Service();

    public static void main(String[] args) throws IOException {
               while (true) {
                   displayMenu.menu();
                   int choice = checkCondition.checkInputInt("Chọn chức năng: ");

                   switch (choice) {
                case 1:
                    service.displayFile();
                    break;
                case 2:
                    service.addNewContact();
                    break;
                case 3:
                    se
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    service.readFile();
                    break;
                case 7:
                    service.writeFile();
                    break;
                case 8:
                    System.out.println(" Bye bye, see you again");
                    return;
                default:
                    System.out.println("Please try agian");
            }
        }
    }
}