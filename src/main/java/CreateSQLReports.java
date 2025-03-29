import java.util.Scanner;

public class CreateSQLReports {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter customerID");
        String customerId = input.nextLine();
        String allAddressData = "SELECT street, house_number,zip_code, country" +" "+
                "FROM customers" +" "+
                "WHERE customer_id = '"+customerId +"'";
        String totalBalance = "";
        String allTransactions ="";
        queryExecutor.executeQuery(allAddressData, totalBalance, allTransactions);

    }
}
