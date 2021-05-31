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
		# ��ȣȭ
		- ���� �˾ƺ� �� ���� ����(��ȣ��)�� ��ȯ�ϴ� ��
		- ���� �������� ������ ���� ���İ����� �˾ƺ� �� ���� �ϴ� ���� �����̴�
		
		# ��ȣȭ
		- ��ȣȭ �� ��ȣ���� �ٽ� ������ �ǵ����� ��
		
		# Ű
		- ��ȣȭ �Ǵ� ��ȣȭ�� ���Ǵ� ��
		
		# ���� ��ȣ
		
		  "Hello, world!" ---- key:5 ----> "Mjqqt, btwqi!"
		  
		  ABCDEFGHIJKLMNOPQRSTUVWXYZ	
		  
		  ��ȣȭ: key��ŭ ���������� ���ڸ� �̵� ��Ŵ
		  ��ȣȭ: key��ŭ �������� ���ڸ� �̵� ��Ŵ
		  
		
		# "frankenstein.txt"�� ��ü ������ 1 ~ 25������ ���� Ű�� ��ȣȭ��
		  "frankenstein.encrypted.txt"�� �����غ�����
		  (��, ���ĺ��� ��ȣȭ �� ��)
		  
		# ��ȣȭ�� ������ �ٽ� �������� ����������
	*/
	final static String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String LOWER = "abcdefghijklmnopqrstuvwxyz";
	
	// ch�� 'H', key�� 5�� ��
	// ch�� 'X', key�� 13�� ��
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
		
		
		// ��ȣȭ�� ������ �ؼ��ϴ� decryption(file, key) �޼��带 ��������
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
