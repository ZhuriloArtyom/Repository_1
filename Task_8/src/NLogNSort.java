import java.util.Arrays;

public class NLogNSort {
    public void sort(int[] data)
    {
        if(data.length >= 1){QSort(data, 0, data.length-1);}
    }

    public void QSort(int[] A, int l, int r) {
        if(r == l){return;}
        int base = A[r];
        int i = l-1;
        for(int j = l; j <= r-1;j++){
            if(A[j]<= A[r]){
                i++;
                int dummy = A[j];
                A[j] = A[i];
                A[i] = dummy;
            }
        }
        i++;
        int dummy = A[r];
        A[r] = A[i];
        A[i] = dummy;
        if(i>l){QSort(A, l, i-1);}
        if(i<r){QSort(A, i+1, r);}
    }
}
