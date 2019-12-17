import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SpaceImage {

    private static Map<Integer, Long> countMap;
    private static int width = 25;
    private static int height = 6;
    private static int size = width*height;
    private static List<Long> numberOfZeros = new ArrayList<>();
    private static List<Long> onextwo = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        SpaceImage si = new SpaceImage();
        String data = readFileAsString("C:\\Users\\diella.agyeman\\Desktop\\input.txt");
        si.splitDataIntoLayers(data);

        System.out.println(numberOfZeros);
        System.out.println(onextwo);
    }


    public static String readFileAsString(String fileName)throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data.trim();
    }

    public static void splitDataIntoLayers(String data) {
        for(int i = 0; i < data.length(); i += size) {
            List<Integer> pixels = convertStringOfPixelsIntoIntegerArray(data.substring(i, (i+size) - 1));
            Map<Integer, Long> countm = countPixels(pixels);
            numberOfZeros.add(countm.get(0));
            onextwo.add(countm.get(1)*countm.get(2));
        }
    }

    public static List<Integer> convertStringOfPixelsIntoIntegerArray(String pixels) {
        List<String> stringNumArray = Arrays.asList(pixels.split(""));
        return stringNumArray.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Map<Integer, Long> countPixels(List<Integer> pixelArray) {
        return countMap = pixelArray.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public void findSmallestAmountOfZeros() {
        numberOfZeros.stream().sorted().findFirst().get();
    }
}
