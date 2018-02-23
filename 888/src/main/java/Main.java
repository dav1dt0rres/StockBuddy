import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Please type in a stock");
        Scanner sc = new Scanner(System.in);
        String lettering=sc.nextLine();
        UserClass user = new UserClass("David", 888);
        while (!lettering.equals("exit") ) {

            Logic stock = new Logic(lettering);
            System.out.println("Will you purchase?");
            String temp_string=sc.nextLine();
            if(temp_string.equals("yes")){

                System.out.println("How Much?");
                temp_string=sc.nextLine();
                user.addToPurchaseHistory(stock, temp_string);

            }



            else {
                user.addtoLookupHistory(stock,lettering);
                stock.getinformation();
                stock.purchase_at_Price("54");
            }

            user.getPurchaseHistory();

            System.out.println("Please type in a stock");


          lettering=sc.nextLine();
        }
        //stock.getHistory();
        //stock.getinformation();
        //user.addtoLookupHistory(stock);


    }

}