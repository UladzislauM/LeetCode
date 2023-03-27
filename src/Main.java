
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static List<String> readLine() throws IOException {
        List<String> array = new ArrayList<>();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            array.add(line);
        }
        return array;
    }

    private static void writeLine(int[] intToFile) throws IOException {
        bufferedWriter.write(intToFile[0] + "\n");
        bufferedWriter.write(String.valueOf(intToFile[1]));
        bufferedWriter.newLine();
    }

    private static void run() throws IOException {
        List<String> stringArray = readLine();
        int w = Integer.parseInt(stringArray.get(0));
        int n = Integer.parseInt(stringArray.get(1).split(" ")[0]);
        int k = Integer.parseInt(stringArray.get(1).split(" ")[1]);
        int checkNumP = 0;
        Integer[] allHP = new Integer[n];
        for (int i = 2; i < stringArray.size(); i++) {
            double pT1 = Integer.parseInt(stringArray.get(i).split("x")[0]);
            double pT2 = Integer.parseInt(stringArray.get(i).split("x")[1]);
            allHP[checkNumP] = (int) Math.ceil((pT2 * w) / pT1);
            checkNumP++;
        }
        Arrays.sort(allHP);
        int[] h = new int[2];

        for (int i = 0; i < k; i++) {
            h[0] += allHP[i];
        }
        Arrays.sort(allHP, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            h[1] += allHP[i];
        }
        writeLine(h);
    }
}
