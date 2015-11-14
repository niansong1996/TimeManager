package com.company;

public class TextFactory {
    int hour;
    int year;
    int month;
    int day;
    int minute;
    String place;
    int importance;
     void stringdealing(String input){
        char []a=input.toCharArray();
         int timeposition ;
         int placeposition;
         for(int x=0;x<input.length()-1;x++) {
             if (a[x] == '时' && a[x + 1] == '间') {
                 timeposition = input.indexOf("时间") + 3;
                 hour = Integer.parseInt(input.substring(timeposition, timeposition + 2));
                 minute = Integer.parseInt(input.substring(timeposition + 3, timeposition + 5));
             }
         }
         for(int x=0;x<input.length()-1;x++) {
             if (a[x] == '地' && a[x + 1] == '点') {
                 placeposition = input.indexOf("地点");
                 String[] placetemp = input.substring(placeposition + 3, input.length() - 1).split("。");
                 place = placetemp[0];
             }
         }
         for(int x=0;x<input.length();x++) {
             if (a[x] == '午') {
                 switch (a[x - 1]) {
                     case '上':
                         hour = 8;
                         break;
                     case '中':
                         hour = 12;
                         break;
                     case '下':
                         hour = 17;
                         break;
                 }
             }
         }
         for(int x=0;x<input.length();x++){
             if(a[x]=='点'){
                 if(Character.isDigit(a[x-1])){
                     hour=a[x-1];
                 }
             }
         }
         for(int x=0;x<input.length();x++){
             if(a[x]=='年')
                 year=Integer.parseInt(input.substring(x-4,x));
         }
         for(int x=0;x<input.length();x++){
             if(a[x]=='月'&&Character.isDigit(a[x-1]))
                 if(Character.isDigit(a[x-2]))
                     month=Integer.parseInt(input.substring(x-2,x));
                else
                     month=Integer.parseInt(input.substring(x-1,x));
         }
         for(int x=0;x<input.length();x++) {
             if (a[x] == '月') {
                 if (a[x - 2] == '十') {
                     if(a[x-1]=='一')
                         month=11;
                     if(a[x-1]=='二')
                         month=12;


                 } else {
                     switch (a[x - 1]) {
                         case '一':
                             month = 1;
                             break;
                         case '二':
                             month = 2;
                             break;
                         case '三':
                             month = 3;
                             break;
                         case '四':
                             month = 4;
                             break;
                         case '五':
                             month = 5;
                             break;
                         case '六':
                             month = 6;
                             break;
                         case '七':
                             month = 7;
                             break;
                         case '八':
                             month = 8;
                             break;
                         case '九':
                             month = 9;
                             break;
                         case '十':
                             month = 10;
                             break;
                     }
                 }
             }
         }
         for(int x=0;x<input.length();x++){
             if(a[x]=='日'){
                 if(Character.isDigit(a[x-1])){
                     if(Character.isDigit(a[x-2])) {
                         day = Integer.parseInt(input.substring(x - 2, x));
                     }
                     else
                         day=Integer.parseInt(input.substring(x-1,x));
                 }
             }
         }


         System.out.println("year"+year+"place:"+place+"time :"+hour+":"+minute);

     }


    private void saving(){
    }
}
