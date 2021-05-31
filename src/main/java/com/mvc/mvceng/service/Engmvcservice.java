package com.mvc.mvceng.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class Engmvcservice {
    public HashMap<String , Integer>  checkWordEng(String inputeng){


        StringBuilder sbinput = new StringBuilder(inputeng);
        HashMap<String , Integer> hm = new HashMap<>();
        char[] inputengchar = new char[sbinput.length()];
        for(int i =0; i< sbinput.length() ; i++ ){
            inputengchar[i] = sbinput.charAt(i);
            if(inputengchar[i] == '!' || inputengchar[i] == '?'|| inputengchar[i] == ','){
                sbinput.deleteCharAt(i);
            }

        }
        String inputanswer = sbinput.toString();
        String[] st = inputanswer.split(" ");
        System.out.println(inputanswer);
        for(int i =0; i<st.length-1;i++)
        {
            if(hm.containsKey(st[i])) {
                hm.put(st[i], hm.get(st[i])+1);
            }else{
                hm.put(st[i],1);
            }
        }
        System.out.println(hm);

        return hm;
    }
}
