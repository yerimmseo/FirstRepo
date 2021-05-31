package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class E08_CaesarCipher {
	
	/*
		# 암호화
		- 평문을 알아볼 수 없는 형태(암호문)로 변환하는 것
		- 전달 과정에서 내용을 누가 훔쳐가더라도 알아볼 수 없게 하는 것이 목적이다
		
		# 복호화
		- 암호화 된 암호문을 다시 평문으로 되돌리는 것
		
		# 키
		- 암호화 또는 복호화에 사용되는 값
		
		# 시저 암호
		
		  "Hello, world!" ---- key:5 ----> "Mjqqt, btwqi!"
		  
		  ABCDEFGHIJKLMNOPQRSTUVWXYZ	
		  
		  암호화: key만큼 오른쪽으로 문자를 이동 시킴
		  복호화: key만큼 왼쪽으로 문자를 이동 시킴
		  
		
		# "frankenstein.txt"의 전체 내용을 1 ~ 25사이의 랜덤 키로 암호화한
		  "frankenstein.encrypted.txt"를 생성해보세요
		  (단, 알파벳만 암호화 할 것)
		  
		# 암호화한 파일을 다시 원본으로 돌려보세요
	*/
	final static String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String LOWER = "abcdefghijklmnopqrstuvwxyz";
	
	// ch가 'H', key가 5일 때
	// ch가 'X', key가 13일 때
	public static char encrypt_upper(char ch, int key) {
		return UPPER.charAt((UPPER.indexOf(ch) + key) % UPPER.length());
	}
	
	public static char encrypt_lower(char ch, int key) {
		return LOWER.charAt((LOWER.indexOf(ch) + key) % LOWER.length());
	}
	
	public static char decryption_upper(char ch, int key) {
		return UPPER.indexOf(ch) - key < 0 ?
				UPPER.charAt(UPPER.length() - Math.abs(UPPER.indexOf(ch) - key)) :
					UPPER.charAt(UPPER.indexOf(ch) - key);
	}
	
	public static char decryption_lower(char ch, int key) {
		return LOWER.indexOf(ch) - key < 0 ?
				LOWER.charAt(LOWER.length() - Math.abs(LOWER.indexOf(ch) - key)) :
					LOWER.charAt(LOWER.indexOf(ch) - key);
	}
	
	public static void decryption(File file, int key) {
		try (
				FileReader fin = new FileReader(file);
				BufferedReader bin = new BufferedReader(fin);
			) {
			String line = null;
			while ((line = bin.readLine()) != null) {
				for (int i = 0, len = line.length(); i < len; i++) {
					char ch = line.charAt(i);
					
					switch (Character.getType(ch)) {
					case Character.UPPERCASE_LETTER:
						ch = decryption_upper(ch, key);
						break;
					case Character.LOWERCASE_LETTER:
						ch = decryption_lower(ch, key);
						break;
					}
					System.out.print(ch);
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//encryptedNovel(readToNovel());
		
		File frankenstein = new File("./data/text/frankenstein.txt");
		File frankenstein_encrypted = new File("./data/text/frankenstein.encrypted.txt");
		int key = new Random().nextInt(25) + 1;
		
		try (
				FileReader fin = new FileReader(frankenstein);
				BufferedReader bin = new BufferedReader(fin);
				FileWriter fout = new FileWriter(frankenstein_encrypted);
				BufferedWriter bout = new BufferedWriter(fout);
			) {
			String line = null;
			while ((line = bin.readLine()) != null) {
				for (int i = 0, len = line.length(); i < len; ++i) {
					
					char ch = line.charAt(i);
					
//					System.out.printf("Is '%c' Alphabetic? %b\n", ch, Character.isAlphabetic(ch));
					
					switch (Character.getType(ch)) {
					case Character.UPPERCASE_LETTER:
						ch = encrypt_upper(ch, key);
						break;
					case Character.LOWERCASE_LETTER:
						ch = encrypt_lower(ch, key);
						break;
					}
					fout.append(ch);
				}
				fout.append('\n');
			}
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		
		// 암호화된 파일을 해석하는 decryption(file, key) 메서드를 만들어보세요
		decryption(frankenstein_encrypted, key);
		
	}
	
	public static void encryptedNovel(String novel) {
		int key = (int)(Math.random() * 25 + 1);
		
		StringBuilder change = new StringBuilder();
		
		for (int i = 0; i < novel.length(); i++) {
			int ch = novel.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				if (ch + key > 'Z') {
					change.append((char)(ch + key - 26));
				} else {
					change.append((char)(ch + key));
				}
			} else if (ch >= 'a' && ch <= 'z') {
				if (ch + key > 'z') {
					change.append((char)(ch + key - 26));
				} else {
					change.append((char)(ch + key));
				}
			} else {
				change.append((char)ch);
			}
		}
		
		try (BufferedWriter bout = 
				new BufferedWriter(
						new FileWriter(
								new File("./data/text/frankenstein.encrypted.txt")))) {
			
			bout.append(change);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readToNovel() {
		File original = new File("./data/text/frankenstein.txt");
		StringBuilder sb = new StringBuilder();
		
		try (FileReader fin = new FileReader(original)) {
			int ch;
			while ((ch = fin.read()) != -1) {
				sb.append((char)ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return sb.toString();
	}
	
}
