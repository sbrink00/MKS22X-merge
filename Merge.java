import java.util.Arrays;
import java.util.Random;
public class Merge{
  public static void main(String[]args){
    Random r = new Random();
    int[] ms = new int[1000000];
    for (int idx = 0; idx < 1000000; idx ++) ms[idx] = r.nextInt(100000);
    int[] as = ms;
    mergesort(ms);
    Arrays.sort(as);
    System.out.println(Arrays.equals(ms, as));
  }

  public static void mergesort(int[] data) {mergesort(data, 0, data.length - 1);}

  private static void mergesort(int[]data, int lo, int hi){
    if (lo >= hi) return;
    int nums = hi - lo + 1;
    int[] front;
    if (nums % 2 == 1) front = new int[nums/2 + 1];
    else front = new int[nums/2];
    int[] back = new int[nums/2];
    for (int idx = 0; idx < front.length; idx ++){
      front[idx] = data[idx + lo];
      if (back.length - 1 - idx >= 0) back[back.length - 1 - idx] = data[hi - idx];
    }
    mergesort(front, 0, front.length - 1);
    mergesort(back, 0, back.length - 1);
    mergeArrays(data, front, back);
  }

  public static void mergeArrays(int[] whole, int[] front, int[] back){
    int f = 0; int b = 0; int w = 0;
    while (w < whole.length){
      if (f < front.length && b < back.length){
        if (front[f] < back[b]) {whole[w] = front[f]; f ++;}
        else {whole[w] = back[b]; b ++;}
      }
      else if (f < front.length) {whole[w] = front[f]; f ++;}
      else {whole[w] = back[b]; b ++;}
      w ++;
    }
  }


}
