package com.stackroute.jdbc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//      Object creation
        EmployeeDemo demo = new EmployeeDemo();
        RowSetDemo rowSetDemo =new RowSetDemo();
        ResultSetMetaDataDemo resultSetMetaDataDemo = new ResultSetMetaDataDemo();
        DatabaseMetaDataDemo databaseMetadataDemo = new DatabaseMetaDataDemo();
        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
        JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
        
//      Method calls of EmployeeDemo class
        System.out.println("---------------------------------\nEmployeeDemo Class\n---------------------------------\n");
        demo.getEmployeeDetail();
        demo.getEmployeeDetailsInReverse();
        demo.getEmployeeDetailsFromSecondRowInReverse();
        demo.getEmployeeDetailsByNameAndGender("Ishwarya","female");

//      Method calls of RowSetDemo class
        rowSetDemo.rowSetMethodsDemo();
        
        resultSetMetaDataDemo.resultSetMetaDataMethodsDemo();
        databaseMetadataDemo.databaseMetaDataMethodsDemo();
        jdbcBatchDemo.batchExecution();
        jdbcTransactionDemo.transactionDemo();
    }
}
