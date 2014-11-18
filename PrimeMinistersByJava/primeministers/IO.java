package primeministers;

import java.io.File;
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
	 * @param aFIle
	 */
	public static void deleteFileOrDirectory(File aFIle){
		
	}
	/**
	 * 総理大臣ページのためのディレクトリ（存在しなければ作成して）を応答するクラスメソッド。
	 * @return
	 */
	public static File directoryOfPages(){
		
	}
	/**
	 * 入出力する際の文字コードを応答するメソッド。
	 * @return
	 */
	public static String encodingSymbol(){
		
	}
	/**
	 * 指定されたファイルからテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param aFile
	 * @return
	 */
	public static ArrayList<String> readTextFromFile(File aFile){
		
	}
	/**
	 * 指定されたファイル文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param fileString
	 * @return
	 */
	public static ArrayList<String> readTextFromFile(String fileString){
		
	}
	/**
	 * 指定されたURL文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param urlString
	 * @return
	 */
	public static ArrayList<String> readTextFromURL(String urlString){
		
	}
	/**
	 * 指定されたURLからテキストを読み込んで、それを行リストにして応答するクラスメソッド
	 * @param aURL
	 * @return
	 */
	public static ArrayList<String> readTextFromURL(URL aURL){
		
	}
	/**
	 * 文字列をセパレータで分割したトークン列を応答するクラスメソッド
	 * @param string
	 * @param separators
	 * @return
	 */
	public static ArrayList<String> splitString(String string,String separators){
		
	}
	/**
	 * テーブルを応答する
	 */
	public Table table(){
		
	}
	/**
	 * 指定された行リストを、指定されたファイルに書き出すクラスメソッド
	 * @param aCollection
	 * @param aFile
	 */
	public static void writeText(ArrayList<String> aCollection,File aFile){
		
	}
	/**
	 * 指定された行リストを、指定されたファイル名のファイルに書き出すクラスメソッド
	 * @param aCollection
	 * @param fileString
	 */
	public static void writeText(ArrayList<String> aCollection,String fileString){
		
	}
}
