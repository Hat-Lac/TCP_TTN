/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitn_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Server {

    public static void Setthongtin() throws IOException {
        int core = 0;
        ServerSocket server = new ServerSocket(2208);
        System.out.println("Thi trac nghiem already.....");

        Socket conn = server.accept();
        DataInputStream dis = new DataInputStream(conn.getInputStream());
        String str = dis.readUTF();
        String[] arrStr = str.split("///");
        System.out.println(str);

        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
        if (true) {
            dos.writeUTF("Success!");
        } else {
            dos.writeUTF("Fail!");
        }
        conn.close();
        dis.close();
        dos.close();
    }

    public static void Luuthongtin() throws IOException, SQLException {
        int core = 0;
        ServerSocket server = new ServerSocket(2209);
        System.out.println("Thi trac nghiem already.....");

        Socket conn = server.accept();
        DataInputStream dis = new DataInputStream(conn.getInputStream());
        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

        String str = dis.readUTF();
        ConnectDtb.getTHONGTIN(str);

        String ansClient = dis.readUTF();
        System.out.println(ansClient);
        System.out.println(str);

        server.close();
        String[] arrStr = str.split("///");
        System.out.println(str);

    }

    public static void ThiTN() throws IOException, SQLException {
        int diem = 0;
        // tao svsocket
        ServerSocket server = new ServerSocket(2207);
        System.out.println("Thi trac nghiem already....");

        Socket conn = server.accept();
        DataInputStream dis = new DataInputStream(conn.getInputStream());
        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

        //lay cau hoi dua cho client
        String str = ConnectDtb.getAllCH();
        dos.writeUTF(str);
        String[] CH = str.split("///");
        //nhan cay tl tu client
        String ansClient = dis.readUTF();
        System.out.println(ansClient);

        String[] arrTL = ansClient.split("///");
        int dem = 0;
        String answer = "";
        for (int i = 0; i < arrTL.length; i = i + 2) {
            dem++;
            answer += dem + " " + arrTL[i] + " - " + CH[(dem * 8) - 1] + "\n";
            if (arrTL[i].equals(CH[(dem * 8) - 1])) {
                diem++;
            }
        }
        answer += "Diem cua ban la: " + diem;
        dos.writeUTF(answer);
    }

    public static void xacthucDN() throws IOException {
        ServerSocket server = new ServerSocket(2206);
        System.out.println("Server aldready...");
        while (true) {
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Server đã kết nối được với client!");
            String str = dis.readUTF();
            String[] arrStr = str.split("///");

            if (ConnectDtb.getConnect(str)) {
                dos.writeUTF("Success");
            } else {
                dos.writeUTF("Fail");
            }
            server.close();
        }
    }

    public void FirstF() throws IOException {

        ServerSocket ss = new ServerSocket(1433);
        System.out.println("Server aldready...");
        while (true) {
            Socket socket = ss.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Server đã kết nối được với client!");
            ss.close();
        }
    }

    public void layketquaa() throws SQLException {
        LayCH_server.Laycauhoi();
    }

    public static void main(String[] args) throws SQLException, IOException {
        xacthucDN();
        Setthongtin();
        ThiTN();
        try {
            ServerSocket server = new ServerSocket(2207);
            System.out.println("Server is running....");
            while (true) {
                new ThreadSocket(server.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        LayCH_server.Laycauhoi();
        String str = ConnectDtb.getAllCH();
        System.out.println(str);
    }

}
