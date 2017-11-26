package com.nowcoder.swordForOffer;

public class InversePairsCore {
    //进行数组的归并操作
    public static int mergeArray(int[] a, int start, int mid, int end, int[] tmp) {
        int i = mid;
        int j = end;
        int k = 0; //临时数组末尾坐标
        int count = 0;

        while (i >= start && j > mid) {
            if (a[i] > a[j]) {
                tmp[k++] = a[i--];  //从临时数组的最后一个位置开始排序
                //因为arry[mid+1...j...end]是有序的，如果arry[i]>arry[j]，
                // 那么也大于arry[j]之前的元素，从a[mid+1...j]一共有j-(mid+1)+1=j-mid
                count += j - mid;
            } else {
                tmp[k++] = a[j--];
            }
        }
        System.out.println("调用MergeArray时的count: " + count);
        while (i >= start) {
            tmp[k++] = a[i--];
        }
        while (j > mid) {
            tmp[k++] = a[j--];
        }
        //将临时数组中的元素写回到原数组当中去。
        for (i = 0; i < k; i++) {
            a[end - i] = tmp[i];
        }
        for (int num : a) {
            System.out.print(num + " ");
        }
        return count;
    }

    public static int inversePairsCore(int[] a, int start, int end, int[] tmp) {

        int inversions = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            inversions += inversePairsCore(a, start, mid, tmp); //找左半段的逆序对数目
            inversions += inversePairsCore(a, mid + 1, end, tmp);//找右半段的逆序对数目
            //在找完左右半段逆序对以后两段数组有序，然后找两段之间的逆序对。最小的逆序段只有一个元素。
            inversions += mergeArray(a, start, mid, end, tmp);
        }
        return inversions;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 7, 8, 2, 4, 6, 5};
        int[] tmp = new int[array.length];
        int count = inversePairsCore(array, 0, array.length - 1, tmp);
        System.out.println(count);
    }
}
