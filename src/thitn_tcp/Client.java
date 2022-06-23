/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitn_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Client {
    // lay dl dau vao
    public static String inputLogin() {
        String str = "";
        System.out.println("Nhap tai khoan: ");
        str += Input.input_String();
        str += "///";
        System.out.println("Nhap mat khau: ");
        str += Input.input_String();
        str += "///";
        return str;
    }
    
    //thi tn
    private static void Thitracnghiem() throws IOException {
        Socket client = new Socket("localhost", 2207);
        
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        Cauhoi CH = new Cauhoi();
        // lay cau hoi
        String strTN = dis.readUTF();
        String[] arrStr = strTN.split("///");
        List<Cauhoi> listCH = new ArrayList<Cauhoi>();
        int dem = 0;
        for (int i = 0; i < arrStr.length;) {
            //10 cau hoi
            if(dem < 10){
                CH = new Cauhoi();
                CH.setSocau(Integer.parseInt(arrStr[i]));
                CH.setTrinhdo(arrStr[i+1]);
                CH.setNoidung(arrStr[i+2]);
                CH.setCauA(arrStr[i+3]);
                CH.setCauB(arrStr[i + 4]);
                CH.setCauC(arrStr[i + 5]);
                CH.setCauD(arrStr[i + 6]);
                CH.setDapAn(arrStr[i + 7]);
                listCH.add(CH);
                i = i + 8;
            }
            dem++;
        }
        dem = 0;
        String anwClient = "";
        boolean check = true;
        for (Cauhoi cauhoi : listCH) {
            dem++;
            System.out.println("Cau " + dem + ": " + cauhoi.getNoidung());
            System.out.println("A. " + cauhoi.getCauA());
            System.out.println("B. " + cauhoi.getCauB());
            System.out.println("C. " + cauhoi.getCauC());
            System.out.println("D. " + cauhoi.getCauD());
            System.out.println("Nhap dap an: ");
            check = true;
            while (check) {                
                String ans = Input.input_String();
                if(ans.equals("A")||ans.equals("B")||ans.equals("C")||ans.equals("D")){
                    anwClient += dem + "///";
                    anwClient += ans + "///";
                    check = false;
                } else {
                    System.out.println("Nhapsai. Vui long nhap lai!");
                }
            }
        }
        dos.writeUTF(anwClient);
        String answer = dis.readUTF();
        System.out.println(answer);
    }

    // dang nhap
    public static void Login() throws IOException{
        boolean checkAthu = false;
        while (!checkAthu) {            
            //tao socket
            Socket client = new Socket("localhost", 2206);
            //gui dl den server
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            String str = inputLogin();
            dos.writeUTF(str);
            //nhan dl
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String strAthu = dis.readUTF();
            if(strAthu.equals("Success!")){
                System.out.println("Dang nhap thanh cong");
                checkAthu = true;
                Thitracnghiem();
            } else {
                System.out.println("Dang nhap khong thanh cong");
            }

        }
    }
    //chon chuc nang 
    public static void main(String[] args) throws IOException {
        int choice = 0;
        while (true) {            
            System.out.println("1.Xin moi chon dang nhap!");
            System.out.println("0. Thoat");
            choice = Input.input_Int();
            switch(choice){
                case 1: 
                    Login();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Moi nhap lai.");
                    break;
            }
        }
    }

    
}
