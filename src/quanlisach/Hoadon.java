/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

/**
 *
 * @author HUNG
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Hoadon {
private String mahoadon; 
private String makhachhang; 
private String manhanvien; 
private String ngaylaphoadon; 
private float tongtien;
public Hoadon(){}
public Hoadon(String mahoadon,String makhachhang,String manhanvien,String ngaylaphoadon,float tongtien)
{
    this.mahoadon = mahoadon; 
    this.makhachhang = makhachhang;
    this.manhanvien = manhanvien; 
    this.ngaylaphoadon = ngaylaphoadon;
    this.tongtien = tongtien;
}
public Hoadon(Hoadon hd)
{
    this.mahoadon = hd.mahoadon; 
    this.makhachhang = hd.makhachhang;
    this.manhanvien = hd.manhanvien; 
    this.ngaylaphoadon = hd.ngaylaphoadon;
    this.tongtien = hd.tongtien;
}
public float Tongthanhtoan(String mahoadon1) throws IOException {
		Danhsachchitiethoadon dscthd = new Danhsachchitiethoadon();
		dscthd.Docfile("Chitiethoadon.txt");
		int dscthdLength = dscthd.n;
		int tongCong = 0;
		for (int i=0; i<dscthdLength; i++) {
			if (dscthd.dscthd[i].getMahoadon().equals(mahoadon1)) {
				tongCong += dscthd.dscthd[i].getThanhtien();
			}
		}
		return tongCong;
	}
public void Nhap() throws IOException
{
    Scanner sc = new Scanner (System.in);
    System.out.println("Nhap ma hoa don");
    mahoadon = sc.nextLine();
    System.out.println("Nhap ma khach hang:");
    makhachhang = sc.nextLine();
    System.out.println("Nhap ma nhan vien:");
    manhanvien = sc.nextLine();
    System.out.println("Nhap ngay lap hoa don:");
    ngaylaphoadon = sc.nextLine();
    this.tongtien=Tongthanhtoan(this.mahoadon);
}
public void Xuat(){
    System.out.printf("\n|%-30s|%-30s|%-30s|%-30s|%-30f|",mahoadon,makhachhang,manhanvien,ngaylaphoadon,tongtien);
}
public String getMahoadon()
{
    return mahoadon;
}
public String getMakhachhang()
{
    return makhachhang;
}
public String getManhanvien()
{
    return manhanvien;
}
public String getNgaylaphoadon()
{
    return ngaylaphoadon;
}
public float getTongtien()
{
    return tongtien;
}
public void setMahoadon(String mahoadon)
{
    this.mahoadon = mahoadon ;
}
public void setMakhachhang (String makhachhang)
{
    this.makhachhang = makhachhang ;
}
public void setManhanvien(String manhanvien)
{
    this.manhanvien = manhanvien ;
}
public void setNgaylaphoadon(String ngaylaphoadon)
{
    this.ngaylaphoadon =  ngaylaphoadon ;
}
public void setTongtien(float tongtien)
{
    this.tongtien = tongtien ;
}
void Ghifile(String filename) 
{
        try{
            DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename,true));
            outstream.writeUTF(this.mahoadon);
            outstream.writeUTF(this.makhachhang);
            outstream.writeUTF(this.manhanvien);
            outstream.writeUTF(this.ngaylaphoadon);
            outstream.writeFloat(this.tongtien);
            outstream.close();
            
        }
        catch(IOException e)
        {
            System.out.println("Error "+e.getMessage()+"\n");
        }
    }
    
}