package com.easypoi.test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class demo {
    public static void main(String[] args) throws Exception {
        new demo().excelUtil("D:\\excel11\\cssj.xlsx", new demo().dateMap(), "D:\\test.xlsx");
    }
 
   /**
     * @param templateUrl 模板文件路径
     * @param dateMap     文件数据
     * @param exportUrl   导出的文件路径
     */
    public void excelUtil(String templateUrl, Map<String, Object> dateMap, String exportUrl) throws Exception {
        TemplateExportParams params = new TemplateExportParams(templateUrl);
        Workbook workbook = ExcelExportUtil.exportExcel(params, dateMap);
        System.out.println("123456");
        FileOutputStream fos = new FileOutputStream(exportUrl);
        workbook.write(fos);
        fos.close();
    }


    /**
     * 数据
     * @return
     */
    public Map<String, Object> dateMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", "2014-12-25");
        map.put("money", 2000000.00);
        map.put("upperMoney", "贰佰万");
        map.put("company", "执笔潜行科技有限公司");
        map.put("bureau", "财政局");
        map.put("person", "JueYue");
        map.put("phone", "1879740****");
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 4; i++) {
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("id", i + 1 + "");
            lm.put("zijin", i * 10000 + "");
            lm.put("bianma", "A001");
            lm.put("mingcheng", "设计");
            lm.put("xiangmumingcheng", "EasyPoi " + i + "期");
            lm.put("quancheng", "开源项目");
            lm.put("sqje", i * 10000 + "");
            lm.put("hdje", i * 10000 + "");
 
            listMap.add(lm);
        }
        map.put("maplist", listMap);
        return map;
    }
}