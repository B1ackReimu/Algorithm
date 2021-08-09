public class SortBean {

    public final static int TYPE_INT = 1;
    public final static int TYPE_LONG = 2;
    public final static int TYPE_STRING = 3;
    public final static int TYPE_BOOLEAN = 4;

    /**
     * 数组排序根据的字段
     */
    private String sortCol;

    /**
     * 排序字段的类型
     */
    private int sortType;

    /**
     * 是否倒序
     */
    private boolean ifReserve;

    public SortBean(String sortCol, int sortType, boolean ifReserve) throws Exception {
        this.sortCol = sortCol;
        this.sortType = sortType;
        this.ifReserve = ifReserve;
        if (sortType < 1 || sortType > 4){
            throw new Exception("SortBean.sortType must in 1 ~ 4");
        }
    }

    public String getSortCol() {
        return sortCol;
    }

    public int getSortType() {
        return sortType;
    }

    public boolean isIfReserve() {
        return ifReserve;
    }

}
