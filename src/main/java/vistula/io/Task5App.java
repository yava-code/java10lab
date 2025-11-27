package vistula.io;

/**
 * TASK 5 - Application runner with main()
 */
public class Task5App {
    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "userdata.txt";

        DataManagement dm = new DataManagement();
        String data = dm.readData();
        dm.writeDataToFile(data, fileName);
        dm.readDataFromFile(fileName);
    }
}