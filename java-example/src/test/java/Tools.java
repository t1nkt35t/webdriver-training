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

//    public static Integer stringInt (String input) {
//
//        String str = input.replaceAll( "\\D+", "" );
//        System.out.println( Integer.valueOf(str) );
//        return Integer.valueOf(str);
//    }
}
