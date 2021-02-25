package com.universe.gof.bridge;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * <p>文件名称: PayTest.java </p>
 * <p>描述: 桥接模式示例 </p>
 * <p>创建时间: 2021/1/6 15:42 </p>
 *
 * @author <a href="mail to: *******@******.com" rel="nofollow">作者</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class PayTest {
    @Test
    public void withNoGOFTest() {
        PayController pay = new PayController();
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        pay.doPay("jlu19dlxo111", "100000109894", new BigDecimal(100), 2, 3);
    }

    /**
     * 解耦支付渠道、支付方式，支付渠道不需要耦合具体的支付方式     单一职责、开闭原则
     *
     * <p>从桥接模式的实现形式来看满足了单一职责和开闭原则，让每一部分内容都很清晰易于维护和拓展。
     * 但如果我们是实现高内聚的代码，那么就会很复杂。
     * 所以在选择重构代码的时候，需要考虑好整体的设计，否则选不到合理的设计模式，将会让代码变得难以开发。</p>
     *
     * <p>如果有新的支付方式，只需新增支付方式实现类</p>
     * <p>如果有新的支付渠道，只需新增的支付渠道实现类</p>
     *
     * @param
     * @return void
     * @throws
     * @author universe
     * @createDate 2021/1/6 15:53
     * @update
     */
    @Test
    public void gofPayTest() {
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
    }
}

@Slf4j
class PayController {
    /**
     * 没有采用设计模式时的支付示例
     *
     * @param uId         用户id
     * @param tradeId     交易号
     * @param amount      支付金额
     * @param channelType 支付渠道
     * @param modeType    支付方式
     * @return boolean
     * @author universe
     * @createDate 2021/1/6 15:27
     * @update
     */
    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType) {
        // 微信支付
        if (1 == channelType) {
            log.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modeType) {
                log.info("密码支付，风控校验环境安全");
            } else if (2 == modeType) {
                log.info("人脸支付，风控校验脸部识别");
            } else if (3 == modeType) {
                log.info("指纹支付，风控校验指纹信息");
            }
        }
        // 支付宝支付
        else if (2 == channelType) {
            log.info("模拟支付宝渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modeType) {
                log.info("密码支付，风控校验环境安全");
            } else if (2 == modeType) {
                log.info("人脸支付，风控校验脸部识别");
            } else if (3 == modeType) {
                log.info("指纹支付，风控校验指纹信息");
            }
        }
        return true;
    }

}


abstract class Pay {
    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    /**
     * 交易
     *
     * @param uId     用户id
     * @param tradeId 交易id
     * @param amount  交易金额
     * @return java.lang.String
     * @author universe
     * @createDate 2021/1/6 16:26
     * @update
     */
    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}

@Slf4j
class ZfbPay extends Pay {

    public ZfbPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("模拟支付宝渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        log.info("模拟支付宝渠道支付风控校验。uId：{} tradeId：{} security：{}", uId, tradeId, security);
        if (!security) {
            log.info("模拟支付宝渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        log.info("模拟支付宝渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }
}

@Slf4j
class WxPay extends Pay {
    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        log.info("模拟微信渠道支付风控校验。uId：{} tradeId：{} security：{}", uId, tradeId, security);
        if (!security) {
            log.info("模拟微信渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        log.info("模拟微信渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }

}

interface IPayMode {
    boolean security(String uid);
}

@Slf4j
class PayFaceMode implements IPayMode {
    @Override
    public boolean security(String uid) {
        log.info("人脸识别校验");
        return true;
    }
}

@Slf4j
class PayFingerprintMode implements IPayMode {

    @Override
    public boolean security(String uid) {
        log.info("指纹识别校验");
        return true;
    }
}

@Slf4j
class PayCypher implements IPayMode {
    @Override
    public boolean security(String uid) {
        log.info("密码校验");
        return true;
    }
}