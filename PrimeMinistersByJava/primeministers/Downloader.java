package primeministers;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

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

		Reader aReader = new Reader();
		this.table=aReader.table();
	}
	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードする。
	 */
	public void downloadCSV(){
		ArrayList<String> aCollection = super.readTextFromURL(url);
		File aFile = new File(super.directoryOfPages(),"PrimeMinisters.csv");
		super.writeText(aCollection, aFile);
	}
	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadImages(){
		String filename = System.getProperty("user.home")+"/Desktop/SouriDaijin/images";
		File aFile = new File(filename);
		if(!aFile.exists()){
			System.out.println("ファイルが存在しないので作成します。");
			aFile.mkdir();
		}
		int indexOfPicture = this.table.attributes().indexOfImage();
		this.downloadPictures(indexOfPicture);
		System.out.println(this.table.attributes().indexOfImage());
		ArrayList<Tuple> tuples = this.table.tuples();
		tuples.forEach(e->System.out.println(e.values().get(9)));
	}
	/**
	 * 総理大臣の画像群またはサムネイル画像群をダウンロードする。
	 * @param indexOfPicture
	 */
	private void downloadPictures(int indexOfPicture){
		ArrayList<Tuple> tuples = this.table.tuples();
		int img = this.table.attributes().indexOfImage();
		int thum = this.table.attributes().indexOfThumbnail();
		for(Tuple aTuple : tuples){
			if(indexOfPicture==img||indexOfPicture==thum){
				try {
					URL aURL = new URL(urlString()+aTuple.values().get(indexOfPicture));
					HttpURLConnection aURLConnection = (HttpURLConnection)aURL.openConnection();
					aURLConnection.connect();
					String filename = System.getProperty("user.home")+"/Desktop/SouriDaijin/"+aTuple.values().get(indexOfPicture);
					FileOutputStream aOutputStream = new FileOutputStream(filename);

					byte buff[] = new byte[4096];

					DataInputStream aInputStream = new DataInputStream(aURLConnection.getInputStream());
					int readData;
					while((readData=aInputStream.read(buff))!=-1){
						aOutputStream.write(buff,0,readData);
					}
					aOutputStream.close();
					aInputStream.close();
					System.out.println(aTuple.values().get(indexOfPicture)+" Download Finish");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadThumbnails(){
		String aString = System.getProperty("user.home")+"/Desktop/SouriDaijin/thumbnails";
		File aFile = new File(aString);
		if(!aFile.exists()){
			System.out.println("ファイルが存在しないので作成します。");
			aFile.mkdir();
		}
		int indexOfPicture = this.table.attributes().indexOfThumbnail();
		this.downloadPictures(indexOfPicture);
	}
	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群をダウロードし、テーブルで応答する。
	 * @return aTable
	 * 
	 */
	public Table table(){
		this.downloadCSV();
		Table aTable=this.table;
		this.downloadImages();
		this.downloadThumbnails();
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
		String aURLString="http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/";
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
