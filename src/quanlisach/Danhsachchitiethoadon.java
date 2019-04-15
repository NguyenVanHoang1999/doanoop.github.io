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
public class Danhsachchitiethoadon implements Danhsach{
    public int n;
    public Chitiethoadon[] dscthd = new Chitiethoadon[1];
    public Danhsachchitiethoadon(){}
    public Danhsachchitiethoadon(Chitiethoadon[] dscthd,int n) {
        this.n = n;
        this.dscthd = Arrays.copyOf(dscthd, n);
        
    }
    public Danhsachchitiethoadon(Danhsachchitiethoadon ds)
    {
        this.n = ds.n;
        this.dscthd = Arrays.copyOf(ds.dscthd, n);
    }
    public void Nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap vao so luong chi tiet hoa don :");
        this.n = in.nextInt();
        dscthd = Arrays.copyOf(dscthd,n);
        for(int i = 0 ; i < n ; i++)
        {
            dscthd[i] = new Chitiethoadon();
            dscthd[i].Nhap();
        }
        
    }
    public void Xuat(){
       System.out.printf("%-100s\n","________________________________________________________________________________________________________");

        
                System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|\n","Ma hoa don","Ma sach","So luong","Don gia","Thanh tien");   

        System.out.printf("%-100s\n","----------------------------------------------------------------------------------------------------------");
        
            
         for(int i = 0 ; i < n ; i++)
        {
            dscthd[i].Xuat();
         System.out.printf("%-100s\n","----------------------------------------------------------------------------------------------------------");
                       
        }
    }
    public void Xoavt(int vitrixoa){
        for(int i = vitrixoa ; i < n -1 ; i++)
        {
            dscthd[i] = dscthd[i+1];
        }
        dscthd = Arrays.copyOf(dscthd,n-1);
        n--;
    }
    public void Xoatheoma(String ma){
        for(int i = 0 ; i < n ; i++)
        {
            if(dscthd[i].getMahoadon().equals(ma))
            {
                Xoavt(i);
            }
        }
    }
    public void Them(){
        dscthd = Arrays.copyOf(dscthd,n+1);
        dscthd[n] = new Chitiethoadon();
        dscthd[n].Nhap();
        n++;
    }
    public void Themk(int k)
    {
        for(int i = 0 ; i < n ; i++)
        {
            Them();
        }
    }
   public void Timkiemtheoma(String ma)
   {
       for(int i = 0 ; i < n ; i++)
       {
           if(dscthd[i].getMahoadon().equals(ma))
           {
               System.out.println(dscthd[i].toString());
           }
       }
   }
     public void Suatheoma(String ma){
    	 Scanner in = new Scanner(System.in);
    	 String mahdmoi;
    	 String masachmoi;
    	 int soluongmoi;
    	 int dongiamoi;
    	 for(int i=0;i<n;i++)
    	 {
    		 if(dscthd[i].getMahoadon().equals(ma))
    		 {
    			 int luachon;
    			 while(true)
    			 {
    				 System.out.println("\n1.Sua ma hoa don.");
    				 System.out.println("\n2.Sua ma sach.");
    				 System.out.println("\n3.Sua so luong.");
    				 System.out.println("\n4.Sua don gia.");
    				 System.out.println("\n5.Thoat.");
    				 System.out.println("\nMoi nhap vao lua chon: ");
    				 luachon=in.nextInt();
    				 in.nextLine();
    				 if(luachon<1 || luachon>5)
    				 {
    					 System.out.println("\nBan da nhap sai lua chon!!!");
    				 }
    				 if(luachon==1)
    				 {
    					 System.out.println("\nMoi ban nhap vao ma hoa don moi: ");
    					 mahdmoi=in.nextLine();
    					 dscthd[i].setMahoadon(mahdmoi);
    				 }
    				 if(luachon==2)
    				 {
    					 System.out.println("\nMoi ban nhap vao ma sach moi: ");
    					 masachmoi=in.nextLine();
    					 dscthd[i].setMasach(masachmoi);
    				 }
    				 if(luachon==3)
    				 {
    					 System.out.println("\nMoi ban nhap vao so luong moi: ");
    					 soluongmoi=in.nextInt();
    					 dscthd[i].setSoluong(soluongmoi);
    				 }
    				 if(luachon==4)
    				 {
    					 System.out.println("\nMoi ban nhap don gia moi: ");
    					 dongiamoi=in.nextInt();
    					 dscthd[i].setDongia(dongiamoi);
    				 }
    				 if(luachon==5)
    				 {
    					 System.out.println("\nBan da thoat sua thanh cong. ");
    					 break;
    				 }
    			 }
    		 }
    	 }
    
    }
     public void Menu() throws IOException{
        Scanner in = new Scanner(System.in);
            Docfile("Chitiethoadon.txt");
		 boolean exit = false;
		 String option = "";
		 while (!exit) {
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			 System.out.println("|       MENU CHI TIET HOA DON        |");
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			 System.out.println("|1. Xuat danh sach chi tiet hoa don  |");
			 System.out.println("|2. Them 1 chi tiet hoa don          |");
			 System.out.println("|3. Them k chi tiet hoa don          |");
			 System.out.println("|4. Sua mot chi tiet hoa don         |");
			 System.out.println("|5. Xoa mot chi tiet hoa don         |");
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
                                    this.Ghifile("Chitiethoadon.txt");
			 		break;
			 	case "3":
                                    int k;
                                    System.out.println("Moi ban vao so luong can them");
                                    k = in.nextInt();
                                    this.Themk(k);
                                    this.Ghifile("Chitiethoadon.txt");
                                    break;
			 		
			 	case "4":
                                    System.out.println("\nMoi ban nhap ma can xoa: ");
                                String maloaisachxoa=in.nextLine();
                                this.Xoatheoma(maloaisachxoa);
                                this.Ghifile("Chitiethoadon.txt");
                                break;
			 	case "5":
                                        System.out.println("Moi ban nhap ma can sua");
                                        String ma = in.nextLine();
			 		this.Xoatheoma(ma);
                                        this.Ghifile("Chitiethoadon.txt");
                                        break;
			 	
			 	case "0":
			 		exit = true;
			 		this.Ghifile("Chitiethoadon.txt");
			 		break;
			 	default:
			 		System.out.println("NHAP SAI LUA CHON. MOI CHON LAI.");
			 		break;
			 }
			 System.out.println("----------");
		 }
	 }
    public  void Ghifile(String filename) throws FileNotFoundException, IOException{
        DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
        for(int i = 0 ; i < n ; i ++)
        {
            dscthd[i].Ghifile(filename);
        }
        outstream.close();
    }
    public void Docfile(String filename) throws FileNotFoundException, IOException{
        int i = 0 ; 
        n = 0;
        try{
            DataInputStream instream = new DataInputStream(new FileInputStream(filename));
            try{
            while(true){
                String idhoadon = instream.readUTF();
                String idsach = instream.readUTF();
                int soluong = instream.readInt();
                float dongia = instream.readFloat();
                float thanhtien = instream.readFloat();
                dscthd = Arrays.copyOf(dscthd,n+1);
                dscthd[i] = new Chitiethoadon(idhoadon,idsach,soluong,dongia,thanhtien);
                i++;
                n++;
            }
            
        }catch(EOFException e){
            }
         finally{
                instream.close();
            }
        }
       catch(FileNotFoundException e){
               System.out.println("IOERROR"+filename+"NOT FOUND");
               }
       catch(IOException e){
               System.out.println("IOERROR"+e.getMessage()+"\n");
               }
        }

 
 }