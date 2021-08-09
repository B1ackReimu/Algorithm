package mergesort;

import java.lang.reflect.Field;

public abstract class SortInvoke {

    public Object invokeGetV(SortBean sortBean, Object o) {
        String sortCol = sortBean.getSortCol();
        int sortType = sortBean.getSortType();
        try {
            Field field = o.getClass().getDeclaredField(sortCol);
            field.setAccessible(true);
            if (sortType == SortBean.TYPE_INT) {
                return field.getInt(o);
            } else if (sortType == SortBean.TYPE_LONG) {
                return field.getLong(o);
            } else if (sortType == SortBean.TYPE_STRING) {
                return field.get(o);
            } else if (sortType == SortBean.TYPE_BOOLEAN) {
                return field.getBoolean(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
