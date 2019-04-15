/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HUNG
 */
public class Loaigiamgia {
  private String maloaigiamgia;
  private float sophantram;
    public Loaigiamgia(){}
    public Loaigiamgia(String maloaigiamgia,float sophantram)
    {
        this.maloaigiamgia=maloaigiamgia;
        this.sophantram=sophantram;
    }
    public Loaigiamgia(Loaigiamgia lgg)
    {
        maloaigiamgia=lgg.maloaigiamgia;
        sophantram=lgg.sophantram;
    }
    public void Nhap()
    {
        Scanner nhap=new Scanner(System.in);
        System.out.println("\nNhap ma loai giam gia:");
            maloaigiamgia=nhap.nextLine();
        System.out.println("Nhap vao so phan tram giam gia: ");
            sophantram=nhap.nextFloat();
    }
    public void Xuat()
    {
        System.out.printf("\n|%-20s|%-20s|",maloaigiamgia,sophantram+"%");
    }
    public float getSophantram()
    {
        return sophantram;
    }
    public void setSophantram(float sophantram)
    {
        this.sophantram=sophantram;
    }
    public String getMaloaigiamgia() {
        return maloaigiamgia;
    }
    public void setMaloaigiamgia(String maloaigiamgia) {
        this.maloaigiamgia = maloaigiamgia;
    }
    
    public void Ghifile(String filename)
    {
        try{
            DataOutputStream outstream=new DataOutputStream(new FileOutputStream(filename,true));
            outstream.writeUTF(maloaigiamgia);
            outstream.writeFloat(sophantram);
            outstream.close();
        }catch(IOException e)
        {
            System.out.println("IOERROR"+e.getMessage()+"\n");
        }
    }
}
