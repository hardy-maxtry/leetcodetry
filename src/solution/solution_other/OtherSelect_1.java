package solution.solution_other;

public class OtherSelect_1 {
    public int[] select(int[] arr) {

        for(int i = 0; i < arr.length - 1; i++){
            int k = i;
            for(int j = i+1; j<arr.length; j++){
                System.out.println("k="+ (k+1) + ", j="+(j+1));
                if(arr[k] > arr[j]){
                    System.out.print("a[k]="+arr[k]);
                    System.out.print("  a[j]="+arr[j]);
                    System.out.print("  a[k] > a[j]需要对k赋值");
                    k = j;
                    System.out.println("  k=j之后, k="+(k+1) + ", j="+(j+1));
                }else {
                    System.out.print("a[k]="+arr[k]);
                    System.out.print("  a[j]="+arr[j]);
                    System.out.println("  a[k] <= a[j] 不需要对k赋值");
                }
            }
            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
        }
        return arr;
    }
    public static void main(String[] args) {
        OtherSelect_1 otherSelect = new OtherSelect_1();
        int[] a = {89,75,91,82,60,77,93,59,68,79};
        int[] result = otherSelect.select(a);
        for (int i : result) {
            System.out.println(i);
        }



    }
}


