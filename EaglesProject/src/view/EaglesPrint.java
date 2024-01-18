package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import controller.MainController;
import service.MemberService;
import service.TicketService;
import util.ScanUtil;
import vo.GameVo;
import vo.MemberVo;
import vo.RestaurantVo;
import vo.TicketVo;

public class EaglesPrint {
	
	public static final String black = "\u001B[30m";
	public static final String red = "\u001B[31m";
	public static final String green = "\u001B[32m";
	public static final String yellow = "\u001B[33m";
	public static final String blue = "\u001B[34m";
	public static final String purple = "\u001B[35m";
	public static final String cyan = "\u001B[36m";
	public static final String white = "\u001B[37m";
    public static final String orange = "\u001B[38;2;255;111;15m";
	public static final String exit = "\u001B[0m";

	public static void main(String[] args) {
		System.out.println(red + "test" + exit);
		System.out.println(black + "test" + exit);
		System.out.println(green + "test" + exit);
		System.out.println(yellow + "test" + exit);
		System.out.println(blue + "test" + exit);
		System.out.println(purple + "test" + exit);
	}

	TicketService ticketService = TicketService.getInstance();
	MemberService memberService = MemberService.getInstance();
	
	public void printLn(int num) {
		for (int i = 0; i < num; i++)
			System.out.println();
	}

	public void printLongVar() {
		System.out.println("─────────────────────────────────────────────°•⚾•°─────────────────────────────────────────────");
	}
	
	public void printLongVar2() {
		System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────");
	}

	public void printVar1() {
		System.out.println("\t\t\t\t\t    ─────────°•⚾•°─────────");
	}

	public void printVar2() {
		System.out.println("\t\t\t\t\t    ────────────────────────");
	}

	public void printMenuVar1() {
		System.out.println("────────────°•⚾•°────────────");
	}

	public void printMenuVar2() {
		System.out.println("──────────────────────────────");
	}
	
	public void printSlogan() {
	      System.out.println(orange+"\r\n" + 
	            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
	            "⠀⠀⠀⠀⠀⠀⠀⠀⣾⣾⣾⣾⣾⡆⣠⣶⡖⠀⣤⣶⡆⢠⣴⡶⠀⣤⣴⣶⣷⣷⡀⠀⠀⢠⣶⡶⠀⣤⣶⣶⣿⣶⠀⠀⠀⠀⠀⢠⣶⣾⣿⣿⣷⡀⢰⣶⣟⠀⢰⣶⡟⢀⣶⣶⣿⣿⣷⡄⠀⠀⢰⣶⡗⠀⢰⣶⣿⠀⢠⣶⣾⠀⢠⣶⣾⡇⠀⣤⣶⡀⣠⣶⡎⠀⠀⠀⠀⠀⠀⠀\r\n" + 
	            "⠀⠀⠀⠀⠀⠀⠀⠀⠁⣽⣿⡇⠁⠁⣾⣿⡃⢀⣿⣿⠂⣸⣿⡏⢸⣿⡿⠀⣿⣿⡃⠀⠀⣼⣿⡇⢸⣿⡏⠀⣿⣿⠅⠀⠀⠀⢀⣿⣿⠅⠀⣿⣿⡃⣾⣿⡇⠀⣿⣿⠇⣸⣿⡗⢀⣿⣿⡃⠀⠀⢸⣿⡏⢀⣿⣿⡿⠀⣼⣿⡃⠀⣾⣿⣿⡇⠀⢿⣿⡆⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
	            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠂⠀⢐⣿⣿⣠⣼⣿⡿⠀⣿⣿⡃⢸⣿⣿⣄⠉⠉⠀⠀⢀⣿⣿⠂⢹⣿⣷⣈⠉⠉⠀⠀⠀⠀⢸⣿⣟⠀⢰⣿⣿⢀⣿⣿⠂⢠⣿⣿⠁⣾⣿⠇⢰⣿⣿⠀⠀⠀⢸⣿⡇⣸⣿⣿⡯⢰⣿⡏⠀⣸⣿⢳⣿⡇⠀⢹⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
	            "⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⡿⠀⠀⢸⣿⡿⡟⣿⣿⡇⢰⣿⡿⠀⠀⠙⢿⣿⣷⡄⠀⠀⢰⣿⣟⠀⠀⠙⢿⣿⣷⡀⠀⠀⠀⠀⣾⣿⡇⠀⣸⣿⡗⢸⣿⡿⠀⢸⣿⡯⢠⣿⣿⣿⣿⡿⠃⠀⠀⠀⢸⣿⢅⣿⡯⣿⣇⣿⣿⡡⢤⣿⠯⢸⢿⠇⠂⠀⣿⣻⡻⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
	            "⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⡏⠀⠀⣿⣿⡃⠀⣿⣿⠅⣸⣿⡏⢰⣶⡖⠀⣽⣿⡇⠀⠀⣾⣿⡇⢰⣶⡆⠀⣿⣿⠅⠀⠀⠀⢀⣿⣿⠁⠀⣿⣿⡃⣾⣿⡇⠀⣿⣿⡇⣸⢿⢯⢻⠿⠧⠴⠔⠖⠒⢛⣋⣋⡫⢋⣭⣭⣭⠆⠀⣶⣶⣥⣼⣿⡇⠀⠀⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
	            "⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠂⠀⢠⣿⣿⠀⢸⣿⣟⠀⣾⣿⡃⢼⣿⣧⣠⣿⣿⠁⠀⢀⣿⣿⠁⣽⣿⣇⣬⣿⡿⠀⠀⠀⠀⠘⠟⠛⠀⢊⢋⠙⠀⣉⣉⣤⣥⣥⡤⠀⣴⣴⠆⣲⣾⣇⠀⠀⠀⠀⢸⣿⣿⠇⢐⣿⣿⡯⠀⢸⣿⡟⠋⢻⣿⡇⠀⠀⣿⣿⠅⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
	            "⠀⠀⠀⠀⠀⠀⠀⠘⠋⠋⠀⠀⠘⠋⠉⠀⠚⠋⠁⠐⠛⠉⠀⠈⠻⠻⠛⠉⠁⠀⠀⠐⠋⠋⠀⠘⠻⠻⠛⠙⠁⠀⠀⠀⠀⠀⠘⠛⠋⠉⠉⠀⠀⠈⠛⠋⠉⠈⠀⠀⠋⠉⠀⠘⠉⠁⠀⠀⠀ ⠀⠘⠉⠉⠀⠐⠉⠉    ⠀⠋⠉⠀⠀⠙⠉⠀⠀⠀⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
	            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
	            ""+exit);
	   }
	
	
	public void printLogo() {
        System.out.println(orange+"\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                  ⣀⣴⡾⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                ⢀⣠⣤⣶⣿⣿⣿⠇⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀               ⢀⣀⣀⣤⣴⣶⡿⢻⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣀⣀⣀⣤⣤⣴⣴⣶⣶⣶⣿⣿⢿⣿⣿⡿⡿⡿⡿⢿⠿⡿⡿⡿⡿⣿⣿⣿⣿⣿⣷⣷⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣾⣿⣿⣿⣿⢿⠿⠛⡩⠁⣠⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⢀⣀⣠⣤⣴⣶⣾⣿⠿⠿⠻⠛⠛⠙⣉⡉⣉⢨⢠⢄⠤⡤⠤⡤⡰⡰⡰⡰⡰⡰⡰⡄⡆⡦⠤⡄⡤⡠⡠⡠⡨⣈⢉⢉⢉⢉⡉⣉⢉⡉⣉⢉⣁⢡⢠⢄⢆⢆⠇⢁⣴⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⠀⢀⣀⣤⣴⣶⣿⠿⠻⠛⢙⢉⡁⡤⡠⡢⡲⡸⡸⡪⡝⣔⢕⢕⢕⢕⢕⢝⢜⢝⢜⢜⢎⢎⢎⢎⢎⢮⢪⡪⡪⡝⣜⢜⢜⢜⢎⢎⢎⢎⢇⢗⢕⢕⢕⢕⢕⢕⢕⢎⢮⢪⠪⠊⢀⣤⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⢀⣴⣾⠿⠟⢋⢩⢠⢤⢲⢸⢜⢎⢎⢎⠎⠎⠎⠎⠎⠎⠎⠎⠎⠎⠎⠇⠳⠱⠱⠱⠱⠱⠕⡕⣕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⠕⠕⠑⠁⢀⣠⣴⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣤⣾⡿⢁⢔⢕⠕⠑⠑⠁⠁⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢀⠤⡄⣆⢦⢣⢳⢹⢸⡸⡪⠃⠃⠃⠑⠁⠃⠑⠁⠃⠑⠁⠃⠑⠁⠁⠁⠁⠁⠁⠀⢀⣀⣠⣴⣶⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⡿⠿⠟⠛⡋⣋⡁⡎⠮⠠⠤⠰⢰⢰⠔⠂⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢔⢜⢜⢕⢝⢜⢜⢜⢜⢎⢎⢇⠃⠀⢀⣤⣴⣴⣴⣴⣴⣴⣴⣴⣴⣴⣴⣦⣶⣶⣶⣾⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⢀⣾⣿⠋⡠⡢⡲⡱⡹⡸⡢⡃⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢎⢎⢮⢪⡪⡪⡪⡣⡣⡣⡳⡱⡅⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⢸⣿⣯⠐⡕⠕⠑⠁⠉⠈⠈⠊⠊⠊⠒⠲⢰⠤⢤⢠⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⡎⡇⡧⡣⡣⡫⡪⡪⡪⡪⡪⡪⠀⠀⣾⢿⡿⣿⢿⡿⣿⢿⡿⣿⢿⡿⡿⠿⠿⢛⠉⠀⣼⣿⣿⣿⣿⣿⡟⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⢿⣿⣄⠘⠀⢰⣾⣿⣿⣿⣾⣶⣶⣤⣤⣀⡈⠈⠑⠱⢍⢏⢎⢆⢆⢄⡀⠀⠀⠀⢰⢱⢕⢕⢕⢕⢝⢜⢜⢎⢎⢎⢮⢢⢢⠤⡤⢤⠤⡤⢤⠤⡤⢤⠤⡤⢤⢔⢔⡲⡸⠂⠀⣼⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣦⡀⢸⣿⣿⣿⠿⠿⣿⣿⣿⣿⣿⣿⣷⣶⣤⡀⠁⠃⢇⢧⢣⢳⢹⢰⢄⢇⢧⢳⢱⡱⡕⣕⢕⢕⢕⢕⢕⢕⢕⢕⢝⢜⢎⢇⢏⢎⢇⢏⢎⢇⢏⢎⢮⠪⠊⠀⣠⣾⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⣿⣷⣿⣿⣯⠀⠀⠀⠈⠈⠛⠿⢿⣿⣿⣿⣿⣷⣦⣀⠈⠘⢎⢮⢪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡣⡳⡱⠱⠱⠱⠱⠱⠱⠱⠱⠱⠕⠕⠕⠕⠑⠁⠁⢀⣠⣾⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⢿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠉⠛⢿⣿⣿⣿⣿⣷⣄⠀⠑⢱⡱⡹⡸⡜⡜⡎⣎⢮⢪⢪⢪⡪⡊⠀⢀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣤⣤⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⣷⠀⡎⣎⢮⢪⡪⡪⡪⡪⡪⡪⡣⡣⡓⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⠇⢰⢱⡱⡱⡱⡱⡕⡕⡝⡜⡎⡮⡪⠂⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⡟⢀⢇⢇⢇⢏⢎⢎⢮⢪⡪⡪⡪⡪⡊⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡿⠟⡛⠉⢨⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⠁⡜⡜⡕⡕⡕⡕⡕⡕⡕⡕⡝⡜⡎⡆⡤⡠⡠⡠⡠⡠⡠⡠⡠⡠⡠⡠⡠⡠⡠⡄⡖⠜⠀⢠⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⡇⢰⢱⢹⢸⢪⢪⢪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⠪⠊⠀⣴⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⡿⠀⡎⡇⡗⡕⡕⡕⡕⡕⡕⡕⡝⡜⡎⡎⡮⡪⡪⡪⡪⡪⡪⡪⡪⡪⡪⠪⠪⠊⠊⠀⢀⣴⣾⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣤⣴⣾⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠚⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠋⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              ""+exit);
        System.out.println("\r\n" + 
              "         ⠀⠀   ⠀⠀  ⠀⠠⣿⣷⣿⣿⣾⡗⢰⣼⡞⠀⣴⣶⡇⢠⣶⣷⠐⣤⣶⣷⣿⣷⡄⠀⠀⢢⣾⡾⢀⣴⣼⣾⣾⣷⡀⠀⠀     ⢨⣶⣷⣿⣿⣷⡄⢢⣷⡿⠀  ⣸⣾⣟ ⢠⣾⣾⣿⣿⣷⡆⠀⠀⢼⣾⡯⠀⣰⣷⣿⠀⢰⣵⣿⠁⢠⣷⣿⡇ ⢠⣰⣼⡄⣰⣾⡞⠀⠀⠀⠀⠀     \r\n" + 
              "         ⠀⠀⠀⠀⠀⠀⠀⠈⠉⣽⣿⡏⠁⠁⣿⣿⡇⢐⣿⣿⠃⢼⣿⡏⢸⣿⡿⠀⣿⣿⡇⠀⠀⣽⣿⡇⢼⣿⡟⠈⣿⣿⡃⠀⠀⠀⢠⣿⣿⠃⢀⣿⣿⠇⣾⣿⡏⠀ ⣾⣿⡇  ⢸⣿⡯⢀⣿⣿⠇⠀⠀⢺⣿⡏⢀⣿⣿⣿⠀⣾⣿⠇⢀⣿⣿⣿⡇⠀ ⣿⣿⣇⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "         ⠀⠀⠀⠀⠀⠀⠀⠀⠠⣿⣿⠅⠀⢰⣿⣿⣤⣼⣿⡿⢀⣿⣿⠇⢹⣿⣿⣤⡉⠈⠀⠀⢠⣿⣿⠅⢹⣿⣿⣌⡉⠉⠀⠀⠀⠀⣸⣿⡿⠀⢸⣿⣿⢡⣿⣿⠅  ⢰⣿⣿⠁ ⣿⣿⡇⢸⣿⣿⠁⠀⠀⣸⣿⡇⣼⣿⣿⣗⢰⣿⡟⠀⣸⣿⢽⣿⡇⠀ ⢸⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
              "         ⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⡿⠀⠀⣸⣿⡿⠛⣿⣿⡏⢰⣿⣿⠀⠀⠉⠿⣿⣿⡄⠀⠀⢸⣿⣟⠀⠀⠙⠿⣿⣷⡄⠀⠀⠀⠀⣾⣿⡇⠀⣺⣿⡗⢸⣿⣟⠀  ⣸⣿⡟  ⢰⣿⣿⣿⣿⡿⠃⠀⠀⠀⢸⣿⣧⣿⣟⣿⣧⣿⡿⠥⢴⢿⠟⠸⣿⡋⠈⠈ ⣿⣟⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"         ⠀⠀⠀⠀⠀⠀⠀ ⣾⣿⡏⠀⠀⣿⣿⠇ ⢐⣿⣿⠅⢼⣿⡗⢸⣷⡗⠀⣿⣿⡇⠀⠀⣿⣿⡇⢼⣾⡇⢀⣿⣿⠇⠀⠀⠀⢰⣿⣿⠅⢀⣿⣿⠇⣿⣿⡇⢀⢿⠿⠇ ⠼⠿⠯  ⠞⡟⡓⠒⠚⠊⠋⢹⣭⣭⡵⢉⣷⣷⣾⠂⣾⣿⣷⣾⣿⡇⠀      ⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "         ⠀  ⠀⠀   ⠀⢰⣿⣿⠅⠀⢸⣿⣿⠁⢸⣿⣟⢀⣿⣿⡃⢹⣿⣷⣾⣿⡿⠂⠀ ⢐⣿⣿⠂⢻⣿⣷⣾⣿⡟⠁⠀⠀⠈⣉⣉⣁⣌⡍⠌⠀⢴⣴⣴⣶⠶⠖ ⢀⣿⢿⠃   ⢽⣿⡯⠀⠀⠀⠀  ⣸⣿⡿⠃⢨⣿⡿⡏⣼⡿⠏⠁⢽⣿⠇⠀      ⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀   \r\n"
				+ "         ⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠈⠈⠀⠀⠉⠁⠀⠀⠉⠀⠀⠀⠉⠋⠉⠀⠀⠀⠀  ⠈⠉⠀⠀  ⠈⠉⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀       ⠀⠈⠀⠀⠀⠀⠁⠀⠀⠀⠁⠀⠀⠀⠁⠀⠀ ⠀⠀   ⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
	}
	
	public void printAdminImage() {
		System.out.println("\r\n" + 
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣾⣿⣿⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"⠀⠀⠀⠀⠀⠀⠀⠀⢼⣿⣿⣿⣿⣿⣿⣿⡦⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"⠀⠀⠀⠀⠀⠀⠀⠀⢽⣿⣿⣿⣿⣿⣿⣿⡗⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"⠀⠀⠀⠀⠀⠀⢀⣠⣄⡈⠛⠿⢿⠿⠋⠠⣠⣄⡀⠀⠀⠀⠀⠀⠀\r\n" + 
				"⠀⠀⠀⠀⢀⣾⣿⣿⣿⣦⠀⠲⣶⠆⠀⣾⣿⣿⣿⣶⡀⠀⠀⠀⠀\r\n" + 
				"⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣷⡨⣿⣂⣾⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀\r\n" + 
				"⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀\r\n" + 
				"⠀⠀⠀⠘⢿⣿⣿⣿⠉⣠⣀⣅⣠⣁⣄⣁⠙⣿⣿⣿⡿⠁⠀⠀⠀\r\n" + 
				"⠀⠀⠀⠀⠀⠁⠉⠉⠀⡿⣿⡿⣿⣿⢿⡿⠀⠉⠉⠁⠀⠀⠀⠀⠀\r\n" + 
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"");
	}

	public void printHome() {
		printVar1();
		System.out.println("\t\t\t\t\t     1. 로그인");
		System.out.println("\t\t\t\t\t     2. 회원가입");
	}

	public void printAdmin() {
		printLn(2);
		System.out.println("1. 경기 정보 수정\r\r\r");
		System.out.println("2. 회원 목록 조회\r\r\r");
		System.out.println("3. 로그아웃");
	}

	public void printMember() {
		printLongVar();
		MemberVo mem = (MemberVo) MainController.sessionStorage.get("user");
		String memNm = mem.getMem_name();
		System.out.println("\r   👤 "+memNm+"님 환영합니다");
		printLn(11);
		System.out.println("\t1. 경기내역 조회\r\r ");
		System.out.println("\t2. 티켓 예매\r\r");
		System.out.println("\t3. 예매티켓 조회\r\r");
		System.out.println("\t4. 응원도 식후경\r\r");
		System.out.println("\t5. 마이페이지\r\r");
		System.out.println("\t6. 로그아웃\r\r");
		printLn(11);
		printLongVar2();
	   }
	
	public void printTicketList() {
		System.out.println("\t      ⚾ 티켓목록 ⚾");
		System.out.println("------------------------------------------");
		System.out.println("구분 \t 1구간(화/수/목)\t 2구간(금/토/일)");
		System.out.println("------------------------------------------");
		System.out.println("1루 \t    7000원 \t   9000원");
		System.out.println("------------------------------------------");
		System.out.println("3루 \t    7000원 \t   9000원");
		System.out.println("------------------------------------------");
		System.out.println("외야 \t    5000원 \t   7000원");
		System.out.println("------------------------------------------");
	}
	
	public void printAvailGameList() {
		List<GameVo> list = ticketService.availGameList();
		System.out.println("\t      ⚾ 예매 가능한 경기 ⚾");
		printLn(1);
		System.out.println("번호\t      경기날짜\t         상대팀");
		for (GameVo gameVo : list) {
			int no = gameVo.getGame_no();
			Date date = gameVo.getGame_date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
			String str_date = sdf.format(date);
			String team = gameVo.getOpt_name();
			System.out.println(no+"\t"+str_date+"\t vs "+team);
		}
		printLn(2);
	}
	
	public void printAreaMenu() {
		printMenuVar1();
		System.out.println("1. 1루(홈)");
		System.out.println("2. 3루(원정팀)");
		System.out.println("3. 외야");
		System.out.println("4. 메인");
		printMenuVar2();
	}
	
	public void printSeatMenu(List<List<Object>> list) {
		printLn(14);
		String block = ScanUtil.nextLine("블록(A-J) 선택 >");
		block = block.toUpperCase();
		int row = ScanUtil.nextInt("번호선택 >");
		List<Object> param = new ArrayList<Object>();
		int blockNo = block.charAt(0) - 64;
		int gameNo =  (int) MainController.sessionStorage.get("gameNo");
		int areaNo = (int) MainController.sessionStorage.get("area");
		param.add(gameNo);
		param.add(areaNo);
		param.add(blockNo);
		param.add(row);
		list.add(param);

	}

	public void printSeatSel() {
		printLn(1);
		System.out.println("1. 추가 좌석 선택");
		System.out.println("2. 결제 진행");
		System.out.println("3. 취소");

	}

	public void printMypage() {
		printLn(1);
		System.out.println("1. 회원정보 수정\r\r\r");
		System.out.println("2. 회원 탈퇴\r\r\r");
		System.out.println("3. 로그아웃\r\r\r");
		System.out.println("4. 홈\r\r\r");
		printLn(1);
		printMenuVar2();
	}

	public void printUpdate() {
		printLongVar();
		printLn(12);
		System.out.println("1. 패스워드 변경\r\r\r");
		System.out.println("2. 전화번호 변경\r\r\r");
		System.out.println("3. 마이페이지\r");
		printLn(13);
		printLongVar2();
	}
	
	public void printGameList(List<GameVo> gameList) {
		System.out.println("\t    경기날짜\t\t\t 상대팀\t\t           경기결과");
		System.out.println("\t--------------------------------------------------------------------");
		for (GameVo gameVo : gameList) {
			Date date = gameVo.getGame_date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
			String str_date = sdf.format(date);
			String result = gameVo.getGame_result();
			String team = gameVo.getOpt_name();
			System.out.println("\t  "+str_date + "\t\t  한화이글스 vs " + team + "\t\t" + result);
		}
		printLn(5);
		printLongVar2();
		printLn(2);
		System.out.println("\t1. 이전페이지\r\r");
		System.out.println("\t2. 다음페이지\r\r");
		System.out.println("\t3. 메인화면");
		printLn(2);
		printLongVar2();		
		printLn(1);
	}
	
	public void printSeatList(int gameNo) {
		System.out.println("\t [1루] \n");
		ticketService.seatList(1, gameNo);
		System.out.println("\t [3루] \n");
		ticketService.seatList(2, gameNo);
		System.out.println("\t [외야] \n");
		ticketService.seatList(3, gameNo);
	}

	public void printMemList() {
		List<MemberVo> list = memberService.memList();
		for (MemberVo memberVo : list) {
			int no = memberVo.getMem_no();
			String id = memberVo.getMem_id();
			String pw = memberVo.getMem_pw();
			String name = memberVo.getMem_name();
			Date date = memberVo.getMem_birth();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String str_birth = sdf.format(date);
			String phone = memberVo.getMem_phone();

			System.out.println("NO: "
			+ no + "\n" + "ID: " + id + "\n" + "이름: " + name + "\n" + "생년월일: " + str_birth
					+ "\n" + "전화번호: " + phone);
			System.out.println("");
		}
	}

	public void printGameUpdate(List<GameVo> list) {
		System.out.println("번호\t      경기날짜\t         상대팀\t   경기결과");
		for (GameVo gameVo : list) {
			int no = gameVo.getGame_no();
			Date date = gameVo.getGame_date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
			String str_date = sdf.format(date);
			String team = gameVo.getOpt_name();
			String result = gameVo.getGame_result();
			System.out.println(no + "\t" + str_date + "\t vs " + team + "\t\t" + result);
		}
	}
	public void printReservationList(int memNo) {
        
           List<TicketVo> reserveList  = ticketService.ticketingList(memNo);
           
           int a=0;
           for (TicketVo ticketVo : reserveList) {
              int payNo = ticketVo.getPay_no();
              Date payDate = ticketVo.getPay_date();
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
              String str_payDate = sdf.format(payDate);
              Date gameDate = ticketVo.getGame_date();
              SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd(E)");
              String str_gameDate = sdf2.format(gameDate);
              String opt = ticketVo.getOpt_name();
              String gugan = ticketVo.getGugan_no();
              String area = ticketVo.getArea_name();
              String block = ticketVo.getBlock_nm();
              String row = ticketVo.getSeat_row();
              String cancel = ticketVo.getCancel_yn();
              int pay = ticketVo.getPrice_pay();
              if(a!=payNo)   {
                 System.out.println();
                 printMenuVar1();
                 System.out.println(green+"예매번호 "+payNo+exit);
                 System.out.println("예매일시 "+str_payDate);
                 System.out.println("경기정보 "+str_gameDate+"  vs "+opt);
                 a = payNo;
              }
              
              System.out.println(" ["+gugan+"]"+area+" "+block+" "+row+" "+pay+"원 \t"+yellow+cancel+exit);
              System.out.println("");
           }
        }
	public void printReservationListByPay(List<Object> param) {
        
        List<TicketVo> reserveListByPay  = ticketService.ticketingListbyPay(param);
        printLongVar();
        System.out.println("【예매정보】");
        int a=0;
        for (TicketVo ticketVo : reserveListByPay) {
           int payNo = ticketVo.getPay_no();
           Date payDate = ticketVo.getPay_date();
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
           String str_payDate = sdf.format(payDate);
           Date gameDate = ticketVo.getGame_date();
           SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd(E)");
           String str_gameDate = sdf2.format(gameDate);
           String opt = ticketVo.getOpt_name();
           String gugan = ticketVo.getGugan_no();
           String area = ticketVo.getArea_name();
           String block = ticketVo.getBlock_nm();
           String row = ticketVo.getSeat_row();
           String cancel = ticketVo.getCancel_yn();
           int ticketNo = ticketVo.getTk_no();
           int pay = ticketVo.getPrice_pay();
           if(a!=payNo)   {
              System.out.println();
              System.out.println(green+"예매번호 "+payNo+exit);
              System.out.println("예매일시 "+str_payDate);
              System.out.println("경기정보 "+str_gameDate+"  vs "+opt);
              a = payNo;
           }
           printLn(1);
           System.out.println(green+ticketNo+exit+" ["+gugan+"]"+area+" "+block+" "+row+" "+pay+"원 \t"+yellow+cancel+exit);
        }
        printLn(5);
     }
	
	public void printSelectSeatList(List<Object> ticketList) {
		
		List<Map<String, Object>> seatList = ticketService.selectSeatList(ticketList);
		for (Map<String, Object> map : seatList) {
			Date date = (Date) map.get("GAME_DATE");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E)");
			String str_date = sdf.format(date);
			String areaName = (String) map.get("AREA_NAME");
			String blockName = (String) map.get("BLOCK_NM");
			String seatRow = (String) map.get("SEAT_ROW");
			System.out.println(" [ "+str_date+" "+areaName+" "+blockName+" "+seatRow+" ]");
		}
	}
	
	public void printRes() {
		printLongVar();
		printLn(13);
		System.out.println("1. 구장 근처 맛집\r\r\r");
		System.out.println("2. 구장 내부 먹거리\r\r\r");
		System.out.println("3. 홈");
		printLn(13);
		printLongVar2();
	}

	public void printOutsideRes() {
		printLongVar();
		printLn(13);
		System.out.println("1. 구장 근처 식당목록\r\r\r");
		System.out.println("2. 식당검색\r\r\r");
		System.out.println("3. 뒤로가기");
		printLn(13);
		printLongVar2();
	}

	public void printInsideRes() {
		printLongVar();
		printLn(13);
		System.out.println("1. 구장 내부 매장목록\r\r\r");
		System.out.println("2. 식당검색\r\r\r");
		System.out.println("3. 뒤로가기\r\r\r");
		printLn(13);
		printLongVar2();
	}

	public void printResList(List<RestaurantVo> list) {
		printMenuVar1();
		printLn(2);
		for (RestaurantVo restaurantVo : list) {
			String name = restaurantVo.getRes_name();
			String location = restaurantVo.getRes_location();
			int no = restaurantVo.getRn();
			System.out.println(no + ". [ "+name+" ] \r\r" );
		}
		printMenuVar2();
		printLn(3);
		System.out.println("1. 이전페이지\r\r");
		System.out.println("2. 다음페이지\r\r");
		System.out.println("3. 가게 상세조회\r\r");
		System.out.println("4. 뒤로가기");
		printLn(3);
	}

	public void printResDetail(List<RestaurantVo> detailList) {
		System.out.println();
		printLn(2);
		String res = "A";
//		printLn(7);
		for (RestaurantVo restaurantVo : detailList) {
			String resNo = restaurantVo.getRes_no();
			String name = restaurantVo.getRes_name();
			String location = restaurantVo.getRes_location();
			String tel = restaurantVo.getResTel();
			String distance = restaurantVo.getRes_distance();
			String menuName = restaurantVo.getMenu_name();
			String comment = restaurantVo.getRes_remark();
			int menuPrice = restaurantVo.getMenu_price();
			if(!res.equals(resNo)) {
				System.out.println();
				System.out.println(orange+"[ "+name+" ]"+exit);
				System.out.println("☎  "+tel);
				System.out.println("🏠  "+ location+"\t("+distance+")");
				System.out.println("✔️ : "+comment);
				System.out.println();
				res=resNo;
			}
			System.out.println("  ▷  "+menuName+"  "+menuPrice+"원");
		}
		printLn(3);
	}
	
	public void printFctListByLoc(List<RestaurantVo> list) {
		String loc = (String) MainController.sessionStorage.get("loc");
		printLongVar();
		printLn(4);
		if(loc.contains("1")) {
			System.out.println(yellow+"  // 1루 //  "+exit);
		}else if(loc.contains("3")) {
			System.out.println(yellow+"  // 3루 //  "+exit);
		}else {
			System.out.println(yellow+"  // 중앙 //  "+exit);
		}
		printLn(1);
		for (RestaurantVo restaurantVo : list) {
			String name = restaurantVo.getRes_name();
			int rn = restaurantVo.getRn();
			System.out.println(rn+". [ "+name+" ] \r\r");
		}
	}
	
	
	
}
