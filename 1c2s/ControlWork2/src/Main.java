import java.io.*;
import java.util.*;


public class Main {

    // вывод у 3ей задачи очень большой. ответы на 1, 2 в начале консоли
    public static void main(String[] args) {
        List<HumanData> list = new ArrayList<>();
        HumanDataParser parser;
        try {
            parser = new HumanDataParser("resources/BirthsKingCounty2001.txt");
            parser.parseFromFileToCollection(list);
            task1(list);
            System.out.println("ответ на вопрос в задаче 2 - " + task2(list));
            task3(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void task1(List<HumanData> list) {
        Map<String, Integer> raceWeight = new HashMap<>(); // race -> сумма веса
        Map<String, Integer> raceCount = new HashMap<>(); // race -> кол-во
        for (HumanData data : list) {
            String race = data.getRace();
            if (raceWeight.containsKey(race)) {
                raceWeight.put(race, raceWeight.get(race) + data.getBwt());
                raceCount.put(race, raceCount.get(race) + 1);
            } else {
                raceWeight.put(race, (int) data.getBwt());
                raceCount.put(race, 1);
            }
        }
        for (String key : raceWeight.keySet()) {
            System.out.println(key + " - " + 1.0 * raceWeight.get(key) / raceCount.get(key));
        }
    }

    public static boolean task2(List<HumanData> list) {
        double avgGestationSmoker = list.stream()
                                                .filter(HumanData::isSmoker)
                                                .mapToInt(HumanData::getGestation)
                                                .average().orElse(-1);
        double avgGestationNoSmoker = list.stream()
                                                .filter(h -> !h.isSmoker())
                                                .mapToInt(HumanData::getGestation)
                                                .average().orElse(-1);
        System.out.println("среднее у курящих - " + avgGestationSmoker);
        System.out.println("среднее у некурящих - " + avgGestationNoSmoker);
        if (avgGestationSmoker != -1 && avgGestationNoSmoker != -1) {
            return avgGestationSmoker - avgGestationNoSmoker < 0;
        }
        return false;
    }

    public static void task3(List<HumanData> list) throws IOException {
        try (DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("stat.bin")))) {
            for (HumanData data : list) {
                outputStream.writeUTF(data.getRace());
                outputStream.writeByte(data.getEducation());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream in = new DataInputStream(new FileInputStream("stat.bin"))) {
            while (in.available() > 0) {
                String race = in.readUTF();
                byte b = in.readByte();
                System.out.println(race + " " + b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}