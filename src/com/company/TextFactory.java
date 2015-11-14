package com.company;

public class TextFactory {
    String input;
    int hour;
    int minute;
    String place;
    int importance;
    TextFactory(String _input){input=_input;}
     void stringdealing(){
        char []a=this.input.toCharArray();
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
                 String[] placetemp = input.substring(placeposition + 5, input.length() - 1).split("。");
                 place = placetemp[0];
             }
         }


        System.out.println("place:"+place+"time:"+hour+":"+minute);


    }

    private void saving(){

    }


}
