import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Hashmap1 {
    public static void main(String[] args) throws Exception {

        
        HashMap<String, Integer> inventoryMap = new HashMap<>();
        File sourceFile = new File("ECOM_DATASHEET.txt");

        Scanner fileReader = new Scanner(sourceFile);

       
        if (fileReader.hasNextLine()) fileReader.nextLine();

        while (fileReader.hasNextLine()) {
            
            String[] dataRow = fileReader.nextLine().split("\\s+");

           
            String itemName = dataRow[7] + " " + dataRow[8];
            int quantity = Integer.parseInt(dataRow[9]);

           
            inventoryMap.put(itemName, inventoryMap.getOrDefault(itemName, 0) + quantity);
        }
        fileReader.close();

        
        inventoryMap.put("Product E", inventoryMap.getOrDefault("Product E", 0) + 50);

       
        PrintWriter dataWriter = new PrintWriter(new File("UPDATED_DATA.txt"));

       
        for (String itemKey : inventoryMap.keySet()) {
            dataWriter.println(itemKey + " " + inventoryMap.get(itemKey));
        }

        dataWriter.close();

        System.out.println("Inventory update finished successfully!");
    }
}