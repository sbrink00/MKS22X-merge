import java.util.Arrays;
import java.util.Random;
public class Merge{
  public static void main(String[]args){
    int[] ary = {2, 4, 5, 4, 1, 1, 0, 8, 8, 9, 7, 7};
    insertionSort(ary, 2, ary.length - 3);
    System.out.println(Arrays.toString(ary));
    Random r = new Random();
    int[] ms = new int[1000000];
    for (int idx = 0; idx < 1000000; idx ++) ms[idx] = r.nextInt(100000);
    int[] as = ms;
    //mergesort(ms);
    //Arrays.sort(as);
    //System.out.println(Arrays.equals(ms, as));
  }

  public static void mergesort(int[] data) {mergesort(data, 0, data.length - 1, 150);}

  private static void mergesort(int[]data, int lo, int hi, int minLength){
    if (hi - lo < minLength){
      insertionSort(data, lo, hi);
      return;
    }
    int nums = hi - lo + 1;
    int[] front;
    if (nums % 2 == 1) front = new int[nums/2 + 1];
    else front = new int[nums/2];
    int[] back = new int[nums/2];
    for (int idx = 0; idx < front.length; idx ++){
      front[idx] = data[idx + lo];
      if (back.length - 1 - idx >= 0) back[back.length - 1 - idx] = data[hi - idx];
    }
    mergesort(front, 0, front.length - 1, minLength);
    mergesort(back, 0, back.length - 1, minLength);
    mergeArrays(data, front, back);
  }

  /*public static void unoptimizedMergesort(int[]data, int lo, int hi){
    if (hi <= lo) return;
    int nums = hi - lo + 1;
    int[] front;
    if (nums % 2 == 1) front = new int[nums/2 + 1];
    else front = new int[nums/2];
    int[] back = new int[nums/2];
    for (int idx = 0; idx < front.length; idx ++){
      front[idx] = data[idx + lo];
      if (back.length - 1 - idx >= 0) back[back.length - 1 - idx] = data[hi - idx];
    }
    unoptimizedMergesort(front, 0, front.length - 1);
    unoptimizedMergesort(back, 0, back.length - 1);
    mergeArrays(data, front, back);
  }*/

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

  public static void insertionSort(int[] ary, int lo, int hi){
    if (hi - lo == 0) return;
    for (int idx = lo + 1; idx < hi + 1; idx ++){
      int val = ary[idx];
      int i = idx - 1;
      for (;i >= lo && ary[i] > val; i--){
        ary[i + 1] = ary[i];
      }
      ary[i + 1] = val;
    }
  }

}
