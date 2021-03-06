package quanlisach;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import quanlisach.Tacgia;


/**
 *
 * @author HUNG
 */
public class Danhsachtacgia implements Danhsach{
    public Tacgia[] dstg = new Tacgia[1];
    public int n ;

    public Danhsachtacgia() {
        n=0;
    }
    public Danhsachtacgia(Tacgia dstg[] , int n){
        this.n = n; 
        this.dstg = Arrays.copyOf(dstg, n);       
    }
    public Danhsachtacgia(Danhsachtacgia ds){
        this.n = ds.n;
        this.dstg = Arrays.copyOf(ds.dstg, n);
    }
    public void Nhap(){
        System.out.println("Nhap vao so luong tac gia can nhap :");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dstg = Arrays.copyOf(dstg, n);
        for(int i = 0 ; i < n  ; i++)
        {
            dstg[i] = new Tacgia();
            dstg[i].Nhap();
        }
    }
    public void Xuat(){
        System.out.printf("\n%-100s","____________________________________________________________________________________________________");
        System.out.printf("\n|%-30s|%-30s|%-30s|","Ma tac gia","Ten tac gia","Ngay sinh");
        System.out.printf("\n|%-100s","----------------------------------------------------------------------------------------------------");
        for(int i=0;i<n;i++)
        {
            dstg[i].Xuat();
           System.out.printf("\n|%-30s","----------------------------------------------------------------------------------------------------");

        }
    }
    public void Them()
    {
        dstg = Arrays.copyOf(dstg,n+1);
        dstg[n] = new Tacgia();
        dstg[n].Nhap();
        n++;      
    }
    public void Themk(int k)
    {
        for(int i = 0 ; i < k ; i++)
        {
            Them();
        }
    }
    public void xoavt(int vitrixoa){
        for(int i = vitrixoa ; i < n - 1 ; i++)
        {
           dstg[i] = dstg[i+1];
        }
        n--;
    }
    public void Xoatheoma(String ma)
    {
        for(int i = 0 ; i < n ; i++)
        {
            if(dstg[i].getMatacgia().equals(ma))
            {
                xoavt(i);
            }
        }
    }
    public void Suatheoma(String ma)
    {
        for(int i = 0 ; i < n ; i++)
        {
            if(dstg[i].getMatacgia().equals(ma))
            {
                int luachon;
                while(true)
                {
                    System.out.println("1.Sua ma tac gia ");
                    System.out.println("2.Sua ten tac gia ");
                    System.out.println("3.Sua ngay sinh ");
                    System.out.println("4.Thoat");
                    System.out.println("Moi ban nhap lua chon ");
                    Scanner in = new Scanner(System.in);
                    luachon = in.nextInt();
                    if(luachon == 1)
                    {
                        String mamoi;
                        System.out.println("Nhap ma tac gia moi ");
                        mamoi = in.nextLine();
                        dstg[i].setMatacgia(mamoi);
                    }
                    else if(luachon == 2)
                    {
                        String tentacgia;
                        System.out.println("Nhap vao ten tac gia moi ");
                        tentacgia = in.nextLine();
                        dstg[i].setTentacgia(tentacgia);
                    }
                    else if(luachon == 3)
                    {
                        String ngaysinh;
                        System.out.println("Nhap vao ngay sinh moi ");
                        ngaysinh = in.nextLine();
                        dstg[i].setNgaysinh(ngaysinh);
                    }
                    else
                    {
                        break;
                    }
                    
                }
            }
        }
    }
    public void Timkiemtheoma(String ma){
        for(int i = 0 ; i < n ; i++)
        {
            if(dstg[i].getMatacgia().equals(ma))
            {
                System.out.println(dstg[i].toString());
            }
        }
    }
    public void menu() throws IOException
	{
            Scanner in=new Scanner(System.in);
	    docfile("Tacgia.txt");
	    boolean exit=false;
	    String option;
	    while(!exit) {
		    System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
		    System.out.println("|        MENU TAC GIA            |");
		    System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
		    System.out.println("|1.Xuat danh sach loai sach      |");
		    System.out.println("|2.Them mot loai sach            |");
		    System.out.println("|3.Them k loai sach              |");
		    System.out.println("|4.Xoa loai sach theo ma         |");
		    System.out.println("|5.Sua loai sach theo ma         |");
		    System.out.println("|0.Thoat va luu                  |");
		    System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
		    System.out.print("Lua chon: ");
		    option=in.nextLine();
		    switch(option){
		        case "1":
		            this.Xuat();
		            break;
		        case "2":
		            this.Them();
                            this.ghifile("Tacgia.txt");
		            break;
		        case "3":
                            System.out.println("\nMoi ban nhap so luong can them: ");
                            int k=in.nextInt();
		            this.Themk(k);
                            this.ghifile("Tacgia.txt");
		            break;
		        case "4":
                            System.out.println("\nMoi ban nhap ma can xoa: ");
                            String maloaisachxoa=in.nextLine();
		            this.Xoatheoma(maloaisachxoa);
                            this.ghifile("Tacgia.txt");
		            break;
		        case "5":
                            System.out.println("\nMoi ban nhap ma can sua: ");
                            String macansua=in.nextLine();
		            this.Suatheoma(macansua);
                            this.ghifile("Tacgia.txt");
		            break;
		        case "0":
		            exit=true;
		            ghifile("Tacgia.txt");
		            break;
		        default:
		            System.out.println("NHAP SAI VUI LONG NHAP LAI");
		            break;    
		    }
		    System.out.println("----------");
	    }
	}
     public void ghifile(String filename) throws FileNotFoundException, IOException
     {
         DataOutputStream outstream=new DataOutputStream(new FileOutputStream(filename));
         for(int i=0;i<n;i++)
         {
             dstg[i].ghifile(filename);
         }
         outstream.close();
     }
    public void docfile(String filename)
    {
        int i=0;
        int n=0;
        try{
        DataInputStream instream=new DataInputStream(new FileInputStream(filename));
        try{
            while(true){
                String matacgia=instream.readUTF();
                String tentacgia=instream.readUTF();
                String ngaysinh=instream.readUTF();
                dstg = Arrays.copyOf(dstg,n+1);
                dstg[i]=new Tacgia(matacgia,tentacgia,ngaysinh);
                i++;
                n++;
            }
        }catch(EOFException e){
        }finally{
            instream.close();
        }
        }catch(FileNotFoundException e)
        {
            System.out.println("IOEROR: "+filename+"Not Found:\n");
        }catch(IOException e)
        {
            System.out.println("IOEROR: "+e.getMessage()+"\n");
        }
    }
}
