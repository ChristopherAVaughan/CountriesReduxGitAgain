package com.CountriesHW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.Utils.CountriesHomeworkValidator;

public class CountriesHW {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean correctInput = true;
		boolean continueApp = true;
		String userInput = null;
		String addThisCountry = null;
		ArrayList<String> fromMyCountryFile = new ArrayList<>();

		Path ourCountryPath = Paths
				.get("\\Users\\admin\\newWorkspace\\CountriesHW\\src\\com\\Utils\\CountriesVaughanVisited");
		File aNewFile = ourCountryPath.toFile();

		System.out.println("Welcome to the Chris Vaughan countries list.");
		System.out.println(
				"These are the counrtries Chris Vaughan has either lived, traveled to, or wants to visit in the future.\n");

		do {
			do {
				userInput = CountriesHomeworkValidator.menuSelections(sc);
				correctInput = CountriesHomeworkValidator.correctMenuInput(correctInput, userInput);
			} while (correctInput);
			switch (userInput) {
			case "1":
				fromMyCountryFile = CountriesHomeworkValidator.countryReader(fromMyCountryFile, aNewFile);

				for (int i = 0; i < fromMyCountryFile.size(); i++) {
					System.out.println((i + 1) + ". " + fromMyCountryFile.get(i));
				}
				System.out.println();
				fromMyCountryFile.clear();
				break;
			case "2": 
				System.out.println("What country would you like to add?");
				addThisCountry = sc.nextLine();
				CountriesHomeworkValidator.addToCountryFile(addThisCountry, aNewFile);
				break;
			case "3": 
				continueApp = false;
				System.out.println("Thank you for using the app.  Have a great day!");
				break;
			}
		} while (continueApp);

		

	}// main

} // class
