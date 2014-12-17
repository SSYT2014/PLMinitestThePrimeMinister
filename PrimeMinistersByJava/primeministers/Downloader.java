package primeministers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

/**
 * ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 */
public class Downloader extends IO{
	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL文字列)を記憶するフィールド。
	 */
	private String url;
	private Table table;

	/**
	 * ダウンローダのコンストラクタ。
	 */
	public Downloader(){
		super();
		super.directoryOfPages();
		this.url="http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/PrimeMinisters.csv";
		this.table=this.table();
	}
	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードする。
	 */
	public void downloadCSV(){
		try {
			URL aURL = new URL(url());
			HttpURLConnection aURLConnection = (HttpURLConnection)aURL.openConnection();
			aURLConnection.connect();

			String filename = System.getProperty("user.home")+"/Desktop/SouriDaijin/PrimeMinisters.csv";
	//		File aFile = new File(aString);
			FileOutputStream aOutputStream = new FileOutputStream(filename);
			
			byte buff[] = new byte[4096];
			
			DataInputStream aInputStream = new DataInputStream(aURLConnection.getInputStream());
			int readData;
			while((readData=aInputStream.read(buff))!=-1){
				aOutputStream.write(buff,0,readData);
			}
			aInputStream.close();
			System.out.println("CSV Download Finish");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadImages(){
		this.table.attributes().indexOfImage();
	}
	/**
	 * 総理大臣の画像群またはサムネイル画像群をダウンロードする。
	 * @param indexOfPicture
	 */
	private void downloadPictures(int indexOfPicture){
		
	}
	
	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadThumbnails(){
		
	}
	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群をダウロードし、テーブルで応答する。
	 * @return aTable
	 * 
	 */
	public Table table(){
		this.downloadCSV();
		Reader aReader = new Reader();
		Table aTable=aReader.table();
		
		int a=0;
		this.downloadPictures(a);
		return aTable;
	}
	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答する。
	 * @return aUrl
	 */
	public String url(){
		String aUrl ="http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/PrimeMinisters.csv";
		return aUrl;
	}
	/**
	 * 総理大臣の情報の在処(URL)を文字列で応答するクラスメソッド。
	 * @return
	 */
	public static String urlString(){
		String aURLString="";
		return aURLString;
	}
	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答するクラスメソッド。
	 * @return aUrl
	 */
	public static String urlStringOfCSV(){
		String aUrl = "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/PrimeMinisters.csv";
		return aUrl;
	}
	
}
