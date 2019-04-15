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
import java.util.*;

class Nhanvien {
private String manhanvien;
private String tennhanvien;
private String ngaysinh; 
private String luong;
private String taikhoan;
private String password;
private String quyen;
public Nhanvien(){}
public Nhanvien(String manhanvien, String tennhanvien, String ngaysinh, String luong,String taikhoan,String password,String quyen)
{
    this.manhanvien = manhanvien;
    this.tennhanvien = tennhanvien; 
    this.ngaysinh = ngaysinh; 
    this.luong = luong;
    this.taikhoan = taikhoan;
    this.password = password;
    this.quyen = quyen;
}
public Nhanvien(Nhanvien nv)
{
    this.manhanvien = nv.manhanvien; 
    this.tennhanvien = nv.tennhanvien;
    this.ngaysinh = nv.ngaysinh; 
    this.luong = nv.luong; 
    this.taikhoan = nv.taikhoan;
    this.password = nv.password;
    this.quyen = nv.quyen;
}
public void Nhap()
{
    Scanner sc = new Scanner (System.in);
    System.out.println ("Nhap ma nhan vien:");
    manhanvien = sc.nextLine();
    System.out.println ("Nhap ten nhan vien:"); 
    tennhanvien = sc.nextLine();
    System.out.println ("Nhap ngay sinh:"); 
    ngaysinh = sc.nextLine();
    System.out.println ("Nhap luong:");
    luong = sc.nextLine();  
    System.out.println("Nhap vao tai khoan nhan vien");
    taikhoan = sc.nextLine();
    System.out.println("Nhap vao password ");
    password = sc.nextLine();
    System.out.println("Nhap vao quyen cua nhan vien:");
    quyen = sc.nextLine();
}
public void Xuat()
{
    System.out.printf("\n|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|",manhanvien,tennhanvien,ngaysinh,luong,taikhoan,password,quyen);
}
public String getManhanvien()
{
    return manhanvien;
}

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }
public String getTennhanvien()
{
    return tennhanvien;
}
public String getNgaysinh()
{
    return ngaysinh;
}
public String getLuong()
{
    return luong;
}
public void setManhanvien (String manhanvien)
{
    this.manhanvien = manhanvien;
}
public void setTennhanvien (String tennhanvien)
{
    this.tennhanvien = tennhanvien;
}
public void setNgaysinh (String ngaysinh)
{
    this.ngaysinh = ngaysinh;
}
public void setLuong(String luong)
{
    this.luong = luong;
}
void Ghifile(String filename) 
{
        try{
            DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename,true));
            outstream.writeUTF(this.manhanvien);
            outstream.writeUTF(this.tennhanvien);
            outstream.writeUTF(this.ngaysinh);
            outstream.writeUTF(this.luong);
            outstream.writeUTF(this.taikhoan);
            outstream.writeUTF(this.password);
            outstream.writeUTF(this.quyen);
            outstream.close();
            
        }
        catch(IOException e)
        {
            System.out.println("Error "+e.getMessage()+"\n");
        }
    }
    
}