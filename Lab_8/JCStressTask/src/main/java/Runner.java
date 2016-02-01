import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created on 01.02.2016.
 */
public class Runner {

    public static void main(String[] args) {

        try {
            final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = dateFormat.parse("2015-07-25");

            Calendar calendar = new GregorianCalendar().getInstance();
            calendar.clear();
            calendar.set(Calendar.YEAR, 2015);
            calendar.set(Calendar.MONTH, 6);
            calendar.set(Calendar.DATE, 25);
            Date date = calendar.getTime();

            System.out.println(date);
            System.out.println(parsed);
            System.out.println(date.equals(parsed));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
