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
import java.util.Arrays;
import java.util.Scanner;

public class Danhsachloaigiamgia implements Danhsach{
 public int n;
 public Loaigiamgia [] dslgg =new Loaigiamgia[1];
 public Danhsachloaigiamgia() {}
 public Danhsachloaigiamgia(Loaigiamgia [] a,int n)
 {
	 this.n=n;
	 this.dslgg=Arrays.copyOf(a, n);
 }
 public Danhsachloaigiamgia(Danhsachloaigiamgia lgg)
 {
	 this.n=lgg.n;
	 this.dslgg=Arrays.copyOf(lgg.dslgg, n);
 }
 public void Nhap()
 {
	 Scanner in = new Scanner(System.in);
	 System.out.println("Nhap vao so luong loai giam gia: ");
	 this.n=in.nextInt();
	 dslgg = Arrays.copyOf(dslgg, n);
	 for(int i=0; i<n ; i++)
	 {
		 dslgg[i] = new Loaigiamgia();
		 dslgg[i].Nhap();
	 }
 }
 public void Xuat()
 {
     System.out.printf("\n%-100s","______________________________________");
     System.out.printf("\n|%-20s|%-20s|","Ma loai giam gia","So phan tram giam gia");
     System.out.printf("\n|%-100s","--------------------------------------");
     for(int i=0;i<n;i++)
     {
         dslgg[i].Xuat();
         System.out.printf("\n|%-100s","----------------------------------------------");
     }
 }
 public void Them()
 {
	 dslgg= Arrays.copyOf(dslgg, n+1);
	 dslgg[n]= new Loaigiamgia();
	 dslgg[n].Nhap();
	 n++;
 }
 public void Themk(int k)
 {
	 for(int i=0;i<k;i++)
	 {
		 Them();
	 }
 }
 public void xoavt(int vitrixoa)
 {
	 for(int i=vitrixoa;i<n-1;i++)
	 {
		 dslgg[i]= dslgg[i+1];
	 }
	 dslgg = Arrays.copyOf(dslgg, n-1);
	 n--;
 }
 public void Xoatheoma(String ma)
 {
	 for(int i=0;i<n;i++)
	 {
		 if(dslgg[i].getMaloaigiamgia().equals(ma))
		 {
			 xoavt(i);
		 }
	 }
 }
 public void Timkiemtheoma(String ma)
 {
     System.out.printf("\n%-100s","______________________________________________________________");
     System.out.printf("\n|%-20s|","Sophantram");
     System.out.printf("\n|%-100s","-------------------------------------------------------------");
	 for(int i=0;i<n;i++)
	 {
		 if( dslgg[i].getMaloaigiamgia().equals(ma))
		 {
			 dslgg[i].Xuat();
			 System.out.printf("\n|%-100s","----------------------------------------------");
		 }		 
	 }
 }
 public void Suatheoma(String ma)
 {
	 String maloaigiamgiamoi;
         float sophantramgiamgiamoi;
	 Scanner in = new Scanner(System.in);
	 for(int i=0;i<n;i++)
	 {
             int luachon;
             System.out.println("\n1.Sua ma loai giam gia.");
             System.out.println("\n2.Sua so pham tram giam gia.");
             System.out.println("\n3.Thoat.");
             System.out.println("\nMoi ban nhap lua chon:");
             luachon=in.nextInt();
             while(true)
             {
                 if(luachon==1)
                 {
                     System.out.println("\nNhap vao ma loai giam gia moi: ");
                     maloaigiamgiamoi = in.nextLine();
                     dslgg[i].setMaloaigiamgia(maloaigiamgiamoi);
                 }
                 if(luachon==2)
                 {
                     System.out.println("\nNhap vao so phan tram giam gia moi: ");
                     sophantramgiamgiamoi=in.nextFloat();
                     dslgg[i].setSophantram(sophantramgiamgiamoi);
                 }
                 if(luachon==3)
                 {
                     break;
                 }
             }
		 
	 }
 }
 public void ghifile(String filename) throws FileNotFoundException, IOException
 {
	 DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
	 for(int i=0;i<n;i++)
	 {
		 dslgg[i].Ghifile(filename);
	 }
	 outstream.close();
 }
 public void docfile(String filename)
 {
	 int i=0;
	 int n=0;
	 try {
		 DataInputStream instream = new DataInputStream(new FileInputStream(filename));
		 try {
			 while(true)
			 {
                                 String maloaigiamgia=instream.readUTF();
				 Float sophantram = instream.readFloat();
				 dslgg=Arrays.copyOf(dslgg, n+1);
				 dslgg[i] = new Loaigiamgia(maloaigiamgia,sophantram);
				 i++;
				 n++;
			 }
		 }catch(EOFException e) {}
		 finally
		 {
			 instream.close();
		 }
	 }catch(FileNotFoundException e)
	 {
		 System.out.println("IOERROR: "+filename+"Not Found:");
	 }
	 catch(IOException e)
	 {
		 System.out.println("IOERROR: "+e.getMessage()+"\n");
	 }
 }
}
