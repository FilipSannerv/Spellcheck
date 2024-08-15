/* Labb 2 i DD2350 Algoritmer, datastrukturer och komplexitet    */
/* Se labbinstruktionerna i kursrummet i Canvas                  */
/* Ursprunglig författare: Viggo Kann KTH viggo@nada.kth.se      */
/* Algorithm (Levensthein distance) implemented by @sannerv      */

import java.util.LinkedList;
import java.util.List;

public class ClosestWords {

  int[][] d = new int[40][40];
  String prevs2 = "";
  String prevs1 = "";

  LinkedList<String> closestWords = null;
  int closestDistance = -1;
  int i;

  int LevenshteinDistance(String s1, String s2) {
    int subCost = 0;
    int index = 0;

    if (prevs1 != s1) {
      prevs2 = "";
    }

    //Check if we already have calculated part of matrix and up to which column
    if (prevs2.length() > 0) {
      while (prevs2.charAt(index) == s2.charAt(index)) {
        index++;
        if(index == prevs2.length() || index == s2.length()) {
          break;
        }
      }
    }

    //Only want to allocate matrix once
    if(d[1][0] != 1 || d[0][1] != 1) {
      for (int i = 0; i < 40; i++) {
        d[i][0] = i;
      }
      for (int j = 0; j < 40; j++) {
        d[0][j] = j;
      }
    }

    //LevenshteinDistance algorithm
    //Optimized by starting from +index if the words are the same in the start
    for (int j = 1 + index; j <= s2.length(); j++) {
      for (int i = 1; i <= s1.length(); i++) {
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
          subCost = 0;
        }
        else {
          subCost = 1;
        }
        d[i][j] = Math.min(d[i-1][j] + 1, Math.min(d[i][j-1] + 1, d[i-1][j-1] + subCost));
      }
    }
    prevs2 = s2;
    prevs1 = s1;

    return d[ s1.length() ][ s2.length() ];
  }

  int distance(String w1, String w2) {
    return LevenshteinDistance(w1, w2);
  }

  public ClosestWords(String w, List<String> wordList) {
    for (String s : wordList) {
      int dist = distance(w, s);
      if (dist < closestDistance || closestDistance == -1) {
        closestDistance = dist;
        closestWords = new LinkedList<String>();
        closestWords.add(s);
      }
      else if (dist == closestDistance)
        closestWords.add(s);
    }
  }

  int getMinDistance() {
    return closestDistance;
  }

  List<String> getClosestWords() {
    return closestWords;
  }

  // void printMatrix(int[][] matrix){
  //   for (int i = 1; i < matrix.length; i++) {
  //     for (int j = 1; j< matrix[i].length; j++) {
  //       System.out.print(matrix[i-1][j-1] + " ");
  //     }
  //     System.out.println();
  //   }
  // }
}
