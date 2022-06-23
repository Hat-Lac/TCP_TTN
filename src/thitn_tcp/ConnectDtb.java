/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitn_tcp;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
class ConnectDtb {
    public static int getsoSV(String str) throws SQLException{
        int dem = 0;
        Connection conn = connectSQL();
        // dem so sinh vien trong bang SV
        String sql = "select count(*) from SINHVIEN where MASV='" + str + "'";
        PreparedStatement ptsm = conn.prepareStatement(sql); // truy van tham so 
        ResultSet rs = ptsm.executeQuery();
        if(rs.next()){
            dem = rs.getInt(1);
        }
        return dem;       
    }
    
    public static String getMSV(String str) throws SQLException{
        String idSV = "";
        Connection conn = connectSQL();
        //chon ban tin neu username = ...
        String sql = "select * from SINHVIEN where Username = '" + str + "'";
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();
        if(rs.next()){
            idSV = rs.getString(1);
        }
        return idSV;       
    }
    
    public static String getAllCH() throws SQLException{
        List<Cauhoi> listCH = new ArrayList<Cauhoi>();
        int[] soCau = new int[100];
        Arrays.fill(soCau, 0);
        Connection conn = connectSQL();
        String sql = "select * from BOCAUHOI";
        Random rand = new Random(); 
        int dem=0;
        while(dem<10){
            int k = rand.nextInt(220);
            if(soCau[k]!=1){
                soCau[k] = 1;
                dem++;
            }
        }
        dem=-1;
        String str="";
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();
        while(rs.next()){
            dem++;
            if(soCau[dem]>0){
                str+=rs.getString("CAUHOI");
                str+="///";
                str+=rs.getString("TRINHDO");
                str+="///";
                str+=rs.getString("NOIDUNG");
                str+="///";
                str+=rs.getString("A");
                str+="///";
                str+=rs.getString("B");
                str+="///";
                str+=rs.getString("C");
                str+="///";
                str+=rs.getString("D");
                str+="///";
                str+=rs.getString("DAP_AN");
                str+="///";
            }
        }
        return str;
    }
    
    public static boolean getThongtin(String MASV, String ten, String sdt, int Diem) throws SQLException{
        boolean check = false;
        Connection conn = connectSQL();
        String sql = "insert into SINHVIEN(MASV, HOTEN, SDT, DIEM) value ('"+MASV+"','"+ten+"','"+sdt+"',"+Diem+")";
        
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ptsm.executeUpdate();
        if(conn != null){
            check = true;
        }
        return check;
    }
    // lay dl tu ban phim
    public static boolean getTHONGTIN(String str) throws SQLException{
        boolean check = false;
        Connection conn = connectSQL();
        String[] arrStr = str.split("///");
        System.out.println(arrStr[0]+arrStr[1]+arrStr[2]);
        String sql = "insert into SINHVIEN(MASV,HOTEN,SDT,DIEM) values ('"+arrStr[1]+"','"+arrStr[0]+"',"+arrStr[2]+")";        
        
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ptsm.executeUpdate();
        if(conn!=null){
            check= true;
        }
        return check;
    }
    
    public static void insertData(String maSV, int core) throws SQLException {
        Connection conn = connectSQL();
        String time; // 
        LocalDateTime now = LocalDateTime.now();
        String idSV = getMSV(maSV);
        int dem = getsoSV(idSV)+1;
        time = now.toString();
        String sql = "insert into SINHVIEN(MASV,DIEM) values ('"+idSV+"'+'"+core+"')";
        System.out.println(sql);
        
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ptsm.executeLargeUpdate();
    }
    
    public static boolean getConnect(String str) {
        boolean check = false;
        Connection conn = null;
        String[] arrStr = str.split("///");
        System.out.println(arrStr[0]+arrStr[1]+arrStr[2]);
        String ServerName = arrStr[0];
        String name = arrStr[1];
        String pass = arrStr[2];
        String url = "jdbc:sqlserver://"+ServerName+";databaseName=KIEMTRALTM";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, name, pass); 
            if (conn != null) {
            System.out.println("Connected");
            check = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return check;
        //return conn;
    }

    private static Connection connectSQL() throws SQLException {
        Connection conn = null;
        try {
            String userName = "sa";
            String password = "123";
            String URL = "jdbc:sqlserver://localhost:1433;databaseName=KIEMTRALTM;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, userName, password);
            System.out.println("Ket noi thanh cong!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Ket noi that bai!");
            return null;
        }
        
    }
    
    public static void main(String[] args) {
        
    }
    static void getTHONGTIN(String masv, String ten, String sdt, String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
