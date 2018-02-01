package Testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ReadCSV {
    public static void main(final String args[]) {
        try {
            final Map<String, Integer> cms_firstMap = load("/Users/mk049501/Downloads/cms_old_total.csv");
            System.out.println("CMS OLD MAP Size     " + cms_firstMap.size());
            final Map<String, Integer> cms_secondMap = load("/Users/mk049501/Downloads/cms_new_total.csv");
            System.out.println("CMS NEW MAP Size     " + cms_secondMap.size());
            printDiff(cms_firstMap, cms_secondMap, "cms.txt");

            System.out.println();
            System.out.println();

            final Map<String, Integer> ppc_firstMap = load("/Users/mk049501/Downloads/ppc_old_total.csv");
            System.out.println("PPC OLD MAP Size    " + ppc_firstMap.size());
            final Map<String, Integer> ppc_secondMap = load("/Users/mk049501/Downloads/ppc_new_total.csv");
            System.out.println("PPC NEW MAP Size    " + ppc_secondMap.size());
            printDiff(ppc_firstMap, ppc_secondMap, "ppc.txt");
            // printMap(cms_firstMap);
            System.out.println("----------");
            System.out.println("db322bc4-a0c0-4f42-8c54-704a1295f704 in CMS OLD  "
                    + cms_firstMap.get("db322bc4-a0c0-4f42-8c54-704a1295f704"));
            System.out.println("db322bc4-a0c0-4f42-8c54-704a1295f704 in CMS New  "
                    + cms_secondMap.get("db322bc4-a0c0-4f42-8c54-704a1295f704"));
            System.out.println();
            System.out.println("db322bc4-a0c0-4f42-8c54-704a1295f704 in PPC OLD  "
                    + ppc_firstMap.get("db322bc4-a0c0-4f42-8c54-704a1295f704"));
            System.out.println("db322bc4-a0c0-4f42-8c54-704a1295f704 in PPC NEW  "
                    + ppc_secondMap.get("db322bc4-a0c0-4f42-8c54-704a1295f704"));
            System.out.println("----------");
            // final double x = (double) 14 / 16;
            // System.out.println("x:" + x);
            final List<String> inputVals = ReadTextFile("/Users/mk049501/Documents/NeonWorkSpace2/Z_FirstProject/count-diff-ppc.txt");

            final int i = 0;
            for (final Entry<String, Integer> each : ppc_secondMap.entrySet()) {
                if (inputVals.contains(each.getKey())) {
                    // i++;
                    // System.out.println(i + ".  " + each.getKey() + "  ---------   " + each.getValue());

                }
            }

        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> load(final String name) throws IOException {

        final Map<String, Integer> re = new HashMap<String, Integer>();
        final Scanner scanner = new Scanner(new File(name));
        scanner.useDelimiter(",");
        // while (scanner.hasNext()) {
        // System.out.print(scanner.next() + "|");
        // }
        scanner.close();

        final BufferedReader br = new BufferedReader(new FileReader(name));
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.equals("empipersonmetadata.empipersonid,_c1")) {
                final String[] emp = line.split(",");
                re.put(emp[0], Integer.valueOf(emp[1]));
            }
        }
        br.close();
        return re;
    }

    private static List<String> ReadTextFile(final String name)
            throws IOException {

        final List<String> re = new ArrayList<String>();
        final Scanner scanner = new Scanner(new File(name));
        scanner.useDelimiter("\\n");
        // while (scanner.hasNext()) {
        // System.out.print(scanner.next() + "|");
        // }
        scanner.close();

        final BufferedReader br = new BufferedReader(new FileReader(name));
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.equals("empipersonmetadata.empipersonid,_c1")) {
                // final String[] emp = line.split(",");
                re.add(line);
            }
        }
        br.close();
        return re;
    }

    private static void printDiff(final Map<String, Integer> old, final Map<String, Integer> neww, final String fileName) {
        final List<String> missingInNew = new ArrayList<String>();
        final List<String> justCountDiff = new ArrayList<String>();
        final List<String> allSame = new ArrayList<String>();
        final Set<Double> factor = new HashSet<Double>();
        final List<String> missingInOLD = new ArrayList<String>();
        final List<String> countsIncreasedInNew = new ArrayList<String>();
        final List<String> countsDecreasedInNew = new ArrayList<String>();
        final List<String> countsSameInNew = new ArrayList<String>();
        // final Map<Double, List<String>> fact = new HashMap<Double, List<String>>();

        for (final String eachKey : neww.keySet()) {
            if (!old.containsKey(eachKey)) {
                missingInOLD.add(eachKey);
            }
        }
        for (final String eachKey : old.keySet()) {
            if (!neww.containsKey(eachKey)) {
                missingInNew.add(eachKey);
            } else if (old.get(eachKey) != neww.get(eachKey)) {
                justCountDiff.add(eachKey);
                final double valueOf = ((double) neww.get(eachKey) / old.get(eachKey));
                factor.add(valueOf);
                // if (fact.get(valueOf) == null) {
                // final List<String> nn = new ArrayList<String>();
                // nn.add(eachKey);
                // fact.put(valueOf, nn);
                // } else {
                // final List<String> list = fact.get(valueOf);
                // list.add(eachKey);
                // fact.put(valueOf, list);
                // }

                // System.out.println(old.get(eachKey) + " - " + neww.get(eachKey));

                if (old.get(eachKey) > neww.get(eachKey)) {
                    countsDecreasedInNew.add(eachKey + " - " + old.get(eachKey) + " - " + neww.get(eachKey));
                } else if (old.get(eachKey) == neww.get(eachKey)) {
                    countsSameInNew.add(eachKey + " - " + old.get(eachKey) + " - " + neww.get(eachKey));
                } else {
                    countsIncreasedInNew.add(eachKey + " - " + old.get(eachKey) + " - " + neww.get(eachKey));
                }
            } else {
                allSame.add(eachKey + " - " + old.get(eachKey) + " - " + neww.get(eachKey));
            }
        }
        System.out.println("");
        System.out.println("size of missing in new: " + missingInNew.size());
        System.out.println("size of just the count differences: " + justCountDiff.size());
        System.out.println("size of everything same: " + allSame.size());
        System.out.println("size of missing in old: " + missingInOLD.size());
        System.out.println("size of factor array: " + factor.size());
        System.out.println("factor array:" + factor);
        writeToFile(justCountDiff, "count-diff-" + fileName);
        writeToFile(missingInNew, "missing-in-new-" + fileName);
        writeToFile(allSame, "allSame-" + fileName);
        writeToFile(missingInOLD, "missingInOLD-" + fileName);
        writeToFile(countsIncreasedInNew, "countsIncreasedInNew-" + fileName);
        writeToFile(countsDecreasedInNew, "countsDecreasedInNew-" + fileName);
        writeToFile(countsSameInNew, "countsSameInNew-" + fileName);
        // System.out.println(fact);

        // for (final Double each : factor) {
        // final List<String> list = fact.get(each);
        // for (int i = 0; i <= 2; i++) {
        // System.out.println(each + "  " + list.get(i));
        // }
        // }
    }

    private static void printMap(final Map<String, Integer> input) {
        for (final Entry<String, Integer> each : input.entrySet()) {
            System.out.println(each.getKey() + "  " + each.getValue());
        }
    }

    private static void writeToFile(final List<String> input, final String fileName) {
        try {
            final PrintWriter writer = new PrintWriter("/Users/mk049501/Documents/NeonWorkSpace2/Z_FirstProject/"
                    + fileName, "UTF-8");
            for (final String each : input) {
                writer.println(each);
            }
            writer.close();
        } catch (final FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
