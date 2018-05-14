import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Tools {
    public static List<String> digitize(List <String> inputs) {

        List <String> list = new ArrayList<>();
        for (String input: inputs) {
            String str = input.replaceAll("\\D+","");
            list.add( str );
        }
        return list;
    }

    public static String timeStamp (String dateFormat) {                 //"yyyy.MM.dd.HH.mm.ss"
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return sdf.format(time);

    }
}
