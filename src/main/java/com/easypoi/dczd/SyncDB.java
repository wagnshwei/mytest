package com.easypoi.dczd;

import java.sql.*;
import java.util.List;

public class SyncDB {

    private static String jdbcURL = "jdbc:mysql://localhost:3306/dczd?useUnicode=true&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "123";
    private static final String INSERT_APPLY_SQL = "INSERT INTO dczd_business_apply " +
            " (company_name, bank_name, apply_loan_contract_no, bank_lease_info, company_offer_amount, apply_loan_amount, " +
            " apply_loan_start_time, apply_loan_end_time, if_issue_loan_contact_form, if_settle, approval_status, create_time, create_user_id, update_time, update_user_id) " +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_DETAIL_SQL = "INSERT INTO dczd_business_repay_detail " +
            " (business_apply_id, enlending_balance, interest_balance, if_loan, start_time, end_time, create_time, create_user_id, update_time, update_user_id) " +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void insert(List<Entity> entities) {
        final PreparedStatement applyStatement;
        final PreparedStatement detailStatement;

        try {
            Connection connection = connect();
            if (connection != null) {
                connection.setAutoCommit(false);

                applyStatement = connection.prepareStatement(INSERT_APPLY_SQL, Statement.RETURN_GENERATED_KEYS);
                detailStatement = connection.prepareStatement(INSERT_DETAIL_SQL);

                for (Entity entity : entities) {
                    String now = Helper.getNowDatetime();
                    applyStatement.setString(1, entity.getCompanyName());
                    applyStatement.setString(2, entity.getBankName());
                    applyStatement.setString(3, entity.getApplyLoanContractNo());
                    applyStatement.setString(4, entity.getLeaseInfo());
                    applyStatement.setDouble(5, entity.getCompanyOfferAmount());
                    applyStatement.setDouble(6, entity.getApplyLoanAmount());
                    applyStatement.setString(7, entity.getApplyLoanStartTime());
                    applyStatement.setString(8, entity.getApplyLoanEndTime());
                    applyStatement.setString(9, entity.getIfBankOfferContractForm());
                    applyStatement.setString(10, entity.getIfSettle());
                    applyStatement.setString(11, "-1");
                    applyStatement.setString(12, now);
                    applyStatement.setLong(13, 1L);
                    applyStatement.setString(14, now);
                    applyStatement.setLong(15, 1L);
                    applyStatement.executeUpdate();

                    ResultSet rs = applyStatement.getGeneratedKeys();

                    if (rs.next()) {
                        long businessApplyId = rs.getLong(1);
                        for (Entity child : entity.getChildren()) {
                            now = Helper.getNowDatetime();
                            detailStatement.setLong(1, businessApplyId);
                            detailStatement.setDouble(2, child.getOfferLeaseAmount());
                            detailStatement.setDouble(3, child.getRepayInterest());
                            detailStatement.setString(4, child.getIfLoan());
                            detailStatement.setString(5, child.getApplyLoanStartTime());
                            detailStatement.setString(6, child.getApplyLoanEndTime());
                            detailStatement.setString(7, now);
                            detailStatement.setLong(8, 1L);
                            detailStatement.setString(9, now);
                            detailStatement.setLong(10, 1L);
                            detailStatement.executeUpdate();
                        }
                    }
                    rs.close();

                }

                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
