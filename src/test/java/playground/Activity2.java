package playground;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity2 {

    @Test(dataProvider = "addingData")
    public void test1(String lastName, String firstName, String expectedOutput) {

        String actualResult = getFullName(firstName,lastName);
        Assert.assertEquals(expectedOutput, actualResult);
    }
    public String getFullName(String firstName, String lastName) {
        if (firstName == null || lastName == null)
            throw new RuntimeException("FirstName or Last Name can NOT be null");

        if (firstName.isEmpty() || lastName.isEmpty())
            throw new RuntimeException("First Name or Last Name can NOT be Empty");

        lastName = lastName.trim();
        firstName = firstName.trim();

        return lastName.toUpperCase() + ", " +
                firstName.substring(0, 1).toUpperCase() +
                firstName.substring(1).toLowerCase();
    }

    @DataProvider(name = "addingData")
    private String[][] fullName() {
        String[][] fullName = {
                {"doe", "john", "DOE, John"},
                {"alexander", "mathias", "ALEXANDER, Mathias"},
                {"BaBy", "BOSS", "BABY, Boss"}
        };
        return fullName;
    }


}