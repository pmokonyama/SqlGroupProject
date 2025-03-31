import java.util.Scanner;

public class CreateSQLReports {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter customerID");
        String customerId = input.nextLine();
        String allAddressData = "SELECT street, house_number,zip_code, country" +" "+
                "FROM customers" +" "+
                "WHERE customer_id = '"+customerId +"'";
        String totalBalance = "SELECT c.customer_id, COALESCE(SUM(a.balance), 0) AS total_total_balance" +" "+
                "FROM customers c" +" "+
                "LEFT JOIN accounts a ON c.customer_id = a.customer_id" +" "+
                "WHERE c.customer_id = '"+customerId +"'" +
                "GROUP BY c.customer_id;";
        String allTransactions ="SELECT a.account_number, t.transaction_date, t.amount, t.transaction_type" +" "+
                "FROM accounts a" +" "+
                "JOIN transactions t ON a.account_number = t.account_number" +" "+
                "WHERE a.customer_id = '"+customerId +"'"+ "AND a.account_type = 'CHECKING'" +" "+
                "ORDER BY t.transaction_date;";
        queryExecutor.executeQuery(allAddressData, totalBalance, allTransactions);

    }
}
