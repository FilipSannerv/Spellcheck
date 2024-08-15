/* Labb 2 i DD2350 Algoritmer, datastrukturer och komplexitet    */
/* Ursprunglig författare: Viggo Kann KTH viggo@nada.kth.se      */
/* Updated implementation by @sannerv                            */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static List<String> readWordList(BufferedReader input) throws IOException {
    LinkedList<String> list = new LinkedList<String>();
    while (true) {
      String s = input.readLine();
      if (s.equals("#"))
        break;
      list.add(s);
    }
    return list;
  }

  public static void main(String args[]) throws IOException {
    //long t1 = System.currentTimeMillis();
    // We use UTF-8 to be safe, some systems use other standards for character encoding
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
    List<String> wordList = readWordList(stdin);
    String word;
    while ((word = stdin.readLine()) != null) {
      ClosestWords closestWords = new ClosestWords(word, wordList);
      //long t1 = System.currentTimeMillis();
      System.out.print(word + " (" + closestWords.getMinDistance() + ")");
      for (String w : closestWords.getClosestWords())
        System.out.print(" " + w);
      System.out.println();
      //long tottime = (System.currentTimeMillis() - t1);
 	    //System.out.println("CPU time: " + tottime + " ms");
    }
  }
}
