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
public class Danhsachnhacungcap implements Danhsach{
    public int n ;
    public Nhacungcap[] dsncc = new Nhacungcap[1];
    public Danhsachnhacungcap(){
    }
    public Danhsachnhacungcap(Nhacungcap[] a,int n){
        this.n = n;
        this.dsncc = Arrays.copyOf(a, n);
    }
    public Danhsachnhacungcap(Danhsachnhacungcap ds){
        this.n = ds.n;
        this.dsncc = Arrays.copyOf(ds.dsncc,n);
    }
    public void Nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap vao so luong nha cung cap :");
        this.n = in.nextInt();
        dsncc = Arrays.copyOf(dsncc,n);
        for(int i = 0 ; i < n ; i++)
        {
            dsncc[i] = new Nhacungcap();
            dsncc[i].Nhap();
        }
        
    }
    public void Xuat(){
         System.out.printf("%-80s\n","________________________________________________________________________________________________________________");

        
        System.out.printf("|%-20s|%-20s|%-50s|%-20s|\n","Ma nha cung cap","Tên nha cung cap","Dia chi","Dien thoai");
        System.out.printf("%-80s\n","------------------------------------------------------------------------------------------------------------------");
        
            
         for(int i = 0 ; i < n ; i++)
        {
            dsncc[i].Xuat();
         System.out.printf("%-80s\n","-------------------------------------------------------------------------------------------------------------------");
                       
        }
    }
    public void Xoanhacungcap(int vitrixoa){
        for(int i = vitrixoa ; i < n -1 ; i++)
        {
            dsncc[i] = dsncc[i+1];
        }
        dsncc = Arrays.copyOf(dsncc,n-1);
        n--;
    }
    public void Xoatheoma(String ma){
        for(int i = 0 ; i < n ; i++)
        {
            if(dsncc[i].getManhacungcap().equals(ma))
            {
                Xoanhacungcap(i);
            }
        }
    }
    public void Them(){
        dsncc = Arrays.copyOf(dsncc,n+1);
        dsncc[n] = new Nhacungcap();
        dsncc[n].Nhap();
        n++;
    }
    public void Themk(int k)
    {
        for(int i=0;i<k;i++)
        {
            Them();
        }
    }
   public void Timkiemtheoma(String ma)
   {
       for(int i = 0 ; i < n ; i++)
       {
           if(dsncc[i].getManhacungcap().equals(ma))
           {
               System.out.println(dsncc[i].toString());
           }
       }
   }
   public void Suatheoma(String ma)
    {
        int vt = -1 ;
        for(int i = 0 ; i < n ; i++)
        {
           if(ma.equals(dsncc[i].getManhacungcap()))
               vt = i;
        }
        if(vt == -1)
        {
            System.out.println("Khong tim thay ma can sua !");
        }
        else
        {
                   String manhacungcap;
                    String tennhacungcap;
                   String diachi;
                     String dienthoai;
                   int luachon;
                   Scanner sc = new Scanner(System.in);
               while(true)
               {
                   System.out.println("Nhap 1 de sua ma nha cung cap");
                   System.out.println("Nhap 2 de sua ten nha cung cap");
                   System.out.println("Nhap 3 de sua dia chi");
                   System.out.println("Nhap 4 de sua so dien thoai");
                   
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
                       System.out.println("Moi ban nhap ma nha cung cap :");
                       manhacungcap = sc.nextLine();
                       dsncc[vt].setManhacungcap(manhacungcap);
                   }
                   
                   else if(luachon == 2)
                   {
                       System.out.println("Moi ban nhap ten nha cung cap:");
                       tennhacungcap = sc.nextLine();
                       dsncc[vt].setTennhacungcap(tennhacungcap);
                   }
                   else if(luachon == 3)
                   {
                       System.out.println("Moi ban nhap dia chi nha cung cap ");
                       diachi = sc.nextLine();
                       dsncc[vt].setDiachi(diachi);
                   }
                   else if(luachon == 4)
                   {
                       System.out.println("Moi ban nhap so dien thoai nha cung cap");
                       dienthoai = sc.nextLine();
                       dsncc[vt].setDienthoai(dienthoai);
                   }
                   
                   
               }
        }
    }
   public void Menu() throws IOException{
        Scanner in = new Scanner(System.in);
            Docfile("Nhacungcap.txt");
		 boolean exit = false;
		 String option = "";
		 while (!exit) {
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			 System.out.println("|       MENU NHA CUNG CAP            |");
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			 System.out.println("|1. Xuat danh sach nha cung cap      |");
			 System.out.println("|2. Them 1 nha cung cap              |");
			 System.out.println("|3. Them k nha cung cap              |");
			 System.out.println("|4. Sua 1 nha cung cap               |");
			 System.out.println("|5. Xoa 1 nha cung cap               |");
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
                                    this.Ghifile("Nhacungcap.txt");
			 		break;
			 	case "3":
                                    int k;
                                    System.out.println("Moi ban vao so luong can them");
                                    k = in.nextInt();
                                    this.Themk(k);
                                    this.Ghifile("Nhacungcap.txt");
                                    break;
			 		
			 	case "4":
                                    System.out.println("Moi ban nhap ma can sua");
                                        String ma1 = in.nextLine();
                                    this.Suatheoma(ma1);
                                    this.Ghifile("Nhacungcap.txt");
			 		break;
			 	case "5":
                                        System.out.println("Moi ban nhap ma can sua");
                                        String ma = in.nextLine();
			 		this.Xoatheoma(ma);
                                        this.Ghifile("Nhacungcap.txt");
                                        break;
			 	
			 	case "0":
			 		exit = true;
			 		this.Ghifile("Nhacungcap.txt");
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
           dsncc[i].Ghifile(filename);
       }
       outstream.close();
   }
   public void Docfile(String filename) throws IOException
   {
       int i = 0; 
       n = 0;
        try{
            DataInputStream instream = new DataInputStream(new FileInputStream(filename));
            try{
                while(true){
                    String id = instream.readUTF();
                    String name = instream.readUTF();
                    String address = instream.readUTF();
                    String phone = instream.readUTF();
                    dsncc = Arrays.copyOf(dsncc,n+1);
                    dsncc[i] = new Nhacungcap(id,name,address,phone);
                    i++;
                    n++;
                }
            }
            catch(EOFException e){
                
            }
            finally{
                instream.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("IOERROR "+filename +"not found");
        }
        catch(IOException a){
            System.out.println("IOERROR "+a.getMessage()+"\n");
        }
    }
    
}