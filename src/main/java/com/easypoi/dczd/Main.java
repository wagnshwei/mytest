package com.easypoi.dczd;

import java.util.List;

public class Main {
    
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 5; i ++) {
//        int i = 4;
            System.out.println("reading...");
            List<Entity> sheet = ReadExcel.readDTOFromExcel(i);
            List<Entity> refList = ReadExcel.refactorDTO(sheet);
            refList.forEach(entity -> Helper.constructBankLeaseInfo(entity));
            Helper.printList(refList);
            System.out.println("read");
            System.out.println("inserting...");
            SyncDB.insert(refList);
            System.out.println("inserted");
        }
    }

}
