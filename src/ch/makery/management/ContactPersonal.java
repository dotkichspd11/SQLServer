package ch.makery.management;


import java.sql.*;
import java.util.ArrayList;

import ch.makery.management.model.Personal;

public class ContactPersonal implements ConnectSQL {
	Personal student =new Personal();
    public ArrayList<Personal> getData() {
        ArrayList<Personal> people=new ArrayList<Personal>();
        try {
            Connection conn = ConnectSQL.getConnection(DB_URL,USER_NAME,PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select list.stt,list.fistname, list.lastname,list.username, "
            		+ "list.passwordd,list.mathematic,list.physic,sv.average, sv.nickname,sv.rage from SV join list on SV.stt= list.STT ");
            while (rs.next()) {
            	Personal student=new Personal();
            	student.setI1(rs.getInt("stt"));
            	student.setS1(rs.getString("fistname"));
            	student.setS2(rs.getString("lastname"));
            	student.setS3(rs.getString("username"));
            	student.setS4(rs.getString("passwordd"));
            	student.setS5(rs.getString("mathematic"));
            	student.setI2(rs.getString("average"));
            	student.setS6(rs.getString("nickname"));
            	student.setS7(rs.getString("rage"));
            	student.setS8(rs.getString("physic"));
                people.add(student);
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println("ERROR_");
            ex.printStackTrace();
        }
        return people;
    }


    public static void deleteData(Personal student) {

        try {
            Connection conn = ConnectSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
            String sq = "DELETE FROM SV where stt=? DELETE FROM list where STT=? ";
            
            PreparedStatement statement = conn.prepareStatement(sq);
            statement.setInt(1,student.getI1());

            statement.setInt(2,student.getI1());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A Presonal was deleted successfully!");
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
//    public void updateData(Personal student) throws  SQLException {
//        Connection conn = ConnectSQL.getConnection(DB_URL, USER_NAME, PASSWORD);
//        String sql = "UPDATE list SET   fistname=?, lastname=? WHERE STT=? UPDATE SV SET  age = ?, idertiferNumber= ? ,city=?, birthday = ?, average=? WHERE stt=?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, student.getS1());
//        statement.setString(2, student.getS2());
//        statement.setInt(3,student.getI1());
//        statement.setInt(4, student.getI2());
//        statement.setInt(5, student.getI3());
//        statement.setString(6, student.getS3());
//        statement.setString(7, student.getS4());
//        statement.setString(8,student.getS5());
//        statement.setInt(9,student.getI1());
//        int rowsInserted = statement.executeUpdate();
//        if (rowsInserted > 0) {
//            System.out.println("This Student was updated successfully!");
//        }
//        conn.close();
//    }
}