package by.tc.task01.dataprovider;

        import java.io.BufferedWriter;
        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;

public class FileCreator {
    public File createFile() throws IOException {
        final String FILENAME ="res/db.txt";
        File file = new File(FILENAME);
        if (file.exists()){
            file.delete();
        }
        file.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILENAME));
        bufferedWriter.write(ApplianceData.getApplianceData());
        bufferedWriter.close();
        return file;
    }
}
