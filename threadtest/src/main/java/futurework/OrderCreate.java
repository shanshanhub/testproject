package futurework;


import threadtest.CheckCallBackService;

/**
 * @author WanChuanLai
 * @create 8/24/16.
 */
public class OrderCreate {

    public void createOrder(){
        final long begin = System.currentTimeMillis();

        CheckCallable demoA=new CheckCallable(new CheckCallBackService() {
            public boolean callBack(boolean isSuccess, int errorCode, Object... objects) {
                System.out.println("isContinue="+isSuccess);
                if(isSuccess){
                    create();
                }
                else {
                    System.out.println("检查失败了哦");
                }
                long end = System.currentTimeMillis();
                System.out.println("end-begin=" + (end - begin));
                return false;
            }
        });
        demoA.execute(new WorkA(),new WorkB(),new WorkC());


    }
interface CheckCallBack{
    void onSuccess();
    void onFailure();

}
    private void create(){
        System.out.println("最后才创建订单哦");
    }


    public static void main(String [] args){
        OrderCreate orderCreate=new OrderCreate();
        orderCreate.createOrder();
    }
}
