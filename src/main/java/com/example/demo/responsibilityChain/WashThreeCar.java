package com.example.demo.responsibilityChain;

import lombok.extern.slf4j.Slf4j;

/** 3套餐
 * @author qiangqiang
 */
@Slf4j
public class WashThreeCar extends WashCarPackage {



    @Override
    public void handleRequest(WashCarBizReq req) {

        if (req.getType().equals(washCarEnum.THREE.getCode())) {
            //业务处理
            log.info("washCar is {} Package ", washCarEnum.THREE.getCode());
        } else {
            log.error("sorry ");
        }
    }
}
