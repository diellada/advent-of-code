import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SpaceImage {

    private static Map<Integer, Long> countMap;
    private static int width = 25;
    private static int height = 6;
    private static int size = width*height;
    private static List<Long> numberOfZeros = Arrays.asList();
    private static List<Integer> onextwo = Arrays.asList();

    public static void main(String[] args) throws Exception {
        SpaceImage si = new SpaceImage();
        String data = readFileAsString("C:\\Users\\diella.agyeman\\Desktop\\input.txt");


//        List<Integer> cm = si.convertStringOfPixelsIntoIntegerArray(data);
//        System.out.println(si.countPixels(cm));
//        List<List<Integer>> l = si.splitIntoLayer(data);
//        System.out.println(l);

        for(int i = 0; i < size; i += size) {
            List<Integer> pixels = si.convertStringOfPixelsIntoIntegerArray(data.substring(i, (i+size) - 1));
            Map<Integer, Long> countm = si.countPixels(pixels);
            numberOfZeros.add(countm.get(0));
            onextwo.add((int) (countm.get(1)*countm.get(2)));
        }
        System.out.println(numberOfZeros);
    }


    public static String readFileAsString(String fileName)throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data.trim();
    }

//    public static String splitDataIntoLayers(String pixelData) {
//        List<String> pixels = Arrays.asList(pixelData.split(""));
//        String stringPixels = "";
//        for (String p: pixels) {
//
//        }
//    }


    public List<Integer> convertStringOfPixelsIntoIntegerArray(String pixels) {
        List<String> stringNumArray = Arrays.asList(pixels.split(""));
        return stringNumArray.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

//    public List<Integer> splitIntoLayer(List<String> pixelData) {
////        List<List<Integer>> layers = Arrays.asList();
//        List<Integer> layers = Arrays.asList();
//        for (int pixel = 0; pixel < pixelData.length(); pixel += size) {
////        for (int pixel = 0; pixel < 26; pixel += size) {
//            List<Integer> layer = pixelData.subList(pixel, pixel + size);
//            layers.add(layer);
//            numberOfZeros.add(Math.toIntExact(countPixels(layer).get(0)));
//        }
////        return layers;
//    }

    public Map<Integer, Long> countPixels(List<Integer> pixelArray) {
        return countMap = pixelArray.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
