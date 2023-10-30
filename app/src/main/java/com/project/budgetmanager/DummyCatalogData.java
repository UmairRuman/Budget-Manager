package com.project.budgetmanager;

import java.util.ArrayList;

public class DummyCatalogData {

    public ArrayList<CatalogModel> generateDailyCatalogData(){
        ArrayList<CatalogModel> list = new ArrayList<>();
        list.add(new CatalogModel(R.drawable.w_pic,"catalogFirst",1,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogSecond",2,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogThird",3,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogFourth",4,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogFifth",5,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogSix",6,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogSeven",7,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogEight",8,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogNine",9,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogTen",10,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogEleven",11,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogTwelve",12,CatalogModel.DAILY_CATALOG,1000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogThirteen",13,CatalogModel.DAILY_CATALOG,1000));
    return list;
    }

    public ArrayList<CatalogModel> generateWeeklyCatalogData(){
        ArrayList<CatalogModel> list = new ArrayList<>();
        list.add(new CatalogModel(R.drawable.w_pic,"catalogFirst",14,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogSecond",15,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogThird",16,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogFourth",17,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogFifth",18,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogSix",19,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogSeven",20,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogEight",21,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogNine",22,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogTen",23,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogEleven",24,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogTwelve",25,CatalogModel.WEEKLY_CATALOG,4000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogThirteen",26,CatalogModel.WEEKLY_CATALOG,4000));
        return list;
    }

    public ArrayList<CatalogModel> generateMonthlyCatalogData(){
        ArrayList<CatalogModel> list = new ArrayList<>();
        list.add(new CatalogModel(R.drawable.w_pic,"catalogFirst",27,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogSecond",28,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogThird",29,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogFourth",30,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogFifth",31,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogSix",32,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogSeven",33,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogEight",34,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogNine",35,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogTen",36,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogEleven",37,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogTwelve",38,CatalogModel.MONTHS_CATALOG,50000));
        list.add(new CatalogModel(R.drawable.w_pic,"catalogThirteen",39,CatalogModel.MONTHS_CATALOG,50000));
        return list;
    }
}
