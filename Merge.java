import java.util.Arrays;
public class Merge{
  public static void main(String[]args){
    //int[] ary = {3, 4, 3, 1, 6 ,7 ,43, 2, 67, 9};
    //mergesort(ary);
  }

  public static void mergesort(int[] data) {mergesort(data, 0, data.length - 1);}

  private static void mergesort(int[]data, int lo, int hi){
    System.out.println(Arrays.toString(data));
    if (hi - lo < 2) return;
    int nums = hi - lo + 1;
    int[] front;
    if (nums % 2 == 1) front = new int[nums/2 + 1];
    else front = new int[nums/2];
    int[] back = new int[nums/2];
    for (int idx = 0; idx < front.length; idx ++){
      front[idx] = data[idx + lo];
      if (back.length - 1 - idx >= 0) back[back.length - 1 - idx] = data[hi - idx];
    }
    //System.out.println(Arrays.toString(front) + " " + Arrays.toString(back));
    //System.out.println(Arrays.toString(back));
    mergesort(front, 0, front.length - 1);
    mergesort(back, 0, back.length - 1);
  }

  public static void mergeArrays(int[] whole, int[] front, int[] back){
    int f = 0; int b = 0; int w = 0;
    while (w < whole.length){
      if (f < front.length && b < back.length){
        if (front[f] < back[b]) whole[w] = front[f]; f ++;
        else whole[w] = back[b]; b ++;
      }
      else if (f < front.length) whole[w] = front[f]; f ++;
      else whole[w] = back[b]; b ++;
      w ++;
    }
  }


}
