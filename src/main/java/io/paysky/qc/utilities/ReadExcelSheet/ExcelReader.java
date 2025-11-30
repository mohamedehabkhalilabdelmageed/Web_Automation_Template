//package io.paysky.qc.utils;
//
//
//
//
//import java.io.FileInputStream;
//
//import java.io.IOException;
//
//
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Cell;
//
//public class ExcelReader {
//
//    public static void main(String[] args) throws Exception {
//        // JSON payload to be encrypted
//        /*String text = getToken(1);
//        System.out.println(text);*/
//        //String[][] data = readExcelSheet("./payout.xlsx", "payoutTransfere");
//
//       /* if (data != null) {
//            // Use the data as needed
//            for (String[] row : data) {
//                for (String cell : row) {
//                    System.out.print(cell + " | ");
//                }
//                System.out.println();
//            }
//        }*/
//
//    }
//
//
//
//    public static String[][] readExcelSheet(String filePath, String sheetName, boolean skipHeader) {
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheet(sheetName);
//
//            if (sheet == null) {
//                throw new IllegalArgumentException("Sheet not found: " + sheetName);
//            }
//
//            int numRows = sheet.getPhysicalNumberOfRows();
//            int numCols = 0;
//
//            // Calculate the number of columns based on the row with the maximum number of cells
//            for (int i = 0; i < numRows; i++) {
//                Row row = sheet.getRow(i);
//                if (row != null) {
//                    int cols = row.getPhysicalNumberOfCells();
//                    if (cols > numCols) {
//                        numCols = cols;
//                    }
//                }
//            }
//
//            String[][] matrix;
//
//            if (skipHeader) {
//                // If skipping the header, reduce the number of rows by 1
//                matrix = new String[numRows - 1][numCols];
//            } else {
//                matrix = new String[numRows][numCols];
//            }
//
//            for (int i = skipHeader ? 1 : 0; i < numRows; i++) {
//                Row row = sheet.getRow(i);
//                if (row != null) {
//                    for (int j = 0; j < numCols; j++) {
//                        Cell cell = row.getCell(j);
//                        if (cell != null) {
//                            matrix[i - (skipHeader ? 1 : 0)][j] = cell.toString();
//                        }
//                    }
//                }
//            }
//
//            return matrix;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//}
//
//
