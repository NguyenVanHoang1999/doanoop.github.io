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

public class Danhsachsach implements Danhsach{
 public int n;
 public Sach[] dss = new Sach[1];
 public Danhsachsach()
 {}
 public Danhsachsach(int n, Sach[] dss)
 {
	 this.n=n;
	 this.dss = Arrays.copyOf(dss, n);
 }
 public Danhsachsach(Danhsachsach dss)
 {
	 this.n= dss.n;
	 this.dss = Arrays.copyOf(dss.dss, n);
 }
 @Override public void Nhap()
 {
	 Scanner Nhap= new Scanner(System.in);
	 System.out.println("Nhap vao so luong sach: ");
	  	n=Nhap.nextInt();
	  	dss= Arrays.copyOf(dss, n);
	  	int luachon;
	  	for(int i=0;i<n;i++)
	  	{
	  		System.out.println("1 Nhap vao sach giao khoa");
	  		System.out.println("2 Nhap vao truyen");
	  		System.out.println("3 Nhap de thoat");
	  		System.out.println("Nhap vao lua chon: ");
	  		luachon=Nhap.nextInt();
                        Nhap.nextLine();
	  		if(luachon==1)
	  		{
	  			dss[i] = new Sachgiaokhoa();
	  			dss[i].Nhap();
	  		}
	  		else if(luachon==2)
	  		{
	  			dss[i] = new Truyen();
	  			dss[i].Nhap();
	  		}
	  		else if(luachon==3) break;
	  		else
	  		{
	  			System.out.println("Ban da Nhap sai. Xin Nhap lai lua chon");
	  			i=i-1;
	  		}
	  	}
 }
 //????????????????????????????????????????????????????????
 public void Xuat(){
    System.out.printf("%-250s","_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
    System.out.printf("\n|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|","Ma sach","Ten sach","Ma tac gia","Ma nha san xuat","Ma loai","Ma giam gia","Don gia","So luong","Mon","Lop","Lua tuoi","Chu de");
    System.out.printf("\n%-250s","-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    for(int i = 0 ; i < n ; i++ )
    {
       dss[i].Xuat();
       System.out.printf("\n%-250s","--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
 public void Them() 
 {
	 Scanner sc=new Scanner(System.in);
	 int luachon;
	 while (true)
	 {
		 System.out.println("1 Nhap vao sach giao khoa");
		 System.out.println("2 Nhap vao truyen");
		 System.out.println("3 Nhap de thoat");
		 System.out.println("Nhap vao lua chon");
		 luachon = sc.nextInt();
		 if(luachon== 1)
		 {
			 dss = Arrays.copyOf(dss, n+1);
			 dss[n] = new Sachgiaokhoa();
			 dss[n].Nhap();
			 n++;
			 break;
		 }
		 else if(luachon == 2)
		 {
			 dss= Arrays.copyOf(dss, n+1);
			 dss[n] = new Truyen();
			 dss[n].Nhap();
			 n++;
			 break;
		 }
		 else { break;}
	 }
 }
 public void Themk(int k) 
 {
	 dss=Arrays.copyOf(dss, n+k);
	 for(int i=n;i< n+k;i++)
	 {
		 Them();
	 }
 }
 public void xoavt(int vitrixoa)
 {
	 for(int i=vitrixoa ; i<n-1 ;i++)
	 {
		 dss[i] = dss[i+1];
	 }
	 dss = Arrays.copyOf(dss, n-1);
	 n--;
 }
 public void Xoatheoma(String Masach)
 {
	 for(int i=0 ;i<n; i++)
	 {
		 if(dss[i].getMasach().equals(Masach))
		 {
			 xoavt(i);
			 break;
		 }
	 }
 }
 public void Timkiemtheoma(String Masach)
 {
	 int a = 0;
	 for(int i=0 ;i<n; i++)
	 {
		 if(dss[i].getMasach().equals(Masach))
		 {
			 a=i;
			 break;
		 }
	 }
	    dss[a].Xuat();
 }
 public int TimKiemVitriTheoMaSach(String Masach)
 {
	 int a = 0;
	 for(int i=0 ;i<n; i++)
	 {
		 if(dss[i].getMasach().equals(Masach))
		 {
			 a=i;
			 break;
		 }
	 }
	 return a;
 }
 public void Suatheoma(String masach)
 {
	// String masach;
	 String tensach;
	 String matacgia;
	 String manhasanxuat;
	 String maloai;
	 int dongia;
	 int soluong;
	 Scanner in=new Scanner(System.in);
	 int timkiem = TimKiemVitriTheoMaSach(masach);
	 if(dss[timkiem] instanceof Sachgiaokhoa)
	 {
		 String mon;
		 String lop;
		 Sachgiaokhoa sgk = new Sachgiaokhoa();
		 sgk = (Sachgiaokhoa) dss[timkiem];
		 System.out.println("\n1 nhap sua ma sach.");
		 System.out.println("\n2 nhap sua ten sach.");
		 System.out.println("\n3 nhap sua ma tac gia.");
		 System.out.println("\n4 nhap sua ma nha san xuat.");
		 System.out.println("\n5 nhap sua ma loai sach.");
		 System.out.println("\n6 nhap sua mon hoc.");
		 System.out.println("\n7 nhap sua lop hoc.");
		 System.out.println("\n8 nhap sua don gia.");
		 System.out.println("\n9 nhap sua so luong.");
		 System.out.println("\n10 nhap de thoat.");
		 	int luachon;
		 while(true)
		 {
			 System.out.println("Moi ban nhap vao lua chon: ");
			 luachon=in.nextInt();
			 		 in.nextLine();
			 if(luachon==1)
			 {
				 System.out.println("Moi nhap vao ma sach moi: ");
				 masach=in.nextLine();
				 sgk.setMasach(masach);
			 }
			 if(luachon==2)
			 {
				 System.out.println("Moi nhap vao ten sach moi: ");
				 tensach=in.nextLine();
				 sgk.setTensach(tensach);;
			 }
			 if(luachon==3)
			 {
				 System.out.println("Moi nhap vao ma tac gia moi: ");
				 matacgia=in.nextLine();
				 sgk.setMatacgia(matacgia);
			 }
			 if(luachon==4)
			 {
				 System.out.println("Moi nhap vao ma nha san xuat moi: ");
				 manhasanxuat=in.nextLine();
				 sgk.setManhasanxuat(manhasanxuat);;
			 }
			 if(luachon==5)
			 {
				 System.out.println("Moi nhap vao ma loai sach moi: ");
				 maloai=in.nextLine();
				 sgk.setMaloai(maloai);
			 }
			 if(luachon==6)
			 {
				 System.out.println("Moi nhap vao mon hoc moi: ");
				 mon=in.nextLine();
				 sgk.setMon(mon);
			 }
			 if(luachon==7)
			 {
				 System.out.println("Moi nhap vao lop hoc moi: ");
				 lop=in.nextLine();
				 sgk.setLop(lop);
			 }
			 if(luachon==8)
			 {
				 System.out.println("Moi nhap vao don gia moi: ");
				 dongia=in.nextInt();
				 sgk.setDongia(dongia);
			 }
			 if(luachon==9)
			 {
				 System.out.println("Moi nhap vao so luong moi: ");
				 soluong=in.nextInt();
				 sgk.setSoluong(soluong);
			 }
			 if(luachon==10)
			 {
				 break;
			 }
		 }
		 dss[timkiem] = new Sachgiaokhoa(sgk);
	 }
	 else if(dss[timkiem] instanceof Truyen)
	 {
		 int luatuoi;
		 String chude;
		 Truyen t = new Truyen();
		 t=(Truyen) dss[timkiem];
		 System.out.println("\n1 nhap sua ma sach.");
		 System.out.println("\n2 nhap sua ten sach.");
		 System.out.println("\n3 nhap sua ma tac gia.");
		 System.out.println("\n4 nhap sua ma nha san xuat.");
		 System.out.println("\n5 nhap sua ma loai sach.");
		 System.out.println("\n6 nhap sua don gia.");
		 System.out.println("\n7 nhap sua so luong.");
		 System.out.println("\n8 nhap sua lua tuoi.");
		 System.out.println("\n9 nhap sua chu de.");
		 System.out.println("\n10 nhap de thoat.");
		  int luachon;
		 while (true)
		 {
			 System.out.println("Moi ban nhap vao lua chon: ");
			 luachon=in.nextInt();
			 		 in.nextLine();
			 if(luachon==1)
			 {
				 System.out.println("Moi nhap vao ma sach moi: ");
				 masach=in.nextLine();
				 t.setMasach(masach);
			 }
			 if(luachon==2)
			 {
				 System.out.println("Moi nhap vao ten sach moi: ");
				 tensach=in.nextLine();
				 t.setTensach(tensach);;
			 }
			 if(luachon==3)
			 {
				 System.out.println("Moi nhap vao ma tac gia moi: ");
				 matacgia=in.nextLine();
				 t.setMatacgia(matacgia);
			 }
			 if(luachon==4)
			 {
				 System.out.println("Moi nhap vao ma nha san xuat moi: ");
				 manhasanxuat=in.nextLine();
				 t.setManhasanxuat(manhasanxuat);;
			 }
			 if(luachon==5)
			 {
				 System.out.println("Moi nhap vao ma loai sach moi: ");
				 maloai=in.nextLine();
				 t.setMaloai(maloai);
			 }
			 if(luachon==6)
			 {
				 System.out.println("Moi nhap vao ma don gia moi: ");
				 dongia=in.nextInt();
				 t.setDongia(dongia);
			 }
			 if(luachon==7)
			 {
				 System.out.println("Moi nhap vao so luong moi: ");
				 soluong=in.nextInt();
				 t.setSoluong(soluong);
			 }
			 if(luachon==8)
			 {
				 System.out.println("Moi nhap vao lua tuoi moi: ");
				 luatuoi=in.nextInt();
				 t.setLuatuoi(luatuoi);
			 }
			 if(luachon==9)
			 {
				 System.out.println("Moi nhap vao chu de moi: ");
				 chude=in.nextLine();
				 t.setChude(chude);
			 }
			 if(luachon==10)
			 {
				 break;
			 }
		 }
		 dss[timkiem] = new Truyen(t);
		 
		 
	 }
 }
 public void Menu() throws IOException{
        Scanner in = new Scanner(System.in);
            Docfile("Sach.txt");
		 boolean exit = false;
		 String option = "";
		 while (!exit) {
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			 System.out.println("|       MENU SACH                    |");
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
                         System.out.println("|1. Nhap n sach moi dau tien         |");
			 System.out.println("|2. Xuat danh sach                   |");
			 System.out.println("|3. Them 1 quyen sach moi            |");
			 System.out.println("|4. Them k quyen sach moi            |");
			 System.out.println("|5. Sua 1 quyen sach                 |");
			 System.out.println("|6. Xoa 1 quyen sach                 |");
			 System.out.println("|0. Thoat va luu                     |");
			 System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			 System.out.print("Lua chon: ");
			 option = in.nextLine();
			 switch (option) {
                             case "1":
                                 this.Nhap();
                                 this.Ghifile("Sach.txt");
                                 break;
			 	case "2":
			 		this.Xuat();
			 		break;
			 	case "3":
			 		this.Them();
                                    this.Ghifile("Sach.txt");
			 		break;
			 	case "4":
                                    int k;
                                    System.out.println("Moi ban vao so luong can them");
                                    k = in.nextInt();
                                    this.Themk(k);
                                    this.Ghifile("Sach.txt");
                                    break;
			 		
			 	case "5":
                                    System.out.println("Moi ban nhap ma can sua");
                                        String ma1 = in.nextLine();
                                    this.Suatheoma(ma1);
                                    this.Ghifile("Sach.txt");
			 		break;
			 	case "6":
                                        System.out.println("Moi ban nhap ma can sua");
                                        String ma = in.nextLine();
			 		this.Xoatheoma(ma);
                                        this.Ghifile("Sach.txt");
                                        break;
			 	
			 	case "0":
			 		exit = true;
			 		this.Ghifile("Sach.txt");
			 		break;
			 	default:
			 		System.out.println("NHAP SAI LUA CHON. MOI CHON LAI.");
			 		break;
			 }
			 System.out.println("----------");
		 }
	 }
 public void Ghifile(String filename) throws FileNotFoundException, IOException
 {
     DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
     for(int i = 0 ; i < n ; i++)
     {
         if(dss[i] instanceof Sachgiaokhoa)
         {
             outstream.writeUTF("SGK");
             outstream.writeUTF(dss[i].getMasach());
            outstream.writeUTF(dss[i].getTensach());
            outstream.writeUTF(dss[i].getMatacgia());
             outstream.writeUTF(dss[i].getManhasanxuat());
             outstream.writeUTF(dss[i].getMaloai());
            outstream.writeUTF(dss[i].getMagiamgia());
            outstream.writeInt(dss[i].getDongia());
            outstream.writeInt(dss[i].getSoluong());
            Sachgiaokhoa a = new Sachgiaokhoa();
            a = (Sachgiaokhoa)dss[i];
            outstream.writeUTF(a.getMon());
            outstream.writeUTF(a.getLop());
             
         }
         else
         {
             outstream.writeUTF("T");
              outstream.writeUTF(dss[i].getMasach());
            outstream.writeUTF(dss[i].getTensach());
            outstream.writeUTF(dss[i].getMatacgia());
             outstream.writeUTF(dss[i].getManhasanxuat());
             outstream.writeUTF(dss[i].getMaloai());
            outstream.writeUTF(dss[i].getMagiamgia());
            outstream.writeInt(dss[i].getDongia());
            outstream.writeInt(dss[i].getSoluong());
            Truyen a = new Truyen();
            a = (Truyen)dss[i];
            outstream.writeInt(a.getLuatuoi());
            outstream.writeUTF(a.getChude());
             
           }
     
        }
     outstream.close();
 }
 public void Docfile(String filename) throws IOException
 {
     int i = 0 ;
     n = 0;
     DataInputStream instream = new DataInputStream(new FileInputStream(filename));
     try{
         try{
             while(true){
                 String id = instream.readUTF();
                 if(id.equalsIgnoreCase("SGK"))
                 {
                    String idsach = instream.readUTF();
                   String tensach = instream.readUTF();
                   String idtacgia = instream.readUTF();
                   String idnhasanxuat = instream.readUTF();
                   String idloai = instream.readUTF();
                   String idgiamgia = instream.readUTF();
                   int dongia = instream.readInt();
                   int soluong = instream.readInt();
                   String mon = instream.readUTF();
                   String lop = instream.readUTF();
                    dss = Arrays.copyOf(dss,n+1);
                    dss[i] = new Sachgiaokhoa(idsach,tensach,idtacgia,idnhasanxuat,idloai,idgiamgia,dongia,soluong,mon,lop);
                    i++;
                    n++;
                 }
                 else
                 {
                    String idsach = instream.readUTF();
                   String tensach = instream.readUTF();
                   String idtacgia = instream.readUTF();
                   String idnhasanxuat = instream.readUTF();
                   String idloai = instream.readUTF();
                   String idgiamgia = instream.readUTF();
                   int dongia = instream.readInt();
                   int soluong = instream.readInt();
                   int luatuoi = instream.readInt();
                   String chude = instream.readUTF();
                    dss = Arrays.copyOf(dss,n+1);
                    dss[i] = new Truyen(idsach,tensach,idtacgia,idnhasanxuat,idloai,idgiamgia,dongia,soluong,luatuoi,chude);
                    i++;
                    n++;
                 }
                 
                 
             }
             
         }catch(EOFException e){
             
         }
         finally{
             instream.close();
         }
     }catch(FileNotFoundException e)
     {
         
     }
     catch(IOException e)
     {
         
     }
         
    }
 
}
