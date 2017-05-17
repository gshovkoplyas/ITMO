package Utils;

import java.io.*;
import java.util.ArrayList;

public class Proof {
    public Header header;
    public ArrayList<String> list = new ArrayList<>();

    public Proof() {
    }

    public Proof(ArrayList<String> list) {
        proofFromList(list);
    }

    public Proof(File file) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String cur = in.readLine();
            while (cur != null) {
                lines.add(cur);
                cur = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        proofFromList(lines);
    }

    private void proofFromList(ArrayList<String> list) {
        String potentialHeader = list.get(0);
        if (potentialHeader.contains("|-")) {
            header = new Header(potentialHeader);
            list.remove(0);
        }
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (header != null) {
            sb.append(header.toString());
            sb.append("\n");
        }
        for (String s : list) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
