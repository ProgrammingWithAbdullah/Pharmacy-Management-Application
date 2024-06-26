/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pharmacyy;
import java.sql.*;
import java.util.logging.Level;
import java.sql.PreparedStatement;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author abdul
 */
public class Pharmacyy {
    static PreparedStatement myStmttt = null;
    static Connection myConnn=null;
        static PreparedStatement myStmttt1 = null;
    static Connection myConnn1=null;
//    static Connection myConn1=null;
//    static Connection myConn2=null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Connection myConn=null;
    Statement myStmt = null;
    ResultSet myRs = null;
    PreparedStatement myStmtt = null;
   
    
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypharm", "root", "abdullah123");
        myStmt = myConn.createStatement();
        
        System.out.println("hello");

        
        String sql = "INSERT INTO login(username, password) VALUES (?, '34')";
        myStmtt = myConn.prepareStatement(sql);
        String user = "okk";
        myStmtt.setString(1, user);

        
        int rowsAffected1 = myStmtt.executeUpdate(); 
        System.out.println("Rows affected: " + rowsAffected1);

        
        
        int rowsAffected = myStmt.executeUpdate("INSERT INTO login(username, password) VALUES ('user1', '324')");
        System.out.println("Rows affected: " + rowsAffected);
        

        myRs = myStmt.executeQuery("SELECT * FROM login");

        while (myRs.next()) 
        {
            String username = myRs.getString("username");
            String password = myRs.getString("password");
            System.out.println("Username: " + username + ", Password: " + password);
        }
    }
    catch(Exception exc)
    {
        exc.printStackTrace();
    }finally
    {
        if(myRs !=null)
        {
            try {
                myRs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Pharmacyy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(myStmt !=null)
        {
            try {
                myStmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Pharmacyy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(myConn !=null)
        {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Pharmacyy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    {  
    }
    }    
    
    public static class Login 
    {
    private String username;
    private String password;

    // Empty constructor
    public Login() {
        this.username = "";
        this.password = "";
    }

    // Setter for username
    public void addUsername(String username) {
        this.username = username;
    }

    // Setter for password
    public void addPassword(String password) {
        this.password = password;
    }

    // Print function to display both username and password
    public void printLoginDetails() {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        
        try {
        myConnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/receptionist_info", "root", "abdullah123");

        String sql = "INSERT INTO login(username, password) VALUES (?, ?)";
        myStmttt = myConnn.prepareStatement(sql);

        String user = username;
        String user1 = password;

        myStmttt.setString(1, user);
        myStmttt.setString(2, user1);

        int rowsAffected2 = myStmttt.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected2);
    } catch (SQLException ex) 
    {
        Logger.getLogger(Pharmacyy.class.getName()).log(Level.SEVERE, null, ex);
    } 
        finally {
        // Close resources in the finally block to ensure they are closed even if an exception occurs
        try {
            if (myStmttt != null) {
                myStmttt.close();
            }
            if (myConnn != null) {
                myConnn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pharmacyy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
}
    
     public static class Medicine{
        private String medicine_id;
        private String medicine_name;
        private String num_of_units;
        private String company_name;
        private String price_per_unit;

        public Medicine() {
            this.medicine_id = "";
            this.medicine_name = "";
            this.num_of_units = "";
            this.company_name = "";
            this.price_per_unit = "";
        }

        public void setMedicineId(String medicine_id) {
            this.medicine_id = medicine_id;
        }

        public void setMedicineName(String medicine_name) {
            this.medicine_name = medicine_name;
        }

        public void setNumOfUnits(String num_of_units) {
            this.num_of_units = num_of_units;
        }

        public void setCompanyName(String company_name) {
            this.company_name = company_name;
        }

        public void setPricePerUnit(String price_per_unit) {
            this.price_per_unit = price_per_unit;
        }

        public void printMedicineDetails() {
    System.out.println("Medicine ID: " + medicine_id);
    System.out.println("Medicine Name: " + medicine_name);
    System.out.println("Number of Units: " + num_of_units);
    System.out.println("Company Name: " + company_name);
    System.out.println("Price Per Unit: " + price_per_unit);

    try (Connection myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sell_medicine", "root", "abdullah123")) {
        String sql = "INSERT INTO sell(medicine_id, medicine_name, num_of_units, company_name, price_per_unit) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement myStmttt1 = myConn1.prepareStatement(sql)) {
            // Set values for the placeholders
    System.out.println("Price Per Unit: " + price_per_unit);
            
            myStmttt1.setString(1, medicine_id);
            myStmttt1.setString(2, medicine_name);
            myStmttt1.setString(3, num_of_units);
            myStmttt1.setString(4, company_name);
            myStmttt1.setString(5, price_per_unit);
            
            

            int rowsAffected = myStmttt1.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle the exception, e.g., show an error message to the user
        System.out.println("error in main");
    }
}

    }
     
     public static class User {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String mobileNumber;
    private String email;
    private String username;
    private String password;
    private String address;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = "";
        this.mobileNumber = "";
        this.email = "";
        this.username = "";
        this.password = "";
        this.address = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void printUserDetails() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Address: " + address);

        // Your database insertion logic can be placed here (similar to Medicine class)
            try (Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info", "root", "abdullah123")) {
            String sql = "INSERT INTO user(first_name, last_name, date_of_birth, mobile_number, email, username, password, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
            try (PreparedStatement myStmt = myConn.prepareStatement(sql)) {
                myStmt.setString(1, firstName);
                myStmt.setString(2, lastName);
                myStmt.setString(3, dateOfBirth);
                myStmt.setString(4, mobileNumber);
                myStmt.setString(5, email);
                myStmt.setString(6, username);
                myStmt.setString(7, password);
                myStmt.setString(8, address);

                int rowsAffected = myStmt.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error in database insertion");
        }
    }
}
      public static class SellMedicine {
        private String medicine_id;
        private String medicine_name;
        private String num_of_units;
        private String company_name;
        private String price_per_unit;

        public SellMedicine() {
            this.medicine_id = "";
            this.medicine_name = "";
            this.num_of_units = "";
            this.company_name = "";
            this.price_per_unit = "";
        }

        public void setMedicineId(String medicine_id) {
            this.medicine_id = medicine_id;
        }

        public void setMedicineName(String medicine_name) {
            this.medicine_name = medicine_name;
        }

        public void setNumOfUnits(String num_of_units) {
            this.num_of_units = num_of_units;
        }

        public void setCompanyName(String company_name) {
            this.company_name = company_name;
        }

        public void setPricePerUnit(String price_per_unit) {
            this.price_per_unit = price_per_unit;
        }

public void printMedicineDetails() {
    System.out.println("Medicine ID: " + medicine_id);
    System.out.println("Medicine Name: " + medicine_name);
    System.out.println("Number of Units: " + num_of_units);
    System.out.println("Company Name: " + company_name);
    System.out.println("Price Per Unit: " + price_per_unit);

    try (Connection myConn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sell_medicine", "root", "abdullah123")) {
        // Check if the medicine with the given name already exists
        String checkSql = "SELECT * FROM sell WHERE medicine_name = ?";
        try (PreparedStatement checkStmt = myConn2.prepareStatement(checkSql)) {
            checkStmt.setString(1, medicine_name);

            // Execute the SELECT query
            ResultSet resultSet = checkStmt.executeQuery();
            boolean available1 = true;
            boolean available2 = true;
            boolean available3 = true;
            
            String checkIdSql = "SELECT * FROM sell WHERE medicine_id = ?";
            try (PreparedStatement checkIdStmt = myConn2.prepareStatement(checkIdSql)) 
            {
                checkIdStmt.setString(1, medicine_id);

                // Execute the SELECT query
                ResultSet idResultSet = checkIdStmt.executeQuery();

                if (idResultSet.next()) {
                    available3 = true;
                    System.out.println("Medicine with the ID " + medicine_id + " exists.");
                    // Handle the case where the medicine with the given ID already exists
                }
                else
                {
                    available3 = false;
                }
            }
            if (resultSet.next()) 
            {   
                available1 =true;
                System.out.println("Medicine with the name " + medicine_name + " exists.");
                // Compare the quantity in the database with the user-provided quantity
                int availableQuantity = resultSet.getInt("num_of_units");

                int value = Integer.parseInt(num_of_units);
                if (value > availableQuantity) 
                {
                    available2 = false;
                    System.out.println("Quantity entered by the user is greater than available quantity.");
                    // Handle the case where the user-provided quantity is greater
                } 
                else 
                {   available2=true;
                    // Calculate the updated quantity
                    int updatedQuantity = availableQuantity - value;

                    // Proceed with the insertion or other actions
                    System.out.println("Quantity is within the available range. Proceeding with the insertion...");

                    // Update the quantity in the database
                    String updateSql = "UPDATE sell SET num_of_units = ? WHERE medicine_name = ?";
                    try (PreparedStatement updateStmt = myConn2.prepareStatement(updateSql)) {
                        updateStmt.setInt(1, updatedQuantity);
                        updateStmt.setString(2, medicine_name);
                        int rowsAffected = updateStmt.executeUpdate();
                        System.out.println("Rows affected by update: " + rowsAffected);
                        System.out.println("Quantity updated in the database.");
                    }
                }
            } 
            else 
            {
                available1 =false;
                // Medicine does not exist, proceed with the insertion or other actions
                System.out.println("Medicine does not exist. Proceeding with the insertion...");
            }
            if (available1 && available2 && available3) {
            System.out.println("This medcine is available.Thanks for purchasing from us.");
            try (Connection myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sold_medicines", "root", "abdullah123")) {
                String insertSql = "INSERT INTO sold (medicine_id, medicine_name, no_of_units, company_name, price_per_unit) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement insertStmt = myConn1.prepareStatement(insertSql)) {
                    insertStmt.setString(1, medicine_id);
                    insertStmt.setString(2, medicine_name);
                    insertStmt.setString(3, num_of_units);
                    insertStmt.setString(4, company_name);
                    insertStmt.setString(5, price_per_unit);

                    int rowsAffected = insertStmt.executeUpdate();
                    System.out.println("Rows affected by insert into sold: " + rowsAffected);
                    System.out.println("Entries inserted into the 'sold' database.");
                }
        }
    }
            else
            {
                System.out.println("Sorry for contacting but this medcine is not available");
            }
        }
        catch (SQLException ex) {
        ex.printStackTrace();
        // Handle the exception, e.g., show an error message to the user
        System.out.println("Error in main");
    }
    }       catch (SQLException ex) {
                Logger.getLogger(Pharmacyy.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
  }
}
