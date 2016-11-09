/**
 * @author WanChuanLai
 * @create 4/6/16.
 */
public class B {
    private Integer createUserId;

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public static void main(String [] args){
        A aa=new A();
        aa.setUserId(1);
        B bb=new B();
        bb.setCreateUserId(aa.getUserId());
        System.out.print(bb.getCreateUserId());
    }
}
