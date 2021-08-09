public class MergeSort extends SortInvoke {

    public void merge(SortBean sortBean, Object[] arrays, int left, int mid, int right, Object[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (sortBean.getSortType() == SortBean.TYPE_INT) {
                int a = (int) super.invokeGetV(sortBean, arrays[i]);
                int b = (int) super.invokeGetV(sortBean, arrays[j]);
                if (sortBean.isIfReserve()) {
                    if (a >= b) {
                        temp[t++] = arrays[i++];
                    } else {
                        temp[t++] = arrays[j++];
                    }
                } else {
                    if (a <= b) {
                        temp[t++] = arrays[i++];
                    } else {
                        temp[t++] = arrays[j++];
                    }
                }
            } else if (sortBean.getSortType() == SortBean.TYPE_LONG) {
                long a = (long) super.invokeGetV(sortBean, arrays[i]);
                long b = (long) super.invokeGetV(sortBean, arrays[j]);
                if (sortBean.isIfReserve()) {
                    if (a >= b) {
                        temp[t++] = arrays[i++];
                    } else {
                        temp[t++] = arrays[j++];
                    }
                } else {
                    if (a <= b) {
                        temp[t++] = arrays[i++];
                    } else {
                        temp[t++] = arrays[j++];
                    }
                }
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arrays[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arrays[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arrays[left++] = temp[t++];
        }
    }

    public void sort(SortBean sortBean, Object[] arrays, int left, int right, Object[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(sortBean, arrays, left, mid, temp);
            sort(sortBean, arrays, mid + 1, right, temp);
            merge(sortBean, arrays, left, mid, right, temp);
        }
    }

    /**
     * 入口
     * @param sortBean
     * @param arrays
     */
    public void sort(SortBean sortBean, Object[] arrays) {
        Object[] temp = new Object[arrays.length];
        this.sort(sortBean, arrays, 0, arrays.length - 1, temp);
    }

}
