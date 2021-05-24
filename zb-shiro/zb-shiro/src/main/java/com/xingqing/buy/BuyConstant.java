package com.xingqing.buy;

public interface BuyConstant {
    interface SPtype {
        int KANGSHENGSHU=10;//抗生素
        int HUAXUEZHIDI=11;//化学制剂
        int HUAXUEHYUANLIAOYAO=12;//化学原料药
        int SHENGHUA_YAOPIN=13;//生化药品
        int CHUFANGYAO=14;//处方药品

        int ZHONGYAOYINPIAN=20;//中药饮片
        int ZHONGCHENGYAO=21;//中成药
        int ZHONGYAOCAI=22;//中药材

        int ONE_YILIAO_QIXIE=30;//第一类医疗器械
        int TWO_YILIAO_QIXIE=31;//第二类医疗器械
        int THREE_YILIAO_QIXIE=32;//第三类医疗器械

        int TWO_JINGSHEN_YAOPING=40;//二类精神药品

        int XIAODULEI=50;//消毒类

        int SHENGWUZHIPIN=60;//生物制品
        int HUAXUE_MAHUAJIAN=70;//麻黄碱药品

        int TAILEIJISUYAOPIN=80;//肽类激素药品
        int TAILEI_JISU=81;//肽类激素(胰岛素)
        int DANBAJI_ZHIJI=11;//蛋白同化制剂


        int BAOJINPIN=90;//保健品

        int SHIPIN=110;//食品
        int BAOJIAN_SHIPIN=111;//保健食品
        int HUAZHUANGPIN=100;//化妆品
        int STOP_RENSHEN_YAOPIN=120;//终止妊娠药品

        int OTHER=1000;//其他类
    }

    interface Product_Unit{
        int HE =1;//盒包装
        int PING=2;//瓶包装
    }
}
