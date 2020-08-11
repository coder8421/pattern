package com.example.demo;

import com.example.demo.responsibilityChain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 责任链Test
 */
@SpringBootTest(classes = DemoApplication.class)
class ResponsibilityChainTest {

    @Test
    public  void ResponsibilityChain() {

        WashCarPackage washCar = new WashOneCar();
        WashCarBizReq req = new WashCarBizReq();
        req.setType(washCarEnum.ONE.getCode());
        washCar.handleRequest(req);
        req.setType(washCarEnum.TWO.getCode());
        washCar.handleRequest(req);
        req.setType(washCarEnum.THREE.getCode());
        washCar.handleRequest(req);
    }

}
