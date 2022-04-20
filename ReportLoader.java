import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class ReportLoader {

    public List<MonthEntry> readFilesContentsMonth(String path) {
        try {
            List<String> lines = readAllLines(Path.of(String.format(path)));
            List<MonthEntry> result = new ArrayList<>();
            for (int i = 1; i < lines.size(); i++) {
                String[] value = lines.get(i).split(",");
                MonthEntry operation = new MonthEntry(
                        path.substring(16, 18),
                        value[0],
                        Boolean.parseBoolean(value[1]),
                        Integer.parseInt(value[2]),
                        Integer.parseInt(value[3]));
                result.add(operation);
            }
            System.out.println("Отчет за месяц " + path.substring(16,18) + " получен.");
            return result;
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public List<YearEntry> readFilesContentsYear(String path) {
        try {
            List<String> lines = readAllLines(Path.of(String.format(path)));
            List<YearEntry> result = new ArrayList<>();
            for (int i = 1; i < lines.size(); i++) {
                String[] value = lines.get(i).split(",");
                YearEntry operation = new YearEntry(
                        Integer.parseInt(value[0]),
                        Integer.parseInt(value[1]),
                        Boolean.parseBoolean(value[2]));

                result.add(operation);
            }
            System.out.println("Отчет за ГОД получен.");
            return result;
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}




