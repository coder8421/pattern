package com.example.demo.responsibilityChain;

import lombok.extern.slf4j.Slf4j;

/**2 套餐
 * @author qiangqiang
 */
@Slf4j
public class WashTwoCar extends WashCarPackage {



    @Override
    public void handleRequest(WashCarBizReq req) {

        if (req.getType().equals(washCarEnum.TWO.getCode())) {
            //业务处理
            log.info("washCar is {} Package ", washCarEnum.TWO.getCode());
        } else {
            this.setNextWashCarBiz(WashCarHandlerChainStaticFactory.createWashThreeCar());
            this.nextPackage.handleRequest(req);

        }
    }
}
