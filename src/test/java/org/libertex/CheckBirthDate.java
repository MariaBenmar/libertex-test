package org.libertex;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.util.Calendar.*;

public class CheckBirthDate {

    public static void main(String[] args)
    {
        System.out.print("Enter date of birth in YYYY-MM-DD format: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        if (!input.isEmpty()) {
            LocalDate birthDate = LocalDate.parse(input);
            if (LocalDate.now().isAfter(birthDate)) {
                if (calculateAge(birthDate) < 18) {
                    System.out.println("You are under 18 years.");
                } else {
                    System.out.println("You are over 18 years old.");
                }
            }
            else System.out.println("The age can't be defined");
        }
        else System.out.println("The age can't be defined");
    }

    public static int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        if (birthDate != null)    {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
        else {
            return 0;
        }

    }

}
