package com.xingqing.buy;

public class ErpfieldUtils {
    public static int sptype2Producttype(String sptType){
        switch (sptType){
            case "抗生素":
                return BuyConstant.SPtype.KANGSHENGSHU;
            case "化学制剂":
                return BuyConstant.SPtype.HUAXUEZHIDI;
            case "化学原料药":
                return BuyConstant.SPtype.HUAXUEHYUANLIAOYAO;
            case "生化药品":
                return BuyConstant.SPtype.SHENGHUA_YAOPIN;

        }
       return 1;//默认返回西药
    }
    public static int sptBzdw2ProductUnit(String sptType){
        switch (sptType){
            case "盒":
                return BuyConstant.Product_Unit.HE;
            case "瓶":
                return BuyConstant.Product_Unit.PING;

        }
        return BuyConstant.Product_Unit.HE;//默认返回盒
    }
}
