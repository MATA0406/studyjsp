package test01;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ConnUtil {

    private static ConnUtil instance = new ConnUtil();

    public static ConnUtil getInstatnce() {
        return instance;
    }

    private ConnUtil() {
    }

    private Connection getConnection() {//
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://192.168.137.128:3306/jsptest?" +
                    "user=moving33&password=1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("connecting �꽦怨�");
        return conn;
    }

    //db �젒�냽 醫낅즺 method
    void stop(Connection conn) {


        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        System.out.println("connecting 醫낅즺..");
    }

    //db insert
    public int InsertData(String name, String jumin, StringBuffer tel, String gender, StringBuffer hobby) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int x = 0;
        try {
            conn = getConnection();
            //以묐났�솗�씤
            pstmt = conn.prepareStatement("SELECT * FROM manager WHERE jumin=?");
            pstmt.setString(1,jumin);
            rs = pstmt.executeQuery();
            if(rs.next()){
                x=-1;
                return x;
            }
            pstmt = conn.prepareStatement("INSERT INTO manager(name, jumin, tel, gender, hobby) " +
                    "VALUES (?,?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, jumin);
            pstmt.setString(4, gender);
            pstmt.setString(3, tel.toString());
            pstmt.setString(5, hobby.toString());
            x = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
        }
        return x;
    }

    //listview 媛��졇�삤湲�
    public ObservableList<Client> getList() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        ObservableList<Client> clients = FXCollections.observableArrayList();


        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("SELECT * from manager ORDER BY manager.name ASC");
            rs = pstmt.executeQuery();
            if(rs == null){
                return clients;
            }
            while (rs.next()) {
                Client client = new Client();
                client.setName(rs.getString(2));
                client.setJuminNum(rs.getString(3));
                client.setTel(rs.getString(4));
                client.setGender(rs.getString(5));
                client.setHobby(rs.getString(6));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
        }

        return clients;

    }

    //db modify
    public int ModifyData(StringBuffer tel, StringBuffer hobby,String jumin) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int x = 0;
        try {
            conn = getConnection();
            pstmt= conn.prepareStatement("UPDATE manager SET tel=?,hobby=? WHERE jumin=?");
            pstmt.setString(1,tel.toString());
            pstmt.setString(2,hobby.toString());
            pstmt.setString(3,jumin);
            x =pstmt.executeUpdate();
        } catch (SQLException e) {


        } finally {
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            return x;
        }
    }

    //db delete
    public void deleteData(String jumin){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement("DELETE FROM manager WHERE jumin=?");
            pstmt.setString(1,jumin);
            pstmt.executeUpdate();
        }catch (SQLException e){e.printStackTrace();
        }finally {
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
        }
    }
}
