/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HUNG
 */
public class Danhsachphieunhap implements Danhsach{
    public int n ;
    public Phieunhap[] dspn = new Phieunhap[1];
    public Danhsachphieunhap(){
    }
    public Danhsachphieunhap(Phieunhap[] a,int n){
        this.n = n;
        this.dspn = Arrays.copyOf(a, n);
    }
    public Danhsachphieunhap(Danhsachphieunhap ds){
        this.n = ds.n;
        this.dspn = Arrays.copyOf(ds.dspn,n);
    }
    public void Nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("nhap vao so luong phieu nhap hang :");
        this.n = in.nextInt();
        dspn = Arrays.copyOf(dspn,n);
        for(int i = 0 ; i < n ; i++)
        {
            dspn[i] = new Phieunhap();
            dspn[i].Nhap();
        }
        
    }
      public void Xuat(){
       System.out.printf("%-160s\n","_______________________________________________________________________________________________________________________________________________________________________");

        
             System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n","Ma phieu nhap","Ma sach","Ngày nhap hang","So luong","Don gia","Tong tien","Ma nha cung cap","Ma nhan vien"); 

        System.out.printf("%-160s\n","-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
            
         for(int i = 0 ; i < n ; i++)
        {
            dspn[i].Xuat();
         System.out.printf("%-160s\n","-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                       
        }
    }
    public void xoavt(int vitrixoa){
        for(int i = vitrixoa ; i < n -1 ; i++)
        {
            dspn[i] = dspn[i+1];
        }
        dspn = Arrays.copyOf(dspn,n-1);
        n--;
    }
    public void Xoatheoma(String ma){
        for(int i = 0 ; i < n ; i++)
        {
            if(dspn[i].getMaphieunhap().equals(ma))
            {
                xoavt(i);
            }
        }
    }
    public void Them(){
        dspn = Arrays.copyOf(dspn,n+1);
        dspn[n] = new Phieunhap();
        dspn[n].Nhap();
        n++;
    }
    
    public void Themk(int k)
    {
        for(int i=0;i<k;i++)
        {
            Them();
        }
    }
    public void Suatheoma(String ma)
    {
        int vt = -1 ;
        for(int i = 0 ; i < n ; i++)
        {
           if(ma.equals(dspn[i].getMaphieunhap()))
               vt = i;
        }
        if(vt == -1)
        {
            System.out.println("Khong tim thay ma can sua !");
        }
        else
        {
                    String maphieunhap;
                     String masach;
                    String ngaynhap;
                    int soluong;
                    float dongia;
                    float tongtien;
                   String manhanvien;
                   int luachon;
                   Scanner sc = new Scanner(System.in);
               while(true)
               {
                   System.out.println("Nhap 1 de sua ma phieu nhap");
                   System.out.println("Nhap 2 de sua ma sach");
                   System.out.println("Nhap 3 de sua ngay nhap");
                   System.out.println("Nhap 4 de sua so luong nhap ");
                   System.out.println("Nhap 5 de sua don gia");
                   System.out.println("Nhap 6 de sua tong tien ");
                   System.out.println("Nhap 7 de sua ma nhan vien");
                   System.out.println("Nhap 0 de thoat");
                   System.out.println("Moi ban nhap lua chon cua minh :");
                   luachon = sc.nextInt();
                   sc.nextLine();
                   if(luachon == 0)
                   {
                       break;
          
                   }
                   else if(luachon == 1)
                   {
                       System.out.println("Moi ban nhap ma phieu nhap moi :");
                       maphieunhap = sc.nextLine();
                       dspn[vt].setMaphieunhap(maphieunhap);
                   }
                   
                   else if(luachon == 2)
                   {
                       System.out.println("Moi ban nhap ma sach moi :");
                       masach = sc.nextLine();
                       dspn[vt].setMasach(masach);
                   }
                   else if(luachon == 3)
                   {
                       System.out.println("Moi ban nhap ngay nhap hang ");
                       ngaynhap = sc.nextLine();
                       dspn[vt].setNgaynhap(ngaynhap);
                   }
                   else if(luachon == 4)
                   {
                       System.out.println("Moi ban nhap so luong");
                       soluong = sc.nextInt();
                       dspn[vt].setSoluong(soluong);
                   }
                   else if(luachon == 5)
                   {
                       System.out.println("Moi ban nhap don gia");
                       dongia = sc.nextFloat();
                       dspn[vt].setDongia(dongia);
                   }
                   else if(luachon == 6)
                   {
                       System.out.println("Moi ban nhap tong tien");
                       tongtien = sc.nextFloat();
                       dspn[vt].setTongtien(tongtien);
                               
                   }
                   else if(luachon == 7)
                   {
                       System.out.println("Nhap ma nhan vien moi ");
                       manhanvien = sc.nextLine();
                       dspn[vt].setManhanvien(manhanvien);
                   }
                   
               }
        }
    }
   public void Timkiemtheoma(String ma)
   {
       for(int i = 0 ; i < n ; i++)
       {
           if(dspn[i].getMaphieunhap().equals(ma))
           {
               dspn[i].Xuat();
           }
       }
   }
   public void Menu() throws IOException{
        Scanner in = new Scanner(System.in);
            Docfile("Phieunhap.txt");
		 boolean exit = false;
		 String option = "";
		 while (!exit) {
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			 System.out.println("|       MENU PHIEU NHAP              |");
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			 System.out.println("|1. Xuat danh sach phieu nhap        |");
			 System.out.println("|2. Them 1 phieu nhap                |");
			 System.out.println("|3. Them k phieu nhap                |");
			 System.out.println("|4. Sua mot phieu nhap               |");
			 System.out.println("|5. Xoa mot phieu nhap               |");
			 System.out.println("|0. Thoat va luu                     |");
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			 System.out.print("Lua chon: ");
			 option = in.nextLine();
			 switch (option) {
			 	case "1":
			 		this.Xuat();
			 		break;
			 	case "2":
			 		this.Them();
                                    this.Ghifile("Phieunhap.txt");
			 		break;
			 	case "3":
                                    int k;
                                    System.out.println("Moi ban vao so luong can them");
                                    k = in.nextInt();
                                    this.Themk(k);
                                    this.Ghifile("Phieunhap.txt");
                                    break;
			 		
			 	case "4":
                                    System.out.println("Moi ban nhap ma can sua");
                                        String ma1 = in.nextLine();
                                    this.Suatheoma(ma1);
                                    this.Ghifile("Phieunhap.txt");
			 		break;
			 	case "5":
                                        System.out.println("Moi ban nhap ma can sua");
                                        String ma = in.nextLine();
			 		this.Xoatheoma(ma);
                                        this.Ghifile("Phieunhap.txt");
                                        break;
			 	
			 	case "0":
			 		exit = true;
			 		this.Ghifile("Phieunhap.txt");
			 		break;
			 	default:
			 		System.out.println("NHAP SAI LUA CHON. MOI CHON LAI.");
			 		break;
			 }
			 System.out.println("----------");
		 }
	 }
    public void Ghifile(String filename) throws FileNotFoundException, IOException{
       DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
       for(int i = 0 ; i < n ; i++)
       {
           dspn[i].Ghifile(filename);
       }
       outstream.close();
   }
   public void Docfile(String filename) throws FileNotFoundException, IOException
   {
       
       int i = 0 ; 
       n = 0;
       try{
           DataInputStream instream = new DataInputStream(new FileInputStream(filename));
           try{
               while(true){
                   String idpn = instream.readUTF();
                   String masach = instream.readUTF();
                   String ngaynhap = instream.readUTF();
                   int number = instream.readInt();
                   float dongia = instream.readFloat();
                   float tongtien = instream.readFloat();
                   String idnhacungcap = instream.readUTF();
                   String idnhanvien = instream.readUTF();
                   dspn = Arrays.copyOf(dspn,n+1);
                   dspn[i] = new Phieunhap(idpn,masach,ngaynhap,number,dongia,tongtien,idnhacungcap,idnhanvien);
                   i++;
                   n++;
               }
           }
           catch(EOFException e){
           }
           finally{
               instream.close();
           }
           
       } catch(FileNotFoundException e){
               System.out.println("IOERROR"+filename+"NOT FOUND");
               
        }
       catch(IOException e){
               System.out.println("IOERROR"+e.getMessage()+"\n");
               }
   }
}

