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
public class Danhsachkhachhang implements Danhsach{
    public Khachhang [] dskh = new Khachhang[1];
    public int n; 
    public int i;
    public Danhsachkhachhang(){
    }
    public Danhsachkhachhang(int n, Khachhang [] a)
    {
       this.n = n;
       this.dskh = Arrays.copyOf(a,n);
    }
    public Danhsachkhachhang (Danhsachkhachhang ds)
    {
        this.n = ds.n; 
        this.dskh = Arrays.copyOf(ds.dskh,n);
    }
    public void Nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong khach hang:");
        this.n = sc.nextInt();
        dskh = Arrays.copyOf(dskh, n);
        for(int i=0; i<n; i++)
            
        {
            dskh[i] = new Khachhang();
            dskh[i].Nhap();
        }
    }
    public void Xuat()
    {
        System.out.printf("|%-200s","_______________________________________________________________________________________________________________________________________________");
        System.out.printf("\n|%-30s|%-20s|%-20s|%-50s|%-15s|","Ma khach hang","Ten khach hang","Ho khach hang","Dia chi","So dien thoai");
        System.out.printf("\n|%-200s","---------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0;i<n;i++)
        {
            dskh[i].Xuat();
            System.out.printf("\n|%-200s","-------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    
    public void Ghifile(String filename) throws FileNotFoundException, IOException
        {
                        DataOutputStream outstream=new DataOutputStream(new FileOutputStream(filename));
                        for(int i=0; i<n; i++)
                        {
                            dskh[i].Ghifile(filename);
                        }
                        outstream.close();
        }
        public void Docfile(String filename) throws IOException
        {
            int n=0, i=0;
            try{
                DataInputStream inStream = new DataInputStream(new FileInputStream(filename));
                try{
                    while(true)
                    {
                        
                        String Makhachhang=inStream.readUTF();
                        String Hokhachhang=inStream.readUTF();
                        String Tenkhachhang=inStream.readUTF();
                        String Diachi=inStream.readUTF();
                        String Dienthoai=inStream.readUTF();
                        dskh=Arrays.copyOf(dskh, n+1);
                        dskh[i]=new Khachhang(Makhachhang,Hokhachhang,Tenkhachhang,Diachi,Dienthoai);
                        i++;
                        n++;
                    }
                }
                catch(EOFException e){}
                finally{
                    inStream.close();
                }
            }catch(FileNotFoundException e)
            {
                System.out.println("IOERROR:"+filename+"Not Found:");
            }
            catch(IOException e){
                System.out.println("IOERROR:"+e.getMessage()+"\n");
            }
        }
    public void Xoavt(int vitrixoa)
    {
        for(int i = vitrixoa; i<n-1; i++)
        {
            dskh[i] = dskh[i+1]; 
        }
        dskh = Arrays.copyOf(dskh, n-1);
        n--;
    }
    public void Xoatheoma(String ma)
    {
        for(int i =0; i<n; i++)
        {
            if(dskh[i].getMakhachhang().equals(ma))
            {
                Xoavt(i);
            }
        }
    }
    public void Them()
    {
      dskh = Arrays.copyOf(dskh, n+1);
      dskh[n] =new Khachhang();
      dskh[n].Nhap();
      n++;
    }
    public void Themk(int k)
    {
        for(int i=0; i<k; i++)
        {
            Them();
        }
    }
    public void Suatheoma(String ma)
    {
    	Scanner in = new Scanner(System.in);
    	String makhmoi;
    	String hokhmoi;
    	String tenkhmoi;
    	String diachimoi;
    	String dienthoaimoi;
    	for(int i=0;i<n;i++)
    	{
    		if(dskh[i].getMakhachhang().equals(ma))
    		{
	    		int luachon;
	    		while(true)
	    		{
	    			System.out.println("\n1.Sua ma khach hang.");
	    			System.out.println("\n2.Sua ho khach hang.");
	    			System.out.println("\n3.Sua ten khach hang.");
	    			System.out.println("\n4.Sua dia chi.");
	    			System.out.println("\n5.Sua dien thoai.");
	    			System.out.println("\n6.Thoat.");
	    			System.out.println("\nMoi ban nhap vao lua chon: ");
	    			luachon=in.nextInt();
	    			in.nextLine();
	    			if(luachon<1||luachon>6)
	    			{
	    				System.out.println("Ban da nhap sai lua chon.!!!");
	    			}
	    			if(luachon==1)
	    			{
	    				System.out.println("\nMoi ban nhap vao ma khach hang moi: ");
	    				makhmoi=in.nextLine();
	    				dskh[i].setMakhachhang(makhmoi);
	    			}
	    			if(luachon==2)
	    			{
	    				System.out.println("\nMoi ban nhap vao ho khach hang moi: ");
	    				hokhmoi=in.nextLine();
	    				dskh[i].setHokhachhang(hokhmoi);
	    			}
	    			if(luachon==3)
	    			{
	    				System.out.println("\nMoi ban nhap vao ten khach hang moi: ");
	    				tenkhmoi=in.nextLine();
	    				dskh[i].setTenkhachhang(tenkhmoi);
	    			}
	    			if(luachon==4)
	    			{
	    				System.out.println("\nMoi ban nhap vao dia chi moi: ");
	    				diachimoi=in.nextLine();
	    				dskh[i].setDiachi(diachimoi);
	    			}
	    			if(luachon==5)
	    			{
	    				System.out.println("\nMoi ban nhap vao so dien thoai moi: ");
	    				dienthoaimoi=in.nextLine();
	    				dskh[i].setDienthoai(dienthoaimoi);
	    			}
	    			if(luachon==6)
	    			{
	    				System.out.println("\nBan da thoat thanh cong. ");
	    				break;
	    			}
	    		}
    		}
    	}
    }
   public void Timkiemtheoma(String ma)
   {
       for(int i = 0 ; i < n ; i++)
       {
           if(dskh[i].getMakhachhang().equals(ma))
           {
               System.out.println(dskh[i].toString());
           }
       }
   }
   public void Menu() throws IOException{
        Scanner in = new Scanner(System.in);
            Docfile("Khachhang.txt");
		 boolean exit = false;
		 String option = "";
		 while (!exit) {
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			 System.out.println("|       MENU KHACH HANG              |");
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
                                    this.Ghifile("Khachhang.txt");
			 		break;
			 	case "3":
                                    int k;
                                    System.out.println("Moi ban vao so luong can them");
                                    k = in.nextInt();
                                    this.Themk(k);
                                    this.Ghifile("Khachhang.txt");
                                    break;
			 		
			 	case "4":
                                    System.out.println("Moi ban nhap ma can sua");
                                        String ma1 = in.nextLine();
                                    this.Suatheoma(ma1);
                                    this.Ghifile("Khachhang.txt");
			 		break;
			 	case "5":
                                        System.out.println("Moi ban nhap ma can sua");
                                        String ma = in.nextLine();
			 		this.Xoatheoma(ma);
                                        this.Ghifile("Khachhang.txt");
                                        break;
			 	
			 	case "0":
			 		exit = true;
			 		this.Ghifile("Khachhang.txt");
			 		break;
			 	default:
			 		System.out.println("NHAP SAI LUA CHON. MOI CHON LAI.");
			 		break;
			 }
			 System.out.println("----------");
		 }
	 }
}
