import java.util.ArrayList;
import java.util.List;

public class Tools {
    public static List<String> split (List <String> inputs) {
        List <String> list = new ArrayList<>();
        for (String input: inputs) {
            String str = input.replaceAll("\\D+","");
            list.add( str );
        }
        return list;
    }
}
