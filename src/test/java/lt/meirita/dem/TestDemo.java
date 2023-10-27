package lt.meirita.dem;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestDemo {

    @Test
    public void testNumber4isEven(){
        //1.Duomenys
        int input = 4;
        int expectedReminder = 0;
        int actualReminder;

        //2.Testo veiksmai
        actualReminder = input % 2;

        //3. Rezultatu palyginimas
        Assert.assertEquals(actualReminder, expectedReminder);


    }
    @Test
    public void testNumber5IsNotEven(){

        //1.Duomenys
        int input = 5;
        int expectedReminder = 0;
        int actualReminder;

        //2.Testo veiksmai
        actualReminder = input % 2;

        //3. Rezultatu palyginimas
        Assert.assertTrue(
                actualReminder != expectedReminder,"\nValues are not equal\nActual result: %s, \nExpected result: %s".formatted(actualReminder,expectedReminder)
        );


    }
    @Test
    public void testNumberMinus11IsNotEven(){

        //1.Duomenys
        int input = -11;
        int expectedReminder = 1;
        int actualReminder;

        //2.Testo veiksmai
        actualReminder = input % 2;

        //3. Rezultatu palyginimas
        Assert.assertFalse(
                actualReminder == expectedReminder,"\nValues are not equal\nActual result: %s, \nExpected result: %s".formatted(actualReminder,expectedReminder)
        );


    }
    @Test
    public void testNowIs7Pm(){

        //1.Duomenys
        int expectedHour = 19;
        int actualHour;

        //2.Testo veiksmai
        actualHour = LocalTime.now().getHour();


        //3. Rezultatu palyginimas
        Assert.assertTrue(
                actualHour == expectedHour
        );


    }
    @Test
    public void testNumber995Divides3Equally(){

        //1.Duomenys
        int input = 995;
        int expectedReminder = 0;
        int actualReminder;

        //2.Testo veiksmai
        actualReminder = input % 3;

        //3. Rezultatu palyginimas
        Assert.assertFalse(actualReminder == expectedReminder);


    }
    @Test
    public void testTodayisWednesday(){

        //1.Duomenys
        String expectedDay = "WEDNESDAY";
        String actualDay;

        //2.Testo veiksmai
        actualDay = String.valueOf(LocalDate.now().getDayOfWeek());
        System.out.println(actualDay);


        //3. Rezultatu palyginimas
        Assert.assertTrue(
                expectedDay == actualDay
        );


    }
    @Test
    public void testWait5Sec(){

        long startMillis;
        long endMillis;
        int expectedSec = 5;
        int actualSec;

        startMillis = System.currentTimeMillis();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        endMillis = System.currentTimeMillis();

        actualSec = (int) ((endMillis - startMillis)/1000);

        Assert.assertEquals(actualSec, expectedSec);


    }

    }
