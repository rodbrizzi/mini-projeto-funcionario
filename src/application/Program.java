package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the department's name: ");
		String departmentName = sc.nextLine();
		System.out.println();

		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();

		System.out.print("Level: ");
		String workerLevel = sc.nextLine();

		System.out.print("Base salary: ");
		Double workerSalary = sc.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerSalary,
				new Department(departmentName));

		System.out.println();
		System.out.print("How many contracts to this worker? ");
		int numberContracts = sc.nextInt();

		for (int i = 0; i < numberContracts; i++) {
			System.out.println();
			System.out.println("Enter contract #" + (i + 1) + " data: ");
			System.out.print("Date DD/MM/YYYY: ");
			String dateString = sc.next();
			LocalDate dateContract = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();

			System.out.print("Duration (hours): ");
			Integer duration = sc.nextInt();

			HourContract contract = new HourContract(dateContract, valuePerHour, duration);

			worker.addContract(contract);

		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		String dateEdit = "01/" + monthAndYear;
		
		LocalDate dateFilter = LocalDate.parse(dateEdit, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		int month = dateFilter.getMonthValue();
		int year = dateFilter.getYear();
		
		System.out.println();
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: "+ worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + worker.income(month, year));
				
		
		
		
		
		
		
		
		sc.close();
	}
}
