package iss.AES;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        AESAlgorithm aesAlgorithm = new AESAlgorithm();

        // 암호화/복화화 선택
        System.out.println("Encode - 1, Decode - 2 : ");
        int c = scanner.nextInt();
        scanner.nextLine();
        // 암호화 경우
        if(c == 1){
            // 경로 및 키 입력
            System.out.print("Path : ");
            String path = scanner.nextLine();
            System.out.print("Key : ");
            String key = scanner.nextLine();
            // 암호화 및 프로젝트 경로에 암호화 파일 생성
            String origin = aesAlgorithm.fileRead(path);    // 파일 원본
            String text = aesAlgorithm.encode(origin,key);  // 암호화한 파일 내용
            aesAlgorithm.fileWrite("./encodetxt.txt",text); // 파일 저장

            System.out.println("Path : ./encodetxt.txt");
            System.out.println("Origin Text : " + origin);
            System.out.println("Encode Text : " + text);
        }
        // 복호화 경우
        else if(c == 2){
            // 경로 및 키 입력
            System.out.print("Path : ");
            String path = scanner.nextLine();
            System.out.print("Key : ");
            String key = scanner.nextLine();
            // 복호화 및 프로젝트 경로에 복호화 파일 생성
            String origin  = aesAlgorithm.fileRead(path); // 복호화할 파일 내용
            String text = aesAlgorithm.decode(origin,key);  // 복호화 한 파일 내용
            aesAlgorithm.fileWrite("./decodetxt.txt",text);    // 파일 저장

            System.out.println("Path : ./decodetxt.txt");
            System.out.println("Origin Text : " + origin);
            System.out.println("Encode Text : " + text);
        }
    }
}
