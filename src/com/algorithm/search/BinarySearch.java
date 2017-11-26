package com.algorithm.search;

public class BinarySearch {

    public int binarySearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int binarySearch(int[] a, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (a[mid] < value) {
            return binarySearch(a, mid + 1, right, value);
        } else if (a[mid] > value) {
            return binarySearch(a, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    /*
    1、条件为key<=a[mid]，意思是key小于等于中间值，则往左半区域查找。
    如在 {1,2,2,2,4,8,10}查找2，第一步，low=0, high=6, 得mid=3, key <= a[3]，往下标{1,2,2}中继续查找。
    2、终止前一步为: low=high，得mid = low，此时如果key <= a[mid]，
    则high会改变，而low指向当前元素，即为满足要求的元素。如果key > a[mid]，则low会改变，而low指向mid下一个元素。
    3、如果key大于数组最后一个元素，low最后变为n+1，即没有元素大于key，需要返回 -1。
     */
    public int firstLargeOrEqual(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key <= a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low <= a.length ? low : -1;
        /*
        返回小于某个数key的最大下标
        return (low-1 >= 0)? low-1 : -1;
         */
    }

    public int bSearchUpperBound(int array[], int start, int end, int target) {
        if (start > end || target >= array[end])
            return -1;
        int mid = (start + end) / 2;
        while (end > start) {
            if (array[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return mid;
    }


    public int lastIndex(int[] a, int key) {

        int start = 0;
        int end = a.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (a[mid] <= key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return end;
    }

    public int firstIndex(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (a[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return start;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] a = {1, 2, 3, 4, 4, 4, 4, 5, 5, 7, 8};
        int pos = bs.lastIndex(a, 3);

        int firstIndex = bs.firstIndex(a, 4);
        int lastIndex = bs.lastIndex(a, 4);
        System.out.println("value: 3 = " + pos);
        System.out.println("第一次出现的位置： " + firstIndex);
        System.out.println("最后一次出现的位置： " + lastIndex);
        System.out.println("4出现的次数 " + (lastIndex - firstIndex + 1));

    }

}
