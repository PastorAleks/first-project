import java.util.List;

public class ReportProcessing {

    public void dataProcessingMonthlyProduct(List<MonthEntry> month) {
        String monthName = "";
        String itemName = "";
        int currentValue;
        int maxValue = 0;

        for (int i = 1; i < month.size(); i++) {
            if (!month.get(i).is_expense) {
                currentValue = (month.get(i).quantity * month.get(i).sum_of_one);
                if (currentValue > maxValue) {
                    maxValue = currentValue;
                    monthName = month.get(i).month_Name;
                    itemName = month.get(i).item_name;
                }
            }
        }
        System.out.println("Самый прибыльный товар за месяц " + monthName + ": " + itemName + ". " + "Продано на сумму - " + maxValue);
    }

    public void dataProcessingPerYear(List<YearEntry> year) {
        int numberOfOperation1 = 0;
        int numberOfOperation2 = 0;
        double totalExpense = 0;
        double totalIncome = 0;
        for (YearEntry yearEntry : year) {
            if (yearEntry.is_expense) {
                totalExpense = totalExpense + yearEntry.amount;
                numberOfOperation1 = numberOfOperation1 + 1;
            }
        }
        for (YearEntry yearEntry : year) {
            if (!yearEntry.is_expense) {
                totalIncome = totalIncome + yearEntry.amount;
                numberOfOperation2 = numberOfOperation2 + 1;
            }
        }
        for (int i = 0; i < year.size(); i = i + 2) {
            int profit;
            if (year.get(i).month == year.get(i + 1).month && !year.get(i).is_expense) {
                profit = year.get(i).amount - year.get(i + 1).amount;
                System.out.println("Прибыль за месяц: " + profit);
            } else if (year.get(i).month == year.get(i + 1).month) {
                profit = year.get(i + 1).amount - year.get(i).amount;
                System.out.println("Прибыль за месяц: " + profit);
            }
        }
        System.out.println("Средний расход за все месяцы в году; " + totalExpense / numberOfOperation1);
        System.out.println("Средний доход за все месяцы в году; " + totalIncome / numberOfOperation2);
    }

    public void checkReports(List<MonthEntry> month, List<YearEntry> year) {
        int allEarning = 0;
        int allExpense = 0;

        for (int i = 0; i < month.size(); i++) {
            if (!month.get(i).is_expense) {
                allEarning = allEarning + month.get(i).sum_of_one * month.get(i).quantity;
            } else {
                allExpense = allExpense + month.get(i).sum_of_one * month.get(i).quantity;
            }

        }
        //System.out.println(allEarning);
        //System.out.println(allExpense);
        for (int i = 0; i < year.size(); i++) {
            if (Integer.parseInt(month.get(i).month_Name) == year.get(i).month)
            for (int j = 0; j < year.size(); j++) {
                if (!year.get(j).is_expense && (year.get(j).amount == allEarning)) {
                    System.out.println(year.get(j).amount + " 1111");
                    System.out.println(allEarning);
                    break;
                }

//            } if (Integer.parseInt(month.get(i).month_Name) == year.get(i).month && year.get(i).is_expense && (year.get(i).amount == allExpense)) {
//                System.out.println(year.get(i).amount+ " 2222");
//                System.out.println(allExpense);
//            }
                System.out.println("Ошибка в отчете за " + month.get(i).month_Name + " месяц.");

            }
        }
    }
}
//(month.get(i).month_Name.equals(Integer.toString(year.get(i).month)) && !year.get(i).is_expense && (year.get(i).amount != allEarning))