package primeministers;

import java.io.BufferedReader;
import java.io.DataInputStream;
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
		this.url=null;
		this.table=new Table();
	}
	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードする。
	 */
	public void downloadCSV(){
		try {
			URL aURL = new URL(url());
			HttpURLConnection aURLConnection = (HttpURLConnection)aURL.openConnection();
			aURLConnection.connect();
			
			FileOutputStream aOutputStream = new FileOutputStream("./PrimeMinisters.csv");
			
			byte buff[] = new byte[4096];
			
			DataInputStream aInputStream = new DataInputStream(aURLConnection.getInputStream());
			int readData;
			while((readData=aInputStream.read(buff))!=-1){
				aOutputStream.write(buff,0,readData);
			}
			aInputStream.close();
			System.out.println("CSV Download Finish");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadImages(){
		
	}
	/**
	 * 総理大臣の画像群またはサムネイル画像群をダウンロードする。
	 * @param indexOfPicture
	 */
	private void downloadPictures(int indexOfPicture){
		try {
			FileReader aFileReader = new FileReader("./csv");
			BufferedReader aCSVReader = new BufferedReader(aFileReader);
			String aLine;
			StringTokenizer aToken;
			while((aLine=aCSVReader.readLine())!=null){
				aToken=new StringTokenizer(aLine,",");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadThumbnails(){
		
	}
	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群をダウロードし、テーブルで応答する。
	 * @return aTable
	 */
	public Table table(){
		Table aTable=new Table();
		int a=0;
		this.downloadCSV();
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
