package chap_13;

import java.io.File;

public class _04_Folder {
    public static void main(String[] args) {
        String folderName = "A";
        File folder = new File(folderName);
        folder.mkdir(); //폴더 생성
        if(folder.exists()){
            System.out.println("폴더가 존재합니다. : " + folder.getAbsolutePath());
        }

        System.out.println("---------------------------------------");

        folderName = "A/B/C";
        folder = new File(folderName);
        folder.mkdirs(); //여러개의 하위 폴더가 존재하는 경우
        if(folder.exists()){
            System.out.println("폴더가 존재합니다. : " + folder.getAbsolutePath());
        } else {
            System.out.println("폴더 생성 실패 (mkdir)");
        }
    }
}
