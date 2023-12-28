package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = scan.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		scan.nextLine();
		Date checkIn = sdf.parse(scan.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(scan.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-ou date must be after Check-in date");
		} else {

			Reservation reserv = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			scan.nextLine();
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());

			String error = reserv.updateDates(checkIn, checkOut);
			if (error != null) {

				System.out.println(error);
			} else {

				System.out.println("Reservation: " + reserv);
			}
		}

		scan.close();
	}

}
