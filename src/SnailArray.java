public class SnailArray {

  public void main(String args[]) {
    int m = 5;

    int[][] arr = new int[m][m];

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (i == 0) {
          arr[i][j] = j;
        }
        if(i == 1){
            arr[j][arr[i].length] = i;
        }
      }
    }
  }
}
