package lrmall.bean;

/**
 * 购物车
 */
public class Cart {
    private String uid;//用户id
    private int pid;//商品id
    private int number;//商品数量

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
