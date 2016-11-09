package createanddistoryobject;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author WanChuanLai
 * @create 9/26/16.
 * 作用:避免创建不需要的对象
 * 例如:这个类创建了一个模型:其中有一个人,并有一个isBabyBoomer方法,检验这个人是否为一个"baby Boomer(生育高峰期出生的小孩)",换句话说是否出生于1946 和1964年
 *
 */
public class Persion {
    private final Date birthDate;
    public Persion(Date birthDate){
        this.birthDate=birthDate;
    }
    private static final Date BOOM_START;
    private static final Date BOOM_END;
    static {
        Calendar gmtCal=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
        BOOM_START=gmtCal.getTime();
        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        BOOM_END=gmtCal.getTime();
    }
    public boolean isBabyBoomer(){
        return birthDate.compareTo(BOOM_START)>=0&&birthDate.compareTo(BOOM_END)<0;
    }
}
