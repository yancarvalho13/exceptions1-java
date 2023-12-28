package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainExceptions;

public class program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		boolean validInput = false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		do {
			try {
				System.out.print("Room number: ");
				int roomNumber = scan.nextInt();
				System.out.print("Check-in date (dd/MM/yyyy): ");
				scan.nextLine();
				Date checkIn = sdf.parse(scan.next());
				System.out.print("Check-out date (dd/MM/yyyy): ");
				Date checkOut = sdf.parse(scan.next());

				Reservation reserv = new Reservation(roomNumber, checkIn, checkOut);
				System.out.println("Reservation: " + reserv);

				System.out.println();
				System.out.println("Enter data to update the reservation: ");
				System.out.print("Check-in date (dd/MM/yyyy): ");
				scan.nextLine();
				checkIn = sdf.parse(scan.next());
				System.out.print("Check-out date (dd/MM/yyyy): ");
				checkOut = sdf.parse(scan.next());

				reserv.updateDates(checkIn, checkOut);

				validInput = true;

				System.out.println("Reservation: " + reserv);
			} catch (ParseException e) {
				System.out.println("Invalid date format");
			} catch (DomainExceptions e) {
				System.out.println("Error in reservation: " + e.getMessage());
			} catch (RuntimeException e) {
				System.out.println("Unexpected error");
			}
		} while (!validInput);
		scan.close();
	}
}
