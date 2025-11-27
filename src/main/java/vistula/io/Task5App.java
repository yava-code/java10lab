package vistula.io;

public class Task5App {
    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "userdata.txt";

        DataManagement dm = new DataManagement();
        String s = dm.readData();
        dm.writeDataToFile(s, fileName);
        dm.readDataFromFile(fileName);
    }
}