package au.edu.unimelb.btree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by apple on 2018/1/19.
 */
public class Main {

    public static void main(String[] args) {
        BTree<Long, Point> st = new BTree();
        StringBuffer sb = new StringBuffer("");
        FileReader reader = null;
        try {
            reader = new FileReader("./data/nodes.txt");
            BufferedReader br = new BufferedReader(reader);

            String str = null;
            int index = 0;
            while ((str = br.readLine()) != null) {
//            sb.append(str+"/n");
//            System.out.println(str);
                String[] attrs = str.split(" ");
                Point point = new Point();
                if (attrs != null) {
                    point.setId(Long.valueOf(attrs[0]));
                    point.setLat(Double.valueOf(attrs[1]));
                    point.setLon(Double.valueOf(attrs[2]));
                }
                st.put(point.getId(), point);
            }

            br.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("size:    " + st.size());
        System.out.println("height:  " + st.height());
        System.out.println(st);
        System.out.println();

        System.out.println("5334815570:  " + st.get(5334815570L));



    }

}
