package sort;

/**
 * Created by z_dk on 2018/10/13.
 */
public class Sort {
    //冒泡排序
    public static void bubbleSort(int a[]){
        int len = a.length;
        for (int i = 0; i<len-1; i++){
            for (int j=0; j<len-i-1; j++){
                if (a[j]>a[j+1]){
                    int a0 = a[j];
                    a[j] = a[j+1];
                    a[j+1] = a0;
                }
            }
        }
    }
    //选择排序
    public static void selectionSort(int a[]){
        int len = a.length;
        for (int i=0; i<len-1;i++){
            int min = i;
            for (int j=i+1; j<len; j++){
                if (a[j]<a[min]){
                    min = j;
                }
            }
            if (min != i){
                int c = a[i];
                a[i] = a[min];
                a[min] = c;
            }
        }
    }
    //插入排序
    public static void insertSort(int a[]){
        int len = a.length;
        for (int i=1; i<len; i++){
            int preIndex = i-1;
            int current = a[i];
            while (preIndex>=0 && a[preIndex]>current){
                a[preIndex+1] = a[preIndex];
                preIndex--;
            }
            a[preIndex+1] = current;
        }
    }
    //快速排序
    public static void quickSort(int a[],int l,int h){
        int low = l;
        int hight = h;
        int povit = a[l];
        while(low<hight) {
            while(low<hight&&a[hight]>=povit)
                hight--;
            if(low<hight){
                int temp=a[hight];
                a[hight]=a[low];
                a[low]=temp;
                low++;
            }
            while(low<hight&&a[low]<=povit)
                low++;
            if(low<hight){
                int temp=a[hight];
                a[hight]=a[low];
                a[low]=temp;
                hight--;
            }
            print(a);
        }
        if(low>l)
            quickSort(a,l,low-1);
        if(hight<h)
            quickSort(a,low+1,h);
    }

    public static void shellSort(int a[]){
        int len = a.length;
        double gap = 1;
        while (gap<len/3){
            gap = gap*3+1;
        }
        for ( ; gap>0; gap=Math.floor(gap/3)){
            for (int i= (int) gap; i<len;i++){

            }
        }
    }
    public static void print(int a[]){
        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int a[] = {3,2,6,4,12,9,15,17,8,11};
        //bubbleSort(a);
//        selectionSort(a);
//        insertSort(a);
        quickSort(a,0,a.length-1);
        for (int i:a){
            System.out.print(i+" ");
        }
    }
}
