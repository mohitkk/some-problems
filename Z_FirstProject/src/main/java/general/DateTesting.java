package general;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTesting {

    public static void main(final String args[]) {
        final String dString = "04172018";
        // final String dString = "01012018";
        final DateFormat originalFormat = new SimpleDateFormat("mmddyyyy", Locale.ENGLISH);
        final DateFormat targetFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            // final Date date = originalFormat.parse("August 21, 2012");
            final Date date = originalFormat.parse(dString);
            final String formattedDate = targetFormat.format(date);
            System.out.println(formattedDate);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
    }
}
