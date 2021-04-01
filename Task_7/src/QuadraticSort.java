import java.util.Arrays;

public class QuadraticSort {
    public void sort(int[] data)
    {
        for (int i = data.length-1; i > 0; i--){
            int ind_max;
            int max;
            ind_max = 0;
            max = data[0];
            for(int j =1; j<=i; j++) {
                if (data[j] > max){
                    max =  data[j];
                    ind_max = j;
                }
            }
            data[ind_max] = data[i];
            data[i] = max;
        }
    }
    
}