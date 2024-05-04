package com.easypoi.dczd;

import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Entity implements Serializable {

    @Excel(name="序号")
    private String index;

    @Excel(name="转贷企业")
    private String companyName;

    @Excel(name="是否结清")
    private String ifSettle;

    @Excel(name="合同编号")
    private String applyLoanContractNo;

    @Excel(name="开始日期")
    private String applyLoanStartTime;

    @Excel(name="转贷银行")
    private String bankName;

    @Excel(name="原贷款金额（万元）")
    private Double originalLoanAmount;

    @Excel(name="省平台配资金额（万元）")
    private Double companyOfferAmount;

    @Excel(name="本次借款金额（万元）")
    private Double applyLoanAmount;

    @Excel(name="到期日")
    private String applyLoanEndTime;

    @Excel(name="德诚出资额（万元）")
    private Double offerLeaseAmount;

    @Excel(name="利息收益")
    private Double repayInterest;

    private String leaseInfo;

    private String ifLoan;

    private List<Entity> children = new ArrayList<>();

}
