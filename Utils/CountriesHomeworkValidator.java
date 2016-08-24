package com.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CountriesHomeworkValidator {

	public static String menuSelections(Scanner sc) {
		String userInput;
		System.out.println("Press 1 - to display a list of countries.");
		System.out.println("Press 2 - to add a country to this list.");
		System.out.println("Press 3 - to exit the application.");
		userInput = sc.nextLine();
		System.out.println();
		return userInput;
	}
	
	public static boolean correctMenuInput(boolean correctInput, String userInput) {
		switch (userInput) {
		case "1":
		case "2":
		case "3":
			correctInput = false;
			break;
		default:
			System.out.println("I'm sorry that is not a valid option.");
		}
		return correctInput;
	}
	
	public static ArrayList<String> countryReader(ArrayList<String> fromMyCountryFile, File aNewFile) {
		try (BufferedReader in = new BufferedReader(new FileReader(aNewFile))) {
			String readingStuff;

			while ((readingStuff = in.readLine()) != null) {
				fromMyCountryFile.add(readingStuff);
			}
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fromMyCountryFile;
	} 
	
	public static void addToCountryFile(String addThisCountry, File aNewFile) {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(aNewFile, true)))) {
			out.println(addThisCountry);

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}