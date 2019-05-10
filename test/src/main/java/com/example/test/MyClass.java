package com.example.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyClass {

    public static void main(String args[]){
        getList();
//        getLists();
    }

    public static void getList(){
        List<Audio> list01=new ArrayList<>();
        List<Audio> list02=new ArrayList<>();
        List<Audio> list03=new ArrayList<>();
        for(int i=0;i<3;i++){
            Audio audio=new Audio();
            audio.setChange(false);
            list01.add(audio);
        }
        list02.addAll(list01);
        list03.addAll(list01);
        for(int i=0;i<list02.size();i++){
            Audio a=list02.get(i);
            a.setChange(true);
        }
        printData(list01);
        printData(list02);
        printData(list03);

    }

    static  public void getLists(){
        List<Boolean> list01=new ArrayList<>();
        List<Boolean> list02=new ArrayList<>();
        List<Boolean> list03=new ArrayList<>();
        for(int i=0;i<3;i++){
            list01.add(false);
        }
        list02.addAll(list01);
        list03.addAll(list01);
//        list01.clear();
//        printData(list01);
//        printData(list02);
//        printData(list03);
        for(int i=0;i<list02.size();i++){
            Collections.replaceAll(list02,false,true);
        }

        printDatas(list01);
        printDatas(list02);
        printDatas(list03);

    }

    public static  void printData(List<Audio> listAudio){
        for(int i=0;i<listAudio.size();i++){
            System.out.println(listAudio.get(i).isChange);
        }
    }

    public static  void printDatas(List<Boolean> listAudio){
        for(int i=0;i<listAudio.size();i++){
            System.out.println(listAudio.get(i));
        }
    }



    private static class Audio{
        boolean isChange;

        public boolean isChange() {
            return isChange;
        }

        public void setChange(boolean change) {
            isChange = change;
        }
    }
}
