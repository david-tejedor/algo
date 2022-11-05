package toolset;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneUtil {

    public static void main(String[] args) {
        System.out.println(calcTimeZoneOffSetInMinutes("Europe/Madrid"));
    }

    private static int calcTimeZoneOffSetInMinutes(String timeZone) {
        return ZonedDateTime.now(ZoneId.of(timeZone)).getOffset().getTotalSeconds() / 60;
    }
}
