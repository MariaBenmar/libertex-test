package org.libertex;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.Period;

public class CheckBirthDateTestng {

    @DataProvider(name = "testdata")
    public Object[][] TestData() {
        Object[][] data = new Object[3][1];
        data[0][0] = "1970-02-24";
        data[1][0] = "2022-12-01";
        data[2][0] = "2023-11-11";
        return data;
    }

    @Test(dataProvider = "testdata")
    public void birthDate(String str) {
        LocalDate birthDate = LocalDate.parse(str);
        if (LocalDate.now().isAfter(birthDate)) {
            if (calculateAge(birthDate) < 18) {
                System.out.println("Birthdate " + str + " - You are under 18 years.");
            } else {
                System.out.println("Birthdate " + str + " - You are over 18 years old.");
            }
        } else System.out.println("Birthdate " + str + " - The age can't be defined");
    }

    public static int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}
