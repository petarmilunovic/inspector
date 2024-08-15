import java.io.File;
import java.util.ArrayList;

public class Picture {

    private String pictureName;
    public static ArrayList<Picture> pictureList = new ArrayList<>();
    public static final String filepath = System.getProperty("user.dir").concat("/images");

    public Picture(String pictureName) {
        this.pictureName = pictureName;
    }

    public static void loadAllPictures() {

        File dir = new File(filepath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {

                        pictureList.add(new Picture(file.getName().replace(".jpg", "")));
                    }
                }
                System.out.println("Pictures successfully added!");
            }
        } else {
            System.out.println("Error accessing images folder!");
        }
    }

    public String getPictureName() {
        return pictureName;
    }

}





