package com.example.demo.responsibilityChain;

/**
 * 静态工厂--》具体套餐
 */
public class WashCarHandlerChainStaticFactory {

    public static WashOneCar createWashOneCar(){
        return  new WashOneCar();
    }
    public static WashTwoCar createWashTwoCar(){
        return  new WashTwoCar();
    }
    public static WashThreeCar createWashThreeCar(){
        return  new WashThreeCar();
    }
}

