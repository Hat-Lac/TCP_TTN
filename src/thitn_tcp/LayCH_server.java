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
class LayCH_server {

    public static void Laycauhoi() throws SQLException {
        int diem = 0;
        try {
            ServerSocket server = new ServerSocket(2207);
            System.out.println("ThiTracNghiem aldready...");

            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String str = ConnectDtb.getAllCH();
            dos.writeUTF(str);
            String[] cauhoi = str.split("///");
            String anwClient = dis.readUTF();
            System.out.println(anwClient);

            String[] arrAnw = anwClient.split("///");
            int dem = 0;
            String answer = "";
            for (int i = 1; i < arrAnw.length; i = i + 2) {
                dem++;
                answer += dem + " " + arrAnw[i] + " - " + cauhoi[(dem * 8) - 1] + "\n";
                if (arrAnw[i].equals(cauhoi[(dem * 8) - 1])) {
                    diem++;
                }
            }
            answer += "Diem cua ban la: " + diem;
            DapAn.diem = diem;
            dos.writeUTF(answer);

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(diem);
    }
}
