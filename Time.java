import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class Time{
    public static void main(String[] args) {
        
        LocalDate date=LocalDate.now();
        LocalDate date1=LocalDate.of(2004,Month.MAY,16);

        System.out.println(date);
        System.out.println(date1);

        LocalTime time=LocalTime.of(12,58,23);
        LocalTime time1=LocalTime.now();
        System.out.println(time);

        Instant In=Instant.now();
        System.out.println(In);

        for(String str: ZoneId.getAvailableZoneIds()){
            System.out.println(str);
        }

        LocalTime time2=LocalTime.now(ZoneId.of("Asia/Singapore"));
        System.out.print(time2);
        
    }
}