package primeministers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * 入出力：リーダ・ダウンローダ・ライタを抽象する。
 */
public abstract class IO extends Object{

	private File filename;
	/**
	 * テーブル（表：スプレッドシート）を記憶するフィールド。
	 */
	protected Table table;
	/**
	 * 入出力のコンストラクタ
	 */
	public IO(){
	}
	/**
	 * ファイルやディレクトリを削除するクラスメソッド。
	 * @param aFile
	 */
	public static void deleteFileOrDirectory(File aFile){
		aFile.delete();
	}
	/**
	 * 総理大臣ページのためのディレクトリ（存在しなければ作成して）を応答するクラスメソッド。
	 * @return aFile
	 */
	public static File directoryOfPages(){
		String aString = System.getProperty("user.home")+"/Desktop/SouriDaijin";
		File aFile = new File(aString);

		if(!aFile.exists()){
			System.out.println("ファイルが存在しないので作成します。");
			aFile.mkdir();
		}
		return aFile;
	}
	/**
	 * 入出力する際の文字コードを応答するメソッド。
	 * @return encoding
	 */
	public static String encodingSymbol(){
		String encoding = "utf-8";
		return encoding;
	}
	/**
	 * 指定されたファイルからテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param aFile
	 * @return aList
	 */
	public static ArrayList<String> readTextFromFile(File aFile){
		ArrayList<String> aList=new ArrayList<String>();
		try {
			BufferedReader aLineReader = new BufferedReader(new FileReader(aFile));
			String aString;
			while((aString=aLineReader.readLine())!=null){
				aList.add(aString);
			}
			aLineReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aList;
	}
	/**
	 * 指定されたファイル文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param fileString
	 * @return aList
	 */
	public static ArrayList<String> readTextFromFile(String fileString){
		ArrayList<String> aList=new ArrayList<String>();
		File aFile = new File(fileString);
		aList=readTextFromFile(aFile);
		return aList;
	}
	/**
	 * 指定されたURL文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param urlString
	 * @return aList
	 */
	public static ArrayList<String> readTextFromURL(String urlString){
		ArrayList<String> aList = new ArrayList<String>();
		try {
			URL aURL = new URL(urlString);
			aList=readTextFromURL(aURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return aList;
	}
	/**
	 * 指定されたURLからテキストを読み込んで、それを行リストにして応答するクラスメソッド
	 * @param aURL
	 * @return aList
	 */
	public static ArrayList<String> readTextFromURL(URL aURL){
		ArrayList<String> aList = new ArrayList<String>();
		InputStream aInputStream;
		try {
			aInputStream = aURL.openStream();
			InputStreamReader aStreamReader = new InputStreamReader(aInputStream);
			BufferedReader aReader = new BufferedReader(aStreamReader);
			while(true){
				aList.add(aReader.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return aList;
	}
	/**
	 * 文字列をセパレータで分割したトークン列を応答するクラスメソッド
	 * @param string
	 * @param separators
	 * @return aList
	 */
	public static ArrayList<String> splitString(String string,String separators){
		ArrayList<String> aList = new ArrayList<String>();
		String[] splitList = string.split(separators);
		int splitLength=splitList.length;
		for(int i=0;i<splitLength;i++){
			aList.add(splitList[i]);
		}
		return aList;
	}
	/**
	 * テーブルを応答する
	 */
	public Table table(){
		return this.table;
	}
	/**
	 * 指定された行リストを、指定されたファイルに書き出すクラスメソッド
	 * @param aCollection
	 * @param aFile
	 */
	public static void writeText(ArrayList<String> aCollection,File aFile){
		try {
			FileWriter aFileWriter = new FileWriter(aFile);
			aCollection.forEach(string->{try {
				aFileWriter.write(string);
			} catch (Exception e) {
				e.printStackTrace();
			}});
			aFileWriter.close();
		}catch (IOException e) {
			e.printStackTrace();
		};
	}
	/**
	 * 指定された行リストを、指定されたファイル名のファイルに書き出すクラスメソッド
	 * @param aCollection
	 * @param fileString
	 */
	public static void writeText(ArrayList<String> aCollection,String fileString){
		File aFile = new File(fileString);
		writeText(aCollection,aFile);
	}
}
