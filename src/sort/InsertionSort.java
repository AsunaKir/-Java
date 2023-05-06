package sort;

public class InsertionSort {
    // 插入排序，arr表示数组，n表示数组大小
    public void insertionSort(int[] arr, int n) {
        if (n <= 1) return;

        // 从第二个元素开始，查找插入的位置
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j]; // 数据移动
                } else {
                    break;
                }
            }

            arr[j + 1] = value; // 插入数据
        }
    }
}
