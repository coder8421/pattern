package com.example.demo.responsibilityChain;

import lombok.extern.slf4j.Slf4j;

/** 1套餐
 * @author qiangqiang
 */
@Slf4j
public class WashOneCar extends WashCarPackage {



    @Override
    public void handleRequest(WashCarBizReq req) {

        if (req.getType().equals(washCarEnum.ONE.getCode())) {
            //业务处理
            log.info("washCar is {} Package ", washCarEnum.ONE.getCode());
        } else {
            this.setNextWashCarBiz(WashCarHandlerChainStaticFactory.createWashTwoCar());
            this.nextPackage.handleRequest(req);

        }
    }
}
