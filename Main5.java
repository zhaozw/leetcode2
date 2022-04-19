
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//We have imported the necessary tool classes.
//If you need to import additional packages or classes, please import here.

public class Main5 {

  private static Map<Integer,Integer> map = new HashMap<>();
  static {
    int tempNum = 1;
    for (int i = 0; i < 21; i++) {
      map.put(i, tempNum);
      tempNum=tempNum<<1;
    }
  }
  public static void main(String[] args) {
    //	  System.out.println("\u67e5\u770bjob\u72b6\u6001");
    // please define the JAVA input here. For example:
    Scanner s = null;
    try {
      s = new Scanner(System.in);
      //			while (true) {

      int n = s.nextInt();
      int[] jieList = new int[n + 1];

      for (int i = 0; i <= n; i++) {
        jieList[i] = s.nextInt();
      }
      int num = s.nextInt();
      int lastWei = 0;
//      int tempNum = 1;
      for (int i = 1; i <= n; i++) {
        if (map.get(i)<num) {
          lastWei++;
        }else {
          break;
        }
      }
      int[] he = new int[n + 1];
      int total = 0;
      for (int i = lastWei+1; i <= n; i++) {
        total+=jieList[i];
      }
      while (true) {
        for (int i = 0; i <= lastWei; i++) {
          he[i] = 0;
        }
        for (int i = 1; i <= lastWei; i++) {
          he[i] = he[i - 1] + jieList[i]*map.get(i);
        }
        if (he[lastWei] >= num) {
          digui(jieList, num, he,lastWei);
          total++;
        } else {
          break;
        }
      }
      System.out.println(total);

      //			}
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (s != null) {
        s.close();
      }
    }

  }

  private static void digui(int[] jieList, int num, int[] he, int lastWei) {
    if(lastWei<0)
      return;
    if(lastWei==0) {
      if (he[lastWei]>=num) {
        jieList[lastWei]-=num;
      }
      return;
    }
    int min = Math.min(jieList[lastWei], num/(map.get(lastWei)));
    if (min*map.get(lastWei)==num) {
      jieList[lastWei]-=min;
    }else {
      if(he[lastWei-1]>=num-min*map.get(lastWei)) {
        jieList[lastWei]-=min;
        digui(jieList, num-min*map.get(lastWei), he,lastWei-1);
      }else {
        jieList[lastWei]-=min+1;
      }
    }
  }
}
/*
5
10 5 0 1 3 2
30

*/
