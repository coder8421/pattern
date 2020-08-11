package com.example.demo.responsibilityChain;

/**
 * 抽象套餐类
 */
public abstract class WashCarPackage {


    protected WashCarPackage nextPackage;

    // 责任链下个节点
    public void setNextWashCarBiz(WashCarPackage next) {
        this.nextPackage = next;
    }

    /**
     * 处理请求的核心的业务方法
     *
     * @param req
     */
    public abstract void handleRequest(WashCarBizReq req);
}
