/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

import java.io.IOException;

/**
 *
 * @author HUNG
 */
public class test {
    public static void main(String[] args) throws IOException {
        Danhsachhoadon a=new Danhsachhoadon();
        a.Nhap();
        a.Ghifile("Hoadon.txt");
        a.Docfile("Hoadon.txt");
        a.Xuat();
    }
    
}
