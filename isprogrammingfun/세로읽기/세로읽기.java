import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[][] ch = new char[5][15];	
        
        //배열 넣기
        for ( int i = 0; i < ch.length; i++) {
            String str = br.readLine();
            
            for(int j = 0; j < str.length(); j++){
                ch[i][j]=str.charAt(j);
            }
        }
            
        //배열 출력
         for ( int i = 0; i < ch[0].length; i++){
             for(int j = 0 ; j < ch.length; j ++)
			{
				if(ch[j][i]==' ' || ch[j][i]=='\0')		// 출력을 할 떄, 참조한 인덱스가 공백 또는 null 문자 일 경우, 넘어가고 계속 진행 ( continue )
					continue;
				
				System.out.print(ch[j][i]);	
			}
         }
        }
    }