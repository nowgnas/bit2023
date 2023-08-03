package frame;

public class SQL {
    public static String custInsert = "INSERT INTO cust VALUES (?, ?, ?)";
    public static String custUpdate = "UPDATE cust SET pwd=?, name=? WHERE id=?";
    public static String custDelete = "DELETE FROM cust WHERE id=?";
    public static String custSelect = "SELECT * FROM cust WHERE id=?";
    public static String custSelectAll = "SELECT * FROM cust ";
}
