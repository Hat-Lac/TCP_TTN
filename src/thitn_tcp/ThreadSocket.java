/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitn_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
public class ThreadSocket extends Thread {

    Socket socket;
    int diem = 0;

    public ThreadSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //luong nhan dl tu ban phim
            DataInputStream disSv = new DataInputStream(System.in);
            //luong nhan dl tu client
            DataInputStream disCl = new DataInputStream(socket.getInputStream());
            //luong ui dl toi client
            DataOutputStream dosCl = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String strCl = disCl.readUTF();// lay dl tu client in ra mh
                System.out.println("\nClient: " + strCl);
                System.out.println("\nServer: ");

                String strSV = disSv.readUTF();// ;ay dl tu ban [him va gui ve clirnt
                dosCl.writeBytes(strSV + "\n");

                String str = ConnectDtb.getAllCH();
                dosCl.writeUTF(str);
                String[] cauhoi = str.split("///");
                String anwClient = disCl.readUTF();
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
                dosCl.writeUTF(answer);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
