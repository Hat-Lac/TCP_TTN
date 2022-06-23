/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitn_tcp;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Input {
    public static String input_String() {
        String str = null;
        
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        while(!check){
            try {
                str = sc.nextLine();
                check = true;
            } catch (Exception e) {
                check = false;
                e.printStackTrace();
            }
        }
        return str;
    }
    
    public static int input_Int() {
        int n = 0;
        
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        while(!check){
            try {
                n = Integer.parseInt(sc.nextLine());
                check = true;
            } catch (Exception e) {
                check = false;
                System.out.println("Nhap sai. Vui long nhap lai!");
            }
        }
        return n;
    }
    
    public static float input_Float() {
        float f = 0;
        
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        while(!check){
            try {
                f = Float.parseFloat(sc.nextLine());
                check = true;
            } catch (Exception e) {
                check = false;
                e.printStackTrace();
            }
        }
        return f;
    }
}
