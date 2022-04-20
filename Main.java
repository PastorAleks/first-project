import java.util.Scanner;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        ReportProcessing reportProcessing = new ReportProcessing();
        ReportLoader reportLoader = new ReportLoader();
        List<MonthEntry> rlM01 = null;
        List<MonthEntry> rlM02 = null;
        List<MonthEntry> rlM03 = null;
        List<YearEntry> rlY = null;

        while (true) {
            printMenu();
            int userInput = inputData(5);
            if (userInput == 1) {
                rlM01 = reportLoader.readFilesContentsMonth("resources/m.202101.csv");
                rlM02 = reportLoader.readFilesContentsMonth("resources/m.202102.csv");
                rlM03 = reportLoader.readFilesContentsMonth("resources/m.202103.csv");
                System.out.println("");
            } else if (userInput == 2) {
                rlY = reportLoader.readFilesContentsYear("resources/y.2021.csv");
                System.out.println("");
            } else if (userInput == 3) {
                reportProcessing.checkReports(rlM01, rlY);
                reportProcessing.checkReports(rlM02, rlY);
                //reportProcessing.checkReports(rlM03, rlY);

            } else if (userInput == 4) {
                reportProcessing.dataProcessingMonthlyProduct(rlM01);
                reportProcessing.dataProcessingMonthlyProduct(rlM02);
                reportProcessing.dataProcessingMonthlyProduct(rlM03);
                System.out.println("");
            } else if (userInput == 5) {
                reportProcessing.dataProcessingPerYear(rlY);
                System.out.println("");
            } else if (userInput == 0) {
                break;
            }
        }
    }

    public static void printMenu(){
        System.out.println("1. Считать все месячные отчёты");
        System.out.println("2. Считать годовой отчёт");
        System.out.println("3. Сверить отчёты");
        System.out.println("4. Вывести информацию о всех месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
        System.out.println("0. Выход из программы");
    }

    static int inputData(int upValue) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int data = scanner.nextInt();
            if (data < 0) {
                System.out.println("Ошибка ввода!");
            } else if (data > upValue) {
                System.out.println("Ошибка ввода!");
            } else {
                return data;
            }
        }
    }

}

