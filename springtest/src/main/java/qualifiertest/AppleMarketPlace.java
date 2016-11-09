package qualifiertest;

/**
 * @author WanChuanLai
 * @create 6/6/16.
 */
import org.springframework.stereotype.Component;

import static spring.Spring.Platform;
@Component
@Platform(Platform.OperatingSystems.IOS)
public class AppleMarketPlace implements MarketPlace {
}
