import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        String[] names1 = null; // result: e
//        String[] names2 = null;

//        String[] names1 = {}; // result: e
//        String[] names2 = {};

        String[] names1 = {"Ava", "Emma", "Olivia"}; // result: Ava, Emma, Olivia and Sophia
        String[] names2 = {"Olivia", "Sophia", "Emma"};

        try {
            String[] uniqueNames = uniqueNames(names1, names2);
            String result = "";
            for (int i = 0; i < uniqueNames.length; i++) {
                if (i != uniqueNames.length - 1) {
                    result = result + uniqueNames[i] + ", ";
                } else {
                    result = result + "and " + uniqueNames[i];
                }
            }
            System.out.println(result);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[] uniqueNames(String[] names1, String[] names2) throws IllegalArgumentException {
        if ((names1 == null) || (names2 == null)) {
            throw new NullPointerException("Illegal argument: null");
        }
        if ((names1.length == 0) || (names2.length == 0)) {
            throw new IllegalArgumentException("Illegal argument: no strings");
        }
        List<String> uniqueNamesList = new ArrayList<>();
        for (int i = 0; i < names1.length; i++) {
            if (!uniqueNamesList.contains(names1[i])) {
                uniqueNamesList.add(names1[i]);
            }
        }
        for (int i = 0; i < names2.length; i++) {
            if (!uniqueNamesList.contains(names2[i])) {
                uniqueNamesList.add(names2[i]);
            }
        }

        String[] uniqueNames = new String[uniqueNamesList.size()];
        for (int i = 0; i < uniqueNamesList.size(); i++) {
            uniqueNames[i] = uniqueNamesList.get(i);
        }
        return uniqueNames;
    }
}
