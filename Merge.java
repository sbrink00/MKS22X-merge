import java.util.Arrays;
public class Merge{
  public static void main(String[]args){
    int[] ary = {3, 4, 3, 1, 6 ,7 ,43, 2, 67, 11};
    mergesort(ary);
  }

  public static void mergesort(int[] data) {mergesort(data, 0, data.length - 1);}

  private static void mergesort(int[]data, int lo, int hi){
    int half = data.length/2;
    int[] front = new int[half];
    int[] back = new int[data.length - half];
    for (int idx = 0; idx < half; idx ++){
      front[idx] = data[idx];
      back[idx + half] = data[idx + half];
    }
    System.out.println(Arrays.toString(front));
    System.out.println(Arrays.toString(back));
  }
}
