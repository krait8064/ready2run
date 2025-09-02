package org.example.sort;

public class QuickSort {
    void quick_sort(int s[], int l, int r) {
        if (l >= r) {
            return;
        }

  //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
        int i = l, j = r, x = s[l];
        while (i < j) {
            while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                j--;
            if (i < j)
                s[i++] = s[j];

            while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                i++;
            if (i < j)
                s[j--] = s[i];
        }
        s[i] = x;
        quick_sort(s, l, i - 1); // 递归调用
        quick_sort(s, i + 1, r);


    }

    public static void main(String[] args) {
        int[] ar = {1, 4, 2, 7, 9, 3, -1};
        new QuickSort().quick_sort(ar, 0, ar.length - 1);
        System.out.println(ar.toString());
    }
}
