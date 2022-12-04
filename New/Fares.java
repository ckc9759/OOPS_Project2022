import java.util.*;
public class Fares{
    public static String getCost(String str){
        if(str.equals("PilaniDelhi")||str.equals("DelhiPilani")){
            return Integer.toString(3500);
        }
        else if(str.equals("PilaniJaiput")||str.equals("JaipurPilani")){
            return Integer.toString(3000);
        }
        else if(str.equals("JaipurDelhi")||str.equals("DelhiJaipur")){
            return Integer.toString(3500);
        }
        return Integer.toString(5000);
    }
    public static TreeMap<String,String> farelist;
}