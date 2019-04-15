/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

import java.util.Scanner;

/**
 *
 * @author HUNG
 */
public class Menu {
    public static void Menunhanvien(){
                Scanner in = new Scanner (System.in);
		Danhsachsach dss = new Danhsachsach();
                Danhsachkhachhang dskh = new Danhsachkhachhang();
                Danhsachhoadon dshd = new Danhsachhoadon();
                Danhsachchitiethoadon  dscthd = new Danhsachchitiethoadon();
                
                Danhsachloaisach dsls = new Danhsachloaisach();
                Danhsachphieunhap dspn = new Danhsachphieunhap();
                Danhsachnhacungcap dsncc = new Danhsachnhacungcap();
                Danhsachnhaxuatban dsnxb = new Danhsachnhaxuatban();
                Danhsachtacgia dstg = new Danhsachtacgia();
                
		boolean exit = false;
		String option ;
		while (!exit) {
			System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			System.out.println("|          MAIN MENU         |");
			System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			System.out.println("|1. Quan ly sach             |");
			System.out.println("|2. Quan ly khach hang       |");
			System.out.println("|3. Quan ly hoa don          |");
			System.out.println("|4. Quan ly chi tiet hoa don |");
			System.out.println("|5. Quan ly khuyen mai       |");
			System.out.println("|6. Quan ly nhan hieu        |");
			System.out.println("|7. Quan ly phieu nhap hang  |");
			System.out.println("|8. Quan ly nha cung cap     |");
                        System.out.println("|9.Quan ly nha xuat ban      |");
                        System.out.println("|10.Quan ly tac gia          |");
			System.out.println("|11. Thoat                    |");
			System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			System.out.print("Lua chon: ");
			option = in.nextLine();
            System.out.println("----------");
			switch (option) {
				case "1":
					
					break;
				case "2":
					
					break;
				case "3":
					
					break;
				case "4":
					
					break;
				case "5":
					
					break;
				case "6":
					
					break;
				case "7":
					
					break;
				case "8":
					
					break;
				case "9":
					
					break;
				case "11":
					{System.out.println("XIN CHAO va HEN GAP LAI");
					exit = true;
					break;}
				default:
                	System.out.println("NHAP SAI LUA CHON. MOI CHON LAI.");
			 		break;
			}
            System.out.println("----------");
		}
	
    
        }   
    public static void Menuadmin(){
        Scanner in = new Scanner (System.in);
                Danhsachsach dss = new Danhsachsach();
                Danhsachkhachhang dskh = new Danhsachkhachhang();
                Danhsachhoadon dshd = new Danhsachhoadon();
                Danhsachchitiethoadon  dscthd = new Danhsachchitiethoadon();
                
                Danhsachloaisach dsls = new Danhsachloaisach();
                Danhsachphieunhap dspn = new Danhsachphieunhap();
                Danhsachnhacungcap dsncc = new Danhsachnhacungcap();
                Danhsachnhaxuatban dsnxb = new Danhsachnhaxuatban();
                Danhsachtacgia dstg = new Danhsachtacgia();
                
		
		boolean exit = false;
		String option = "";
		while (!exit) {
			System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			System.out.println("|             MAIN MENU           |");
			System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			System.out.println("|1. Quan ly sach                  |");
			System.out.println("|2. Quan ly khach hang            |");
			System.out.println("|3. Quan ly nhan vien             |");
			System.out.println("|4. Quan ly hoa don               |");
			System.out.println("|5. Quan ly chi tiet hoa don      |");
			System.out.println("|6. Quan ly loai giam gia         |");
                        System.out.println("|7. Quan ly thong tin giam gia    |");
			System.out.println("|8. Quan ly loai sach             |");
			System.out.println("|9. Quan ly phieu nhap hang       |");
			System.out.println("|10. Quan ly nha cung cap          |");
                        System.out.println("|11.Quan ly nha xuat ban          |");
                        System.out.println("|12.Quan ly tac gia               |");
			System.out.println("|0. Thoat                         |");
			System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			System.out.print("Lua chon: ");
			option = in.nextLine();
            System.out.println("----------");
			switch (option) {
				case "1":
					
					break;
				case "2":
					
					break;
				case "3":
					
					break;
				case "4":
					
					break;
				case "5":
					
					break;
				case "6":
					
					break;
				case "7":
					
					break;
				case "8":
					
					break;
				case "9":
					
					break;
				case "0":
                                {System.out.println("XIN CHAO va HEN GAP LAI");
					exit = true;
					break;}
				default:
                	System.out.println("NHAP SAI LUA CHON. MOI CHON LAI.");
			 		break;
			}
            System.out.println("----------");
		}
		

    
        }   
    public  static void MainMenu(){
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        Danhsachnhanvien dsnv = new Danhsachnhanvien();
        dsnv.docfile("Nhanvien.txt");
		String taikhoan;
                String password;
		
		String option = "";
		while (!exit) {
			System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			System.out.println("|             MAIN MENU           |");
			System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			System.out.println("|1. Quan ly sach                  |");
			System.out.println("|2. Quan ly khach hang            |");
			System.out.println("|3. Quan ly hoa don               |");
			System.out.println("|4. Quan ly chi tiet hoa don      |");
			System.out.println("|5. Quan ly loai giam gia         |");
                        System.out.println("|6. Quan ly thong tin giam gia    |");
			System.out.println("|7. Quan ly loai sach             |");
			System.out.println("|8. Quan ly phieu nhap hang       |");
			System.out.println("|9. Quan ly nha cung cap          |");
                        System.out.println("|10.Quan ly nha xuat ban          |");
                        System.out.println("|11.Quan ly tac gia               |");
			System.out.println("|0. Thoat                         |");
			System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
			System.out.print("Lua chon: ");
			option = in.nextLine();
            System.out.println("----------");
			switch (option) {
				case "1":
                                        System.out.println("DANG NHAP TAI KHOAN NHAN VIEN");
					System.out.print("Tai Khoan :");
                                        taikhoan = in.nextLine();
                                        System.out.print("Mat Khau :");
                                        password = in.nextLine();
                                        if(dsnv.checklogin(taikhoan, password,"nhanvien"))
                                        {
                                            Menunhanvien();
                                        }
                                        else
                                        {
                                            System.out.println("Tai khoan hoac mat khau khong chinh xac !");
                                        }
					break;
				case "2":
					System.out.println("DANG NHAP TAI KHOAN ADMIN");
					System.out.print("Tai Khoan :");
                                        taikhoan = in.nextLine();
                                        System.out.print("Mat Khau :");
                                        password = in.nextLine();
                                        if(dsnv.checklogin(taikhoan, password,"admin"))
                                        {
                                            Menuadmin();
                                        }
                                        else
                                        {
                                            System.out.println("Tai khoan hoac mat khau khong chinh xac !");
                                        }
					break;
				case "0":
					System.out.println("XIN CHAO va HEN GAP LAI");
					exit = true;
					break;
				default:
                	System.out.println("NHAP SAI LUA CHON. MOI CHON LAI.");
			 		break;
			}
            System.out.println("----------");
		}
		
	}
}
