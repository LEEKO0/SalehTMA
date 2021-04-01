package DALAL;

import java.util.*;

public class Processes {

    public static void main(String[] args) {
        Sections sections = new Sections(1330, "TM10");
        Sections sections2 = new Sections(1331, "TM10");
        Sections sections6 = new Sections(1336, "TM11");
        Sections sections3 = new Sections(1332, "AM10");
        Sections sections5 = new Sections(1632, "AM10");
        Sections sections4 = new Sections(1334, "TM10");
        Set<Sections> set = new HashSet<>();

        set.add(sections);
        set.add(sections2);
        set.add(sections3);
        set.add(sections4);
        set.add(sections5);
        set.add(sections6);
        Course.display(set);

    }

}
