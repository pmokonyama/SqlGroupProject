import java.sql.*;

public class queryExecutor {

    public static void executeQuery(String... queries){

        try (
            Connection conn = DatabaseConnection.DBConnection();
            Statement statement = conn.createStatement();
        ) {
            for (String query : queries) {
                System.out.println("Running query: " + query);
                System.out.println();
                boolean hasResultSet = statement.execute(query);
                if (hasResultSet) {
                    try (ResultSet rs = statement.getResultSet()) {
                        ResultSetMetaData metaData = rs.getMetaData();
                        int columnCount = metaData.getColumnCount();

                        while (rs.next()) {
                            for (int i = 1; i <= columnCount; i++) {
                                String columnName=metaData.getColumnName(i);
                                String value=rs.getString(i);
                                System.out.println(columnName + ": "+ value );

                            }
                            System.out.println();
                        }
                    }
                    System.out.println("Completed");
                } else {
                    int updateCount = statement.getUpdateCount();
                    System.out.println("Update Count" + updateCount + "\n");
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}