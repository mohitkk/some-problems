package general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTesting {

    public static void main(final String args[]) {
        final String regexToMatchAll = "[0-9]*[.]{0,1}[0-9]*";
        final String testString = ".1234545";
        final Pattern pattern = Pattern.compile(regexToMatchAll);
        final Matcher matcher = pattern.matcher(testString);
        System.out.println(matcher.matches());

        Pattern p = Pattern.compile("^migrate\\.data");
        Matcher m = p.matcher("migrate.data.empi_links_2_0.metadata");
        System.out.println(m.matches());
    }
}
