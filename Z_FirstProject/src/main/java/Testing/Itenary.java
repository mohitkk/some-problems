package Testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Itenary {
    public static void main(final String args[]) {
        final String[][] input = { { "JFK", "MUC" }, { "MUC", "CHC" }, { "CHC", "BAD" }, { "BAD", "MUC" },
                { "MUC", "CHD" }, { "CHD", "CHC" }, { "CHC", "NYC" } };
        reconstruct(input);
        System.out.println(Integer.valueOf("4"));
        System.out.println(Integer.valueOf(4));
    }

    public static void reconstruct(final String[][] input) {
        final HashMap<String, List<String>> itrMap = new HashMap<String, List<String>>();
        final int totalTickets = input.length;
        // final String start = "JFK";
        for (int i = 0; i < input.length; i++) {
            if (itrMap.containsKey(input[i][0])) {
                itrMap.get(input[i][0]).add(input[i][1]);
            } else {
                final List<String> alist = new ArrayList<String>();
                alist.add(input[i][1]);
                itrMap.put(input[i][0], alist);
            }
        }

        System.out.println(itrMap);
        System.out.println("---------------");
        final List<String> outputs = new ArrayList<String>();
        for (final String start : itrMap.keySet()) {
            System.out.println("start: " + start);
            reconstruct(itrMap, totalTickets, 0, start, "", outputs);
        }
        System.out.println("---------------");
        System.out.println(outputs);

    }

    public static void reconstruct(final HashMap<String, List<String>> itrMap, final int totalTickets,
            int currentNumber, final String start, String tillNow, final List<String> outputs) {
        System.out.println(totalTickets + " " + currentNumber + " " + start + " " + tillNow + " " + outputs);
        tillNow += "-" + start;
        if (currentNumber == totalTickets) {
            outputs.add(tillNow.substring(1));
            return;
        }
        currentNumber++;
        final List<String> list = new ArrayList<String>();
        if (itrMap.containsKey(start)) {
            list.addAll(itrMap.get(start));
            for (final String each : list) {
                itrMap.get(start).remove(each);
                reconstruct(itrMap, totalTickets, currentNumber, each, tillNow, outputs);
                itrMap.get(start).add(each);
            }
        }
    }
}
