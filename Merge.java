public class Merge{
  public static void main(String[]args){
    int[] ary = {3, 4, 3, 1, ,6 ,7 ,43, 2, 67};
    mergesort(ary);
  }

  public static void mergesort(int[] data) {mergesort(data, 0, data.length - 1);}

  private static void mergesort(int[]data, int lo, int hi){
    int half = data.length/2;
    int[] front = new int[half];
    int[] back = new int[data.length - half + 1];
    System.out.println(front.length + back.length);
  }
}
