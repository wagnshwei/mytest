package com.easypoi.dczd;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.commons.lang3.SerializationUtils;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    private static String path = "C:\\Users\\HP\\Desktop\\2024-05\\report.xlsx";

    public static List<Entity> readDTOFromExcel(int sheetIndex) throws Exception {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        params.setStartSheetIndex(sheetIndex);

        List<Entity> list;
        try(InputStream is1 = Files.newInputStream(new File(path).toPath())) {
            list = ExcelImportUtil.importExcel(is1, Entity.class, params);
        }
        return list;
    }

    public static List<Entity> refactorDTO(List<Entity> list) {
        List<Entity> resultList = new ArrayList<>();
        Entity parent = null;

        for(Entity entity : list) {
            Helper.initializeEntity(entity);
            if("*".equals(Helper.trimString(entity.getIndex()))){
                parent.getChildren().add(entity);
            } else {
                entity.getChildren().add(SerializationUtils.clone(entity));
                parent = entity;
                resultList.add(entity);
            }
        }
        return resultList;
    }

}
